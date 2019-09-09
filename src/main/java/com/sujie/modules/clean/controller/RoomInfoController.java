package com.sujie.modules.clean.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sujie.common.utils.ImageUtils;
import com.sujie.modules.clean.entity.RoomImageEntity;
import com.sujie.modules.clean.entity.StaffInfoEntity;
import com.sujie.modules.clean.service.OrderService;
import com.sujie.modules.clean.service.RoomImageService;
import io.swagger.models.auth.In;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sujie.modules.clean.entity.RoomInfoEntity;
import com.sujie.modules.clean.service.RoomInfoService;
import com.sujie.common.utils.PageUtils;
import com.sujie.common.utils.R;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;


/**
 * 房间信息
 *
 * @author zhengsx
 * @email zhengsx@126.com
 * @date 2019-08-18 10:33:16
 */
@RestController
@RequestMapping("/roominfo")
public class RoomInfoController {
    @Autowired
    private RoomInfoService roomInfoService;
    @Autowired
    private RoomImageService roomImageService;
    @Autowired
    private OrderService orderService;

    @RequestMapping("/getRoomInfo")
    public R getRoomInfo(@RequestBody Map<String, Object> params) {
        Map<String, Object> roomInfo = roomInfoService.getRoomInfoByHomestayIdANdRoomId(params);

        return R.ok().put("roomInfo", roomInfo);
    }

    /**
     * 列表
     */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = roomInfoService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 上传图片
     *
     * @param file 图片
     * @return
     */
    @RequestMapping("/upload")
    public R upload(@RequestParam MultipartFile file) {
        R r = ImageUtils.upload(file);
        return r;
    }

    @RequestMapping("/getImage")
    public void getImage(@RequestParam String path, HttpServletResponse response) {


        response.setContentType("image/jpeg");
        FileInputStream is = ImageUtils.getFileInputStream(path);
        if (is != null) {
            int i = 0; // 得到文件大小
            try {

                i = is.available();
                byte data[] = new byte[i];
                is.read(data); // 读数据
                is.close();
                response.setContentType("image/jpeg");  // 设置返回的文件类型
                OutputStream toClient = response.getOutputStream(); // 得到向客户端输出二进制数据的对象
                toClient.write(data); // 输出数据
                toClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id) {

        RoomInfoEntity roomInfo = roomInfoService.getById(id);

        if (null != roomInfo) {
            Map<String, Object> params = new HashMap<>();
            params.put("homestayId", roomInfo.getHomestayId());
            params.put("roomId", roomInfo.getRoomId());
            List<RoomImageEntity> roomImageEntities = roomImageService.listByHomestayIdAndRoomId(params);
            Integer[] imageType = new Integer[15];
            String[] path = new String[15];
            String[] imageDes = new String[15];
            if (null != roomImageEntities && roomImageEntities.size() > 0) {
                for (int i = 0; i < roomImageEntities.size(); i++) {
                    RoomImageEntity imageEntity = roomImageEntities.get(i);
                    imageType[imageEntity.getPicTypeCode()] = imageEntity.getPicTypeCode();
                    path[imageEntity.getPicTypeCode()] = imageEntity.getPicPath();
                    imageDes[imageEntity.getPicTypeCode()] = imageEntity.getComments();
                }
            }
            roomInfo.setImageType(imageType);
            roomInfo.setPath(path);
            roomInfo.setImageDes(imageDes);
        }
        return R.ok().put("roomInfo", roomInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RoomInfoEntity roomInfo) {

        boolean success = roomInfoService.save(roomInfo);
        if (null != roomInfo && roomInfo.getPath().length > 0) {
            for (int i = 0; i < roomInfo.getPath().length; i++) {
                String path = roomInfo.getPath()[i];
                RoomImageEntity imageEntity = new RoomImageEntity();
                imageEntity.setHomestayId(roomInfo.getHomestayId());
                imageEntity.setRoomId(roomInfo.getRoomId());
                if (StringUtils.isNotBlank(path)) {
                    imageEntity.setPicPath(path);
                    imageEntity.setPicTypeCode(roomInfo.getImageType()[i]);
                    imageEntity.setComments(roomInfo.getImageDes()[i]);
                    roomImageService.save(imageEntity);
                }
            }

        }
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody RoomInfoEntity roomInfo) {
        roomInfoService.updateById(roomInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids) {
        roomInfoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
