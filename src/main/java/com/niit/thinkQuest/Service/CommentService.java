package com.niit.thinkQuest.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.thinkQuest.DAO.CommentDAO;
import com.niit.thinkQuest.model.Comment;


@Service
public class CommentService implements ICommentService
{
	@Autowired(required=true)
	private CommentDAO cd;

	public void addComment(Comment comment) 
	{
		cd.addComment(comment);
	}
	
	public List<Comment> viewComment()
	{
		return cd.viewComment();
	}

	}

