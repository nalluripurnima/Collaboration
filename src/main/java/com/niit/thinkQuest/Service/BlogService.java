package com.niit.thinkQuest.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.thinkQuest.DAO.BolgDAO;
import com.niit.thinkQuest.model.Blog;

@Service
public class BlogService implements IBolgService
{
	@Autowired(required=true)
	private BolgDAO b;
	
	public void addBlog(Blog blog)
	{
		 b.addBlog(blog);
	}

	public List<Blog> viewBlog()
	{
		return b.viewBlog();
	}

	public boolean deleteBlog(int id)
	{
		return b.deleteBlog(id);
	}

	public void updateBlog(Blog blog) 
	{
		b.updateBlog(blog);
	}	
}