package views.formdata;
import java.util.HashMap;
import java.util.Map;
import models.Contact;

/**
 * 
 * Holds the telephone type data for the drop down list.
 * @author Andrew
 *
 */
public class TelephoneTypes {

  private static Map<String, Boolean> telMap = new HashMap<>();
  static {
    telMap.put("Mobile", false);
    telMap.put("Home", false);
    telMap.put("Work", false);
  }
  /**
   * 
   * No arguments constructor.
   */
  public TelephoneTypes(){
  }
  
  public TelephoneTypes(Contact contact){
    telMap.put(contact.getTelType(), true);
  }
  
  /**
   * returns a map of all acceptable telephone types and a boolean to tell if they are selected
   * @return telMap the telephone map
   */
  public static Map<String, Boolean> getTypes(){
    return telMap;
  }
  
  /**
   * returns a map of all acceptable telephone types and a boolean to tell if they are selected
   * @param telType the type of telephone to be added
   * @return telMap the telephone map
   */
  public static Map<String, Boolean> getTypes(String telType){
    telMap.put(telType, true);
    return telMap;
  }
  
  /**
   * returns boolean indicating if the provided telephone type is legal.
   * @return isLegal a boolean to indicate if the telephone type is legal
   */
  public static Boolean isTypes(String telType){
    return telMap.containsKey(telType);
  }
}
