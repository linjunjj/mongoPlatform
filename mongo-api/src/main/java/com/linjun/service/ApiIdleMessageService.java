package com.linjun.service;

import com.linjun.entity.IdleMessageEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/24.
 * @desc
 **/
@Service
public interface ApiIdleMessageService {
    IdleMessageEntity queryObject(Integer id);
    List<IdleMessageEntity>  queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void  save(IdleMessageEntity idleMessageEntity);
    void update(IdleMessageEntity idleMessageEntity);
    void delete(Integer id);
    void deleteBatch(Integer[] ids);

}
