package com.demo.slk.apachecamel.filter;

import org.apache.camel.Exchange;
//.filter(and(body().startsWith("Camel"), method(new CamelArticles(), "filterOnlyCamelComponents")))
public class TitleFilter {
	public boolean filter(Exchange exchange) {
        Entry entry = exchange.getIn().getBody(Entry.class);
        String title = entry.getTitle();
        boolean camelArticles = title.toLowerCase().startsWith("camel");
        if (camelArticles) {
            System.out.println("allow " + title);
        }
        return camelArticles;
    }
    public boolean filterOnlyCamelComponents(String body) {       
        boolean camelArticles = body.toLowerCase().contains("component");
        return camelArticles;
    }
    
    public static class Entry{
    	private String title;
    	public String getTitle(){
    		return this.title;
    	}
    	public void settitle(String title){
    		this.title=title;
    	}
    }
}
