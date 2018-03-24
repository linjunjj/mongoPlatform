package com.linjun.service;

import com.linjun.entity.IdleEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/
@Service
public interface ApiIdleService  {
    IdleEntity queryObject(Integer id);
    List<IdleEntity>  queryList(Map<String,Object>map);
    int queryTotal(Map<String,Object> map);
   void save(IdleEntity idleEntity);
   void update(IdleEntity idleEntity);
   void delete(Integer id);
    void deleteBatch(Integer[] ids);
}