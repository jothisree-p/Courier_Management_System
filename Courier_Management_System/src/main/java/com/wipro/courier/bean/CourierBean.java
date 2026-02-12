package com.wipro.courier.bean;

import java.util.Date;

public class CourierBean {
private String courierId;
private String senderName;
private String receiverName;
private String courierItem;
private Date shipDate;
private Date deliveryDate;
private String status;
private String remarks;
public String getCourierId() {
	return courierId;
}
public void setCourierId(String courierId) {
	this.courierId = courierId;
}
public String getSenderName() {
	return senderName;
}
public void setSenderName(String senderName) {
	this.senderName = senderName;
}
public String getReceiverName() {
	return receiverName;
}
public void setReceiverName(String receiverName) {
	this.receiverName = receiverName;
}
public String getCourierItem() {
	return courierItem;
}
public void setCourierItem(String courierItem) {
	this.courierItem = courierItem;
}
public Date getShipDate() {
	return shipDate;
}
public void setShipDate(Date shipDate) {
	this.shipDate = shipDate;
}
public Date getDeliveryDate() {
	return deliveryDate;
}
public void setDeliveryDate(Date deliveryDate) {
	this.deliveryDate = deliveryDate;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getRemarks() {
	return remarks;
}
public void setRemarks(String remarks) {
	this.remarks = remarks;
}
}
