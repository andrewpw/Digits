import models.Contact;
import models.ContactDB;
import models.UserInfoDB;
import play.Application;
import play.GlobalSettings;
import views.formdata.ContactFormData;

public class Global extends GlobalSettings {
  
  public void onStart(Application app) {
    Contact contact = new Contact("Bob", "Barker", "555-555-5555", 1, "Mobile");
    Contact contact2 = new Contact("Bill", "Murray", "555-555-5555", 2, "Home");
    Contact contact3 = new Contact("Bo", "Jackson", "555-555-5555", 3, "Work");
    Contact contact4 = new Contact("Babe", "Ruth", "555-555-5555", 4, "Mobile");
    ContactFormData data = new ContactFormData(contact);
    ContactFormData data2 = new ContactFormData(contact2);
    ContactFormData data3 = new ContactFormData(contact3);
    ContactFormData data4 = new ContactFormData(contact4);
    ContactDB.add(data, "smith@example.com");
    ContactDB.add(data2, "smith@example.com");
    ContactDB.add(data3, "andrew@example.com");
    ContactDB.add(data4, "andrew@example.com");
    UserInfoDB.addUserInfo("Andrew Pearson-Wood", "andrew@example.com", "password");
    UserInfoDB.addUserInfo("John Smith", "smith@example.com", "password");
  }

}