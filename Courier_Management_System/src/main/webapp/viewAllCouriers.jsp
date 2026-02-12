<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All Courier Records</title>
</head>
<body>
<h2>View All Courier Records</h2>

    <form action="MainServlet" method="post">
        <input type="hidden" name="operation" value="viewAllRecords">
        <input type="submit" value="View All Records">
    </form>
</body>
</html>