package com.mb.demo.redis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb.demo.redis.Student.Gender;
import com.mb.demo.redis.beans.Address;
import com.mb.demo.redis.beans.CustomerOrder;
import com.mb.demo.redis.beans.OrderProduct;
import com.mb.demo.redis.beans.HubTeamOrderEntity;
import com.mb.demo.redis.repository.HubTeamOrderRepository;

@Service
public class StudentServie {
	@Autowired
	StudentRepository studentRepository;

	@Autowired
	HubTeamOrderRepository pickerOrderRepository;

	public void add() {
		List<Address> address = new ArrayList<>();
		address.add(Address.builder().name("address").street("street").build());
		address.add(Address.builder().name("address").street("street").build());

		studentRepository
				.save(Student.builder().id("Eng2015001").name("sohan").gender(Gender.MALE).address(address).build());
		studentRepository
				.save(Student.builder().id("Eng2015002").name("sohan").gender(Gender.MALE).address(address).build());
		studentRepository
				.save(Student.builder().id("Eng2015003").name("sohan").gender(Gender.FEMALE).address(address).build());

		studentRepository
				.save(Student.builder().id("Eng2015004").name("sohan1").gender(Gender.FEMALE).address(address).build());

		// studentRepository
		// .save(Student.builder().id("Med2015001").name("sohan").gender(Gender.MALE).address(address).build());

		List<Student> studentbyName = studentRepository.findByName("sohan");
		studentbyName = studentRepository.findByGender(Gender.MALE);
		System.out.println(studentbyName);
		Student retrievedStudent = studentRepository.findById("Eng2015001").get();
		retrievedStudent.setName("Richard Watson");

		studentRepository.deleteAll();

		// addPickerProduct();

		// Student retrievedStudent1 = studentRepository.findById("Eng2015001").get();

	}

	@SuppressWarnings("unused")
	public void addPickerProduct() {
		/*
		 * List<CustomerOrder> order = new ArrayList<>();
		 * 
		 * List<CustomerOrderProducts> product = new ArrayList<>();
		 * 
		 * product.add(CustomerOrderProducts.builder().productId(1).sheet("1").quantity(
		 * 12).build());
		 * product.add(CustomerOrderProducts.builder().productId(2).sheet("2").quantity(
		 * 1).build());
		 * product.add(CustomerOrderProducts.builder().productId(3).sheet("1").quantity(
		 * 13).build());
		 * product.add(CustomerOrderProducts.builder().productId(4).sheet("1").quantity(
		 * 6).build());
		 * order.add(CustomerOrder.builder().clusterId("1").customerId("1").hubId("1").
		 * orderId("1").societyId("1") .towerId("1").build());
		 * order.add(CustomerOrder.builder().clusterId("1").customerId("1").hubId("1").
		 * orderId("1").societyId("1") .towerId("1").build());
		 * 
		 * pickerOrderRepository
		 * .save(HubTeamOrderEntity.builder().id("1122").teamId("1").hubId("1").orders(
		 * order).build()); HubTeamOrderEntity pickerTeamOrder =
		 * pickerOrderRepository.findById("1122").get();
		 * pickerOrderRepository.deleteAll();
		 */}

}
