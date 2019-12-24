package com.szt.service;

import java.util.List;

import com.szt.bean.CarDomain;

public interface CService {
		int toAdd(CarDomain carDomain);
		List<CarDomain> getList(List<Integer> lawAddr);
}
