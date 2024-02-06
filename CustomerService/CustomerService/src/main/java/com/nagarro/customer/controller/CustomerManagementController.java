package com.nagarro.customer.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.customer.model.CustomerDetail;
import com.nagarro.customer.service.CustomerManagementService;

@RestController
@RequestMapping("customers")
public class CustomerManagementController {
	@Autowired
	CustomerManagementService customerManagementService;
	
	@PostMapping
	public ResponseEntity<CustomerDetail> createCustomer(@RequestBody CustomerDetail customerDetail){
		return new ResponseEntity<>(customerManagementService.insertCustomer(customerDetail), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<CustomerDetail>> getAllCustomers(){
		return new ResponseEntity<>(customerManagementService.getAllCustomers(), HttpStatus.OK);
	}
	
	@GetMapping("/{customerNo}")
	public ResponseEntity<Object> getCustomer(@PathVariable String customerNo){
		CustomerDetail customerDetail= customerManagementService.getCustomer(customerNo);
		if(Objects.nonNull(customerDetail)) {
			return new ResponseEntity<>(customerDetail, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Customer not found", HttpStatus.OK);
		}
	}
	
	@PutMapping("/{customerNo}")
	public ResponseEntity<Object> updateCustomer(@PathVariable String customerNo, @RequestBody CustomerDetail customerDetail){
		CustomerDetail updatedCustomerDetail= customerManagementService.updateCustomer(customerNo, customerDetail);
		if(Objects.nonNull(updatedCustomerDetail)) {
			return new ResponseEntity<>(updatedCustomerDetail, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Customer not found", HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/{customerNo}")
	public ResponseEntity<Object> deleteCustomer(@PathVariable String customerNo){
		if(customerManagementService.deleteCustomer(customerNo)) {
			return new ResponseEntity<>("Customer deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Customer not found", HttpStatus.OK);
		}
	}
}
