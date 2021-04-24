package fr.data;

import com.google.gson.JsonArray;

/**
 * This interface is use to give the ability to a object to serialize/deserialize itself into/from a string
 * 
 * @version 2.0 26 Apr 2021
 * 
 * @author Max Labbe
 * @author Mathieu Way
 * @author Ophelie Foucault
 * 
 */
public interface ISerializable {
    /**
     * Serialize the object into a string
     * @return
     */
     public String Serialize();
     
     /**
      * Deserialize a json String into a Object/List
      * @param json to be deserialize
      * @return
      */
     public void Deserialize(String json);
}
