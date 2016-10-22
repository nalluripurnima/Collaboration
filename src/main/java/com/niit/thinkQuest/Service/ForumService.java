package com.niit.thinkQuest.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.thinkQuest.DAO.ForumDAO;
import com.niit.thinkQuest.model.Forum;

@Service
public class ForumService implements IForumService 
{
	@Autowired(required=true)
	private ForumDAO fd;
	
	public void addQuestion(Forum question)
	{
		fd.addQuestion(question);
	}

	public List<Forum> viewForum() 
	{
		return fd.viewForum();
	}

	public boolean deleteQuestion(int id)
	{
		return fd.deleteQuestion(id);
	}

	public Forum getQuestion(int id)
	{
		return fd.getQuestion(id);
	}
}
