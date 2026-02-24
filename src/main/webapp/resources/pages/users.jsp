<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.student.course.registration.portal.dto.UserDto" %>

<!DOCTYPE html>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" href="/student_course_registration_portal/resources/css/styles.css">
</head>
<body>

<%@ include file="header.jsp" %>

<div class="layout">
    <%@ include file="sidebarLayout.jsp" %>
     <main class="content">
         <h3>Users</h3>
         <h3>Add Users</h3>
         <form action="/student_course_registration_portal/users" method="post">
             <input name="first_name" type="text"  placeholder="first name" required>
             <input name="last_name"  type="text" placeholder="last name" required>
             <input name="user_role"  type="text" placeholder="role" required>
             <input name="email" type="email" placeholder="email" required>
             <input name="password" type="password" placeholder="password" required>
             <button type="submit">Add User</button>
         </form>

         <h3>Users Management</h3>
        <table>
            <thead>
            <tr>
                <th>Name</th>
                <th>Role</th>
            </tr>
            </thead>
            <tbody>

            <%
                List<UserDto> usersList =
                        (List<UserDto>) request.getAttribute("UsersList");

                if (usersList != null && !usersList.isEmpty()) {
                    for (UserDto user : usersList) {
            %>

            <tr>
                <td><%= user.getFirstName() %>
                </td>
                <td><%= user.getRole() %>
                </td>
            </tr>

            <%
                }
            } else {
            %>

            <tr>
                <td colspan="2">No users found</td>
            </tr>

            <%
                }
            %>

            </tbody>
        </table>
    </main>
</div>

<%@ include file="footer.jsp" %>

</body>
</html>
