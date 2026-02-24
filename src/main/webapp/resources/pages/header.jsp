<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String studentEmail = (String) session.getAttribute("userEmail");
    String firstName = (String) session.getAttribute("firstName");
    String lastName = (String) session.getAttribute("lastName");

%>
<header class="top-header">
    <div class="user-info">
        👤 <%= firstName + " " + lastName %>
    </div>
    <div class="header-right">
        <span id="datetime"></span>
        <button onclick="toggleMode()" class="toggle">🌙</button>
        <button class="logout-btn" onclick="logout()">
            Logout
        </button>
    </div>
</header>