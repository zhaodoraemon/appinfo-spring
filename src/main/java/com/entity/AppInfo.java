package com.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * app_info
 * @author 
 */
public class AppInfo implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 软件名称
     */
    private String softwarename;

    /**
     * APK名称（唯一）
     */
    private String apkname;

    /**
     * 支持ROM
     */
    private String supportrom;

    /**
     * 界面语言
     */
    private String interfacelanguage;

    /**
     * 软件大小（单位：M）
     */
    private BigDecimal softwaresize;

    /**
     * 更新日期
     */
    private Date updatedate;

    /**
     * 开发者id（来源于：dev_user表的开发者id）
     */
    private Long devid;

    /**
     * 应用简介
     */
    private String appinfo;

    /**
     * 状态（来源于：data_dictionary，1 待审核 2 审核通过 3 审核不通过 4 已上架 5 已下架）
     */
    private Long status;

    private String specificStatus;

    /**
     * 上架时间
     */
    private Date onsaledate;

    /**
     * 下架时间
     */
    private Date offsaledate;

    /**
     * 所属平台（来源于：data_dictionary，1 手机 2 平板 3 通用）
     */
    private Long flatformid;

    private String specificFlatformid;

    /**
     * 所属三级分类（来源于：data_dictionary）
     */
    private Long categorylevel3;
    private String specificCategorylevel3;

    /**
     * 下载量（单位：次）
     */
    private Long downloads;

    /**
     * 创建者（来源于dev_user开发者信息表的用户id）
     */
    private Long createdby;

    /**
     * 创建时间
     */
    private Date creationdate;

    /**
     * 更新者（来源于dev_user开发者信息表的用户id）
     */
    private Long modifyby;

    /**
     * 最新更新时间
     */
    private Date modifydate;

    /**
     * 所属一级分类（来源于：data_dictionary）
     */
    private Long categorylevel1;
    private String specificCategorylevel1;

    /**
     * 所属二级分类（来源于：data_dictionary）
     */
    private Long categorylevel2;
    private String specificCategorylevel2;

    /**
     * LOGO图片url路径
     */
    private String logopicpath;

    public String getSpecificStatus() {
        return specificStatus;
    }

    public void setSpecificStatus(String specificStatus) {
        this.specificStatus = specificStatus;
    }

    public String getSpecificFlatformid() {
        return specificFlatformid;
    }

    public void setSpecificFlatformid(String specificFlatformid) {
        this.specificFlatformid = specificFlatformid;
    }

    public String getSpecificCategorylevel3() {
        return specificCategorylevel3;
    }

    public void setSpecificCategorylevel3(String specificCategorylevel3) {
        this.specificCategorylevel3 = specificCategorylevel3;
    }

    public String getSpecificCategorylevel1() {
        return specificCategorylevel1;
    }

    public void setSpecificCategorylevel1(String specificCategorylevel1) {
        this.specificCategorylevel1 = specificCategorylevel1;
    }

    public String getSpecificCategorylevel2() {
        return specificCategorylevel2;
    }

    public void setSpecificCategorylevel2(String specificCategorylevel2) {
        this.specificCategorylevel2 = specificCategorylevel2;
    }

    /**
     * LOGO图片的服务器存储路径
     */
    private String logolocpath;

    /**
     * 最新的版本id
     */
    private Long versionid;

    private String specificVersionid;

    public String getSpecificVersionid() {
        return specificVersionid;
    }

    public void setSpecificVersionid(String specificVersionid) {
        this.specificVersionid = specificVersionid;
    }

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSoftwarename() {
        return softwarename;
    }

    public void setSoftwarename(String softwarename) {
        this.softwarename = softwarename;
    }

    public String getApkname() {
        return apkname;
    }

    public void setApkname(String apkname) {
        this.apkname = apkname;
    }

    public String getSupportrom() {
        return supportrom;
    }

    public void setSupportrom(String supportrom) {
        this.supportrom = supportrom;
    }

    public String getInterfacelanguage() {
        return interfacelanguage;
    }

    public void setInterfacelanguage(String interfacelanguage) {
        this.interfacelanguage = interfacelanguage;
    }

    public BigDecimal getSoftwaresize() {
        return softwaresize;
    }

    public void setSoftwaresize(BigDecimal softwaresize) {
        this.softwaresize = softwaresize;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public Long getDevid() {
        return devid;
    }

    public void setDevid(Long devid) {
        this.devid = devid;
    }

    public String getAppinfo() {
        return appinfo;
    }

    public void setAppinfo(String appinfo) {
        this.appinfo = appinfo;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Date getOnsaledate() {
        return onsaledate;
    }

    public void setOnsaledate(Date onsaledate) {
        this.onsaledate = onsaledate;
    }

    public Date getOffsaledate() {
        return offsaledate;
    }

    public void setOffsaledate(Date offsaledate) {
        this.offsaledate = offsaledate;
    }

    public Long getFlatformid() {
        return flatformid;
    }

    public void setFlatformid(Long flatformid) {
        this.flatformid = flatformid;
    }

    public Long getCategorylevel3() {
        return categorylevel3;
    }

    public void setCategorylevel3(Long categorylevel3) {
        this.categorylevel3 = categorylevel3;
    }

    public Long getDownloads() {
        return downloads;
    }

    public void setDownloads(Long downloads) {
        this.downloads = downloads;
    }

    public Long getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Long createdby) {
        this.createdby = createdby;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Long getModifyby() {
        return modifyby;
    }

    public void setModifyby(Long modifyby) {
        this.modifyby = modifyby;
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    public Long getCategorylevel1() {
        return categorylevel1;
    }

    public void setCategorylevel1(Long categorylevel1) {
        this.categorylevel1 = categorylevel1;
    }

    public Long getCategorylevel2() {
        return categorylevel2;
    }

    public void setCategorylevel2(Long categorylevel2) {
        this.categorylevel2 = categorylevel2;
    }

    public String getLogopicpath() {
        return logopicpath;
    }

    public void setLogopicpath(String logopicpath) {
        this.logopicpath = logopicpath;
    }

    public String getLogolocpath() {
        return logolocpath;
    }

    public void setLogolocpath(String logolocpath) {
        this.logolocpath = logolocpath;
    }

    public Long getVersionid() {
        return versionid;
    }

    @Override
    public String toString() {
        return "AppInfo{" +
                "id=" + id +
                ", softwarename='" + softwarename + '\'' +
                ", apkname='" + apkname + '\'' +
                ", supportrom='" + supportrom + '\'' +
                ", interfacelanguage='" + interfacelanguage + '\'' +
                ", softwaresize=" + softwaresize +
                ", updatedate=" + updatedate +
                ", devid=" + devid +
                ", appinfo='" + appinfo + '\'' +
                ", status=" + status +
                ", specificStatus='" + specificStatus + '\'' +
                ", onsaledate=" + onsaledate +
                ", offsaledate=" + offsaledate +
                ", flatformid=" + flatformid +
                ", specificFlatformid='" + specificFlatformid + '\'' +
                ", categorylevel3=" + categorylevel3 +
                ", specificCategorylevel3='" + specificCategorylevel3 + '\'' +
                ", downloads=" + downloads +
                ", createdby=" + createdby +
                ", creationdate=" + creationdate +
                ", modifyby=" + modifyby +
                ", modifydate=" + modifydate +
                ", categorylevel1=" + categorylevel1 +
                ", specificCategorylevel1='" + specificCategorylevel1 + '\'' +
                ", categorylevel2=" + categorylevel2 +
                ", specificCategorylevel2='" + specificCategorylevel2 + '\'' +
                ", logopicpath='" + logopicpath + '\'' +
                ", logolocpath='" + logolocpath + '\'' +
                ", versionid=" + versionid +
                ", specificVersionid='" + specificVersionid + '\'' +
                '}';
    }

    public void setVersionid(Long versionid) {
        this.versionid = versionid;
    }
}