package com.linjun.service.impl;

import com.linjun.dao.ApiRentImageMapper;
import com.linjun.entity.RentImageEntity;
import com.linjun.service.ApiRentImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/
@Service
public class ApiRentImageServiceImpl implements ApiRentImageService {
    @Autowired
    private ApiRentImageMapper apiRentImageMapper;

    @Override
    public RentImageEntity queryObject(Long id) {
        return apiRentImageMapper.queryObject(id);
    }

    @Override
    public List<RentImageEntity> queryList(Map<String, Object> map) {
        return apiRentImageMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiRentImageMapper.queryTotal(map);
    }

    @Override
    public void save(RentImageEntity rentImageEntity) {
       apiRentImageMapper.save(rentImageEntity);
    }

    @Override
    public void update(RentImageEntity rentImageEntity) {
     apiRentImageMapper.update(rentImageEntity);
    }

    @Override
    public void delete(Long id) {
     apiRentImageMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
    apiRentImageMapper.deleteBatch(ids);
    }
}
