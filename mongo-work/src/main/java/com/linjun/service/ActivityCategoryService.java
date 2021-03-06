package com.linjun.service;

import com.linjun.entity.ActivityCategoryEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/

public interface ActivityCategoryService {
    ActivityCategoryEntity queryObject(Long id);
    List<ActivityCategoryEntity> queryList(Map<String, Object> map);
    int queryTotal(Map<String, Object> map);
    void save(ActivityCategoryEntity activityCategoryEntity);
    void update(ActivityCategoryEntity activityCategoryEntity);
    void delete(Long id);
    void deleteBatch(Long[] ids);

}
