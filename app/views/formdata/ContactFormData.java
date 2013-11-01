package views.formdata;

import java.util.ArrayList;
import java.util.List;
import models.Contact;
import views.formdata.ProductFormData;
import play.data.validation.ValidationError;

/**
 * Holds the data when a New Contact form is filled in.
 */
public class ContactFormData {
  private static final int NUM_TELEPHONE_DIGITS = 12;
  
  /**The first name.*/
  public String name = "";
  /**The telephone number.*/
  public String telephone = "";
  /**The id number.*/
  public long id;
  /**The address.*/
  public String address;
  /**The city.*/
  public String city;
  /**The zipcode.*/
  public String zipcode;
  /**The zipcode.*/
  public String username;
  /**The zipcode.*/
  public String password;
  
  /**
   * No argument constructor for this class.
   */
  public ContactFormData() {
    
    
  }
  
  /**
   * Contsructor that takes a contact.
   * @param contact the contact to add
   */
  public ContactFormData(Contact contact) {
    this.id = contact.getId();
    this.name = contact.getName();
    this.telephone = contact.getTel();
    this.address = contact.getAddress();
    this.city = contact.getCity();
    this.zipcode = contact.getZipcode();
    this.username = contact.getUsername();
    this.password = contact.getPassword();
  }
  
  /**
   * Checks to make sure that all form fields are filled.
   * @return null on success.
   *         List<Validation Error> of errors on failure.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();
    
    if (name == null || name.length() == 0) {
      errors.add(new ValidationError("name", "Name is required."));
    }
    
    if (address == null || address.length() == 0) {
      errors.add(new ValidationError("address", "Address is required."));
    }
    
    if (telephone == null || telephone.length() == 0) {
      errors.add(new ValidationError("telephone", "Telephone is required."));
    }
    
    if (telephone.length() != NUM_TELEPHONE_DIGITS) {
      errors.add(new ValidationError("telephone", "Telephone must be xxx-xxx-xxxx."));
    }
    
    if (city == null || city.length() == 0) {
      errors.add(new ValidationError("city", "City is required."));
    }
    
    if (zipcode == null || zipcode.length() == 0) {
      errors.add(new ValidationError("zipcode", "Zipcode is required."));
    }
    
    if (username == null || username.length() == 0) {
      errors.add(new ValidationError("username", "Username is required."));
    }
    
    if (password == null || password.length() == 0) {
      errors.add(new ValidationError("password", "Password is required."));
    }
    
    return errors.isEmpty() ? null : errors;
  }
}
