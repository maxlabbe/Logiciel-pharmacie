package fr.data;

import com.google.gson.Gson;

import java.io.OutputStreamWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * This interface is use to manipulate file containing data from databases
 * 
 * @version 2.0 26 Apr 2021
 * 
 * @author Max Labbe
 * @author Mathieu Way
 * @author Ophelie Foucault
 * 
 */
public class FileManager {
    /**
     * Save a database into a Json File
     * @param databaseName name of the file to save the database into
     * @param database
     */
    public static void SaveDatabase(String databaseName, ISerializable database){
	Gson gson = new Gson();
        try {
            OutputStreamWriter logFile = new OutputStreamWriter(new FileOutputStream(databaseName + ".json"), StandardCharsets.UTF_8);
            logFile.write(gson.toJson(database));
            logFile.close();
        } catch (IOException e) {
            System.out.println("Un erreur est survenu lors de la sauvegarde d'une base de données (name:" + databaseName + ")");
            e.printStackTrace();
        }
    }

    /**
     * Load a database from a Json File
     * @param <T>
     * @param databaseName name of the file to load the database from
     * @param type
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static <T> T LoadDatabase(String databaseName, Class<T> type) throws IllegalAccessException, InstantiationException {
	Path dbPath = Paths.get(databaseName + ".json");
        try {
            String json = Files.readString(dbPath);
            return new Gson().fromJson(json, type);
	} catch (IOException e) {
	    	// Get the file
	        File f = new File(dbPath.toString());
	        // Check if the specified file
	        // Exists or not
	        if (f.exists()){
	            System.out.println("Un erreur est survenu lors du chargement d'une base de donn�es (name:" + databaseName + ")");
	            e.printStackTrace();
	            return null;
	        }
	        else {
		    System.out.println("Création d'une base de donnée de type: " + type.getName());
	            return type.newInstance();
	        }
        }
    }
}
