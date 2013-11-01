package views.formdata;

import java.util.ArrayList;
import java.util.List;
import models.ContactDB;
import play.data.validation.ValidationError;

public class Login {
  public String username;
  public String password;
  public boolean loggedIn = false;
  
  public Login(){
    
  }
  
  public Login(String username, String password, boolean loggedIn){
    this.username = username;
    this.password = password;
    this.loggedIn = loggedIn;
  }
  
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();
    
    if (username == null || username.length() == 0 || ContactDB.getContact(username) == null) {
      errors.add(new ValidationError("username", "Username is required."));
    }
    
    else if (password == null || password.length() == 0 || !(ContactDB.getContact(username).getPassword().equals(password))){
      errors.add(new ValidationError("password", "Password is required."));
    }
    
    return errors.isEmpty() ? null : errors;
  }
  
}
