<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, com.student.course.registration.portal.dto.CourseDto" %>

<!DOCTYPE html>
<html>
<head>
    <title>Course Registration</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/styles.css">
    <script src="<%= request.getContextPath() %>/resources/js/index.js"></script>
</head>
<body>
<%@ include file="header.jsp" %>

<div class="layout">
    <%@ include file="sidebarLayout.jsp" %>

    <main class="content">
        <h3>Register Student</h3>

        <form action="<%= request.getContextPath() %>/registration" method="post">

            <div class="form-group">
                <label>Student Name:</label>
                <input type="text" value="<%= firstName %> <%= lastName %>" readonly>
            </div>

            <div class="form-group">
                <label>Select Course:</label>
                <select name="courseId" required>
                    <option value="">-- Select Course --</option>

                    <%
                        List<CourseDto> courses =
                                (List<CourseDto>) request.getAttribute("courseList");

                        for (CourseDto c : courses) {
                    %>
                    <option value="<%= c.getCourseId() %>">
                        <%= c.getCourseName() %>
                    </option>
                    <%
                        }
                    %>
                </select>
            </div>

            <button type="submit">Register</button>

        </form>
    </main>
</div>

<%@ include file="footer.jsp" %>

</body>
</html>
