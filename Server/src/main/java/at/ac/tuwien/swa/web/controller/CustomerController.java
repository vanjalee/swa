package at.ac.tuwien.swa.web.controller;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import at.ac.tuwien.swa.entities.Customer;
import at.ac.tuwien.swa.service.CustomerService;
import at.ac.tuwien.swa.web.model.CustomerModel;

@Named
@Scope("request")
public class CustomerController {

	@Inject
	private CustomerModel customerModel;

	private boolean newCustomer;

	@Inject
	CustomerService customerService;

	public void saveCustomer() {
		customerService.save(customerModel.getCustomerDTO());

		findAll();
	}

	public void setNewCustomer(boolean newCustomer) {
		this.newCustomer = newCustomer;
	}

	public void createNewCustomer() {
		customerModel.setCustomerDTO(new Customer());
	}

	public void removeCustomer() {

		customerService.delete(customerModel.getCustomerDTO());
		customerModel.setCustomerDTO(new Customer());

		findAll();
	}

	public void editCustomer(Customer customer) {
		customerModel.setCustomerDTO(customer);
	}

	public boolean isNewCustomer() {
		return newCustomer;
	}

	public void setCustomerModel(CustomerModel customerModel) {
		this.customerModel = customerModel;
	}

	public CustomerModel getCustomerModel() {
		return customerModel;
	}

	public void findAll() {
		customerModel.setSearchResult(customerService.findAll());
	}

}
