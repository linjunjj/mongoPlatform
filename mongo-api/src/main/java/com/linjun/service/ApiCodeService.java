package com.linjun.service;

import com.linjun.entity.CodeEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/23.
 * @desc
 **/
@Service
public interface ApiCodeService {
    CodeEntity queryObject(Integer id);
    List<CodeEntity> queryList(Map<String,Object> map);
    int queryTotal(Map<String,Object> map);
    void save(CodeEntity codeEntity);
    void update(CodeEntity codeEntity);
    void delete(Integer id);
    void deleteBatch(Integer[] ids);

}