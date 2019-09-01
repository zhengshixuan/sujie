package com.sujie.common.utils;

import com.sujie.common.exception.CommonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

/**
 * 上传文件工具类
 */
@Configuration
public class ImageUtils {

    private static String staticLocation;
    private static String staticLocationMapping;

    @Autowired
    public void setLocation2() {
        staticLocation = location;
        staticLocationMapping = locationMapping;
    }


    /**
     * 在配置文件中配置的文件保存路径
     */
    @Value("${img.location}")
    private String location;
    @Value("${img.locationMapping}")
    private  String locationMapping;
    /**
     * 将文件保存在本地
     *
     * @param file
     * @return
     */
    public static R upload(MultipartFile file) {


        if (file.isEmpty()) {
            throw new CommonException("上传文件不能为空");
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 文件上传后的路径
        String filePath = staticLocation;
        // 解决中文问题，liunx下中文路径，图片显示问题
        fileName = UUIDUtils.getUUIDHex() + suffixName;
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);

        } catch (IllegalStateException e) {
            e.printStackTrace();
            return R.error("保存失败！");
        } catch (IOException e) {
            e.printStackTrace();
            return R.error("保存失败！");
        }
        return R.ok().put("path",dest.getPath().replace(staticLocation,"/"+staticLocationMapping+"/"));

    }

    /**
     * 获取文件流
     *
     * @param adress
     * @return
     */
    public static FileInputStream getFileInputStream(String adress) {
        FileInputStream is = null;
        File filePic = new File(adress);
        try {
            is = new FileInputStream(filePic);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return is;

    }

}
