package controllers;

import java.util.Map;
import models.Contact;
import models.ContactDB;
import models.Product;
import models.ProductDB;
import models.ShoppingCartDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ContactFormData;
import views.formdata.Login;
import views.html.Index;
import views.html.NewContact;
import views.html.Profile;
import views.html.Shoes;
import views.html.Display;
import views.html.ShoppingCart;
import play.mvc.Security;

/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  private static boolean loggedIn = false;
  private static Contact user;
  private static boolean log = false;
  /**
   * Returns the home page. 
   * @return The resulting home page. 
   */
  
  public static Result index() {
    return ok(Index.render(Secured.isLoggedIn(ctx()), Secured.getUsernam(ctx())));
  }
  
  public static Result checkout() {
    ShoppingCartDB.delete(Secured.getUsernam(ctx()));
    return ok(Index.render(Secured.isLoggedIn(ctx()), Secured.getUsernam(ctx())));
  }
  
  public static Result shoppingCart(String name) {
    if(!name.equals("")){
      Contact contact = Contact.find().where().eq("username", user).findUnique();
      Product product = Product.find().where().eq("name", name).findUnique();
      if(contact.addToCart(product) == false){
        flash("error", "Sorry this item is already in someone's shopping cart");
        return ok(Shoes.render(product.getType(), contact, Secured.getUsernam(ctx()), 0));
      }
    }
    return ok(ShoppingCart.render(Secured.isLoggedIn(ctx()), Secured.getUsernam(ctx())));
  }
  
  public static Result profile(String username) {
    if(username == ""){
      loggedIn = false;
      //user ="";
      return ok(Index.render(Secured.isLoggedIn(ctx()), Secured.getUsernam(ctx())));  
    }
    return ok(Profile.render(ContactDB.getContact(username), Secured.getUsernam(ctx())));
  }
  
  public static Result shoes(String type) {
    return ok(Shoes.render(type, ContactDB.getContact(Secured.getUsernam(ctx())), Secured.getUsernam(ctx()), 0));
  }
  
  public static Result sort(String type) {
    //ProductDB.sortBySize();
    return ok(Shoes.render(type, ContactDB.getContact(Secured.getUsernam(ctx())), Secured.getUsernam(ctx()), 1));
  }
  
  public static Result display(String name) {
    Product shoe = ProductDB.getProducts(name);
    return ok(Display.render(Secured.isLoggedIn(ctx()), Secured.getUsernam(ctx()), shoe));
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
    if (username.equals("")) {
      log = true;
      return ok(NewContact.render(formData, Secured.getUsernam(ctx()), Secured.isLoggedIn(ctx()), true));
    }
    else {
      log = false;
      return ok(NewContact.render(formData, Secured.getUsernam(ctx()), Secured.isLoggedIn(ctx()), false));
    }
  }
  
  /**
   * 
   * @param id the id to delete
   * @return New Contact page with the contact to delete
   */
  public static Result deleteContact(String username) {
    //Form<ContactFormData> formData = Form.form(ContactFormData.class);
    ContactDB.deleteContact(username);
    return ok(Index.render(Secured.isLoggedIn(ctx()), Secured.getUsernam(ctx())));
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
      return badRequest(NewContact.render(formData, Secured.getUsernam(ctx()), Secured.isLoggedIn(ctx()), log));
    }
    else {
      ContactFormData data = formData.get();
      flash("success",
          String.format("Successfully added %s", data.name));
      ContactDB.add(data);
      return ok(NewContact.render(formData, Secured.getUsernam(ctx()), Secured.isLoggedIn(ctx()), log));
    }
  }
  
  public static Result postLogin() {
    Form<Login> formData = Form.form(Login.class).bindFromRequest();
    if (formData.hasErrors()) {
      flash("error", "Please correct the form below.");
      System.out.println("failure");
      System.out.println(formData.errors());
      return badRequest(Index.render(Secured.isLoggedIn(ctx()), Secured.getUsernam(ctx())));
    }
    else {
      Login data = formData.get();
      data.loggedIn = true;
      session().clear();
      session("username", formData.get().username);
      //user = data.username;
      flash("success",
          String.format("Successfully added %s", data.username));
      //ContactDB.add(data);
      System.out.println("success");
      return ok(Index.render(Secured.isLoggedIn(ctx()), Secured.getUsernam(ctx())));
    }
  }
}
