package com.niit.thinkQuest.Service;

import java.util.List;

import com.niit.thinkQuest.model.Forum;

public interface IForumService {
	
	
		public void addQuestion(Forum question);
		public List<Forum> viewForum();
		public boolean deleteQuestion(int id);
		public Forum getQuestion(int id);
	}


