<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/customers/find">
            <label for="name"><font color="#ffffff">Customer ID:</font></label><br>
            <input type="text" id="customerId" name="customerId"><br>
            <button type="submit">Find</button>
        </form><br>
        <c:if test="${not empty customer.id}">
            <table>
                <thead>
                    <tr>
                        <th>Customer ID:</th>
                        <th>Customer name:</th>
                        <th>Country:</th>
                        <th>E-mail:</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <c:out value="${customer.id}"/>
                        </td>
                        <td>
                            <c:out value="${customer.customerName}"/>
                        </td>
                        <td>
                            <c:out value="${customer.country}"/>
                        </td>
                        <td>
                            <c:out value="${customer.email}"/>
                        </td>
                    </tr>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty customer.id}">
            <p><font color="#ffffff">${message}</font></p>
        </c:if>
    </body>
</html>