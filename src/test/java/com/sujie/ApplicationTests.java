package com.sujie;

import com.sujie.common.utils.PageUtils;
import com.sujie.modules.clean.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Autowired
	private OrderService orderService;
	@Test
	public void contextLoads() {
        Map<String,Object> map = new HashMap<>();
        map.put("cleanStatusCode","3");
        PageUtils pageUtils = orderService.listRoomCleanRecord(map);

    }

}
