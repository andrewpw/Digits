package controllers;

import java.util.Map;
import models.ContactDB;
import models.ShoeDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ContactFormData;
import views.formdata.Login;
import views.html.Index;
import views.html.NewContact;
import views.html.Profile;
import views.html.Shoes;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  private static boolean loggedIn = false;
  private static String user = "";
  /**
   * Returns the home page. 
   * @return The resulting home page. 
   */
  public static Result index() {
    return ok(Index.render(loggedIn, user));
  }
  
  public static Result profile(String username) {
    return ok(Profile.render(ContactDB.getContact(username)));
  }
  
  public static Result shoes() {
    return ok(Shoes.render(ContactDB.getContact(user)));
  }
  
  /**
   * Returns a new contact form.
   * @param id the id of the contact to create
   * @return NewContact page with a form.
   */
  public static Result newContact(String username) {
    ContactFormData data = (ContactDB.getContact(username) == null) ? new ContactFormData() : new 
        ContactFormData(ContactDB.getContact(username));
    if (ContactDB.getContact(username) != null) System.out.println("true");
    Form<ContactFormData> formData = Form.form(ContactFormData.class).fill(data);
    //if (id == 0) {
      //return ok(NewContact.render(formData, user, loggedIn));
    //}
    //else {
      return ok(NewContact.render(formData, user, loggedIn));
    //}
  }
  
  /**
   * 
   * @param id the id to delete
   * @return New Contact page with the contact to delete
   */
  public static Result deleteContact(String username) {
    //Form<ContactFormData> formData = Form.form(ContactFormData.class);
    ContactDB.deleteContact(username);
    return ok(Index.render(false, ""));
  }
  
  /**
   * Posts input from a contact form.
   * @return NewContact page with a form on success.
   *         NewContact page with a form and error message on failure
   */
  public static Result postContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      flash("error", "Please correct the form below.");
      return badRequest(NewContact.render(formData, user, loggedIn));
    }
    else {
      ContactFormData data = formData.get();
      flash("success",
          String.format("Successfully added %s", data.name));
      ContactDB.add(data);
      return ok(NewContact.render(formData, user, loggedIn));
    }
  }
  
  public static Result postLogin() {
    Form<Login> formData = Form.form(Login.class).bindFromRequest();
    if (formData.hasErrors()) {
      flash("error", "Please correct the form below.");
      System.out.println("failure");
      System.out.println(formData.errors());
      return badRequest(Index.render(false, ""));
    }
    else {
      Login data = formData.get();
      data.loggedIn = true;
      loggedIn = data.loggedIn;
      user = data.username;
      flash("success",
          String.format("Successfully added %s", data.username));
      //ContactDB.add(data);
      System.out.println("success");
      return ok(Index.render(loggedIn, data.username));
    }
  }
}
