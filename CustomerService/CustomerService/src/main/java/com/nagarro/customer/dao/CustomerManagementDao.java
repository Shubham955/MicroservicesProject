package com.nagarro.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.customer.model.CustomerDetail;

public interface CustomerManagementDao extends JpaRepository<CustomerDetail, String>{

}
