package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.avaje.ebean.Ebean;

public class ShoppingCartDB {
  
  public static void add(ShoppingCart cart, Product product) {
    //;
    product.update();
    cart.save();
  }
  
  public static List<Product> getShoppingList(String user) {
    Contact contact = Contact.find().where().eq("username", user).findUnique();
    ShoppingCart cart = ShoppingCart.find().where().eq("id", contact.getId()).findUnique();
    return cart.getProducts();
  }

  public static void delete(String user) {
    Contact contact = Contact.find().where().eq("username", user).findUnique();
    System.out.println("SCart.delete " + user);
    ShoppingCart cart = ShoppingCart.find().where().eq("id", contact.getId()).findUnique();
    System.out.println("SCart.delete " + contact.getId());
    List<Product> list = cart.getProductList();
    System.out.println("SCart.delete " + list.size());
    cart.deleteAll();
    cart.save();
    while(!list.isEmpty()){
      Ebean.delete(list.remove(0));
    }
  }
}