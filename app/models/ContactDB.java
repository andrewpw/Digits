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

  private static Map<String, Map<Long, Contact>> cdForm = new HashMap<String, Map<Long, Contact>>();
  
  /**
   * adds a new contact to the list or updates the pre-existing contact if there is one.
   * @param fData the contact data form with the data
   * @return contact the new contact
   */
  public static Contact add(ContactFormData fData, String user) {
    
    Contact contact;
    
    if (fData.id == 0) {
      long id = cdForm.size() + 1;
      contact = new Contact(fData.firstName, fData.lastName, fData.telephone, id, fData.telType);
      if(!cdForm.containsKey(user)){
        cdForm.put(user, new HashMap<Long, Contact>());
      }
      cdForm.get(user).put(id, contact);
    }
    else {
      contact = new Contact(fData.firstName, fData.lastName, fData.telephone, fData.id, fData.telType);
      if(!cdForm.containsKey(user)){
        cdForm.put(user, new HashMap<Long, Contact>());
      }
      cdForm.get(user).put(fData.id, contact);
    }
    return contact;
  }
  
  /**
   * deletes a contact.
   * @param id the id of the contact to delete
   */
  public static void deleteContact(long id) {
    cdForm.remove(id);
  }
  
  /**
   * returns the list of contacts.
   * @return cdForm the list of contacts
   */
  public static List<Contact> getContacts(String user) {
    if(!isUser(user)){
      return null;
    }
    return new ArrayList<>(cdForm.get(user).values());
  }
  
  public static boolean isUser(String user){
    return cdForm.containsKey(user);
  }
  
  /**
   * finds a Contact specified by an IDor throws a Runtime Exception if no ID is found.
   * @param id the id of the Contact we are searching for
   * @return contact the Contact that was searched for
   */
  public static Contact getContact(String user, long id) {
    if(!isUser(user)){
      throw new RuntimeException("No contact with this username exists: " + user);
    }
    Contact contact = cdForm.get(user).get(id);
    if (contact == null) {
      throw new RuntimeException("No contact with this ID exists: " + id);
    }
    return contact;
  }
}
