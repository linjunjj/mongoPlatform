package com.linjun.api;

import com.linjun.annotation.IgnoreAuth;
import com.linjun.entity.*;
import com.linjun.service.*;
import com.linjun.util.ApiBaseAction;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/10/5.
 * @desc
 **/
@Api(value = "租房市场")
@RestController
@RequestMapping("/api/rent/")
public class ApiRentController  extends ApiBaseAction {
    @Autowired
    private ApiAdService apiAdService;
  @Autowired
  private ApiRentServcie apiRentServcie;
  @Autowired
    private ApiRentCategoryService apiRentCategoryService;
  @Autowired
    private ApiRentImageService apiRentImageService;
  @Autowired
     private ApiRentMessageService apiRentMessageService;
    /*
     *  租房首页数据
     * */
    @IgnoreAuth
    @RequestMapping("index")
  public  Object index(){
        Map<String, Object> resultObj = new HashMap();
        Map param = new HashMap();
        param.put("ad_position_id", 2);
        List<AdVo> banner=apiAdService.queryList(param);
        resultObj.put("banner",banner);
        param=new HashMap();
        param.put("sidx","sort_order");
        param.put("order","asc");
        List<RentCategoryVo> rentCategoryVoList=apiRentCategoryService.queryList(param);
        resultObj.put("categroy",rentCategoryVoList);
        param=new HashMap();
        param.put("sidx","create_time");
        param.put("order","desc");
        param.put("offset",0);
        param.put("limit",11);
        List<RentVo> idleVoList=apiRentServcie.queryList(param);
        resultObj.put("newRent",idleVoList);
        return  toResponsSuccess(resultObj);

    }






}
