package views.formdata;

import java.util.ArrayList;
import java.util.List;
import models.Contact;
import views.formdata.TelephoneTypes;
import play.data.validation.ValidationError;

/**
 * Holds the data when a New Contact form is filled in.
 */
public class ContactFormData {
  private static final int NUM_TELEPHONE_DIGITS = 12;
  
  /**The first name.*/
  public String firstName = "";
  /**The last name.*/
  public String lastName = "";
  /**The telephone number.*/
  public String telephone = "";
  /**The id number.*/
  public long id = -1;
  /**The telephone type.*/
  public String telType;
  
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
    this.firstName = contact.getFirst();
    this.lastName = contact.getLast();
    this.telephone = contact.getTel();
    this.telType = contact.getTelType();
  }
  
  public ContactFormData(String first, String last, String tel, String telType) {
    this.firstName = first;
    this.lastName = last;
    this.telephone = tel;
    this.telType = telType;
  }

  /**
   * Checks to make sure that all form fields are filled.
   * @return null on success.
   *         List<Validation Error> of errors on failure.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();
    
    if (firstName == null || firstName.length() == 0) {
      errors.add(new ValidationError("firstName", "First name is required."));
    }
    
    if (lastName == null || lastName.length() == 0) {
      errors.add(new ValidationError("lastName", "Last name is required."));
    }
    
    if (telephone == null || telephone.length() == 0) {
      errors.add(new ValidationError("telephone", "Telephone is required."));
    }
    
    if (telephone.length() != NUM_TELEPHONE_DIGITS) {
      errors.add(new ValidationError("telephone", "Telephone must be xxx-xxx-xxxx."));
    }
    
    if (telType == null || telephone.length() == 0 || TelephoneTypes.isTypes(telType) == false) {
      errors.add(new ValidationError("telType", "Telephone Type is required."));
    }
    
    return errors.isEmpty() ? null : errors;
  }
}
