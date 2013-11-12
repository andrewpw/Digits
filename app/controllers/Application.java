package controllers;

import java.util.Map;
import models.ContactDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ContactFormData;
import views.html.Index;
import views.html.NewContact;
import views.formdata.TelephoneTypes;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page. 
   * @return The resulting home page. 
   */
  public static Result index() {
    return ok(Index.render(ContactDB.getContacts()));
  }
  
  /**
   * Returns a new contact form.
   * @param id the id of the contact to create
   * @return NewContact page with a form.
   */
  public static Result newContact(long id) {
    ContactFormData data = (id == 0) ? new ContactFormData() : new ContactFormData(ContactDB.getContact(id));
    Form<ContactFormData> formData = Form.form(ContactFormData.class).fill(data); 
    if (id == 0) {
      return ok(NewContact.render(formData, TelephoneTypes.getTypes()));
    }
    else {
      return ok(NewContact.render(formData, TelephoneTypes.getTypes(ContactDB.getContact(id).getTelType())));
    }
  }
  
  /**
   * 
   * @param id the id to delete
   * @return New Contact page with the contact to delete
   */
  public static Result deleteContact(long id) {
    //Form<ContactFormData> formData = Form.form(ContactFormData.class);
    ContactDB.deleteContact(id);
    return ok(Index.render(ContactDB.getContacts()));
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
      return badRequest(NewContact.render(formData, TelephoneTypes.getTypes()));
    }
    else {
      ContactFormData data = formData.get();
      flash("success",
          String.format("Successfully added %s %s", data.firstName, data.lastName));
      ContactDB.add(data);
      return ok(NewContact.render(formData, TelephoneTypes.getTypes()));
    }
  }
}
