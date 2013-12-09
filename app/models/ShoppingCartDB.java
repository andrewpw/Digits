package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCartDB {

  private static Map<String, Product> cdForm = new HashMap<>();
  
  public static Product add(String name) {
    if(!(name.equals(""))){
      cdForm.put(name, ProductDB.getProducts(name));  
    }
    return null;
  }
  
  public static List<Product> getShoppingList() {
    List<Product> shoppingList = new ArrayList<>();
    shoppingList.addAll(cdForm.values());
    return shoppingList;
  }

  public static void delete() {
    cdForm = new HashMap<>();
  }
}