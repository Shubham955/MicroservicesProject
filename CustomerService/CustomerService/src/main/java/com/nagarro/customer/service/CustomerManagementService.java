package com.nagarro.customer.service;

import java.util.List;

import com.nagarro.customer.model.CustomerDetail;

public interface CustomerManagementService {
	CustomerDetail insertCustomer(CustomerDetail customerDetail);
	List<CustomerDetail> getAllCustomers();
	CustomerDetail getCustomer(String customerNo);
	CustomerDetail updateCustomer(String customerNo, CustomerDetail customerDetail);
	boolean deleteCustomer(String customerNo);
}
