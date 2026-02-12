<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Courier Record</title>
</head>
<body>
 <h2>View Courier Record</h2>

    <form action="MainServlet" method="post">
        <input type="hidden" name="operation" value="viewRecord">

        Sender Name:
        <input type="text" name="senderName" required><br><br>

        Ship Date:
        <input type="date" name="shipDate" required><br><br>
        <input type="submit" value="View Courier">
    </form>
</body>
</html>