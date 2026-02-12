package com.wipro.courier.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import com.wipro.courier.bean.CourierBean;
import com.wipro.courier.util.DBUtil;

public class CourierDAO{
	 public String createRecord(CourierBean authorCode) {
	        try {
	            Connection connection = DBUtil.getDBConnection();
	            String id = generateCourierID(authorCode.getSenderName(), authorCode.getShipDate());

	            PreparedStatement ps = connection.prepareStatement("Insert into COURIER_TBL Values(?,?,?,?,?,?,?,?)");
	            ps.setString(1, id);
	            ps.setString(2, authorCode.getSenderName());
	            ps.setString(3, authorCode.getReceiverName());
	            ps.setString(4, authorCode.getCourierItem());
	            ps.setDate(5, new java.sql.Date(authorCode.getShipDate().getTime()));
	            ps.setDate(6, authorCode.getDeliveryDate() == null ? null :new java.sql.Date(authorCode.getDeliveryDate().getTime()));
	            ps.setString(7, authorCode.getStatus());
	            ps.setString(8, authorCode.getRemarks());

	            int rows = ps.executeUpdate();
	            return rows > 0 ? id : "FAIL";

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return "FAIL";
	 }
	 public String generateCourierID(String senderName, Date shipDate) {
	        String id = "";
	        try {
	            DateFormat f = new SimpleDateFormat("yyyyMMdd");
	            String datePart = f.format(shipDate);
	            String namePart = senderName.substring(0, 2).toUpperCase();

	            Connection con = DBUtil.getDBConnection();
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery("Select COURIER_SEQ.NEXTVAL from DUAL");
	            rs.next();
	            int seq = rs.getInt(1);

	            id = datePart + namePart + seq;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return id;
	    }

	public CourierBean fetchRecord(String senderName, Date shipDate) {
	        CourierBean authorBean = null;
	        try {
	            Connection connection = DBUtil.getDBConnection();
	            PreparedStatement ps = connection.prepareStatement(
	            	    "SELECT * FROM COURIER_TBL WHERE UPPER(SENDER_NAME)=UPPER(?) AND TRUNC(SHIP_DATE)=TRUNC(?)");

	            ps.setString(1, senderName);
	            ps.setDate(2, new java.sql.Date(shipDate.getTime()));

	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	            	authorBean = new CourierBean();
	            	authorBean.setCourierId(rs.getString(1));
	            	authorBean.setSenderName(rs.getString(2));
	            	authorBean.setReceiverName(rs.getString(3));
	                authorBean.setCourierItem(rs.getString(4));
	                authorBean.setShipDate(rs.getDate(5));
	                authorBean.setDeliveryDate(rs.getDate(6));
	                authorBean.setStatus(rs.getString(7));
	                authorBean.setRemarks(rs.getString(8));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return authorBean;
	    }
	
 public boolean recordExists(String senderName, Date shipDate) {
    boolean flag = false;
    try {
        Connection connection = DBUtil.getDBConnection();
        PreparedStatement ps = connection.prepareStatement(
        	    "SELECT 1 FROM COURIER_TBL WHERE UPPER(SENDER_NAME)=UPPER(?) AND TRUNC(SHIP_DATE)=TRUNC(?)");
        ps.setString(1, senderName);
        ps.setDate(2, new java.sql.Date(shipDate.getTime()));
        ResultSet rs = ps.executeQuery();
        if (rs.next()) flag = true;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return flag;
}
public List<CourierBean> fetchAllRecords() {
    List<CourierBean> list = new ArrayList<>();
    try {
        Connection connection = DBUtil.getDBConnection();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("Select * from COURIER_TBL");

        while (rs.next()) {
            CourierBean authorBean = new CourierBean();
            authorBean.setCourierId(rs.getString(1));
            authorBean.setSenderName(rs.getString(2));
            authorBean.setReceiverName(rs.getString(3));
            authorBean.setCourierItem(rs.getString(4));
            authorBean.setShipDate(rs.getDate(5));
            authorBean.setDeliveryDate(rs.getDate(6));
            authorBean.setStatus(rs.getString(7));
            authorBean.setRemarks(rs.getString(8));
            list.add(authorBean);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}
}