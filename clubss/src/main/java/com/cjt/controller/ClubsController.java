package com.cjt.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cjt.entity.Announces;
import com.cjt.entity.Clubs;
import com.cjt.entity.Users;
import com.cjt.mapper.ClubsMapper;
import com.cjt.service.IClubsService;
import com.cjt.service.IMembersService;
import com.cjt.utils.Result;
import com.cjt.utils.StringUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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
@RequestMapping("/api/cjt/clubs")
public class ClubsController {

    @Autowired
    private ClubsMapper clubsMapper;
    @Autowired
    private IClubsService clubsService;
    @Autowired
    private IMembersService membersService;

    @PostMapping("status")
    public Object status(Integer clubsId,Boolean enabled){
        System.out.println(clubsId+","+enabled);
        clubsMapper.updateStatus(clubsId,enabled);
         return new Result(0, "成功");
    }

    @RequestMapping("getAllList")
    public Object getAllList(){
        return clubsMapper.getAllList();
    }

    @RequestMapping("alllist")
    public Object alllist(){
        return clubsMapper.selectList(null);
    }

    @RequestMapping("querybyName")
    public Object querybyName(String query){
        return clubsService.querybyName(query);
    }

    @RequestMapping("update")
    public Object update(Clubs clubs){
        return clubsService.updateById(clubs);
    }


    @RequestMapping("queryId")
    public Integer queryId(String clubName){
        return clubsService.queryId(clubName);
    }

    @CrossOrigin
    @RequestMapping("page")
    //分页
    public PageInfo<Clubs> page(int pageCode, int pageSize) {
        PageInfo<Clubs> pageInfo = clubsService.page(pageCode, pageSize);
        return pageInfo;
    }



    @RequestMapping("addClub")
    public Object add(Clubs clubs,String userName){
         clubsService.addClub(clubs);
         return membersService.add(userName,clubs.getClubsName());
    }

    @PostMapping("coversUpload")
    public String coversUpload(MultipartFile file) {
        String folder = "D:/workspace/img";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, StringUtils.getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8443/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
    
    

}
