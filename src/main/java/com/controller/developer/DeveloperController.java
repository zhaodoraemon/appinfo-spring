package com.controller.developer;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/jsp/developer")
public class DeveloperController {
    @Autowired
    private AppInfoServiceImpl appInfoService;
    @Autowired
    private AppCategoryServiceImpl appCategoryService;
    @Autowired
    private AppversionServiceImpl appversionService;
    @RequestMapping("/applist.do")
    public String applist(HttpServletRequest request, @RequestParam(value="page",required=false,defaultValue="1") int page){
        PageInfo<AppInfo> appInfoPageInfo=appInfoService.showApp(page);
        request.getSession().setAttribute("appinfo1",appInfoPageInfo);
        return "redirect:/jsp/developer/appinfolist.jsp";
    }
    @RequestMapping("/viewapp.do")
    public String appview(Long id,HttpServletRequest request){
        AppInfo appInfo=appInfoService.selectByPrimaryKey(id);
        String logo=appInfo.getLogopicpath();
        List<AppVersion> appVersion=appversionService.showById(id);
        request.getSession().setAttribute("appInfo",appInfo);
        request.getSession().setAttribute("appVersionList",appVersion);
        return "redirect:/jsp/developer/appinfoview.jsp";
    }
    @RequestMapping(value="/categorylevellist.do",produces={"application/json;charset=utf-8"})
    @ResponseBody
    public String getleave(@RequestParam(required=false)Long parentId){
        String json="";
        List<AppCategory> appCategoryList=appCategoryService.selectCategory(parentId);
        json= JSONArray.toJSONString(appCategoryList);
        return json;
    }
    @RequestMapping("/addAppinfo.do")
    public String addAppinfo(AppInfo appInfo, @RequestParam(value = "file") MultipartFile file, HttpServletRequest request){
        //保存路径
        String path = request.getServletContext().getRealPath("/statics/uploadfiles");
        //原文件名
        String fileName = file.getOriginalFilename();
        //创建文件实例
        File filePath = new File(path, fileName);
        //写入文件
        try {
            file.transferTo(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileName="/statics/localjs/"+fileName;
        appInfo.setLogopicpath(fileName);
        appInfoService.insertSelective(appInfo);
        return "redirect:/jsp/developer/appinfolist.jsp";
    }
    @RequestMapping("/appversionadd.do")
    public String appversionadd(HttpServletRequest request,long id,String name){
        List<AppVersion> appVersion=appversionService.showById(id);
        request.getSession().setAttribute("appVersionList",appVersion);
        request.getSession().setAttribute("appname",name);
        request.getSession().setAttribute("appid",id);
        return "redirect:/jsp/developer/appversionadd.jsp";
    }
    @RequestMapping(value = "/addversionsave.do", method= RequestMethod.POST)
    public String addversionsave(AppVersion appVersion, @RequestParam(value = "attach") MultipartFile file, HttpServletRequest request){
        System.out.println("进入增加版本号");
        //保存路径
        String path = request.getServletContext().getRealPath("/statics/uploadfiles");
        //原文件名
        String fileName = file.getOriginalFilename();
        appVersion.setApklocpath(path+fileName);
        //创建文件实例
        File filePath = new File(path, fileName);
        //写入文件
        try {
            file.transferTo(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        appVersion.setApkfilename(fileName);
        fileName="/statics/localjs/"+fileName;
        appVersion.setDownloadlink(fileName);
        appversionService.insertSelective(appVersion);
        return "redirect:/jsp/developer/appinfolist.jsp";
    }
    @RequestMapping("/appversionmodify.do")
    public String appversionmodify(HttpServletRequest request,long aid,String name){
        List<AppVersion> appVersion=appversionService.showById(aid);
        request.getSession().setAttribute("appVersionList",appVersion);
        request.getSession().setAttribute("appid",aid);
        request.getSession().setAttribute("appname",name);
        return "redirect:/jsp/developer/appversionmodify.jsp";
    }
    @RequestMapping("/appversionmodifysave.do")
    public String appinfomodifysave( AppVersion appVersion,@RequestParam(value = "apk") MultipartFile file, HttpServletRequest request){
        //保存路径
        String path = request.getServletContext().getRealPath("/statics/uploadfiles");
        //原文件名
        String fileName = file.getOriginalFilename();
        appVersion.setApklocpath(path+fileName);
        //创建文件实例
        File filePath = new File(path, fileName);
        //写入文件
        try {
            file.transferTo(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        appVersion.setApkfilename(fileName);
        fileName="/statics/localjs/"+fileName;
        appVersion.setDownloadlink(fileName);
        appversionService.updateByPrimaryKeySelective(appVersion);
        return "redirect:/jsp/developer/appinfolist.jsp";
    }
    @RequestMapping("/appinfomodify.do")
    public String appinfomodify(Long id,HttpServletRequest request){
        request.getSession().setAttribute("id",id);
        AppInfo appInfo=appInfoService.selectByPrimaryKey(id);
        System.out.print(appInfo.toString());
        request.getSession().setAttribute("appInfo",appInfo);
        return "redirect:/jsp/developer/appinfomodify.jsp";
    }
    @RequestMapping("/appinfomodifysave.do")
    public String appinfomodifysave(AppInfo appinfo, @RequestParam(value = "pic") MultipartFile file, HttpServletRequest request){
        //保存路径
        String path = request.getServletContext().getRealPath("/uploadfiles");
        //原文件名
        String fileName = file.getOriginalFilename();
        //创建文件实例
        File filePath = new File(path, fileName);
        //写入文件
        try {
            file.transferTo(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileName="/localjs/"+fileName;
        appinfo.setLogopicpath(fileName);
        appInfoService.insertSelective(appinfo);
        return "redirect:/jsp/developer/appinfolist.jsp";
    }
    @RequestMapping(value="/delapp.do",produces={"application/json;charset=utf-8"})
    @ResponseBody
    public String delapp(Long id){
        String json="";
        int flag=appInfoService.deleteByPrimaryKey(id);
        if(flag==1){
            json="true";
        }else{
            json="false";
        }
        json= JSONArray.toJSONString(json);
        System.out.print(json);
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
        request.getSession().setAttribute("appinfo1",appInfoPageInfo);
        return "redirect:/jsp/developer/appinfolist.jsp";
    }
}
