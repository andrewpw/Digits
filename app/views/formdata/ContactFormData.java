package views.formdata;

import java.util.ArrayList;
import java.util.List;
import play.data.validation.ValidationError;

/**
 * Holds the data when a New Contact form is filled in
 */
public class ContactFormData {
  private static final int NUM_TELEPHONE_DIGITS = 12;
  
  public String firstName = "";
  public String lastName = "";
  public String telephone = "";
  
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
    
    return errors.isEmpty() ? null : errors;
  }
}
