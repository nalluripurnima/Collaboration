package com.niit.thinkQuest.Controller;

import java.io.IOException;
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

import com.niit.thinkQuest.Service.IChatService;
import com.niit.thinkQuest.Service.IFriendService;
import com.niit.thinkQuest.Service.IUserService;
import com.niit.thinkQuest.model.Chat;
import com.niit.thinkQuest.model.User;

@Controller
public class ChatController {
	
	@Autowired
	IChatService iChatService;

	@Autowired
	IUserService iUserService;
	
	User friend;

	@Autowired
	IFriendService iFriendService;
	
	
	
	@RequestMapping(value=  { "viewChatUsers"})
	public ModelAndView viewchat(HttpServletRequest request,@Valid @ModelAttribute("thinkQuest") Chat c,BindingResult result) 
	{
		System.out.println("view chat");
		ModelAndView mv=new ModelAndView("viewChatUsers","command",new Chat());
		mv.addObject("chatusers", iUserService.viewUsers());
		//mv.addObject(iChatService.viewChat(c.getFromUser(),c.getToUser()));
		/*mv.addObject("friendRequests",iFriendService.viewAllRequest(iUserService.getUser().getUserid()));*/
		return  mv; 
	}
	
	@RequestMapping(value=  { "startChart"})
	public ModelAndView startChart(HttpServletRequest request) {
		System.out.println("start chat");
		String frdid=request.getParameter("frdid");
		System.out.println("hg");
		Chat chat=new Chat();
		chat.setFromUser(String.valueOf(iUserService.get().getUserid()));
		ModelAndView mv=new ModelAndView("viewChatUsers","command",chat);
		mv.addObject("user",iUserService.get());
		System.out.println("hgsdc");
		System.out.print(iChatService.viewChat(chat.getFromUser(),chat.getToUser()));
		mv.addObject("msgs",iChatService.viewChat(chat.getFromUser(),chat.getToUser()));
		System.out.println("hgsdc");
		mv.addObject("chatusers", iUserService.viewUsers());
		System.out.println("hcvh");
		friend=iFriendService.retriveFriend(Integer.parseInt(frdid));
		mv.addObject("friend",friend);
		return  mv; 
	}
	
	@RequestMapping(value = "storechat", method=RequestMethod.POST)
	public String storeChat(HttpServletRequest request,@Valid @ModelAttribute("thinkQuest") Chat c,BindingResult result) 
	{
		System.out.println("storing chat here "+c.getFromUser());
		c.setToUser(String.valueOf(friend.getUserid()));
		System.out.println("hii chat here");
		c.setFromUser(String.valueOf(iUserService.get().getUserid()));
		System.out.println("helllloooo");
		iChatService.addChat(c);
		System.out.println("chating....!");
		 //mv.addObject("", iChatService.addChat(c));
		return "redirect:/viewChatUsers";
		
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

