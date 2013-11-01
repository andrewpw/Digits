package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.ProductFormData;

public class ShoeDB {

  private static Map<String, Shoes> cdForm = new HashMap<>();
  
  public static Shoes add(ProductFormData fData) {
    
    Shoes shoe;
    
    shoe = new Shoes(fData.brand, fData.model, fData.type, fData.description, fData.price, fData.size,
          fData.sex, fData.url);
      cdForm.put(fData.brand + fData.model, shoe);
    return shoe;
  }
  
  public static Shoes getShoes(String brand, String model) {
    Shoes shoe = cdForm.get(brand+model);
    if (shoe == null) {
      return null;
    }
    return shoe;
  }

  public static List<Shoes> getShoeList() {
    List<Shoes> shoeList = new ArrayList<>();
    shoeList.addAll(cdForm.values());
    return shoeList;
  }
}
