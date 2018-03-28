package com.demo.slk.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TimerTask;



public class Bar<E extends Foo> {

	public static void add() {

	}

	@SuppressWarnings("unused")
	public static void main(String[] str) {
     Bar<?> br=new Bar<>();
     final Collection<? extends Runnable> example1 = new ArrayList<Runnable>();
     final Collection<? extends Runnable> example2 = new ArrayList<TimerTask>();
     final Collection<? super Runnable> example3 = new ArrayList<Runnable>();
     final Collection<? super Runnable> example4 = new ArrayList<Object>();
	}
}
