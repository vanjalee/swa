package at.ac.tuwien.swa.web.model;

import java.util.List;

import javax.inject.Named;

import at.ac.tuwien.swa.entities.Customer;

@Named
public class CustomerModel {
	private Customer customerDTO;

	private List<Customer> searchResult;

	public void setCustomerDTO(Customer customerDTO) {
		this.customerDTO = customerDTO;
	}

	public Customer getCustomerDTO() {
		return customerDTO;
	}

	public List<Customer> getSearchResult() {
		return searchResult;
	}

	public void setSearchResult(List<Customer> searchResult) {
		this.searchResult = searchResult;
	}
}
