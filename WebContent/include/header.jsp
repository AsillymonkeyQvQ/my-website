<%@ page contentType="text/html; charset=utf-8"%>

<header id="header">
    <div class="logo">
        <a href="<%= request.getContextPath() %>">Asillymonkey</a>
    </div>
    <nav class="navigation">
        <ul>
            <li><a href="<%= request.getContextPath() %>/category/LIFESTYLE">LIFESTYLE</a></li>
            <li><a href="<%= request.getContextPath() %>/category/TECHNOLOGY">TECHNOLOGY</a></li>
            <li><a href="<%= request.getContextPath() %>/category/JAPANESE">JAPANESE</a></li>
            <li><a href="<%= request.getContextPath() %>/category/ANIMATION">ANIMATION</a></li>
        </ul>
    </nav>
</header>