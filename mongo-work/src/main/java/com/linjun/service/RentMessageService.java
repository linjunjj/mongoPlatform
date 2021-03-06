package com.linjun.service;

import com.linjun.entity.RentMessageEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/25.
 * @desc
 **/

public interface RentMessageService {
    RentMessageEntity queryObject(Long id);
    List<RentMessageEntity> queryList(Map<String, Object> map);
    int queryTotal(Map<String, Object> map);
    void save(RentMessageEntity rentMessageEntity);
    void update(RentMessageEntity rentMessageEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);
}
