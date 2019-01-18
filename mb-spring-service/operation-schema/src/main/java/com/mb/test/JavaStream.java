package com.mb.test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

public class JavaStream {
	@SuppressWarnings("unused")
	public static void main(String str[]) {
	 List<String> items =
             Arrays.asList("apple", "apple", "banana",
                     "apple", "orange", "banana", "papaya");

     Map<String, Long> result =
             items.stream().collect(
                     Collectors.groupingBy(
                             Function.identity(), Collectors.counting()
                     )
             );

    // System.out.println(result);
     streamFunction();
	}
	
	public static void streamFunction() {
		 List<Item> items = Arrays.asList(
	                new Item("apple", 10, new BigDecimal("9.99")),
	                new Item("banana", 20, new BigDecimal("19.99")),
	                new Item("orang", 10, new BigDecimal("29.99")),
	                new Item("watermelon", 10, new BigDecimal("29.99")),
	                new Item("papaya", 20, new BigDecimal("9.99")),
	                new Item("apple", 10, new BigDecimal("9.99")),
	                new Item("banana", 10, new BigDecimal("19.99")),
	                new Item("apple", 20, new BigDecimal("9.99"))
	        );
		 
		  Map<Item, Long> result =
		             items.stream().collect(
		                     Collectors.groupingBy(
		                             Function.identity(), Collectors.counting()
		                     )
		             );
		  
		  System.out.println(result);

	        Map<String, Long> counting = items.stream().collect(
	                Collectors.groupingBy(Item::getName, Collectors.counting()));

	        System.out.println(counting);

	        Map<String, Integer> sum = items.stream().collect(
	                Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));

	        System.out.println(sum);
	}
	@Data
	@AllArgsConstructor
	public  static class Item {

	    private String name;
	    private int qty;
	    private BigDecimal price;
	    @Override
		public boolean equals(Object obj) {

			if (this == obj)
				return true;
			if (obj == null || obj.getClass() != this.getClass())
				return false;
			Item item = (Item) obj;
			return (item.name == this.name && item.name == this.name);
		}

		@Override
		public int hashCode() {
			return this.name.hashCode();
		}
	}
}
