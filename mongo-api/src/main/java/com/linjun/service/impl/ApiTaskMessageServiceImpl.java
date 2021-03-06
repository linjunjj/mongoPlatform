package com.linjun.service.impl;

import com.linjun.dao.ApiTaskMessageMapper;
import com.linjun.entity.TaskMessageVo;
import com.linjun.service.ApiTaskMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/26.
 * @desc
 **/
@Service("apiTaskMessageService")
public class ApiTaskMessageServiceImpl implements ApiTaskMessageService {
    @Autowired
    private ApiTaskMessageMapper apiTaskMessageMapper;
    @Override
    public TaskMessageVo queryObject(Long id) {
        return apiTaskMessageMapper.queryObject(id);
    }

    @Override
    public List<TaskMessageVo> queryList(Map<String, Object> map) {
        return apiTaskMessageMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return apiTaskMessageMapper.queryTotal(map);
    }

    @Override
    public void save(TaskMessageVo taskMessageVo) {
  apiTaskMessageMapper.save(taskMessageVo);
    }

    @Override
    public void update(TaskMessageVo taskMessageVo) {
apiTaskMessageMapper.update(taskMessageVo);
    }

    @Override
    public void delete(Long id) {
apiTaskMessageMapper.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
apiTaskMessageMapper.deleteBatch(ids);
    }
}
