package com.nagarro.customer.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.customer.dao.CustomerManagementDao;
import com.nagarro.customer.model.CustomerDetail;
import com.nagarro.customer.service.CustomerManagementService;

@Component
public class CustomerManagementServiceImpl implements CustomerManagementService{
	@Autowired
	CustomerManagementDao customerManagementDao;
	
	@Override
	public CustomerDetail insertCustomer(CustomerDetail customerDetail) {
		CustomerDetail savedCustomer=customerManagementDao.save(customerDetail);
		return savedCustomer;
	}

	@Override
	public List<CustomerDetail> getAllCustomers() {
		List<CustomerDetail> allCustomers=customerManagementDao.findAll();
		return allCustomers;
	}

	@Override
	public CustomerDetail getCustomer(String customerNo) {
		CustomerDetail fetchedCustomer=customerManagementDao.findById(customerNo).orElse(null);
		return fetchedCustomer;
	}

	@Override
	public CustomerDetail updateCustomer(String customerNo, CustomerDetail customerDetail) {
		CustomerDetail fetchedCustomer=getCustomer(customerNo);
		if(Objects.nonNull(fetchedCustomer)) {
			CustomerDetail updatedCustomer=new CustomerDetail(customerNo, customerDetail.getName(), customerDetail.getPhoneNumber(), customerDetail.getAddress(), fetchedCustomer.getCreationTime());
			updatedCustomer=customerManagementDao.save(updatedCustomer);
			return updatedCustomer;
		} else {
			return null;
		}
	}

	@Override
	public boolean deleteCustomer(String customerNo) {
		if(customerManagementDao.existsById(customerNo)) {
			customerManagementDao.deleteById(customerNo);
			return true;
		} else {
			return false;
		}
	}
	
}
