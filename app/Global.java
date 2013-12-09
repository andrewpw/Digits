import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import models.Contact;
import models.ContactDB;
import models.ProductDB;
import models.Product;
import play.Application;
import play.GlobalSettings;
import views.formdata.ContactFormData;
import views.formdata.ProductFormData;

public class Global extends GlobalSettings {
  
  public void onStart(Application app) {
    if(ContactDB.getContacts().isEmpty()){
      Contact contact = new Contact("Bob Barker", "1234 5th st", "Honolulu, HI", "99999", "555-555-5555", "bbarker",
          "abc", -1);
      Contact contact2 = new Contact("Bill Murray", "1234 5th st", "Honolulu, HI", "99999", "555-555-5555",
          "bmurray", "abc", -1);
      Contact contact3 = new Contact("Bo Jackson", "1234 5th st", "Honolulu, HI", "99999", "555-555-5555",
          "bjackson", "abc", -1);
      Contact contact4 = new Contact("Babe Ruth", "1234 5th st", "Honolulu, HI", "99999", "555-555-5555", 
          "bruth", "abc", -1);
      ContactFormData data = new ContactFormData(contact);
      ContactFormData data2 = new ContactFormData(contact2);
      ContactFormData data3 = new ContactFormData(contact3);
      ContactFormData data4 = new ContactFormData(contact4);
      System.out.println(data.name);
      ContactDB.add(data);
      ContactDB.add(data2);
      ContactDB.add(data3);
      ContactDB.add(data4);
    }
    String csvFile = System.getProperty("user.dir") + "\\app\\Products.csv";
    BufferedReader br = null;
    String line = "";
    String[] product;
   
    try {
      br = new BufferedReader(new FileReader(csvFile));
      
      while ((line = br.readLine()) != null) {
        product = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        if(product.length > 0){
          Product shoe = new Product(product[0], product[1], product[2], product[3], Float.parseFloat(product[4]), 
              product[5], product[6].charAt(0), product[7]);
          ProductFormData pdata = new ProductFormData(shoe);
          ProductDB.add(pdata);
        }
      }
   
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

}