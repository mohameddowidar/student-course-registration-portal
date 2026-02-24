<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.List" %>
<%@ page import="com.student.course.registration.portal.dto.CourseDto" %>

<!DOCTYPE html>
<html>
<head>
    <title>Courses</title>
    <link rel="stylesheet" href="/student_course_registration_portal/resources/css/styles.css">
    <script src="/student_course_registration_portal/resources/js/index.js"></script>
</head>
<body>

<%@ include file="header.jsp" %>

<div class="layout">
    <%@ include file="sidebarLayout.jsp" %>
    <main class="content">
        <h3>Courses</h3>


        <h3>Add Course</h3>
        <form action="/student_course_registration_portal/courses" method="post">
            <div class="form-group">
                <label for="name">Course Name:</label>
                <input name="name" id="name" type="text" required>
            </div>

            <div class="form-group">
                <label for="desc">Description:</label>
                <input name="desc" id="desc" type="text" required>
            </div>

            <div class="form-group">
                <label for="hours">Hours:</label>
                <input name="hours" id="hours" type="number" required>
            </div>

            <div class="form-group">
                <label for="available_seats">Available Seats:</label>
                <input name="available_seats" id="available_seats" type="number" required>
            </div>

            <div class="form-group">
                <label for="registration_deadline">Registration Deadline:</label>
                <input name="registration_deadline" id="registration_deadline" type="date">
            </div>

            <div class="form-group">
                <label for="start_date">Start Date:</label>
                <input name="start_date" id="start_date" type="date" required>
            </div>

            <div class="form-group">
                <label for="end_date">End Date:</label>
                <input name="end_date" id="end_date" type="date" required>
            </div>
            <div class="form-group">
                <label for="created_by">created by:</label>
                <input name="created_by" id="created_by" type="text" required>
            </div>
            <button type="submit">Add Course</button>
        </form>


        <c:if test="${not empty courseList}">
            <p>Course list size: ${fn:length(courseList)}</p>
        </c:if>

        <table id="courseTable">
            <thead>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Hours</th>
                <th>available seats</th>
                <th>registration deadline</th>
                <th>start date</th>
                <th>end date</th>
                <th>created by</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <%
                List courseList = (List) request.getAttribute("courseList");
                if (courseList != null) {
                    for (Object obj : courseList) {
                        CourseDto course = (CourseDto) obj;
            %>
            <tr>
                <td><%= course.getCourseName() %>
                </td>
                <td><%= course.getCourseDescription() %>
                </td>
                <td><%= course.getCourseHour() %>
                </td>
                <td><%= course.getAvailableSeats() %>
                </td>
                <td><%= course.getRegistrationDeadline() %>
                </td>
                <td><%= course.getStartDate() %>
                </td>
                <td><%= course.getEndDate() %>
                </td>
                <td><%= course.getCreatedBy() %>
                </td>
                <td>
                    <button onclick="editCourse(<%= course.getCourseId() %>)">Edit</button>
                    <button onclick="deleteCourse(<%= course.getCourseId() %>)">Delete</button>
                </td>
            </tr>
            <%
                }
            } else {
            %>
            <tr>
                <td colspan="8">No courses available</td>
            </tr>
            <%
                }
            %>
            </tbody>

        </table>
        <!-- Edit Modal -->
        <div id="modal" class="modal">
            <div class="modal-content">
                <h3>Edit Course</h3>
                <input id="editName">
                <input id="editDesc">
                <input id="editHours" type="number">
                <button onclick="saveEdit()">Save</button>
                <button onclick="closeModal()">Cancel</button>
            </div>
        </div>
    </main>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>
