<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>

<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" href="/student_course_registration_portal/resources/css/styles.css">
    <script src="/student_course_registration_portal/resources/js/index.js"></script>
</head>
<%
    Integer coursesNumber = (Integer) request.getAttribute("coursesNumber");
    Integer studentsNumber = (Integer) request.getAttribute("studentsNumber");
    Integer usersNumber = (Integer) request.getAttribute("usersNumber");

%>
<body class="light">

<%@ include file="header.jsp" %>

<div class="layout">
    <%@ include file="sidebarLayout.jsp" %>
    <main class="content">
        <section class="dashboard">
            <div class="card">Courses <span id="courseCount"><%= coursesNumber %> </span></div>
            <div class="card">Users <span><%= usersNumber %></span></div>
            <div class="card">Students <span><%= studentsNumber %></span></div>
        </section>
    </main>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>
