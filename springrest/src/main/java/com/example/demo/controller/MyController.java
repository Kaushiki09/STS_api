package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.services.CourseService;
import com.example.demo.entities.Course;
@SpringBootApplication

@RestController
public class MyController {
	@Autowired
	private CourseService courseService;
	//get the courses
	@GetMapping("/courses")
    public List<Course> getCourses()
{
	return this.courseService.getCourses();	
}
	//get single course of given id in url
	@GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId)
{
	return this.courseService.getCourse(Long.parseLong(courseId));	
}
	//add new course 
		@PostMapping("/courses")
	    public Course addCourse(@RequestBody Course course)
	{
		return this.courseService.addCourse(course);	
	}
    //update course 
		@PutMapping("/courses")
	    public Course updateCourse(@RequestBody Course course)
	{
		return this.courseService.updateCourse(course);	
	}
		 //delete course 
		@DeleteMapping("/courses/{courseId}")
	    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId)
	{
			try {
				this.courseService.deleteCourse(Long.parseLong(courseId));
				return new ResponseEntity<>(HttpStatus.OK);
			}catch(Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				
			}
	}
		
}
