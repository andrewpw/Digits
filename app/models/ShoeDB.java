package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import views.formdata.ProductFormData;

public class ShoeDB {

  private static Map<String, Shoes> cdForm = new HashMap<>();
  
  public static Shoes add(ProductFormData fData) {
    
    Shoes shoe;
    int i = 0;
    
    shoe = new Shoes(fData.brand, fData.model, fData.type, fData.description, fData.price, fData.size,
          fData.sex, fData.url);
    if(cdForm.size() % 3 == 0){
      i = 0;
    }
    else {
      i = 1;
    }
    shoe.setIndex(i);
      cdForm.put(fData.brand + fData.model + fData.size, shoe);
    return shoe;
  }
  
  public static Shoes getShoes(String name) {
    Shoes shoe = cdForm.get(name);
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
  
  public static List<Shoes> getShoeList(String type) {
    List<Shoes> shoeList = new ArrayList<>();
    List<Shoes> shoeList2 = new ArrayList<>();
    shoeList.addAll(cdForm.values());
    Iterator<Shoes> it = shoeList.iterator();
    Shoes shoe;
    while (it.hasNext()){
      shoe = it.next();
      System.out.println(shoe.getSex() + shoe.getType());
      if ((shoe.getSex() + shoe.getType()).equals(type)){
        shoeList2.add(shoe);
      }
    }
    return shoeList2;
  }
  
  public static void sortBySize() {
    List<Shoes> shoeList = new ArrayList<>();
    shoeList.addAll(cdForm.values());
    
  }

  public static void sortByPrice() {
    List<Shoes> shoeList = new ArrayList<>();
    shoeList.addAll(cdForm.values());
  }

  public static void sortByBrand() {
    List<Shoes> shoeList = new ArrayList<>();
    shoeList.addAll(cdForm.values());
  }
}
