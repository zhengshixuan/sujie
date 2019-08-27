package com.sujie.modules.clean.controller;

import com.sujie.modules.clean.entity.StaffInfoEntity;
import com.sujie.modules.clean.service.StaffInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@RequestMapping("/comm")
@Component
public class CommController {
    @Autowired
    private StaffInfoService staffInfoService;
    @RequestMapping("/toUpdateStaffCommission")
    public String toUpdateStaffCommission(@RequestParam Map<String,Object> map){
        StaffInfoEntity staff = staffInfoService.getById((String) map.get("staffId"));
        map.put("staff",staff);
        return "modules/homestay/staffCommission";
    }

}
