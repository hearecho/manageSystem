package com.echo.service;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author hearecho
 * @createtime 2020/4/7 12:16
 */
@FeignClient("staff")
public interface StaffFeginService {

}
