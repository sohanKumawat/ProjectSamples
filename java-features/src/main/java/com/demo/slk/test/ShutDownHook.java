package com.demo.slk.test;

public class ShutDownHook
{
  public static void main(String[] args)
  {
    System.out.println("Application Terminating ...");
  }
static{
	  Runtime.getRuntime().addShutdownHook(new Thread()
	    {
	      public void run()
	      {
	        System.out.println("Shutdown Hook is running !");
	      }
	    });
  }
}
