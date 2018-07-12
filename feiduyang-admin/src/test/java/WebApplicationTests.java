import com.feiduyang.api.management.IVehicleCheckInOutFlowService;
import com.feiduyang.common.vo.ResponseInfo;
import com.feiduyang.web.WebApplication;
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
    }

}
