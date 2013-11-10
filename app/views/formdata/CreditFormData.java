package views.formdata;

import models.Credit;



/**
 * 
 * @author Andrew
 *
 */
public class CreditFormData {

  public String name;
  public String number;
  /**
   * 
   * No arguments constructor.
   */
  public CreditFormData(){
  }
  
  public CreditFormData(Credit credit){
    this.name = credit.getName();
    this.number = credit.getNumber();
  }
  
}
