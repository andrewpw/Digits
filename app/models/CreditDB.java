package models;

import views.formdata.CreditFormData;

public class CreditDB {

  public static void check(CreditFormData cdata){
    Credit credit = new Credit(cdata.name, cdata.number);
    if (credit.getName() == cdata.name);
  }
}
