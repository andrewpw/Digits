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
    if(UserInfoDB.adminDefined() && UserInfoDB.getUser(adminEmail).getContacts().isEmpty()){ 
      ContactFormData data = new ContactFormData("Bob", "Barker", "555-555-5555", "Mobile");
      ContactFormData data2 = new ContactFormData("Bill", "Murray", "555-555-5555", "Home");    
      ContactDB.add(data, adminEmail);
      ContactDB.add(data2, adminEmail);
    }
  }
}