package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import play.db.ebean.Model;

@Entity
public class Product extends Model{
  
  private static final long serialVersionUID = 1L;

  @Id
  private long id;
  private String brand;
  private String model;
  private String type;
  private String description;
  private float price;
  private String size;
  private char sex;
  private String url;
  
  @ManyToOne
  private ShoppingCart shoppingCart;
  
  public Product(String brand, String model, String type, String description, float price, String size, char sex, 
      String url){
    this.brand = brand;
    this.model = model;
    this.type = type;
    this.description = description;
    this.price = price;
    this.size = size;
    this.sex = sex;
    this.url = url;
  }


  public String getBrand() {
    return brand;
  }


  public String getModel() {
    return model;
  }


  public String getType() {
    return type;
  }


  public String getDescription() {
    return description;
  }


  public float getPrice() {
    return price;
  }


  public String getSize() {
    return size;
  }


  public char getSex() {
    return sex;
  }


  public String getUrl() {
    return url;
  }
  
  
  public String getName(){
    return brand + model + size;
  }
  
  public static Finder<Long, Product> find(){
    
    return new Finder<Long, Product>(Long.class, Product.class);
  }
}
