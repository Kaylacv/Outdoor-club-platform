package com.cjt.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.cjt.common.HttpMsg;
import com.cjt.commonService.RedisService;
import com.cjt.entity.Managers;
import com.cjt.mapper.ManagersMapper;
import com.cjt.service.IManagersService;
import com.cjt.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-03-18
 */
@RestController
@RequestMapping("/cjt/managers")
public class ManagersController {
    @Autowired
    private IManagersService managersService;
    @Autowired
    private ManagersMapper managersMapper;

    private HttpMsg httpMsg;

    @Autowired
    private RedisService redisService;

    //用户名密码登录
    @RequestMapping("/login")
    public Object login(String managerNo, String managerPass) {
        List<Managers> managers = managersService.list(new QueryWrapper<Managers>().eq("managerNo", managerNo));
        if (CollectionUtils.isEmpty(managers)) {
            return new Result(0, "用户不存在！") ;
        }
        if (managers.size() > 1) {
            return new Result(0, "用户重复！");
        }
        if (!managers.get(0).getManagerPass().equals(managerPass)) {
            return new Result(0, "密码错误");
        }
        return new Result(1, "登录成功");
    }

    //短信登录
    @ResponseBody
    @RequestMapping(value = "loginByMsg", method = RequestMethod.POST)
    public Object loginByMsg(String managerPhone){
        List<Managers> managers = managersService.list(new QueryWrapper<Managers>().eq("managerPhone", managerPhone));
        if (CollectionUtils.isEmpty(managers)) {
            return new Result(0, "用户不存在！");
        }
        else {
            Map<String,Object> map = new HashMap<>();
            String vcodes=httpMsg.sendMsg(managerPhone);
            System.out.println(vcodes);
            map.put("verifyCode",vcodes);
            map.put("phone",managerPhone);
            redisService.set(managerPhone,vcodes);
            redisService.expire(managerPhone,600);//调用reids工具类中存储方法设置超时时间
           return map;
        }
    }

    //判断验证码是否正确
    @ResponseBody
    @RequestMapping(value = "ifcodes", method = RequestMethod.POST)
    public Object ifcodes(String managerPhone,String codes){
        Map<String,Object> map = new HashMap<>();
        String redisauthcode= redisService.get(managerPhone);
        if(StringUtils.isEmpty(redisauthcode)){
            //如果未取到则过期验证码已失效
            return new Result(0, "验证码已失效！");
        }else  if(!"".equals(redisauthcode)&&!codes.equals(redisauthcode)){
            //验证码错误
            return new Result(0, "验证码错误！");
        }
            //登录成功
            return new Result(1, "登录成功！");
    }



    @RequestMapping("getAllList")
    public Object getAllList(String managerNo){
        return managersService.getAllList(managerNo);
    }

    @RequestMapping("queryId")
    public Object queryId(String managerNo){
        return managersService.queryId(managerNo);
    }

    @RequestMapping("update")
    public Object update(Managers managers){
        return managersMapper.updateById(managers);
    }


    @RequestMapping("queryName")
    public Object queryName(String managerPhone){return managersService.queryName(managerPhone);}

}
