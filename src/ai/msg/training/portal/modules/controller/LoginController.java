package ai.msg.training.portal.modules.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ai.msg.training.portal.daoImpl.QueryIntentDao;
import ai.msg.training.portal.module.intent.beans.IntentBean;
import ai.msg.training.portal.module.intent.beans.IntentChildExpression;

@Controller
public class LoginController{
	

	private static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	QueryIntentDao intentDao;
	
	/*@Autowired
	LoginServiceImpl loginService;
*/
	@RequestMapping(value = "/home***", method = RequestMethod.GET)
	public String defaultPage(HttpServletRequest request,
			HttpServletResponse response) {
	
		/*User user = loginService.get(request.getUserPrincipal().getName());
		loginService.setTenantDetails(user.getTenantAccountId());
		HttpSession session = request.getSession(true);
		session.setAttribute("user", user);
*/
		String inetenexp="i want to book hotel11111111111111";// in new delhi on monday
		
		IntentBean obj=new IntentBean();
		obj.setIntentName("@hotel_booking1111111");
		obj.setIntent_id(1);
		obj.setTenantId("1");
		obj.setIntentMasterExpression(inetenexp);
		IntentChildExpression expression=new IntentChildExpression();
		List<IntentChildExpression> expressionList=new ArrayList<IntentChildExpression>();
		expression.setExpressionText("This is child expression");
		expression.setIntentName("@hotel_booking1111111");
		expression.setTenantId("1");
		expressionList.add(expression);
		obj.setSubExpression(expressionList);
		intentDao.save(obj);
		//intentDao.update();
	//	System.out.println("intentDao record "+intentDao.count());
	//	System.out.println("intent saved ***");
		
		//intentDao.updateByIntentName("this is my updated text",1,"@order_details");
		
/*          obj=intentDao.findAllWithDescriptionQuery("@order_details");
		
				List<IntentAttributes> intentAtr=obj.getIntentAttribute();
				List<IntentExpression> expressionlist=obj.getIntentExpression();
				for(IntentAttributes attribute:intentAtr){
					System.out.println("*** IntentAttribute name ***** "+attribute.getIntentAttribute());
				}
				for(IntentExpression exp:expressionlist){
					System.out.println("*** expression text  ***** "+exp.getIntentExpressionText());
				}

*/		
      return "home";

	}
/*	@RequestMapping(value = "/pages/dashboard", method = {RequestMethod.GET,RequestMethod.POST})
	public String routeDashboard(HttpServletRequest request,
			HttpServletResponse response) {
		return "dashboard";
		//return "index";
	}
*/
	
	
	
	@RequestMapping(value ={"/"} , method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("name", "Msg ai Portal login page");
		// System.out.println("loginDao  : "+loginDao);
		return mv;
	}
	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}
	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();

		// check if user is login
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);

			model.addObject("username", userDetail.getUsername());
		}
		model.setViewName("403");
		return model;
	}
}
