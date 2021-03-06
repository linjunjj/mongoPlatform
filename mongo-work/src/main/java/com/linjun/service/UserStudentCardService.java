package com.linjun.service;

import com.linjun.entity.UserStudentCardEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/

public interface UserStudentCardService {
    UserStudentCardEntity queryObject(Long id);
    List<UserStudentCardEntity> queryList(Map<String, Object> map);
    int queryTotal(Map<String, Object> map);
    void save(UserStudentCardEntity userStudentCardEntity);
    void update(UserStudentCardEntity userStudentCardEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
