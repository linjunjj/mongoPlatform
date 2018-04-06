package com.linjun.service.impl;

import com.linjun.dao.ApiPartTimeImageMapper;
import com.linjun.entity.PartTimeImageEntity;
import com.linjun.service.ApiPartTimeImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/
@Service
public class ApiPartTimeImageServiceImpl implements ApiPartTimeImageService {
    @Autowired
    private ApiPartTimeImageMapper apiPartTimeImageMapper;
    @Override
    public PartTimeImageEntity queryObject(Long id) {
        return apiPartTimeImageMapper.queryObject(id);
    }

    @Override
    public List<PartTimeImageEntity> queryList(Map<String, Object> map) {
        return apiPartTimeImageMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiPartTimeImageMapper.queryTotal(map);
    }

    @Override
    public void save(PartTimeImageEntity partTimeImageEntity) {
    apiPartTimeImageMapper.save(partTimeImageEntity);
    }

    @Override
    public void update(PartTimeImageEntity partTimeImageEntity) {
    apiPartTimeImageMapper.update(partTimeImageEntity);
    }

    @Override
    public void delete(Long id) {
  apiPartTimeImageMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
  apiPartTimeImageMapper.deleteBatch(ids);
    }
}
