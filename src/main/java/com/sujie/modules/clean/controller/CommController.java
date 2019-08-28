package com.sujie.modules.clean.controller;

import com.sujie.modules.clean.entity.HomestayInfoEntity;
import com.sujie.modules.clean.entity.StaffInfoEntity;
import com.sujie.modules.clean.service.HomestayInfoService;
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
    @Autowired
    private HomestayInfoService homestayInfoService;

    @RequestMapping("/toUpdateStaffCommission")
    public String toUpdateStaffCommission(@RequestParam String staffId, Map<String, Object> map) {
        StaffInfoEntity staff = staffInfoService.getById(staffId);
        map.put("staff", staff);
        return "modules/homestay/staffCommission";
    }

    @RequestMapping("/toUpdateHomestay")
    public String toUpdateHomestay(@RequestParam String homestayId, Map<String, Object> map) {

//        HomestayInfoEntity homestayInfoEntity = homestayInfoService.getById(homestayId);
//        map.put("homestay", homestayInfoEntity);
        map.put("homestayId",homestayId);
        return "modules/homestay/homestayUpdate";
    }
    @RequestMapping("/toUpdateRoom")
    public String toUpdateRoom(@RequestParam String roomId, Map<String, Object> map) {

//        HomestayInfoEntity homestayInfoEntity = homestayInfoService.getById(homestayId);
//        map.put("homestay", homestayInfoEntity);
        map.put("homestayId",roomId);
        return "modules/homestay/roomAdd";
    }

}
