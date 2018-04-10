package com.linjun.controller;

import com.linjun.entity.UserOrderEntity;
import com.linjun.service.UserOrderService;
import com.linjun.utils.JsonResult;
import com.linjun.utils.PageUtils;
import com.linjun.utils.Query;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/4/10.
 * @desc
 **/
@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private UserOrderService userOrderService;
    @RequestMapping("/list")
    @RequiresPermissions("sign:list")
    public JsonResult list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<UserOrderEntity> addressList = userOrderService.queryList(query);
        int total = userOrderService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(addressList, total, query.getLimit(), query.getPage());

        return JsonResult.ok().put("page", pageUtil);
    }


    /**
     * 查看信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sign:info")
    public JsonResult info(@PathVariable("id") Long id) {
        UserOrderEntity userOrderEntity = userOrderService.queryObject(id);

        return JsonResult.ok().put("address", userOrderEntity);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sign:save")
    public JsonResult save(@RequestBody UserOrderEntity userOrderEntity) {
        userOrderService.save(userOrderEntity);

        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sign:update")
    public JsonResult update(@RequestBody UserOrderEntity userOrderEntity) {
        userOrderService.update(userOrderEntity);

        return JsonResult.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sign:delete")
    public JsonResult delete(@RequestBody Long[] ids) {
        userOrderService.deleteBatch(ids);
        return JsonResult.ok();
    }



}

