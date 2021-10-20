<%--
  Created by IntelliJ IDEA.
  User: supra
  Date: 20/10/2021
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pl">
<head>
    <title>Budżet domowy</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
<main>
    <h1>Budżet domowy</h1>
    <section class="summary">
        <h2>Podsumowanie</h2>
        <p>Wpływy: ${requestScope.incomeSum}zł</p>
        <p>Wydatki: ${requestScope.expensesSum}zł</p>
        <p>Bilans: ${requestScope.balance}zł</p>
    </section>
    <a href="${pageContext.request.contextPath}/add">Dodaj wpływ lub wydatek</a>
    <c:if test="${not empty requestScope.incomes}">
        <section>
            <h2>Wpływy</h2>
            <table>
                <thead>
                <tr>
                    <th>Opis</th>
                    <th>Kwota</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="income" items="${requestScope.incomes}">
                    <tr>
                        <td><c:out value="${income.description}"/></td>
                        <td>${income.value}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </section>
    </c:if>
    <c:if test="${not empty requestScope.expenses}">
        <section>
            <h2>Wydatki</h2>
            <table>
                <thead>
                <tr>
                    <th>Opis</th>
                    <th>Kwota</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="expense" items="${requestScope.expenses}">
                    <tr>
                        <td><c:out value="${expense.description}"/></td>
                        <td>${expense.value}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </section>
    </c:if>
</main>
</body>
</html>
