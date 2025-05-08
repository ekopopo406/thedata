package com.lab.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lab.aop.ReadOnly;
import com.lab.mapper.TutorialMapper;
import com.lab.model.Tutorial;

@Service
public class TutorialService {
	
	@Autowired
	private TutorialMapper tutorialMapper;
	
  static List<Tutorial> tutorials = new ArrayList<Tutorial>();
  static long id = 0;

  public List<Tutorial> findAll() {
    return tutorials;
  }

  public List<Tutorial> findByTitleContaining(String title) {
    return tutorials.stream().filter(tutorial -> tutorial.getTitle().contains(title)).toList();
  }

  public Tutorial findById(long id) {
    return tutorials.stream().filter(tutorial -> id == tutorial.getId()).findAny().orElse(null);
  }

  public Tutorial save(Tutorial tutorial) {
    // update Tutorial
    if (tutorial.getId() != 0) {
      long _id = tutorial.getId();

      for (int idx = 0; idx < tutorials.size(); idx++)
        if (_id == tutorials.get(idx).getId()) {
          tutorials.set(idx, tutorial);
          break;
        }

      return tutorial;
    }

    // create new Tutorial
    tutorial.setId(++id);
    tutorials.add(tutorial);
    return tutorial;
  }

  public void deleteById(long id) {
    tutorials.removeIf(tutorial -> id == tutorial.getId());
  }

  public void deleteAll() {
    tutorials.removeAll(tutorials);
  }
  
  public List<Tutorial> findByPublished(boolean isPublished) {
	  List<Tutorial> tutorials = new ArrayList<Tutorial>();
	  
	  QueryWrapper<Tutorial> wrapper = new QueryWrapper<Tutorial>();
	  wrapper.eq("published", true);
	  tutorials =  tutorialMapper.selectList(wrapper);
	  
	  if(tutorials.isEmpty()) {
		  System.out.println("0");
	  }
    return tutorials.stream().filter(tutorial -> isPublished == tutorial.getPublished()).toList();
  }
}
