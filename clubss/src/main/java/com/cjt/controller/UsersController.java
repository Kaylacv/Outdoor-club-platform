package com.cjt.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.cjt.common.HttpMsg;
import com.cjt.commonService.RedisService;
import com.cjt.entity.Clubs;
import com.cjt.entity.Goods;
import com.cjt.entity.Managers;
import com.cjt.entity.Users;
import com.cjt.mapper.UsersMapper;
import com.cjt.service.IUsersService;
import com.cjt.utils.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-03-18
 */
@RestController
@RequestMapping("/api/cjt/users")
public class UsersController {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private IUsersService usersService;
    private HttpMsg httpMsg;

    @Autowired
    private RedisService redisService;



    //短信登录
    @ResponseBody
    @RequestMapping(value = "loginByMsg", method = RequestMethod.POST)
    public Object loginByMsg(String userPhone){
        List<Users> users = usersService.list(new QueryWrapper<Users>().eq("userPhone", userPhone));
        if (CollectionUtils.isEmpty(users)) {
            return new Result(0, "用户不存在！");
        }
        else {
            Map<String,Object> map = new HashMap<>();
            String vcodes=httpMsg.sendMsg(userPhone);
            System.out.println(vcodes);
            map.put("verifyCode",vcodes);
            map.put("phone",userPhone);
            redisService.set(userPhone,vcodes);
            redisService.expire(userPhone,600);//调用reids工具类中存储方法设置超时时间
            return map;
        }
    }

    //判断验证码是否正确
    @ResponseBody
    @RequestMapping(value = "ifcodes", method = RequestMethod.POST)
    public Object ifcodes(String userPhone,String codes){
        Map<String,Object> map = new HashMap<>();
        String redisauthcode= redisService.get(userPhone);
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



}
