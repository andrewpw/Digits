package models;

/**
 * Provides a model for Contact data.
 * @author Andrew
 *
 */
public class Contact {

  private long id;
  private String firstName;
  private String lastName;
  private String telephone;
  private String telHref;
  
  /**
   * Public constructor for setting the first name last name and telephone number.
   * @param id the ID
   * @param firstName2 the first name
   * @param lastName2 the last name
   * @param telephone2 the telephone number
   */
  public Contact(String firstName2, String lastName2, String telephone2, long id) {
    this.firstName = firstName2;
    this.lastName = lastName2;
    this.telephone = telephone2;
    this.id = id;
  }

  /**
   * returns the id.
   * @return id the ID
   */
  public long getId() {
    return id;
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
  
}
