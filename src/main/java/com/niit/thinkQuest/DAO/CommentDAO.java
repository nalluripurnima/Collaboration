package com.niit.thinkQuest.DAO;

import java.util.List;

import com.niit.thinkQuest.model.Comment;

public interface CommentDAO {
	
	public void addComment(Comment comment);

	public List<Comment> viewComment();
	


}
