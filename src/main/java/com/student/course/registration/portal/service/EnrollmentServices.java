package com.student.course.registration.portal.service;

import com.student.course.registration.portal.dao.EnrollmentDao;
import com.student.course.registration.portal.dto.EnrollmentDto;

public class EnrollmentServices {
    EnrollmentDao enrollmentDao = new EnrollmentDao();
    public void addEnrollment(EnrollmentDto enrollmentDto){
        enrollmentDao.addEnrollment(enrollmentDto);
    }
}
