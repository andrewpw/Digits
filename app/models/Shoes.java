package models;

public class Shoes {

  private String brand;
  private String model;
  private String type;
  private String description;
  private float price;
  private String size;
  private char sex;
  private String url;
  private int index;
  
  
  public Shoes(String brand, String model, String type, String description, float price, String size, char sex, 
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
  
  public int getIndex() {
    return index;
  }
  
  public void setIndex(int i) {
    index = i;
  }
  
  public String getName(){
    return brand + model + size;
  }
  
}
