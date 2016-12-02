package com.niit.thinkQuest.Controller;

import java.io.IOException;
import java.util.List;

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

import com.niit.thinkQuest.Service.IFriendService;
import com.niit.thinkQuest.Service.IUserService;
import com.niit.thinkQuest.model.Friend;
import com.niit.thinkQuest.model.User;
import com.niit.thinkQuest.model.UserFriend;

@Controller
public class FriendController {
	
	@Autowired
	IUserService iUserService;
	
	@Autowired
	IFriendService iFriendService;
	
	
	@RequestMapping(value=  {"viewFriend"})
	public ModelAndView viewfriend() {
		System.out.println("viewfriend");
		
		ModelAndView mv=new ModelAndView("viewFriend","command",new User());
		mv.addObject("users", toJson(iUserService.viewUsers()));
		mv.addObject("friendRequests",iFriendService.viewAllRequest(iUserService.get().getUserid()));
		mv.addObject("friends",iFriendService.viewAllFriends(iUserService.get()));
		mv.addObject("user",iUserService.get());
		return  mv; 
		
	}
	
	User user;

	@RequestMapping(value = { "/addasfriend" })
	public ModelAndView view(HttpServletRequest request, @ModelAttribute("thinkQuest") UserFriend f,BindingResult result) 
	{
		System.out.println("addfnd");
		String fid = request.getParameter("u");
		System.out.println(fid);
		System.out.println("user n frds");
		System.out.println(iUserService.get().getName());
		iFriendService.addFriend(iUserService.get(),Integer.parseInt(fid));
		System.out.println("siri red");
		System.out.println("contro");
		UserFriend userFriend=new UserFriend();
    	System.out.println("what the fish...!!!!");
    	userFriend.setStatus("Requested");
    	Friend friend=new Friend();
    	System.out.println("fishyy it field");
		friend.setUser(user);
    	List<User> frnd=iUserService.viewUsers();
        friend.setUser(user);;
    	System.out.println("i hate eclipse");
    	userFriend.setFriend(friend);
    	System.out.println("pichhhiiiiii.......");
    	
		return new ModelAndView("home","welcome",iUserService.get());
	}



	@RequestMapping(value = { "/acceptfriend" })
	public String view(HttpServletRequest request, @ModelAttribute("thinkQuest") Friend f,BindingResult result) 
	{
		System.out.println("accfnd");
		String fid = request.getParameter("f");
		System.out.println("heyyoo");
		iFriendService.updateFriend(Integer.parseInt(fid));
		System.out.println("userid");
		System.out.println("teddy");
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

