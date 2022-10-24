<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="index.jsp" %>
<!DOCTYPE html>
<html>
    <body>
        <form action="/companies/update" method="post">
            <label for="name"><font color="#ffffff">Company ID:</font></label><br>
            <input type="text" id="companyId" name="companyId"><br>
            <label for="name"><font color="#ffffff">Company name:</font></label><br>
            <input type="text" id="companyName" name="companyName"><br>
            <label for="name"><font color="#ffffff">City:</font></label><br>
            <input type="text" id="city" name="city"><br>
            <label for="name"><font color="#ffffff">E-mail:</font></label><br>
            <input type="text" id="email" name="email"><br>
            <button type="submit">Update</button>
        </form>
    </body>
</html>