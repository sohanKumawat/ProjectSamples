package com.demo.slk.java7;

public class MyAutoClosable implements AutoCloseable {

    public void doIt() {
        System.out.println("MyAutoClosable doing it!");
    }
    @Override
    public void close() throws Exception {
        System.out.println("MyAutoClosable closed!");
    }
    private static void myAutoClosable()  {
        try(MyAutoClosable myAutoClosable = new MyAutoClosable()){
            myAutoClosable.doIt();
        }
        catch(Exception ex){
        	
        }
    }
    private static void tryCatch() throws Exception {
        try{
        	System.out.println("Inside the tryCatch block");
        	//throw new Exception();
        }
        catch(Exception ex){
        	ex.printStackTrace();
        }
        finally{
        	System.out.println("Inside the finally block");
        }
        
    }
    public static void main(String str[]){
    	try{
    		MyAutoClosable.tryCatch();
    	}
    	catch(Exception ex){
    		ex.printStackTrace();
    	}
    }
}
