package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCartDB {

  private static Map<String, Shoes> cdForm = new HashMap<>();
  
  public static Shoes add(String name) {
    if(!(name.equals(""))){
      cdForm.put(name, ShoeDB.getShoes(name)); 
    }
    return null;
  }
  
  public static List<Shoes> getShoppingList() {
    List<Shoes> shoppingList = new ArrayList<>();
    shoppingList.addAll(cdForm.values());
    return shoppingList;
  }

  public static void delete() {
    cdForm = new HashMap<>();
  }
}