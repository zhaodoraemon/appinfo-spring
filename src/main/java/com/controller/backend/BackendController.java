package com.controller.backend;

import com.alibaba.fastjson.JSONArray;
import com.entity.AppCategory;
import com.entity.AppInfo;
import com.entity.AppVersion;
import com.github.pagehelper.PageInfo;
import com.service.Impl.AppCategoryServiceImpl;
import com.service.Impl.AppInfoServiceImpl;
import com.service.Impl.AppversionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/jsp/backend")
public class BackendController {
    @Autowired
    private AppInfoServiceImpl appInfoService;
    @Autowired
    private AppversionServiceImpl appversionService;
    @Autowired
    private AppCategoryServiceImpl appCategoryService;
    /**
     * 获取app列表
     */
    @RequestMapping("/list.do")
    public String list(HttpServletRequest request, @RequestParam(value="pagenum",required=false,defaultValue="1") int pagenum){
        PageInfo<AppInfo> appInfoPageInfo=appInfoService.showApp(pagenum);
        request.getSession().setAttribute("appInfoList",appInfoPageInfo);
        return "/backend/applist";
    }
    /**
     * 审核app
     * */
    @RequestMapping("/check.do")
    public String check(long aid,HttpServletRequest request){
        System.out.println(aid+"-------");
        AppInfo appInfo=appInfoService.selectByPrimaryKey(aid);
        AppVersion appVersion=appversionService.selectByAppid(aid);
        request.getSession().setAttribute("checkappinfo",appInfo);
        request.getSession().setAttribute("checkappversion",appVersion);
        return "/backend/appcheck";
    }
    /**
    * 审核app保存到数据库
    * */
    @RequestMapping("/checksave.do")
    public String checksave(long id,long status,HttpServletRequest request){
        System.out.println(id+"-------"+status);
        int i=appInfoService.checkapp(id,status);
        System.out.println("受影响的行数:"+i);
        PageInfo<AppInfo> appInfoPageInfo=appInfoService.show(1);
        request.getSession().setAttribute("appInfoList",appInfoPageInfo);
        return "/backend/applist";
    }

    @RequestMapping(value="/categorylevellist.do",produces={"application/json;charset=utf-8"})
    @ResponseBody
    public String getleave(@RequestParam(required=false)Long parentId){
        String json="";
        List<AppCategory> appCategoryList=appCategoryService.selectCategory(parentId);
        json= JSONArray.toJSONString(appCategoryList);
        return json;
    }

    @RequestMapping("/selectapp.do")
    public String selectapp(
            @RequestParam(required=false)Long queryCategoryLevel2,
            @RequestParam(required=false)Long queryCategoryLevel1,
            @RequestParam(required=false)Long queryFlatformId,
            @RequestParam(required=false)Long queryStatus,
            @RequestParam(required=false)String querySoftwareName,
            @RequestParam(required=false)Long queryCategoryLevel3,
            HttpServletRequest request,
            @RequestParam(value="page",required=false,defaultValue="1") int page){
        PageInfo<AppInfo> appInfoPageInfo=appInfoService.selectApp(page,querySoftwareName,queryStatus,queryFlatformId,queryCategoryLevel3,queryCategoryLevel2,queryCategoryLevel1);
        request.getSession().setAttribute("appInfoList",appInfoPageInfo);
        return "redirect:/jsp/backend/applist.jsp";
    }

}
