package com.szt.mapper;

import java.util.List;

import com.szt.bean.CarDomain;

public interface UserMapper {
	int toAdd(CarDomain carDomain);
	List<CarDomain> getList(List<Integer> lawAddr);
}
