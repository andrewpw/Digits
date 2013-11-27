package models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import play.db.ebean.Model;
/**
 * A simple representation of a user. 
 * @author Philip Johnson
 */
@Entity
public class UserInfo extends Model{
 
  private static final long serialVersionUID = 1L;

  @Id
  private long id;
  private String name;
  private String email;
  private String password;
  private boolean admin = false;
  
  @OneToMany(mappedBy="userInfo")
  private List<Contact> contacts = new ArrayList<>();


  /**
   * Creates a new UserInfo instance.
   * @param name The name.
   * @param email The email.
   * @param password The password.
   */
  public UserInfo(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
  }
  
  /**
   * @return the name
   */
  public String getName() {
    return name;
  }
  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }
  
  
  
  public static Finder<Long, UserInfo> find(){
    
    return new Finder<Long, UserInfo>(Long.class, UserInfo.class);
  }
  
  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }
  
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
  
  public List<Contact> getContacts() {
    return contacts;
  }
  
  public void addContact(Contact contacts) {
    this.contacts.add(contacts);
  }
  
  public void deleteContact(Contact contacts) {
    this.contacts.remove(contacts);
  }
  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }
  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }
  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isAdmin() {
    return admin;
  }

  public void setAdmin(boolean admin) {
    this.admin = admin;
  }

}