package com.example.demo.service;

import java.util.List;

import com.example.demo.bean.Address;

public interface IAddressService {
	List<Address> getAddressById(int id);
	Address delteAddressById(int id);
	Address updateAddress(Address address);
	Address addAddress(Address address);
}
