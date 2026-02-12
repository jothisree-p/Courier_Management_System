<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Add Courier Record</title>
</head>
<body>
<h2>Add Courier Record</h2>

    <form action="MainServlet" method="post">
        <input type="hidden" name="operation" value="newRecord">

        Sender Name:
        <input type="text" name="senderName" required><br><br>

        Receiver Name:
        <input type="text" name="receiverName" required><br><br>

        Courier Item:
        <input type="text" name="courierItem" required><br><br>

        Ship Date:
        <input type="date" name="shipDate" required><br><br>

        <input type="submit" value="Add Courier">
    </form>

</body>
</html>