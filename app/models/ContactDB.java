package models;

import java.util.ArrayList;
import java.util.List;
import views.formdata.ContactFormData;

public class ContactDB {

  private static List<Contact> cdForm = new ArrayList<>();
  
  /**
   * adds a new contact to the list
   * @param fData
   * @return contact the new contact
   */
  public static Contact add(ContactFormData fData){
    Contact contact = new Contact(fData.firstName, fData.lastName, fData.telephone);
    cdForm.add(contact);
    return contact;
  }
  
  /**
   * returns the list of contacts
   * @return cdForm the list of contacts
   */
  public static List<Contact> getContacts(){
    return cdForm;
  }
}
