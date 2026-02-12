package com.wipro.courier.service;

import java.util.Date;
import java.util.List;

import com.wipro.courier.bean.CourierBean;
import com.wipro.courier.dao.CourierDAO;
import com.wipro.courier.util.InvalidInputException;

public class Administrator {
	public String addRecord(CourierBean beanBean) throws InvalidInputException {

        if (beanBean == null || beanBean.getSenderName() == null || beanBean.getReceiverName() == null
                || beanBean.getCourierItem() == null || beanBean.getShipDate() == null) {
            throw new InvalidInputException();
        }

        if (beanBean.getSenderName().length() < 2)
            return "INVALID SENDER NAME";

        if (beanBean.getReceiverName().length() < 2)
            return "INVALID RECEIVER NAME";

        if (beanBean.getCourierItem().length() < 2)
            return "INVALID COURIER ITEM";

        CourierDAO dao = new CourierDAO();

        if (dao.recordExists(beanBean.getSenderName(), beanBean.getShipDate()))
            return "ALREADY EXISTS";

        String courierId = dao.generateCourierID(beanBean.getSenderName(), beanBean.getShipDate());
        beanBean.setCourierId(courierId);

        return dao.createRecord(beanBean);
    }
	 public CourierBean viewRecord(String senderName, Date shipDate) {
	        CourierDAO dao = new CourierDAO();
	        return dao.fetchRecord(senderName, shipDate);
	    }
	 public List<CourierBean> viewAllRecords() {
	        CourierDAO dao = new CourierDAO();
	        return dao.fetchAllRecords();
	    }
	}


