package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.avaje.ebean.Ebean;
import views.formdata.ContactFormData;

/**
 * class to add contacts to the database.
 * @author Andrew
 *
 */
public class ContactDB {
  
  private static int count = 5;
  /**
   * adds a new contact to the list or updates the pre-existing contact if there is one.
   * @param fData the contact data form with the data
   * @return contact the new contact
   */
  static Timing time = new Timing();
  public static void add(ContactFormData fData) {
    time.start();
    Contact contact = null;
    
    if (Contact.find().where().eq("username", fData.username).findUnique() == null) {
      System.out.println("yes");
      if(fData.name == "Bob Barker"){
        contact = new Contact(fData.name, fData.address, fData.city, fData.zipcode, fData.telephone, fData.username,
            fData.password, 1);
      }
      else if(fData.name == "Bill Murray"){
        contact = new Contact(fData.name, fData.address, fData.city, fData.zipcode, fData.telephone, fData.username,
            fData.password, 2);
      }
      else if(fData.name == "Bo Jackson"){
        contact = new Contact(fData.name, fData.address, fData.city, fData.zipcode, fData.telephone, fData.username,
            fData.password, 3);
      }
      else if(fData.name == "Babe Ruth"){
        contact = new Contact(fData.name, fData.address, fData.city, fData.zipcode, fData.telephone, fData.username,
            fData.password, 4);
      }
      if(Contact.find().byId((long) 4) != null){
      contact = new Contact(fData.name, fData.address, fData.city, fData.zipcode, fData.telephone, fData.username,
          fData.password, Contact.find().findRowCount() + 1);
      }
      contact.getCart().setContact(contact);
      contact.save();   
      contact.getCart().save();
    }
    else {
      System.out.println(fData.username);
      contact = Contact.find().where().eq("username", fData.username).findUnique();
      contact.setName(fData.name);
      contact.setAddress(fData.address); 
      contact.setCity(fData.city);
      contact.setZipcode(fData.zipcode); 
      contact.setTel(fData.telephone); 
      contact.save();
    }
    time.stop();
    System.out.println(time.print("Add Contact"));
  }
  
  /**
   * deletes a contact.
   * @param username the id of the contact to delete
   */
  public static void deleteContact(String username) {
    Contact delContact = Contact.find().where().eq("username", username).findUnique();
    Ebean.delete(delContact);
  }
  
  /**
   * returns the list of contacts.
   * @return cdForm the list of contacts
   */
  public static List<Contact> getContacts() {
    return new ArrayList<>(Contact.find().all());
  }
  
  /**
   * finds a Contact specified by an IDor throws a Runtime Exception if no ID is found.
   * @param id the id of the Contact we are searching for
   * @return contact the Contact that was searched for
   */
  public static Contact getContact(long id) {
    Contact contact = Contact.find().byId(id);
    if (contact == null) {
      throw new RuntimeException("No contact with this ID exists: " + id);
    }
    return contact;
  }

  public static Contact getContact(String username) {
    time.start();
    Contact contact = Contact.find().where().eq("username", username).findUnique();
    if (contact == null) {
      return null;
    }
    time.stop();
    System.out.println(time.print("Get Contact"));
    return contact;
  }
}
