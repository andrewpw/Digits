package controllers;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ContactFormData;
import views.html.Index;
import views.html.NewContact;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page. 
   * @return The resulting home page. 
   */
  public static Result index() {
    return ok(Index.render("Welcome to the home page."));
  }
  
  /**
   * Returns a new contact form.
   * @return NewContact page with a form.
   */
  public static Result newContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class);
    return ok(NewContact.render(formData));
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
      return badRequest(NewContact.render(formData));
    }
    else{
      ContactFormData data = formData.get();
      flash("success",
          String.format("Successfully added %s %s", data.firstName, data.lastName));
      return ok(NewContact.render(formData));
    }
  }
}
