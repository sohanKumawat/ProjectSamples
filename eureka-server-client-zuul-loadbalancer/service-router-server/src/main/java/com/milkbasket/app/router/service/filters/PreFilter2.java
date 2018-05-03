package com.milkbasket.app.router.service.filters;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
public class PreFilter2 extends ZuulFilter {
 
	  @Override
	  public String filterType() {
	    return "pre";
	  }
 
	  @Override
	  public int filterOrder() {
	    return 2;
	  }
 
	  @Override
	  public boolean shouldFilter() {
	    return true;
	  }
 
	  @Override
	  public Object run() {
	    RequestContext ctx = RequestContext.getCurrentContext();
	    HttpServletRequest request = ctx.getRequest();
 
	    log.info("PreFilter 2: " + String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
	    
	    return null;
	  }
}
