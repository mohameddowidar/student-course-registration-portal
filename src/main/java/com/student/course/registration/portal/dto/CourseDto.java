package com.student.course.registration.portal.dto;

import java.util.Date;

public class CourseDto {
    private int courseId;
    private String  CourseName;
    private String CourseDescription;
    private int CourseHour;
    private String createdBy;
    private java.sql.Date registrationDeadline;
    private java.sql.Date startDate;
    private java.sql.Date endDate;
    private int availableSeats;

    public CourseDto(String courseName, String courseDescription, int courseHour, Date registrationDeadlineObj, Date startDateObj, Date endDateObj, int availableSeatsObj) {
        CourseName = courseName;
        CourseDescription = courseDescription;
        CourseHour = courseHour;
    }

    public CourseDto(int courseId, String courseName, String courseDescription, int courseHour) {
        this.courseId = courseId;
        CourseName = courseName;
        CourseDescription = courseDescription;
        CourseHour = courseHour;
    }

    public CourseDto(int courseId, String courseName, String courseDescription, int courseHour, String createdBy,
                     java.sql.Date registrationDeadline, java.sql.Date startDate, java.sql.Date endDate, int availableSeats) {
        this.courseId = courseId;
        this.CourseName = courseName;
        this.CourseDescription = courseDescription;
        CourseHour = courseHour;
        this.createdBy = createdBy;
        this.registrationDeadline = registrationDeadline;
        this.startDate = startDate;
        this.endDate = endDate;
        this.availableSeats = availableSeats;
    }
    public CourseDto( String courseName, String courseDescription, int courseHour, String createdBy,
                     java.sql.Date registrationDeadline, java.sql.Date startDate, java.sql.Date endDate, int availableSeats) {
        this.CourseName = courseName;
        this.CourseDescription = courseDescription;
        CourseHour = courseHour;
        this.createdBy = createdBy;
        this.registrationDeadline = registrationDeadline;
        this.startDate = startDate;
        this.endDate = endDate;
        this.availableSeats = availableSeats;
    }
    public CourseDto(String courseName, String courseDescription, int courseHour,
                     java.sql.Date registrationDeadline, java.sql.Date startDate, java.sql.Date endDate, int availableSeats) {
        CourseName = courseName;
        CourseDescription = courseDescription;
        CourseHour = courseHour;
        this.registrationDeadline = registrationDeadline;
        this.startDate = startDate;
        this.endDate = endDate;
        this.availableSeats = availableSeats;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getCourseDescription() {
        return CourseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        CourseDescription = courseDescription;
    }

    public int getCourseHour() {
        return CourseHour;
    }

    public void setCourseHour(int courseHour) {
        CourseHour = courseHour;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public java.sql.Date getRegistrationDeadline() {
        return registrationDeadline;
    }

    public void setRegistrationDeadline(java.sql.Date registrationDeadline) {
        this.registrationDeadline = registrationDeadline;
    }

    public java.sql.Date getStartDate() {
        return startDate;
    }

    public void setStartDate(java.sql.Date startDate) {
        this.startDate = startDate;
    }

    public java.sql.Date getEndDate() {
        return endDate;
    }

    public void setEndDate(java.sql.Date endDate) {
        this.endDate = endDate;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}
