package controllers;

import java.util.Map;
import models.ContactDB;
import models.UserInfo;
import models.UserInfoDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ContactFormData;
import views.formdata.LoginFormData;
import views.formdata.RegistrationFormData;
import views.html.Index;
import views.html.NewContact;
import views.html.Profile;
import views.formdata.TelephoneTypes;
import views.html.Login;
import play.mvc.Security;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page. 
   * @return The resulting home page. 
   */
  @Security.Authenticated(Secured.class)
  public static Result index() {
    UserInfo userInfo = UserInfoDB.getUser(request().username());
    String user = userInfo.getEmail();
    return ok(Index.render(ContactDB.getContacts(user), Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
  }
  
  /**
   * Returns a new contact form.
   * @param id the id of the contact to create
   * @return NewContact page with a form.
   */
  @Security.Authenticated(Secured.class)
  public static Result newContact(long id) {
    UserInfo userInfo = UserInfoDB.getUser(request().username());
    String user = userInfo.getEmail();
    ContactFormData data = (id == 0) ? new ContactFormData() : new ContactFormData(ContactDB.getContact(user, id));
    Form<ContactFormData> formData = Form.form(ContactFormData.class).fill(data); 
    if (id == 0) {
      return ok(NewContact.render(formData, TelephoneTypes.getTypes(), Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }
    else {
      return ok(NewContact.render(formData, TelephoneTypes.getTypes(ContactDB.getContact(user, id).getTelType()), Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }
  }
    /**
     * Provides the Login page (only to unauthenticated users). 
     * @return The Login page. 
     */
    public static Result login() {
      Form<LoginFormData> formData = Form.form(LoginFormData.class);
      Form<RegistrationFormData> regFormData = Form.form(RegistrationFormData.class);
      return ok(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData, regFormData));
    }
  
    /**
     * Processes a login form submission from an unauthenticated user. 
     * First we bind the HTTP POST data to an instance of LoginFormData.
     * The binding process will invoke the LoginFormData.validate() method.
     * If errors are found, re-render the page, displaying the error data. 
     * If errors not found, render the page with the good data. 
     * @return The index page with the results of validation. 
     */
    
    public static Result postLogin() {

      // Get the submitted form data from the request object, and run validation.
      Form<LoginFormData> formData = Form.form(LoginFormData.class).bindFromRequest();
      Form<RegistrationFormData> regFormData = Form.form(RegistrationFormData.class);

      if (formData.hasErrors()) {
        flash("error", "Login credentials not valid.");
        return badRequest(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData, regFormData));
      }
      else {
        // email/password OK, so now we set the session variable and only go to authenticated pages.
        session().clear();
        session("email", formData.get().email);
        return redirect(routes.Application.index());
      }
    }
    
    public static Result postRegistration() {

      // Get the submitted form data from the request object, and run validation.
      Form<RegistrationFormData> regFormData = Form.form(RegistrationFormData.class).bindFromRequest();
      Form<LoginFormData> formData = Form.form(LoginFormData.class);

      if (formData.hasErrors()) {
        flash("error", "Login credentials not valid.");
        return badRequest(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData, regFormData));
      }
      else {
        // email/password OK, so now we set the session variable and only go to authenticated pages.
        session().clear();
        session("email", regFormData.get().email);
        UserInfoDB.addUserInfo(regFormData.get().name, regFormData.get().email, regFormData.get().password);
        return redirect(routes.Application.index());
      }
    }
  /**
   * 
   * @param id the id to delete
   * @return New Contact page with the contact to delete
   */
    @Security.Authenticated(Secured.class)
  public static Result deleteContact(long id) {
      UserInfo userInfo = UserInfoDB.getUser(request().username());
      String user = userInfo.getEmail();
    //Form<ContactFormData> formData = Form.form(ContactFormData.class);
    ContactDB.deleteContact(id);
    return ok(Index.render(ContactDB.getContacts(user), Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
  }
  
  /**
   * Posts input from a contact form.
   * @return NewContact page with a form on success.
   *         NewContact page with a form and error message on failure
   */
  @Security.Authenticated(Secured.class)
  public static Result postContact() {
    UserInfo userInfo = UserInfoDB.getUser(request().username());
    String user = userInfo.getEmail();
    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      flash("error", "Please correct the form below.");
      return badRequest(NewContact.render(formData, TelephoneTypes.getTypes(), Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }
    else {
      ContactFormData data = formData.get();
      flash("success",
          String.format("Successfully added %s %s", data.firstName, data.lastName));
      ContactDB.add(data, user);
      return ok(NewContact.render(formData, TelephoneTypes.getTypes(), Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
    }
  }
  
  /**
   * Logs out (only for authenticated users) and returns them to the Index page. 
   * @return A redirect to the Index page. 
   */
  @Security.Authenticated(Secured.class)
  public static Result logout() {
    session().clear();
    return redirect(routes.Application.index());
  }
  
  /**
   * Provides the Profile page (only to authenticated users).
   * @return The Profile page. 
   */
  //@Security.Authenticated(Secured.class)
  //public static Result profile() {
    //return ok(Profile.render("Profile", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
  //}
}
