<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.wipro.courier.bean.CourierBean" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Courier Records</title>
</head>
<body>
    <h2>All Courier Records</h2>

    <%
        List<CourierBean> list = (List<CourierBean>) request.getAttribute("list");
        String message = (String) request.getAttribute("message");

        if (list == null || list.isEmpty()) {
    %>
        <p><b><%= message %></b></p>
    <%
        } else {
    %>
        <table border="1">
            <tr>
                <th>Courier ID</th>
                <th>Sender Name</th>
                <th>Receiver Name</th>
                <th>Courier Item</th>
                <th>Ship Date</th>
                <th>Delivery Date</th>
                <th>Status</th>
                <th>Remarks</th>
            </tr>

            <%
                for (CourierBean bean : list) {
            %>
            <tr>
                <td><%= bean.getCourierId() %></td>
                <td><%= bean.getSenderName() %></td>
                <td><%= bean.getReceiverName() %></td>
                <td><%= bean.getCourierItem() %></td>
                <td><%= bean.getShipDate() %></td>
                <td><%= bean.getDeliveryDate() %></td>
                <td><%= bean.getStatus() %></td>
                <td><%= bean.getRemarks() %></td>
            </tr>
            <%
                }
            %>
        </table>
    <%
        }
    %>

</body>
</html>
