package views.formdata;
import models.Shoes;


/**
 * 
 * @author Andrew
 *
 */
public class ProductFormData {

  public String brand;
  public String model;
  public String type;
  public String description;
  public float price;
  public String size;
  public char sex;
  public String url;
  public int index;
  /**
   * 
   * No arguments constructor.
   */
  public ProductFormData(){
  }
  
  public ProductFormData(Shoes shoes){
    this.brand = shoes.getBrand();
    this.model = shoes.getModel();
    this.type = shoes.getType();
    this.description = shoes.getDescription();
    this.price = shoes.getPrice();
    this.size = shoes.getSize();
    this.sex = shoes.getSex();
    this.url = shoes.getUrl();
    this.index = shoes.getIndex();
  }
  
}
