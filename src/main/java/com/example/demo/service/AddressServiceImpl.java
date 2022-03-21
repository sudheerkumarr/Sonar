package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Address;
import com.example.demo.repository.IAddressRepository;

@Service
public class AddressServiceImpl implements IAddressService {
	
	@Autowired
	IAddressRepository addrRepo;

	@Override
	public List<Address> getAddressById(int id) {
		return addrRepo.getAllAddressesById(id);
	}

	@Override
	public Address delteAddressById(int id) {
		Address addr = addrRepo.getById(id);
		if(addr!=null) {
			addrRepo.deleteById(id);
			return addr;
		}
		return null;
	}

	@Override
	public Address updateAddress(Address address) {
		Address addr = addrRepo.getById(address.getAddrId());
		if(addr!=null) {
			addrRepo.save(address);
			return addr;
		}
		return null;
	}

	@Override
	public Address addAddress(Address address) {

		return addrRepo.save(address);
	}

}
