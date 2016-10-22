package com.niit.thinkQuest.Service;

import java.util.List;

import com.niit.thinkQuest.model.Comment;

public interface ICommentService {
	
	public void addComment(Comment comment);
	public List<Comment> viewComment();
	

}
