package models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import play.db.ebean.Model;

@Entity
public class ShoppingCart extends Model {
  private static final long serialVersionUID = 1L;
  
  @Id
  private long id;
  @OneToMany(mappedBy="shoppingCart")
  private List<Product> products = new ArrayList<>();
  @OneToOne
  private Contact contact;
  
  public ShoppingCart(){
    
  }
  
  public List<Product> getProducts() {
    return products;
  }
  
  public void addProduct(Product product) {
    this.products.add(product);
  }
  
  public void deleteProduct(Product product) {
    this.products.remove(product);
  }
  
  public static Finder<Long, ShoppingCart> find(){
    
    return new Finder<Long, ShoppingCart>(Long.class, ShoppingCart.class);
  }

}
