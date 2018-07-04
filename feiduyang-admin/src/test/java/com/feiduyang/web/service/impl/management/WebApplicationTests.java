package com.feiduyang.web.service.impl.management;

import com.feiduyang.core.vo.ResponseInfo;
import com.feiduyang.web.WebApplication;
import com.feiduyang.web.service.management.IVehicleCheckInOutFlowService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
public class WebApplicationTests {

    @Autowired
    IVehicleCheckInOutFlowService checkInOutFlowService;

    @Test
    public void contextLoads() {
        ResponseInfo responseInfo = checkInOutFlowService.doCheck("00101", "00101", false);
        System.out.println(responseInfo.toJSON());
//        ResponseInfo responseInfo = checkInOutFlowService.doCheck("00101", "00101", true);
//        System.out.println(responseInfo.getMessage());
    }

}
