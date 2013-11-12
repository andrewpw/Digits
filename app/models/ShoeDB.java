package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.ProductFormData;

public class ShoeDB {

  private static Map<String, Shoes> cdForm = new HashMap<>();
  private static List<Shoes> sort = new ArrayList<>();
  private static List<Shoes> shoeList2 = new ArrayList<>();
  private static boolean sorted = false;
  private static String typeStat;
  
  public static Shoes add(ProductFormData fData) {
    
    Shoes shoe;
    int i = 0;
    
    shoe = new Shoes(fData.brand, fData.model, fData.type, fData.description, fData.price, fData.size,
          fData.sex, fData.url, fData.index);
    if(cdForm.size() % 3 == 0){
      i = 0;
    }
    else {
      i = 1;
    }
    //shoe.setIndex(i);
    //System.out.println(fData.index + fData.brand + fData.model + fData.size);
      cdForm.put(fData.brand + fData.model + fData.size, shoe);
      //System.out.println(cdForm.keySet());
    return shoe;
  }
  
  public static Shoes getShoes(String name) {
    System.out.println(name);
    Shoes shoe = cdForm.get(name);
    if (shoe == null) {
      return null;
    }
    return shoe;
  }

  public static List<Shoes> getShoeList(String types) {
    List<Shoes> shoeList = new ArrayList<>();
    if(!types.equals("sort") && !types.equals("price") && !types.equals("brand")){
      typeStat = types;
    }
    //System.out.println(typeStat);
    shoeList.addAll(cdForm.values());
    //System.out.println("ShoeList " +shoeList.size());
    int i = 0;
    //System.out.println(shoeList.get(0).getIndex() + shoeList.get(1).getIndex() + shoeList.get(2).getIndex());

    if(sorted == false){
      shoeList2.clear();
    if(typeStat.equals("MensShoes")){
      int j = 0;
      
      while(i < shoeList.size()){
        if(shoeList.get(i).getSex() == 'M' && shoeList.get(i).getType().equals("Shoes")){
          //System.out.println("Blah");
        shoeList.get(i).setIndex(j);
        shoeList2.add(shoeList.get(i));
        j++;
        }
        i++;
      }
    }
    if(typeStat.equals("MensShirts")){
      int j = 0;
      while(i < shoeList.size()){
        if(shoeList.get(i).getSex() == 'M' && shoeList.get(i).getType().equals("Shirt")){
        shoeList.get(i).setIndex(j);
        shoeList2.add(shoeList.get(i));
        j++;
        }
        i++;
      }
    } 
    if(typeStat.equals("MensPants")){
      int j = 0;
      while(i < shoeList.size()){
        if(shoeList.get(i).getSex() == 'M' && shoeList.get(i).getType().equals("Pants")){
        shoeList.get(i).setIndex(j);
        shoeList2.add(shoeList.get(i));
        j++;
        }
        i++;
      }
    } 
    if(typeStat.equals("MensHats")){
      int j = 0;
      while(i < shoeList.size()){
        if(shoeList.get(i).getSex() == 'M' && shoeList.get(i).getType().equals("Hat")){
        shoeList.get(i).setIndex(j);
        shoeList2.add(shoeList.get(i));
        j++;
        }
        i++;
      }
    } 
    if(typeStat.equals("WomensShoes")){
      int j = 0;
      while(i < shoeList.size()){
        if(shoeList.get(i).getSex() == 'W' && shoeList.get(i).getType().equals("Shoes")){
        shoeList.get(i).setIndex(j);
        shoeList2.add(shoeList.get(i));
        j++;
        }
        i++;
      }
    } 
    if(typeStat.equals("WomensShirts")){
      int j = 0;
      while(i < shoeList.size()){
        if(shoeList.get(i).getSex() == 'W' && shoeList.get(i).getType().equals("Shirt")){
        shoeList.get(i).setIndex(j);
        shoeList2.add(shoeList.get(i));
        j++;
        }
        i++;
      }
    } 
    if(typeStat.equals("WomensPants")){
      int j = 0;
      while(i < shoeList.size()){
        if(shoeList.get(i).getSex() == 'W' && shoeList.get(i).getType().equals("Pants")){
        shoeList.get(i).setIndex(j);
        shoeList2.add(shoeList.get(i));
        j++;
        }
        i++;
      }
    } 
    if(typeStat.equals("WomensHats")){
      int j = 0;
      while(i < shoeList.size()){
        if(shoeList.get(i).getSex() == 'W' && shoeList.get(i).getType().equals("Hat")){
        shoeList.get(i).setIndex(j);
        shoeList2.add(shoeList.get(i));
        j++;
        }
        i++;
      }
    } 
    if(typeStat.equals("KidsShoes")){
      int j = 0;
      while(i < shoeList.size()){
        if(shoeList.get(i).getSex() == 'Y' && shoeList.get(i).getType().equals("Shoes")){
        shoeList.get(i).setIndex(j);
        shoeList2.add(shoeList.get(i));
        j++;
        }
        i++;
      }
    } 
    if(typeStat.equals("KidsShirts")){
      int j = 0;
      while(i < shoeList.size()){
        if(shoeList.get(i).getSex() == 'Y' && shoeList.get(i).getType().equals("Shirt")){
        shoeList.get(i).setIndex(j);
        shoeList2.add(shoeList.get(i));
        j++;
        }
        i++;
      }
    } 
    if(typeStat.equals("KidsPants")){
      int j = 0;
      while(i < shoeList.size()){
        if(shoeList.get(i).getSex() == 'Y' && shoeList.get(i).getType().equals("Pants")){
        shoeList.get(i).setIndex(j);
        shoeList2.add(shoeList.get(i));
        j++;
        }
        i++;
      }
    } 
    if(typeStat.equals("KidsHats")){
      int j = 0;
      while(i < shoeList.size()){
        if(shoeList.get(i).getSex() == 'Y' && shoeList.get(i).getType().equals("Hat")){
        shoeList.get(i).setIndex(j);
        shoeList2.add(shoeList.get(i));
        j++;
        }
        i++;
      }
    }
    }
    if(sorted == true){
      shoeList2 = sort;
    }
    sorted = false;
    //System.out.println("Here "+shoeList2.size());
    //System.out.println("Here2 "+sort.size());
    return shoeList2;
  }
  
  public static List<Shoes> getSortList(){
    return sort;
  }
  
  public static void sortBySize() {
    sort.clear();
    int i = 0, j = 6;
    List<Shoes> shoeList = new ArrayList<>();
    List<Shoes> sortList = new ArrayList<>();
    //shoeList.addAll(cdForm.values());
    if(typeStat.contains("Shoes") || typeStat.contains("Hats")){
      //System.out.println(typeStat);
      //System.out.println("size"+shoeList2.size()+"i"+i+"j"+j);
    while (j < 14){
      while (i < shoeList2.size()){
        if((shoeList2.get(i).getSize().compareTo(Integer.toString(j))) == 0){
          shoeList2.get(i).setIndex(sortList.size());
          sortList.add(shoeList2.get(i));
        }
        i++;
      }
      i = 0;
      j++;
    }
    }
    else {
      j = 0;
      String size;
      while (j < 6){
      while (i < shoeList2.size()){
        switch(j){
        case 0:
          size = "S";
          break;
        case 1:
          size = "M";
          break;
        case 2:
          size = "L";
          break;
        case 3:
          size = "XL";
          break;
        case 4:
          size = "XXL";
          break;
        case 5:
          size = "XXXL";
          break;
        default:
          size = "";
          break;
        }
        if((shoeList2.get(i).getSize().compareTo(size)) == 0){
          shoeList2.get(i).setIndex(sortList.size());
          sortList.add(shoeList2.get(i));
        }
        i++;
      }
      i=0;
      j++;
      }
    }
    sort = sortList;
    sorted = true;
  }

  public static void sortByPrice() {
    sort.clear();
    int i = 1, j = 0;
    Shoes[] shoeArray = shoeList2.toArray(new Shoes[0]);
    Shoes temp;
    while (j < shoeList2.size()){
      while (i < shoeList2.size()){
        if(shoeArray[i].getPrice() < shoeArray[j].getPrice()){
          temp = shoeArray[i];
          shoeArray[i] = shoeArray[j];
          shoeArray[j] = temp;
        }
        i++;
      }
      i = 0;
      j++;
    }
    i = 0;
    System.out.println("Two" + shoeList2.size());
    while (i < shoeList2.size()){
      shoeArray[i].setIndex(i);
      sort.add(shoeArray[i]);
      i++;
    }
    sorted = true;
  }

  public static void sortByBrand() {
    List<Shoes> shoeList = new ArrayList<>();
    shoeList.addAll(cdForm.values());
  }
  
}
