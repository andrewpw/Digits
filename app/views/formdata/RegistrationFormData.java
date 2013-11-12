package views.formdata;

import play.data.validation.ValidationError;
import java.util.ArrayList;
import java.util.List;
import models.UserInfoDB;

/**
 * Backing class for the login form.
 */
public class RegistrationFormData {

  /** The submitted email. */
  public String email = "";
  /** The submitted password. */
  public String password = "";
  /** The submitted name */
  public String name = "";

  /** Required for form instantiation. */
  public RegistrationFormData() {
  }

  /**
   * Validates Form<LoginFormData>.
   * Called automatically in the controller by bindFromRequest().
   * Checks to see that email and password are valid credentials.
   * @return Null if valid, or a List[ValidationError] if problems found.
   */
  public List<ValidationError> validate() {

    List<ValidationError> errors = new ArrayList<>();
    
    if (!UserInfoDB.canRegister(name, email, password)) {
      errors.add(new ValidationError("name", ""));
      errors.add(new ValidationError("email", ""));
      errors.add(new ValidationError("password", ""));      
    }

    return (errors.size() > 0) ? errors : null;
  }

}
