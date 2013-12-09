package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import views.formdata.ProductFormData;

public class ProductDB {
  
  public static Product add(ProductFormData fData) {
    
    Product shoe;
    
    shoe = new Product(fData.brand, fData.model, fData.type, fData.description, fData.price, fData.size,
          fData.sex, fData.url);
    shoe.save();
    return shoe;
  }
  
  public static Product getProducts(String name) {
    System.out.println(name);
    Product shoe = Product.find().where().eq("name", name).findUnique();
    if (shoe == null) {
      return null;
    }
    return shoe;
  }

  public static List<Product> getShoeList() {
    return Product.find().all();
  }
  
  public static boolean compareSize(String size1, String size2) {
    
    try {
      int s = Integer.parseInt(size1);
      int s2 = Integer.parseInt(size2);
      if (s <= s2){ 
        return true;
      }
      else {
        return false;
      }
    }
    catch (NumberFormatException e){
      int size1int;
      if (size1.equals("S")){
        size1int = 0;
      }
      else if (size1.equals("M")){
        size1int = 1;
      }
      else if (size1.equals("L")){
        size1int = 2;
      }
      else if (size1.equals("XL")){
        size1int = 3;
      }
      else if (size1.equals("XXL")){
        size1int = 4;
      }
      else if (size1.equals("XXXL")){
        size1int = 5;
      }
      else{
        size1int = 6;
      }
      int size2int;
      if (size2.equals("S")){
        size2int = 0;
      }
      else if (size2.equals("M")){
        size2int = 1;
      }
      else if (size2.equals("L")){
        size2int = 2;
      }
      else if (size2.equals("XL")){
        size2int = 3;
      }
      else if (size2.equals("XXL")){
        size2int = 4;
      }
      else if (size2.equals("XXXL")){
        size2int = 5;
      }
      else{
        size2int = 6;
      }
      if (size1int <= size2int){
        return true;
      }
      else {
        return false;
      }
    }
  }
  
  public static List<Product> getShoeList(String type) {
    String sex = type.substring(0, 1);
    System.out.println(sex);
    return Product.find().where().eq("type", type.substring(1)).eq("sex", sex).findList();
    
    
    /*List<Product> shoeList = new ArrayList<>();
    List<Product> shoeList2 = new ArrayList<>();
    shoeList.addAll();
    Iterator<Product> it = shoeList.iterator();
    Product shoe;
    while (it.hasNext()){
      shoe = it.next();
      if ((shoe.getSex() + shoe.getType()).equals(type)){
        shoeList2.add(shoe);
      }
    }
    return shoeList2;*/
  }
  
  public static List<Product> getSortList(String type) {
    String sex = type.substring(0, 1);
    System.out.println(sex);
    return Product.find().where().eq("type", type.substring(1)).eq("sex", sex).orderBy().desc("size").findList();
  }
    /*
    List<Product> shoeList = new LinkedList<>();
    Object[] inputArray = getShoeList(type).toArray();
    inputArray = mergeSort(inputArray);

    for (int j = 0; j < inputArray.length; j++) {
        shoeList.add((Product)inputArray[j]);
    }
    return shoeList;
  }
  
  static Object[] mergeSort(Object[] A) {
    if (A.length > 1) {
        int q = A.length/2;

        Object[] leftArray = Arrays.copyOfRange(A, 0, q);
        Object[] rightArray = Arrays.copyOfRange(A,q,A.length);

        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(A,leftArray,rightArray);
    }
    return A;
  }
  
  static void merge(Object[] a, Object[] l, Object[] r) {
      int totElem = l.length + r.length;
      //int[] a = new int[totElem];
      int i,li,ri;
      i = li = ri = 0;
      while ( i < totElem) {
          if ((li < l.length) && (ri<r.length)) {
              if (compareSize(((Product)l[li]).getSize(), ((Product)r[ri]).getSize())) {
                  a[i] = l[li];
                  i++;
                  li++;
              }
              else {
                  a[i] = r[ri];
                  i++;
                  ri++;
              }
          }
          else {
              if (li >= l.length) {
                  while (ri < r.length) {
                      a[i] = r[ri];
                      i++;
                      ri++;
                  }
              }
              if (ri >= r.length) {
                  while (li < l.length) {
                      a[i] = l[li];
                      li++;
                      i++;
                  }
              }
          }
      }
      //return a;
  
  }*/
  
  /*public static void sortBySize() {
    List<Product> shoeList = new ArrayList<>();
    shoeList.addAll(cdForm.values());
  }

  public static void sortByPrice() {
    List<Product> shoeList = new ArrayList<>();
    shoeList.addAll(cdForm.values());
  }

  public static void sortByBrand() {
    List<Product> shoeList = new ArrayList<>();
    shoeList.addAll(cdForm.values());
  }*/
}
