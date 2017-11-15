package com.demo.slk.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
	static Map<String,HashMap<String ,Integer>> intMap=null;
	static Map<String,Integer> testMap1=null;
	static Map<String,Integer> testMap2=null;
	static Map<String,HashMap<String ,Integer>> testMap3=null;
	static Map<String ,Integer> countMap=null;

SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	static{
		
		testMap1=new HashMap<String,Integer>(){{
	put("x1",432412);
	put("x2",21);
	}};
		testMap2=new HashMap<String,Integer>(){{
			put("x1",32);
			put("x2",32);
			}};
		
			testMap3=new HashMap<>();
			testMap3.put("x",new HashMap<String,Integer>(){{
		put("xx",323);
		put("x1",21);
		}});
			testMap3.put("y",new HashMap<String,Integer>(){{
		put("xx",211);
		put("x1",12);
		}});
			
		intMap=new HashMap<>();
		intMap.put("2017-11-12",new HashMap<String,Integer>(){{
	put("telco.order.backorder.instruction",432412);
	put("telco.order.cancellation",21);
	}});
		intMap.put("2017-11-14",new HashMap<String,Integer>(){{
	put("telco.order.backorder.instruction",4324);
	put("telco.order.cancellation",12);
	}});
		intMap.put("2017-11-15",new HashMap<String,Integer>(){{
	put("telco.order.backorder.instruction",3432);
	put("telco.order.cancellation",2);
	}});
		intMap.put("2017-11-11",new HashMap<String,Integer>(){{
	put("telco.order.backorder.instruction",432);
	put("telco.order.cancellation",45);
	}});
		intMap.put("2017-11-09",new HashMap<String,Integer>(){{
	put("telco.order.backorder.instruction",321);
	put("telco.order.cancellation",40);
	}});
		intMap.put("2017-11-07",new HashMap<String,Integer>(){{
	put("telco.order.backorder.instruction",432);
	put("telco.order.cancellation",9);
	}});
		
		countMap=new HashMap<>();
		countMap.put("2017-11-12",6546);
		countMap.put("2017-11-11",12);
		countMap.put("2017-11-10",432);
		countMap.put("2017-11-09",645);
	}
	Date minDate=null;
	Date maxDate=null;
	public Test(){
		try {
			minDate = sdf.parse("2017-11-10");
			maxDate = sdf.parse("2017-11-15");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void add() {}

	public static void main(String[] args) {
		
	String val=	LocalDate.parse("2017-11-09")
		.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDateTime currentTimeInLosAngeles = LocalDateTime.now(ZoneId.of("America/Los_Angeles"));
		System.out.println("** val ** "+val);
		// current time in UTC time zone
		/*LocalDateTime nowInUtc = LocalDateTime.now();
		System.out.println(currentTimeInLosAngeles.toString()+"  "+nowInUtc.toString());
		new Test().getIntentByDateRange();
		new Test().getCountByDateRange();*/
		
		new Test().getfinalMapByCount();
	}
	
	public Map<String, Integer> getIntentByDateRange(){
		HashMap<String,HashMap<String,Integer>> dFilteMap = (HashMap<String, HashMap<String, Integer>>) intMap.entrySet().stream()
				.filter(p ->{
					try {
						return minDate.compareTo(sdf.parse(p.getKey()))<0 && maxDate.compareTo(sdf.parse(p.getKey()))>0;
					} catch (ParseException e) {
						e.printStackTrace();
					}
					return false;
				}).collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
		
		Stream<Map<String,Integer>> finalstudents =  dFilteMap.entrySet().stream()
				.map(rmap->rmap.getValue());
		
		Map<String, Integer> result = new HashMap<>();
		finalstudents.forEach(vmap -> {
		    result.putAll(vmap.entrySet().stream()
		        .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue(),(v1,v2)->v1+v2)));
		});
		System.out.println("Intent result by date range ** "+result.toString());
		return result;
	}
	
	public Map<String, Integer> getfinalMapByCount(){
		
		/*Map<Object, Integer> totalVisitCounts1 = testMap3.entrySet().stream()
				.map(rmap->rmap.getValue()).collect(Collectors.toMap(
			        entry -> entry.getKey(), // The key
			        entry -> entry.getValue(), // The value
			        // The "merger" as a method reference
			        Integer::sum
			    ));*/
		   
		Map<String, Integer> totalVisitCounts = Stream.concat(testMap1.entrySet().stream(), testMap2.entrySet().stream())
			    .collect(Collectors.toMap(
			        entry -> entry.getKey(), // The key
			        entry -> entry.getValue(), // The value
			        // The "merger" as a method reference
			        Integer::sum
			    ));
		System.out.println("Intent result by date range ** "+totalVisitCounts.toString());
		return totalVisitCounts;
	}
	
	public HashMap<String,Integer> getCountByDateRange(){
		HashMap<String,Integer> dValueCount = (HashMap<String, Integer>) countMap.entrySet().stream()
				.filter(p ->{
					try {
						return minDate.compareTo(sdf.parse(p.getKey()))<0 && maxDate.compareTo(sdf.parse(p.getKey()))>0;
					} catch (ParseException e) {
						e.printStackTrace();
					}
					return false;
				}).collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
		System.out.println("date by count result ** "+dValueCount.toString());
		return dValueCount;
	}
	
	@SuppressWarnings("unchecked")
	public List<Integer> getIntentByDate(Map<String,Integer> mapValues){
			List<Integer> value  =  mapValues.entrySet().stream()
					.map(rmap->rmap.getValue()).collect(Collectors.toList());
			return value ;
		}
}
