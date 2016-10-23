package com.niit.thinkQuest.Controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.thinkQuest.Service.IForumService;
import com.niit.thinkQuest.model.Event;
import com.niit.thinkQuest.model.Forum;

@Controller
public class ForumController {
	
	@Autowired
	IForumService iForumService;
	
	@RequestMapping(value=  { "forum"})
	public ModelAndView forum() {
		System.out.println("forum");
		return new ModelAndView("forum","command",new Forum());
	}
	@RequestMapping(value = "store2", method=RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request,@Valid @ModelAttribute("thinkQuest") Forum f,BindingResult result) {
		System.out.println("addforum");
		f.setDate(new Date());
		iForumService.addQuestion(f);
		ModelAndView mv=new ModelAndView("store1");
		if(result.hasErrors()){
			mv=new ModelAndView("forum", "command", new Forum());
					mv.addObject("errors", result.getAllErrors());
					for(ObjectError s:result.getAllErrors()){
						System.out.println(s);
					}
		}
		else{
			iForumService.addQuestion(f);
		mv=new ModelAndView("forum", "command", new Forum());
		}
		return mv;
	}
	
	@RequestMapping(value=  {"viewforum"})
	public ModelAndView Viewforum() {
		System.out.println("viewforum");
		String jsonData="";
		ObjectMapper mapper=new ObjectMapper();
		try {
			jsonData=mapper.writeValueAsString(iForumService.viewForum());
			System.out.println(jsonData);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ModelAndView("viewforum","command",new Forum()).addObject("forums", jsonData);
	}


}
