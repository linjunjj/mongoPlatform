package controller;

import com.linjun.entity.SmsConfig;
import com.linjun.service.SysConfigService;
import com.linjun.utils.ConfigConstant;
import com.linjun.utils.PageBean;
import com.linjun.utils.Query;
import com.linjun.utils.JsonResult;
import entity.SysSmsLogEntity;
import net.sf.json.JSON;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.SysSmsLogService;

import java.util.List;
import java.util.Map;

/**
 * @author 林俊
 * @create 2018/3/13.
 * @desc
 **/
@RestController
@RequestMapping(value = "/sys/smslog")
public class SysSmsLogController {
    @Autowired
    private SysSmsLogService smsLogService;
    @Autowired
    private SysConfigService sysConfigService;

    private final static String KEY = ConfigConstant.SMS_CONFIG_KEY;
    /*、
    * 查看列表
    */
    @RequestMapping("/list")
    @RequiresPermissions("sys:smslog:list")
    @ResponseBody
    public JsonResult list(@RequestParam Map<String,Object> params){
        Query query=new Query(params);
        List<SysSmsLogEntity> sysSmsLogEntityList=smsLogService.queryList(query);
        int total=smsLogService.quertTotral(query);
        PageBean pageBean =new PageBean(sysSmsLogEntityList,total,query.getLimit(),query.getPage());
        return JsonResult.ok().put("page", pageBean);
        }
/*
* 查看信息*/
    @RequestMapping(value = "/info/{id}")
    @RequiresPermissions("sys:smslog:info")
    @ResponseBody
    public  JsonResult info(@PathVariable("id") String id){
        SysSmsLogEntity sysSmsLogEntity=smsLogService.queryObject(id);
        return  JsonResult.ok().put("smsLog",sysSmsLogEntity);
    }
/*保存*/
  @RequestMapping(value = "/save")
    @RequiresPermissions("sys:smslog:save")
    public  JsonResult save(@RequestBody SysSmsLogEntity sysSmsLogEntity){
       smsLogService.save(sysSmsLogEntity);
       return JsonResult.ok();
  }
/*更新*/
   @RequestMapping(value = "/update")
    @RequiresPermissions("sys:smslog:update")
  @ResponseBody
    public  JsonResult update(@RequestBody SysSmsLogEntity sysSmsLogEntity){
    smsLogService.update(sysSmsLogEntity);
    return JsonResult.ok();
}
/*删除*/
 @RequestMapping(value = "/delete")
    @RequiresPermissions("sys:smslog:delete")
    @ResponseBody
    public  JsonResult delete(@RequestBody String[] ids){
     smsLogService.deleteBatch(ids);
     return  JsonResult.ok();
 }
    /**
     * 查看所有列表
     */
    @RequestMapping("/queryAll")
    @ResponseBody
    public JsonResult queryAll(@RequestParam Map<String, Object> params) {

        List<SysSmsLogEntity> list = smsLogService.queryList(params);

        return JsonResult.ok().put("list", list);
    }

    /**
     * 短信配置信息
     */
    @RequestMapping("/config")
    public JsonResult config() {
        SmsConfig config = sysConfigService.getConfigObject(KEY, SmsConfig.class);

        return JsonResult.ok().put("config", config);
    }

    /**
     * 保存短信配置信息
     */
    @RequestMapping("/saveConfig")
    public JsonResult saveConfig(@RequestBody SmsConfig config) {
        sysConfigService.updateValueByKey(KEY, com.alibaba.fastjson.JSON.toJSONString(config));
        return JsonResult.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/sendSms")
    @ResponseBody
    public JsonResult sendSms(@RequestBody SysSmsLogEntity smsLog) {
        SysSmsLogEntity sysSmsLogEntity = smsLogService.sendSms(smsLog);
        return JsonResult.ok().put("result", sysSmsLogEntity);
    }


}
