<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Регистрация</title>
</head>
<body>

<div class="form-container">
    <h2>Регистрация</h2>
    <c:if test="${not empty error}">
            <div class="alert alert-danger">${error}</div>
        </c:if>
    <form action="register" method="post">
        <div class="form-group">
            <label for="login">Логин:</label>
            <input type="text" id="login" name="login" required>
        </div>
        <div class="form-group">
            <label for="password">Пароль:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" required>
        </div>
        <button type="submit" class="submit-button">Зарегистрироваться</button>
    </form>
    <p>Уже есть аккаунт? <a href="login">Вход</a></p>

</div>
</body>
</html>