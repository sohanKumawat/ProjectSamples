package com.demo.slk.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LamdaSample {

	@SuppressWarnings("serial")
	public void add() {
		String str = "Ok, let''s get started on some gift ideas.";

		Map<String, HashMap<String, Integer>> map = new HashMap<>();
		map.put("2017-11-10", new HashMap<String, Integer>() {
			{
				put("telco.order.backorder.instruction", 12);
				put("telco.order.cancellation", 32);
			}
		});
		map.put("2017-11-11", new HashMap<String, Integer>() {
			{
				put("telco.order.backorder.instruction", 323);
				put("telco.order.cancellation", 32);
			}
		});
		map.put("2017-11-9", new HashMap<String, Integer>() {
			{
				put("telco.order.backorder.instruction", 22);
				put("telco.order.cancellation", 32);
			}
		});
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//Date date1 = sdf.parse("2017-11-10");
		/*map.entrySet().stream().filter(val -> {
			Date mDate = sdf.parse(val.toString());
			if (mDate.compareTo(date1) > 0) {
				map.get(val.toString());
			}

		});*/
		/*
		 * if (date1.after(date2)) { System.out.println("Date1 is after Date2");
		 * }
		 * 
		 * if (date1.before(date2)) {
		 * System.out.println("Date1 is before Date2"); }
		 * 
		 * if (date1.equals(date2)) {
		 * System.out.println("Date1 is equal Date2"); }
		 */
		str = str.replaceAll("''", "'");
		System.out.println("str" + str);
	}

	public static void main(String[] args) {
		Map<String,Integer> tmap=new HashMap<>();
		tmap.merge("sohan", 1, (oldValue, value) -> oldValue + value); 
		tmap.merge("sohan", 1, (oldValue, value) -> oldValue + value); 
		tmap.merge("sohan", 1, (oldValue, value) -> oldValue + value); 
		System.out.println(tmap.get("sohan"));
		
		Function<Integer,Integer> add1 = x -> x + 1;
int count =10;
        Integer two = add1.apply(count);
        System.out.println("** count ** "+count +" two "+two);
		LocalDateTime currentTimeInLosAngeles = LocalDateTime.now(ZoneId.of("America/Los_Angeles"));
		// current time in UTC time zone
		LocalDateTime nowInUtc = LocalDateTime.now();
		System.out.println(currentTimeInLosAngeles.toString()+"  "+nowInUtc.toString());
		
//List<Employee> emLst=new ArrayList();
//emLst.add(new Employee("sohan"));
//emLst.add(new Employee("sohan1"));
//emLst.add(new Employee("sohan2"));
//emLst.add(new Employee("sohan3"));
//Employee em=emLst.get(0);
//em.setName("mohan");
//emLst.get(1).setName("sdfcsfgx");
//		System.out.println(emLst);

		 Map<Integer, String> HOSTING = new HashMap<>();
	        HOSTING.put(1, "linode.com");
	        HOSTING.put(2, "heroku.com");
	        HOSTING.put(3, "digitalocean.com");
	        HOSTING.put(4, "aws.amazon.com");

	        //Map -> Stream -> Filter -> Map
	        Map<Integer, String> collect = HOSTING.entrySet().stream()
	                .filter(map -> map.getKey() == 2)
	                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));

	        System.out.println(collect); //output : {2=heroku.com}
	        
	        


	        	      
	        	     /* Stream<HashMap<String,Integer>> students = map.stream()
	        	    	      .filter(p ->minDate.compareTo(sdf.parse(p.getKey())<0 && maxDate.compareTo(p.getKey())>0)
	        	    	      .map(new Function<Map<String,HashMap<String ,Integer>>, HashMap<String ,Integer>>() {
	        	                  @Override
	        	                  public HashMap<String ,Integer> apply(Map<String,HashMap<String ,Integer>> person) {
	        	                     return (HashMap<String, Integer>) person.values();
	        	                  }
	        	              });*/
 

	}
	@SuppressWarnings({ "serial", "unused", "rawtypes" })
	public void TestMethod(){
try{
Map<String,HashMap<String ,Integer>> map=new HashMap<>();
map.put("2017-11-10",new HashMap<String,Integer>(){{
	put("telco.order.backorder.instruction",12);
	put("telco.order.cancellation",32);
	}});
map.put("2017-11-11",new HashMap<String,Integer>(){{
	put("telco.order.backorder.instruction",323);
	put("telco.order.cancellation",32);
	}});
map.put("2017-11-9",new HashMap<String,Integer>(){{
	put("telco.order.backorder.instruction",22);
	put("telco.order.cancellation",32);
	}});
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
Date minDate = sdf.parse("2017-11-10");
Date maxDate = sdf.parse("2017-11-13");
		
Function fction=new Function<Map<String,HashMap<String ,Integer>>, HashMap<String ,Integer>>() {
    @SuppressWarnings("unchecked")
	@Override
    public HashMap<String ,Integer> apply(Map<String,HashMap<String ,Integer>> person) {
       return (HashMap<String, Integer>) person.values();
    }
};

		/*Stream<HashMap<String,Integer>> students = ((Collection<Entry<String, HashMap<String, Integer>>>) map).stream()
				.filter(p ->{
					try {
						return minDate.compareTo(sdf.parse(p.getKey()))<0 && maxDate.compareTo(sdf.parse(p.getKey()))>0;
					} catch (ParseException e) {
						e.printStackTrace();
					}
					return false;
				})
				.map(fction).collect(Collectors.groupingBy());*/
		HashMap<String,HashMap<String,Integer>> students = (HashMap<String, HashMap<String, Integer>>) map.entrySet().stream()
				.filter(p ->{
					try {
						return minDate.compareTo(sdf.parse(p.getKey()))<0 && maxDate.compareTo(sdf.parse(p.getKey()))>0;
					} catch (ParseException e) {
						e.printStackTrace();
					}
					return false;
				}).collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
		
		Stream<Map<String,Integer>> finalstudents =  map.entrySet().stream()
				.filter(p -> {
					try {
						return minDate.compareTo(sdf.parse(p.getKey().toString()))!=-1 && minDate.compareTo(sdf.parse(p.getKey().toString()))!=1;
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return false;
				})
				.map(rmap->rmap.getValue());
		
	//Iterator<Map<String, Integer>>	mp=finalstudents.iterator();
		Map<String, Integer> result = new HashMap<>();
		finalstudents.forEach(vmap -> {
			System.out.println(vmap.toString());
		    result.putAll(vmap.entrySet().stream()
		        .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue())));
		});
		System.out.println(result.toString());
		//HashMap<String,Integer> vl=(HashMap<String, Integer>) finalstudents.collect(Collectors.toMap(Entry::getKey, e -> String.valueOf(e.getValue())));
		
		//HashMap<String,Integer> vl=finalstudents.collect(Collectors.toMap(p -> ((Entry<Integer, String>) p).getKey(), p -> p.getValue()));
	}catch(Exception ex){
		ex.printStackTrace();
	}
	}

}
