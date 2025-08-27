package com.tl.service;

import com.tl.dto.PerformanceRequestDto;

public interface PerformanceInfosService {
	public PerformanceInfoProcessor getPIP(PerformanceRequestDto prd);
}
