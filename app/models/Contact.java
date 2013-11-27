package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import play.db.ebean.Model;

/**
 * Provides a model for Contact data.
 * @author Andrew
 *
 */
@Entity
public class Contact extends Model{

  private static final long serialVersionUID = 1L;
  @Id
  private long id;
  private String firstName;
  private String lastName;
  private String telephone;
  private String telHref;
  private String telType;
  
  @ManyToOne
  private UserInfo userInfo;
  
  /**
   * Public constructor for setting the first name last name and telephone number.
   * @param firstName2 the first name
   * @param lastName2 the last name
   * @param telephone2 the telephone number
   * @param telType the telephone type
   */
  public Contact(String firstName2, String lastName2, String telephone2, String telType) {
    this.firstName = firstName2;
    this.lastName = lastName2;
    this.telephone = telephone2;
    this.telType = telType;
  }
  /**
   * Finds a contact
   * @return the finder object for Contacts
   */
  public static Finder<Long, Contact> find(){
    
    return new Finder<Long, Contact>(Long.class, Contact.class);
  }

  /**
   * returns the id.
   * @return id the ID
   */
  public long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  public String getTelephone() {
    return telephone;
  }
  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }
  public String getTelHref() {
    return telHref;
  }
  public void setTelHref(String telHref) {
    this.telHref = telHref;
  }
  public UserInfo getUserinfo() {
    return userInfo;
  }
  public void setUserInfo(UserInfo userInfo) {
    this.userInfo = userInfo;
  }
  public void setId(long id) {
    this.id = id;
  }
  public void setTelType(String telType) {
    this.telType = telType;
  }

  /**
   * returns first name.
   * @return firstName
   */
  public String getFirst() {
    return firstName;
  }
  
  /**
   * returns last name.
   * @return lastName
   *
   */
  public String getLast() {
    return lastName;
  }
  
  /**
   * returns telephone num.
   * @return telephone
   *
   */
  public String getTel() {
    return telephone;
  }
  
  /**
   * returns a linkable form of the telephone number.
   * @return telHref the telephone number in link form
   */
  public String telToString() {
    telHref = "tel:+" + telephone.substring(0, 3) + telephone.substring(4, 7) + telephone.substring(8);
    return telHref;
  }

  /**
   * sets the first name.
   * @param firstName the first name field to set
   */
  public void setFirst(String firstName) {
    this.firstName = firstName;
  }

  /**
   * sets the last name.
   * @param lastName the last name field to set
   */
  public void setLast(String lastName) {
    this.lastName = lastName;
  }

  /**
   * sets the telephone number.
   * @param telephone the telephone number to set
   */
  public void setTel(String telephone) {
    this.telephone = telephone;
  }

  /**
   * returns a string of the type of telephone.
   * @return telType the type of telephone
   */
  public String getTelType() {
    return telType;
  }
  
}
