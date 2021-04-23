package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.jvnet.hk2.annotations.Service;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Course;
@Component
public class CourseServiceImpl implements CourseService {
	
	List<Course> list;
	public CourseServiceImpl() {
		list=new ArrayList<>();
		list.add(new Course(123,"Java","Basics of java"));
		list.add(new Course(124,"Python","Basics of python"));
		list.add(new Course(125,"JavaScript","Basics of javascript"));
	}

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Course getCourse(long courseId) {
		// TODO Auto-generated method stub
		Course c=null;
		for(Course course:list) {
			if(course.getId()==courseId) {
				c=course;
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		// TODO Auto-generated method stub
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		list.forEach(e-> {
			if(e.getId()==course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
		});
		// TODO Auto-generated method stub
		return course;
	}

	@Override
	public Course deleteCourse(long parseLong) {
		// TODO Auto-generated method stub
		list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
	    return null;
	}

}
