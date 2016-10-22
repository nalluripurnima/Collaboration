package com.niit.thinkQuest.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.thinkQuest.Service.ICommentService;
import com.niit.thinkQuest.model.Comment;

@Controller
public class CommentController {
	
	@Autowired
	ICommentService iCommentService;
	
	Comment comment;;
	
	@RequestMapping(value=  { "comment"})
	public ModelAndView comment() {
		System.out.println("comment");
		return new ModelAndView("comment","command",new Comment());
	}
	
	@RequestMapping(value = "store5", method=RequestMethod.POST)
	public ModelAndView addblog(HttpServletRequest request,@Valid @ModelAttribute("thinkQuest") Comment c,BindingResult result) {
		System.out.println("addcomment");
		iCommentService.addComment(c);
		return new ModelAndView("home","command",new Comment());
	}

	@RequestMapping(value=  {"viewcomment"})
	public ModelAndView viewcomment() {
		String jsonData="";
		ObjectMapper mapper=new ObjectMapper();
		try {
			jsonData=mapper.writeValueAsString(iCommentService.viewComment());
			System.out.println(jsonData);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ModelAndView("viewcomment","command",new Comment()).addObject("comments", jsonData);
	}

}
