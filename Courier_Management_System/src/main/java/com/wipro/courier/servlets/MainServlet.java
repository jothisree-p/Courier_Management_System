package com.wipro.courier.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.wipro.courier.bean.CourierBean;
import com.wipro.courier.service.Administrator;
import com.wipro.courier.util.InvalidInputException;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public String addRecord(HttpServletRequest request) throws Exception {

        CourierBean bean = new CourierBean();

        bean.setSenderName(request.getParameter("senderName"));
        bean.setReceiverName(request.getParameter("receiverName"));
        bean.setCourierItem(request.getParameter("courierItem"));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date shipDate = sdf.parse(request.getParameter("shipDate"));
        bean.setShipDate(shipDate);

        Administrator admin = new Administrator();
        return admin.addRecord(bean);
    }
    public CourierBean viewRecord(HttpServletRequest request) throws Exception {

        String senderName = request.getParameter("senderName").trim();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date shipDate = sdf.parse(request.getParameter("shipDate"));

        Administrator admin = new Administrator();
        return admin.viewRecord(senderName, shipDate);
    }
    public List<CourierBean> viewAllRecords(HttpServletRequest request) {

        Administrator admin = new Administrator();
        return admin.viewAllRecords();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String operation = request.getParameter("operation");

        try {
            if ("newRecord".equals(operation)) {

                String result = addRecord(request);

                if ("FAIL".equals(result)) {
                    response.sendRedirect("error.html");
                } else {
                    response.sendRedirect("success.html");
                }
            }
            else if ("viewRecord".equals(operation)) {

                CourierBean bean = viewRecord(request);

                if (bean == null) {
                    request.setAttribute("message",
                            "No matching records exists! Please try again!");
                } else {
                    request.setAttribute("bean", bean);
                }

                RequestDispatcher rd =
                        request.getRequestDispatcher("displayCourier.jsp");
                rd.forward(request, response);
            }
            else if ("viewAllRecords".equals(operation)) {

                List<CourierBean> list = viewAllRecords(request);

                if (list == null || list.isEmpty()) {
                    request.setAttribute("message", "No records available!");
                } else {
                    request.setAttribute("list", list);
                }

                RequestDispatcher rd =
                        request.getRequestDispatcher("displayAllCouriers.jsp");
                rd.forward(request, response);
            }

        } catch (InvalidInputException e) {
            response.sendRedirect("error.html");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.html");
        }
    }
}
