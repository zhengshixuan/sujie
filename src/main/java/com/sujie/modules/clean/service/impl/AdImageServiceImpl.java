package com.sujie.modules.clean.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sujie.modules.clean.dao.AdImageDao;
import com.sujie.modules.clean.entity.AdImageEntity;
import com.sujie.modules.clean.service.AdImageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("adImageService")
public class AdImageServiceImpl extends ServiceImpl<AdImageDao, AdImageEntity> implements AdImageService {

    @Override
    public List<Map<String, Object>> listPic() {

        return baseMapper.listPic();
    }
}