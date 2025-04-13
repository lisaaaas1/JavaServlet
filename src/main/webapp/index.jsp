<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>File Explorer</title>
    <style>
            /* Стили для кнопки выхода */
            .logout-button {
                position: absolute;
                top: 10px;
                right: 10px;
                padding: 10px 15px;
                background-color: #f44336; /* Красный цвет */
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                font-size: 16px;
            }

            .logout-button:hover {
                background-color: #d32f2f; /* Темнее при наведении */
            }
        </style>
</head>
<body>

    <h1>File Explorer</h1>
    <p>Generated at: ${generatedTime}</p>
    <p>Current Directory: ${currentPath}</p>

    <c:if test="${not empty parentPath}">
        <a href="file-explorer?path=${parentPath.replace('\\', '/')}">Up one level</a><br>
    </c:if>
    <form action="${pageContext.request.contextPath}/login" method="post" style="display:inline;">
            <button type="submit" class="logout-button">Выйти</button>
        </form></body>

    <ul>
        <c:forEach var="file" items="${files}">
            <li>
                <c:choose>
                    <c:when test="${file.isDirectory()}">
                        <a href="file-explorer?path=${file.getAbsolutePath().replace('\\', '/')}">📁 ${file.getName()}</a>
                    </c:when>
                    <c:otherwise>
                        <a href="download?path=${file.getAbsolutePath().replace('\\', '/')}">📄 ${file.getName()}</a>
                    </c:otherwise>
                </c:choose>
            </li>
        </c:forEach>
    </ul>

</html>