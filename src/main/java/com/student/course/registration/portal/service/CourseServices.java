package com.student.course.registration.portal.service;

import com.student.course.registration.portal.dao.CourseDao;
import com.student.course.registration.portal.dto.CourseDto;

import java.util.List;

public class CourseServices {
    CourseDao courseDao = new CourseDao();

    public void addCourse(CourseDto courseDto) {
        courseDao.addCourseDTO(courseDto);
    }

    public List<CourseDto> getCourses() {
        return courseDao.getAllCourses();
    }
    public Integer getNumberOfCourses(){
      return   courseDao.getCoursesNumber();
    }
}
