<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.wipro.courier.bean.CourierBean" %>
<!DOCTYPE html>
<html>
<head>
    <title>Courier Details</title>
</head>
<body>
    <h2>Courier Details</h2>

    <%
        CourierBean bean = (CourierBean) request.getAttribute("bean");
        String message = (String) request.getAttribute("message");

        if (bean == null) {
    %>
        <p><b><%= message %></b></p>
    <%
        } else {
    %>
        <table border="1">
            <tr><th>Courier ID</th><td><%= bean.getCourierId() %></td></tr>
            <tr><th>Sender Name</th><td><%= bean.getSenderName() %></td></tr>
            <tr><th>Receiver Name</th><td><%= bean.getReceiverName() %></td></tr>
            <tr><th>Courier Item</th><td><%= bean.getCourierItem() %></td></tr>
            <tr><th>Ship Date</th><td><%= bean.getShipDate() %></td></tr>
            <tr><th>Delivery Date</th><td><%= bean.getDeliveryDate() %></td></tr>
            <tr><th>Status</th><td><%= bean.getStatus() %></td></tr>
            <tr><th>Remarks</th><td><%= bean.getRemarks() %></td></tr>
        </table>
    <%
        }
    %>

</body>
</html>
