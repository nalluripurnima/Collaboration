package com.niit.thinkQuest.Service;

import java.util.List;

import com.niit.thinkQuest.model.Blog;

public interface IBolgService {
	
	public void addBlog(Blog blog);
	public List<Blog> viewBlog();
	public boolean deleteBlog(int id);
	public void updateBlog(Blog blog);
}
