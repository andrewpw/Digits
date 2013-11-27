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
  
  /**
   * adds a new contact to the list or updates the pre-existing contact if there is one.
   * @param fData the contact data form with the data
   * @return contact the new contact
   */
  public static void add(ContactFormData fData, String user) {
    
    Contact contact;
    
    if (fData.id == -1) {
      System.out.println("true");
      contact = new Contact(fData.firstName, fData.lastName, fData.telephone, fData.telType);
      UserInfo userInfo = UserInfo.find().where().eq("email", user).findUnique();
      if(userInfo == null){
        throw new RuntimeException("No user found");
      }
      userInfo.addContact(contact);
      contact.setUserInfo(userInfo);
      contact.save();
      userInfo.save();
    }
    else{
      System.out.println("false");
      contact = Contact.find().byId(fData.id);
      contact.setFirstName(fData.firstName);
      contact.setLastName(fData.lastName);
      contact.setTelephone(fData.telephone);
      contact.setTelType(fData.telType);
      contact.setTelHref(fData.telephone);
      contact.save();
    }
  }
  
  /**
   * deletes a contact.
   * @param id the id of the contact to delete
   */
  public static void deleteContact(long id, String user) {
    UserInfo userInfo = UserInfo.find().where().eq("email", user).findUnique();
    Contact contact = Contact.find().byId(id);
    userInfo.deleteContact(contact);
    //cdForm.remove(id);
  }
  
  /**
   * returns the list of contacts.
   * @return cdForm the list of contacts
   */
  public static List<Contact> getContacts(String user) {
    UserInfo userInfo = UserInfo.find().where().eq("email", user).findUnique();
    if (userInfo == null) {
      return null;
    }
    else {
      return userInfo.getContacts();
    }
  }
  
  public static boolean isUser(String user){
    return (UserInfo.find().where().eq("email", user).findUnique()) != null;
  }
  
  /**
   * finds a Contact specified by an IDor throws a Runtime Exception if no ID is found.
   * @param id the id of the Contact we are searching for
   * @return contact the Contact that was searched for
   */
  public static Contact getContact(String user, long id) {
    Contact contact = Contact.find().byId(id);
    if (contact == null) {
      throw new RuntimeException("No contact with this id exists: " + id);
    }
    UserInfo userInfo = contact.getUserinfo();
    
    if(!isUser(userInfo.getEmail())){
      throw new RuntimeException("Username incorrect match with contact " + user);
    }
    
    return contact;
  }
}
