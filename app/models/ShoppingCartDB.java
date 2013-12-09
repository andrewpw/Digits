package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCartDB {

  private static Map<String, Shoes> cdForm = new HashMap<>();
  static Timing time = new Timing();
  
  public static Shoes add(String name) {
    time.start();
    if(!(name.equals(""))){
      cdForm.put(name, ShoeDB.getShoes(name)); 
    }
    time.stop();
    System.out.println(time.print("Shoes.add"));
    return null;
  }
  
  public static List<Shoes> getShoppingList() {
    time.start();
    List<Shoes> shoppingList = new ArrayList<>();
    shoppingList.addAll(cdForm.values());
    time.stop();
    System.out.println(time.print("GetShoppingList"));
    return shoppingList;
  }

  public static void delete() {
    time.start();
    cdForm = new HashMap<>();
    time.stop();
    System.out.println(time.print("Checkout"));
  }
}