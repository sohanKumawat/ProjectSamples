package ai.msg.training.portal.common.utils;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;

public class CsrfFilter extends OncePerRequestFilter
{
 
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
    {
    	System.out.println("inside the CsrfFilter doFilterInternal");
        CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class
                .getName());
        if (csrf != null) {
            Cookie cookie = new Cookie("XSRF-TOKEN", csrf.getToken());
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        filterChain.doFilter(request, response);
    }
}
