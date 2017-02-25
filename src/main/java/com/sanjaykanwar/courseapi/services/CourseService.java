package com.sanjaykanwar.courseapi.services;

import com.sanjaykanwar.courseapi.models.Course;
import com.sanjaykanwar.courseapi.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicId){
         List<Course> courseList = new ArrayList<>();
         courseRepository.findByTopicId(topicId).forEach(courseList::add);
         return  courseList;
    }

    public Course getTopic(final String id){
        return courseRepository.findOne(id);
    }

    public void create(Course course){
        courseRepository.save(course);
    }


    public void update(Course newCourse){
        courseRepository.save(newCourse);
    }


    public void delete(String id){
        courseRepository.delete(id);
    }

}
