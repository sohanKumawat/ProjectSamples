package ai.msg.training.portal.interceptor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ai.msg.training.portal.property.beans.RedirectUrls;


public final class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	private RedirectUrls redirectUrls;
	
	public static final String LOGIN_URL="/login";
	
	private static Logger LOGGER = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws IOException, ServletException{

		for(int i=0;i<redirectUrls.getAllowedUrls().size();i++){
			if(request.getServletPath().trim().contains(redirectUrls.getAllowedUrls().get(i).trim())){
				return true;
			}
		}
		if(this.isAuthenticated()){
			List<String> restrictUrl=redirectUrls.getLoginRestrictedUrls();
			String urls=restrictUrl.get(0);
			String[] urlList=urls.split(",");
			for(int i=0;i<urlList.length;i++){
				String url=urlList[i];
                String servletPath=request.getServletPath();
				if(url != null && url.equalsIgnoreCase(servletPath)){
					response.sendRedirect(redirectUrls.getLoggedInRedirectionUrl());
			        return false;
				}
				
			}
		}else{
			//LOGGER.debug("user is not authenticated {}");
			if(!request.getServletPath().equals(LOGIN_URL)){
				response.sendRedirect(LOGIN_URL);
	        return false;
			}
			
		}
		return true;
	}
	
	 private boolean isAuthenticated() {
	        Authentication authentication =
	                        SecurityContextHolder.getContext().getAuthentication();
	        if (authentication == null) {
	            return false;
	        }
	        if (authentication instanceof AnonymousAuthenticationToken) {
	            return false;
	        }
	        return authentication.isAuthenticated();
	    }
	
	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		
	}

}
