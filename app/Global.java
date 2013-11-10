import models.Contact;
import models.ContactDB;
import models.ShoeDB;
import models.Shoes;
import play.Application;
import play.GlobalSettings;
import views.formdata.ContactFormData;
import views.formdata.ProductFormData;

public class Global extends GlobalSettings {
  
  public void onStart(Application app) {
    Contact contact = new Contact("Bob Barker", "1234 5th st", "Honolulu, HI", "99999", "555-555-5555", "bbarker",
        "abc", 1);
    Contact contact2 = new Contact("Bill Murray", "1234 5th st", "Honolulu, HI", "99999", "555-555-5555",
        "bmurray", "abc", 2);
    Contact contact3 = new Contact("Bo Jackson", "1234 5th st", "Honolulu, HI", "99999", "555-555-5555",
        "bjackson", "abc", 3);
    Contact contact4 = new Contact("Babe Ruth", "1234 5th st", "Honolulu, HI", "99999", "555-555-5555", 
        "bruth", "abc", 4);
    Shoes shoe = new Shoes("Emporio Armani", "Perforated Leather", "Shoes", "Composition:  Calf-skin leather Laser cut, "
        + "Solid color, Buckle, Lug sole, Visible logo , Round toeline", 995, 
        "9", 'M', "http://cdn.yoox.biz/44/44556676bj_13_n_f.jpg");
    Shoes shoe2 = new Shoes("Emporio Armani", "Perforated Leather", "Shoes", "Composition:  Calf-skin leather Laser cut, "
        + "Solid color, Buckle, Lug sole, Visible logo , Round toeline", 995, 
        "10", 'M', "http://cdn.yoox.biz/44/44556676bj_13_n_f.jpg");
    Shoes shoe3 = new Shoes("Emporio Armani", "Perforated Leather", "Shoes", "Composition:  Calf-skin leather Laser cut, "
        + "Solid color, Buckle, Lug sole, Visible logo , Round toeline", 995, 
        "11", 'M', "http://cdn.yoox.biz/44/44556676bj_13_n_f.jpg");
    Shoes shoe4 = new Shoes("Emporio Armani", "Perforated Leather", "Shoes", "Composition:  Calf-skin leather Laser cut, "
        + "Solid color, Buckle, Lug sole, Visible logo , Round toeline", 995, 
        "12", 'M', "http://cdn.yoox.biz/44/44556676bj_13_n_f.jpg");
    ContactFormData data = new ContactFormData(contact);
    ContactFormData data2 = new ContactFormData(contact2);
    ContactFormData data3 = new ContactFormData(contact3);
    ContactFormData data4 = new ContactFormData(contact4);
    ProductFormData pdata = new ProductFormData(shoe);
    ProductFormData pdata2 = new ProductFormData(shoe2);
    ProductFormData pdata3 = new ProductFormData(shoe3);
    ProductFormData pdata4 = new ProductFormData(shoe4);
    ContactDB.add(data);
    ContactDB.add(data2);
    ContactDB.add(data3);
    ContactDB.add(data4);
    ShoeDB.add(pdata);
    ShoeDB.add(pdata2);
    ShoeDB.add(pdata3);
    ShoeDB.add(pdata4);
  }

}