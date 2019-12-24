package com.szt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szt.bean.CarDomain;
import com.szt.mapper.UserMapper;

@Service
public class ServiceImpl implements CService{
	@Autowired
	private UserMapper mapper;
	@Override
	public int toAdd(CarDomain carDomain) {
		// TODO Auto-generated method stub
		return mapper.toAdd(carDomain);
	}
	@Override
	public List<CarDomain> getList(List<Integer> lawAddr) {
		// TODO Auto-generated method stub
		return mapper.getList(lawAddr);
	}

}
