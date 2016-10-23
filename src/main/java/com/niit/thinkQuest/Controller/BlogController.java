 package com.niit.thinkQuest.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.thinkQuest.Service.IBolgService;
import com.niit.thinkQuest.model.Blog;

@Controller
public class BlogController
{
	@Autowired
	IBolgService iBlogService;

	//For Adding Blog
	@RequestMapping(value = { "blog" })
	public ModelAndView Blog(HttpServletRequest request,@ModelAttribute("thinkQuest")Blog b,BindingResult result) 
	{
		iBlogService.addBlog(b);
		System.out.println("Blog");
		ModelAndView mv=new ModelAndView("viewblog","command",new Blog());
		return mv;
	}
	
	//To Display the blog and search for blog
	@RequestMapping(value=  { "viewblog"})
	public ModelAndView viewblog() {
		String jsonData="";
		//objectmapper is used 2 bring value instead of returning the total object
		ObjectMapper mapper=new ObjectMapper();
		try 
		{
			jsonData=mapper.writeValueAsString(iBlogService.viewBlog());
			System.out.println(jsonData);
		}
		catch (JsonGenerationException e)
		{
			e.printStackTrace();
		}
		catch (JsonMappingException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return new ModelAndView("viewblog","command",new Blog()).addObject("blogs", jsonData);
	}
}
