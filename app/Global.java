import models.Contact;
import models.ContactDB;
import models.UserInfoDB;
import play.Application;
import play.GlobalSettings;
import play.Play;
import views.formdata.ContactFormData;

public class Global extends GlobalSettings {
  
  public void onStart(Application app) {
    String adminEmail = Play.application().configuration().getString("digits.admin.email");
    String adminPassword = Play.application().configuration().getString("digits.admin.password");
    UserInfoDB.defineAdmin("Administrator", adminEmail, adminPassword);
    if(UserInfoDB.adminDefined()){
      Contact contact = new Contact("Bob", "Barker", "555-555-5555", 1, "Mobile"); 
      Contact contact2 = new Contact("Bill", "Murray", "555-555-5555", 2, "Home");
      ContactFormData data = new ContactFormData(contact);
      ContactFormData data2 = new ContactFormData(contact2);    
      ContactDB.add(data, adminEmail);
      ContactDB.add(data2, adminEmail);
    }
  }
}