package com.demo.slk.enumtest;
/*
 * internally is user
 * 
 * public static final Modes MODE3 = new Modes("Mode2");
 * */

public enum Modes {
	  MODE1("Mode1"),
	  MODE2("Mode2"),
	  MODE3("Mode3");

	 private String value;
	 public String getValue() {
	    return value;
	   }
	 private Modes(final String value) {
	  this.value = value;
	 } 
	 public static Modes getModeType(String value) {
			if (value != null) {
				for (Modes mode : Modes.values()) {
					if (value.equalsIgnoreCase(mode.getValue())) {
						return mode;
					}
				}
			}
			return null;
		}
	 
	 public static void main(String[] str){
			System.out.println("name "+Modes.MODE1.name().toString());
			System.out.println("getValue "+Modes.MODE1.getValue().toString());
			System.out.println("ordinal "+Modes.MODE1.ordinal());
			System.out.println("getModeType "+Modes.getModeType("Mode1"));
			
	 }
	
	}