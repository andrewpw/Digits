package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
  private long id = -1;
  private String name;
  private String telephone;
  private String telHref;
  private String address;
  private String city;
  private String zipcode;
  private String username;
  private String password;
  @OneToOne (mappedBy = "contact")
  private ShoppingCart shoppingCart;
  
  /**
   * Public constructor for setting the first name last name and telephone number.
   * @param id the ID
   * @param firstName2 the first name
   * @param lastName2 the last name
   * @param telephone2 the telephone number
   * @param telType the telephone type
   */
  public Contact(String name, String address, String city, String zipcode, String telephone, String username,
      String password, long id) {
    this.name = name;
    this.address = address;
    this.city = city;
    this.zipcode = zipcode;
    this.telephone = telephone;
    this.username = username;
    this.password = password;
    this.id = id;
    System.out.println(this.id);
  }
  
  public Contact(String name, String address, String city, String zipcode, String telephone, String username,
      String password) {
    this.name = name;
    this.address = address;
    this.city = city;
    this.zipcode = zipcode;
    this.telephone = telephone;
    this.username = username;
    this.password = password;
    System.out.println("Hey " + this.id);
  }

  /**
   * returns the id.
   * @return id the ID
   */
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
  /**
   * returns name.
   * @return name
   */
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
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
  public void setFirst(String name) {
    this.name = name;
  }

  /**
   * sets the telephone number.
   * @param telephone the telephone number to set
   */
  public void setTel(String telephone) {
    this.telephone = telephone;
  }

  public String getAddress() {
    return address;
  }

  public String getCity() {
    return city;
  }

  public String getZipcode() {
    return zipcode;
  }

  public String getUsername() {
    // TODO Auto-generated method stub
    return username;
  }

  public String getPassword() {
    // TODO Auto-generated method stub
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public static Finder<Long, Contact> find(){
    
    return new Finder<Long, Contact>(Long.class, Contact.class);
  }
}
