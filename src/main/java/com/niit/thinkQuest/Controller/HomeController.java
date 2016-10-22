package com.niit.thinkQuest.Controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

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

import com.niit.thinkQuest.Service.IBolgService;
import com.niit.thinkQuest.Service.ICommentService;
import com.niit.thinkQuest.Service.IEventService;
import com.niit.thinkQuest.Service.IForumService;
import com.niit.thinkQuest.Service.IFriendService;
import com.niit.thinkQuest.Service.IUserService;
import com.niit.thinkQuest.model.Blog;
import com.niit.thinkQuest.model.Comment;
import com.niit.thinkQuest.model.Event;
import com.niit.thinkQuest.model.Forum;
import com.niit.thinkQuest.model.Friend;
import com.niit.thinkQuest.model.User;
import com.niit.thinkQuest.model.UserFriend;

@Controller
public class HomeController {
	
	private static final int userId = 0;


	@Autowired
	IUserService iUserService;
	
	@Autowired
	IEventService iEventService;
	
	@Autowired
	IFriendService iFriendService;
	
    		
	/*@RequestMapping(value=  { "/" , "home"})
	public ModelAndView login() {
		System.out.println("home");
		return new ModelAndView("home");
	}
	*/
		
	@RequestMapping(value = { "/","login" })
	public ModelAndView Login() {
		System.out.println("Login");
		return new ModelAndView("login","command",new User());
	}
		
	@RequestMapping(value = { "register" })
	public ModelAndView signup() {
		System.out.println("signup");
		return new ModelAndView("register","command",new User());
	}
			
	@RequestMapping(value=  {"viewFriend"})
	public ModelAndView viewfriend() {
		int fndid;
		ModelAndView mv=new ModelAndView("viewFriend");
		mv.addObject("users", toJson(iUserService.viewUsers()));
		mv.addObject("friendRequests",iFriendService.viewAllRequest(iUserService.get().getUserid()));
		return  mv; 
		
	}

	@RequestMapping(value = { "/addasfriend" })
	public ModelAndView view(HttpServletRequest request, @ModelAttribute("thinkQuest") UserFriend uf,BindingResult result) 
	{
		String fid = request.getParameter("u");
		System.out.println(fid);
		int Uid = 0;
		int fndid = 0;
		System.out.println(iUserService.get().getName());
		iFriendService.addFriend(iUserService.get(),Integer.parseInt(fid));
		return new ModelAndView("home","welcome",iUserService.get());
	}

	@RequestMapping(value = { "/acceptfriend" })
	public String view(HttpServletRequest request, @ModelAttribute("thinkQuest") Friend f,BindingResult result) 
	{
		String frndId = request.getParameter("f");
		System.out.println("accept request"+frndId);
		iFriendService.updateFriend(Integer.parseInt(frndId));
		return "redirect:/viewFriend";
	}
	
	public String toJson(List data){
		String jsonData="";
		ObjectMapper mapper=new ObjectMapper();
		try {
			jsonData=mapper.writeValueAsString(data);
			System.out.println(jsonData);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonData;
	}
}