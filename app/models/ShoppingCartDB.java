package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.avaje.ebean.Ebean;

public class ShoppingCartDB {
  
  static Timing time = new Timing();
  public static void add(ShoppingCart cart, Product product) {
    time.start();
    product.update();
    cart.save();
    time.stop();
    System.out.println(time.print("ShoppingCart.Add"));
  }
  
  public static List<Product> getShoppingList(String user) {
    time.start();
    Contact contact = Contact.find().where().eq("username", user).findUnique();
    ShoppingCart cart = ShoppingCart.find().where().eq("id", contact.getId()).findUnique();
    time.stop();
    System.out.println(time.print("getShoppingList"));
    return cart.getProducts();
  }

  public static void delete(String user) {
    time.start();
    Contact contact = Contact.find().where().eq("username", user).findUnique();
    ShoppingCart cart = ShoppingCart.find().where().eq("id", contact.getId()).findUnique();
    List<Product> list = cart.getProductList();
    cart.deleteAll();
    cart.save();
    while(!list.isEmpty()){
      Ebean.delete(list.remove(0));
    }
    time.stop();
    System.out.println(time.print("Checkout"));
  }
}