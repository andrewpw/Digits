package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.ContactFormData;

/**
 * class to add contacts to the database.
 * @author Andrew
 *
 */
public class ContactDB {

  private static Map<String, Contact> cdForm = new HashMap<>();
  
  /**
   * adds a new contact to the list or updates the pre-existing contact if there is one.
   * @param fData the contact data form with the data
   * @return contact the new contact
   */
  public static Contact add(ContactFormData fData) {
    
    Contact contact;
    
    if (fData.id == 0) {
      long id = cdForm.size() + 1;
      contact = new Contact(fData.name, fData.address, fData.city, fData.zipcode, fData.telephone, fData.username,
          fData.password, id);
      cdForm.put(fData.username, contact);
    }
    else {
      contact = new Contact(fData.name, fData.address, fData.city, fData.zipcode, fData.telephone, fData.username,
          fData.password, fData.id);
      cdForm.put(fData.username, contact);
    }
    return contact;
  }
  
  /**
   * deletes a contact.
   * @param username the id of the contact to delete
   */
  public static void deleteContact(String username) {
    cdForm.remove(username);
  }
  
  /**
   * returns the list of contacts.
   * @return cdForm the list of contacts
   */
  public static List<Contact> getContacts() {
    return new ArrayList<>(cdForm.values());
  }
  
  /**
   * finds a Contact specified by an IDor throws a Runtime Exception if no ID is found.
   * @param id the id of the Contact we are searching for
   * @return contact the Contact that was searched for
   */
  public static Contact getContact(long id) {
    Contact contact = cdForm.get(id);
    if (contact == null) {
      throw new RuntimeException("No contact with this ID exists: " + id);
    }
    return contact;
  }

  public static Contact getContact(String username) {
    Contact contact = cdForm.get(username);
    if (contact == null) {
      return null;
    }
    return contact;
  }
}
