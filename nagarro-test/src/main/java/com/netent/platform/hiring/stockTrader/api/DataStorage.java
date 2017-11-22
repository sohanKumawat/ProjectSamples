package com.netent.platform.hiring.stockTrader.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
/**
 * The DataStorage class used to maintain data in persist state so it store data in disk
 * 
 * @param filePath is the external file used to store data on disk
 * 
 * @param userStock used to store data for this application
 * 
 * @author sohan kumawat
 *
 */
public class DataStorage implements Serializable {
	private static final long serialVersionUID = 707958072697906865L;
   // private static String filePath="/home/sohan/Desktop/projects/sohan/learning/storage1.txt";
	private static Properties properties=null;
	public static Map<String,List<StockTransferTransactionRequest>> userStock=new ConcurrentHashMap<>();

	static{
		 try{
			 readConfiguration();
		  readFromFile();
		  System.out.println("** userStock ** "+userStock.toString());
		  Runtime.getRuntime().addShutdownHook(new Thread()
		    {
		      public void run()
		      {
		    	  System.out.println("Shutdown Hook is running to persist data into file");
		    	 try{
		    		 writeToFile();
		    	 }catch(Exception ex){
		    		 ex.printStackTrace();
		    	 }
		      }
		    });
		 }
		 catch(Exception ex){
			 ex.getMessage();
			 ex.printStackTrace();
		 }
	  }
	/**
	 * This method used to read data from external file{@param filePath} and initialize @param userStock map ,
	 * 
	 * @param filePath
	 *           external file to store data on disk
	 * @param userStock
	 *            this used to maintain data for the application
	 * @throws InvalidTransactionRequestException
	 *             if the file not exist of not able to load
	 */
	@SuppressWarnings("unchecked")
	public static void readFromFile() throws InvalidTransactionRequestException{
		 try (ObjectInputStream ois=new ObjectInputStream(new FileInputStream(new File(properties.getProperty("file_path"))))) {
			 userStock=(Map<String, List<StockTransferTransactionRequest>>) ois.readObject();
	    }catch(FileNotFoundException e){
	    	throw new InvalidTransactionRequestException(" DataStorage, This file not exist ** "+properties.getProperty("file_path"));
	    }
		 catch(Exception e){
			 throw new InvalidTransactionRequestException("DataStorage, Stored file not loaded properly, file path is "+properties.getProperty("file_path"));
	    }
	}
	/**
	 * This method used to write  @param userStock map data to external file{@param filePath} ,
	 * 
	 * @param filePath
	 *           external file to store data on disk
	 * @param userStock
	 *            this used to maintain data for the application
	 * @throws InvalidTransactionRequestException
	 *             if the file not exist of not able to load
	 */
public static void writeToFile() throws InvalidTransactionRequestException{
	 try (ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File(properties.getProperty("file_path"))))) {
	        oos.writeObject(userStock);
	 }catch(FileNotFoundException e){
	    	throw new InvalidTransactionRequestException(" DataStorage, This file not exist ** "+properties.getProperty("file_path"));
	    }
		 catch(Exception e){
			 throw new InvalidTransactionRequestException("DataStorage, File writer is not working fine, file path is "+properties.getProperty("file_path"));
	    }
	}
/**
 * This method used to read all the application level configuration properties and store into properties class
 *
 * @throws InvalidTransactionRequestException
 *             if the file not exist of not able to load
 */
public static void readConfiguration() throws InvalidTransactionRequestException{
	try (FileInputStream is=new FileInputStream(new File("config.properties"))) {
		properties = new Properties();
		properties.load(is);
	 }catch(FileNotFoundException e){
	    	throw new InvalidTransactionRequestException(" DataStorage, This file not exist ** "+properties.getProperty("file_path"));
	    }
		 catch(Exception e){
			 throw new InvalidTransactionRequestException("DataStorage, File writer is not working fine, file path is "+properties.getProperty("file_path"));
	    }
}
public static void main(String[] str){
	new DataStorage();
}
}
