package com.cjt.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cjt.entity.Cars;
import com.cjt.entity.Clubs;
import com.cjt.entity.Members;
import com.cjt.entity.Users;
import com.cjt.mapper.MembersMapper;
import com.cjt.service.IClubsService;
import com.cjt.service.IMembersService;
import com.cjt.utils.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-03-18
 */
@RestController
@RequestMapping("/api/cjt/members")
public class MembersController {

    @Autowired
    private IMembersService membersService;
    @Autowired
    private IClubsService clubsService;
    @Autowired
    private MembersMapper membersMapper;

    @RequestMapping("roleById")
    public String roleById(Integer userId){
        return membersService.roleById(userId);
    }

    @RequestMapping("queryByclubId")
    public Object queryByclubId(Integer clubId){return membersService.queryByclubId(clubId);}

    @RequestMapping("delete")
    public Object delete(Integer menberId){return membersService.removeById(menberId);}

    @RequestMapping("join")
    public Object join(Members members){
        List<Members> membersList = membersMapper.ifjoin(members.getUserName(),members.getClubsName());
        if (membersList.size()==0){
             membersService.join(members);
            return new Result(1, "加入成功");
        }else {
            return new Result(0, "已加入过该俱乐部");
        }
    }

    @CrossOrigin
    @RequestMapping("page")
    //分页
    public PageInfo<Members> page(String userName, int pageCode, int pageSize) {
        PageInfo<Members> pageInfo = membersService.page(userName,pageCode, pageSize);
        return pageInfo;
    }

    @CrossOrigin
    @RequestMapping("mempage")
    //分页
    public PageInfo<Members> mempage(String userName, int pageCode, int pageSize) {
        PageInfo<Members> pageInfo = membersService.mempage(userName,pageCode, pageSize);
        return pageInfo;
    }



    @CrossOrigin
    @RequestMapping("clubpage")
    //分页
    public PageInfo<Members> clubpage(Integer clubsId, int pageCode, int pageSize) {
        List<Clubs> clubs = clubsService.list(new QueryWrapper<Clubs>().eq("clubsId", clubsId));
        PageInfo<Members> pageInfo = membersService.clubpage(clubs.get(0).getClubsName(),pageCode, pageSize);
        return pageInfo;
    }

    @RequestMapping("search")
    public Object search(Integer clubsId,String userName){
        List<Clubs> clubs = clubsService.list(new QueryWrapper<Clubs>().eq("clubsId", clubsId));
        return membersMapper.search(clubs.get(0).getClubsName(),userName);
    }

    @RequestMapping("deleteMem")
    public Object deleteMem(Integer memberId){
        return membersService.removeById(memberId);
    }




}
