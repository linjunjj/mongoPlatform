package com.linjun.service;

import com.linjun.entity.AdPositionEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/
@Service
public interface ApiAdPositionService {
    AdPositionEntity queryObject(Integer id);
    List<AdPositionEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(AdPositionEntity adPositionEntity);
    void update(AdPositionEntity adPositionEntity);
    void delete(Integer id);
    void deleteBatch(Integer[] ids);
}
