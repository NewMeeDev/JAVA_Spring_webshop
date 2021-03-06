package com.mneumann1.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mneumann1.exceptions.IdNotFoundException;
import com.mneumann1.exceptions.WebshopException;
import com.mneumann1.model.CustomerResponse;
import com.mneumann1.model.OrderCreateRequest;
import com.mneumann1.model.OrderPositionCreateRequest;
import com.mneumann1.model.OrderPositionResponse;
import com.mneumann1.model.OrderResponse;
import com.mneumann1.model.ProductResponse;
import com.mneumann1.repository.CustomerRepository;
import com.mneumann1.repository.OrderPositionRepository;
import com.mneumann1.repository.OrderRepository;
import com.mneumann1.repository.ProductRepository;

@Service
public class OrderService {

	// private Repositories and Constructor with Dependency Injection
	private OrderRepository orderRepository;
	private CustomerRepository customerRepository;
	private OrderPositionRepository orderPositionRepository;
	private ProductRepository productRepository;

	public OrderService(ProductRepository productRepository, CustomerRepository customerRepository,
			OrderRepository orderRepository, OrderPositionRepository orderPositionRepository) {
		this.productRepository = productRepository;
		this.customerRepository = customerRepository;
		this.orderRepository = orderRepository;
		this.orderPositionRepository = orderPositionRepository;
	}

	public OrderResponse createOrder(OrderCreateRequest request) throws IdNotFoundException {

		/*
		 * for(CustomerResponse cr : customerRepository.customers) {
		 * System.out.println(cr.getFirstName() + " " + cr.getLastName()); }
		 */

		Optional<CustomerResponse> customer = customerRepository.findById(request.getCustomerId());

		if (customer.isEmpty()) {
			throw new IdNotFoundException(String.format("Customer with id %s not found!", request.getCustomerId()), HttpStatus.BAD_REQUEST);
		} else {
			System.out.println("Customer found: " + customer.map(c -> c.getFirstName() + " " + c.getLastName()));
			return orderRepository.save(request);
		}
	}

	public OrderPositionResponse createNewPositionForOrder(String orderId, OrderPositionCreateRequest request) throws IdNotFoundException {

		Optional<OrderResponse> order = orderRepository.findById(orderId);

		if (order.isEmpty()) {
			throw new IdNotFoundException(String.format("Order with id %s not found!", orderId), HttpStatus.BAD_REQUEST);
		} else {

			Optional<ProductResponse> product = productRepository.findById(request.getProductId());

			if (product.isEmpty()) {
				throw new IdNotFoundException(String.format("Product with id %s not found!", request.getProductId()), HttpStatus.BAD_REQUEST);

			} else {
				System.out.println("Product found: " + product.map(p -> p.getName()));

				OrderPositionResponse orderPositionResponse = new OrderPositionResponse(UUID.randomUUID().toString(),
						request.getProductId(), request.getQuantity());

				orderPositionRepository.save(orderPositionResponse);

				return orderPositionResponse;
			}
		}
	}

}
