package com.student.course.registration.portal.service;

import com.student.course.registration.portal.dao.StudentDao;
import com.student.course.registration.portal.dto.StudentDto;

public class StudentService {
    StudentDao studentDao = new StudentDao();

    public void addStudentDto(StudentDto studentDto) {
        studentDao.addStudentDTO(studentDto);
    }

    public boolean isStudentExists(StudentDto studentDto) {
        return  studentDao.isStudentExists(studentDto);
    }
}
