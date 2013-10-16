package models;

/**
 * Provides a model for Contact data.
 * @author Andrew
 *
 */
public class Contact {

  private String firstName;
  private String lastName;
  private String telephone;
  private String telHref;
  
  /**
   * Public constructor for setting the first name last name and telephone number.
   * @param firstName2
   * @param lastName2
   * @param telephone2
   */
  public Contact(String firstName2, String lastName2, String telephone2) {
    this.firstName = firstName2;
    this.lastName = lastName2;
    this.telephone = telephone2;
  }

  /**
   * returns first name.
   * @return firstName
   */
  public String getFirst(){
    return firstName;
  }
  
  /**
   * returns last name.
   * @return lastName
   *
   */
  public String getLast(){
    return lastName;
  }
  
  /**
   * returns telephone num.
   * @return telephone
   *
   */
  public String getTel(){
    return telephone;
  }
  
  public String telToString(){
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
