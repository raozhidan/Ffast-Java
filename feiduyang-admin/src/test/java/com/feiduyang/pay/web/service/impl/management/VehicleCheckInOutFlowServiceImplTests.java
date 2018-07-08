package com.feiduyang.pay.web.service.impl.management;

import com.feiduyang.core.vo.ResponseInfo;
import com.feiduyang.pay.web.WebApplication;
import com.feiduyang.pay.web.service.management.IVehicleCheckInOutFlowService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName VehicleCheckInOutFlowServiceImplTests
 * @Author Zhidan.Rao
 * @Date 2018年07月02日 16:04
 * @Version 1.0.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
public class VehicleCheckInOutFlowServiceImplTests {


    @Autowired
    IVehicleCheckInOutFlowService checkInOutFlowService;

    @Test
    public void doCheck() {
        ResponseInfo responseInfo = checkInOutFlowService.doCheck("00101", "00101", true);
        System.out.println(responseInfo.getMessage());
    }
}