package com.linjun.service.impl;

import com.linjun.dao.ApiRentMessageMapper;
import com.linjun.entity.RentMessageEntity;
import com.linjun.service.ApiRentMessageService;
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
public class ApiRentMessageServiceImpl implements ApiRentMessageService {
    @Autowired
    private ApiRentMessageMapper apiRentMessageMapper;
    @Override
    public RentMessageEntity queryObject(Long id) {
        return apiRentMessageMapper.queryObject(id);
    }

    @Override
    public List<RentMessageEntity> queryList(Map<String, Object> map) {
        return apiRentMessageMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiRentMessageMapper.queryTotal(map);
    }

    @Override
    public void save(RentMessageEntity rentMessageEntity) {
  apiRentMessageMapper.save(rentMessageEntity);
    }

    @Override
    public void update(RentMessageEntity rentMessageEntity) {
  apiRentMessageMapper.update(rentMessageEntity);
    }

    @Override
    public void delete(Long id) {
   apiRentMessageMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
   apiRentMessageMapper.deleteBatch(ids);
    }
}
