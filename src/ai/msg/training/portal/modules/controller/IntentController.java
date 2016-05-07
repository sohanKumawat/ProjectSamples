package ai.msg.training.portal.modules.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ai.msg.training.portal.common.beans.HttpRequestSataus;
import ai.msg.training.portal.common.beans.User;
import ai.msg.training.portal.module.intent.beans.Attributes;
import ai.msg.training.portal.module.intent.beans.ConversationTopic;
import ai.msg.training.portal.module.intent.beans.IntentAttributes;
import ai.msg.training.portal.module.intent.beans.IntentDto;
import ai.msg.training.portal.module.intent.beans.Prompt;
import ai.msg.training.portal.serviceImpl.IntentTrainerService;

@Controller
public class IntentController extends BaseController{

	
	@Autowired
	IntentTrainerService trainerService;
	User user=null;
	@RequestMapping(value="topicCreation",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody HttpRequestSataus  topicCreation(@RequestBody ConversationTopic topicModel){
	     user=this.getTenantUser();
	     topicModel.setTenantId(String.valueOf(user.getTenantAccountId()));
		return trainerService.saveEntity(topicModel);
	}
	
	@RequestMapping(value="intentCreation",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody HttpRequestSataus  intentCreation(@RequestBody IntentDto intentDto){
		 user=this.getTenantUser();
		intentDto.setTenantId(String.valueOf(user.getTenantAccountId()));
		return trainerService.saveEntity(intentDto);
		
	}
	
	@RequestMapping(value="attributeCreation",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody HttpRequestSataus  attributeCreation(@RequestBody Attributes atrModel){
		 user=this.getTenantUser();
		atrModel.setTenantId(String.valueOf(user.getTenantAccountId()));
		return trainerService.saveEntity(atrModel);
	}
	
	@RequestMapping(value="promptCreation",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody HttpRequestSataus  promptCreation(@RequestBody Prompt promptModel){
		 user=this.getTenantUser();
		promptModel.setTenantId(String.valueOf(user.getTenantAccountId()));
		return trainerService.saveEntity(promptModel);
	}
	
	@RequestMapping(value="intentAttributeAssociation",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody HttpRequestSataus  intentAttributeAssociation(@RequestBody IntentAttributes intentAttr){
		 user=this.getTenantUser();
		intentAttr.setTenantId(String.valueOf(user.getTenantAccountId()));
		return trainerService.saveEntity(intentAttr);
	}
	
	@RequestMapping(value="allTopicIntent",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody IntentDto  fetchAllTopicIntent(HttpServletRequest request,HttpServletResponse response){
		
		
		return new IntentDto();
	}
	
	@RequestMapping(value="intentExpressionAnalyzer",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<Attributes>  intentExpressionAnalyzer(HttpServletRequest request,HttpServletResponse response){
		
		return trainerService.fetchAllAttributes();
	}
	
	@RequestMapping(value="fetchIntentAttribute",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<Attributes>  fetchIntentAttribute(HttpServletRequest request,HttpServletResponse response){
		
		 return trainerService.fetchAllAttributes();
		
	}
	
	
}
