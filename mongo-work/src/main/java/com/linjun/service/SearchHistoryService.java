package com.linjun.service;

import com.linjun.entity.SearchHistoryEntity;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/9.
 * @desc
 **/
public interface SearchHistoryService {
    SearchHistoryEntity queryObject(Integer id);
    List<SearchHistoryEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(SearchHistoryEntity searchHistoryEntity);
    void update(SearchHistoryEntity searchHistoryEntity);
    void delete(Integer id);
    void deleteBatch(Integer[] ids);
}
