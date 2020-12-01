package edu.etime.panda.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="scenicspots")
public class ScenicSpots {
	@Id
    private String spotsid;

    private String spotsname;

    private String spotsaddr;

    private String spotsaddr2;

    private String spotsopentime;

    private String spotsoneworlds;

    private String spotsimg;

    private Integer spotsstate;

    private Integer spotsfirst;

    private Integer spotshot;

    private String spotsareaid;

    private String spotsareaname;

    private String spotsdesc;

    public String getSpotsid() {
        return spotsid;
    }

    public void setSpotsid(String spotsid) {
        this.spotsid = spotsid == null ? null : spotsid.trim();
    }

    public String getSpotsname() {
        return spotsname;
    }

    public void setSpotsname(String spotsname) {
        this.spotsname = spotsname == null ? null : spotsname.trim();
    }

    public String getSpotsaddr() {
        return spotsaddr;
    }

    public void setSpotsaddr(String spotsaddr) {
        this.spotsaddr = spotsaddr == null ? null : spotsaddr.trim();
    }

    public String getSpotsaddr2() {
        return spotsaddr2;
    }

    public void setSpotsaddr2(String spotsaddr2) {
        this.spotsaddr2 = spotsaddr2 == null ? null : spotsaddr2.trim();
    }

    public String getSpotsopentime() {
        return spotsopentime;
    }

    public void setSpotsopentime(String spotsopentime) {
        this.spotsopentime = spotsopentime == null ? null : spotsopentime.trim();
    }

    public String getSpotsoneworlds() {
        return spotsoneworlds;
    }

    public void setSpotsoneworlds(String spotsoneworlds) {
        this.spotsoneworlds = spotsoneworlds == null ? null : spotsoneworlds.trim();
    }

    public String getSpotsimg() {
        return spotsimg;
    }

    public void setSpotsimg(String spotsimg) {
        this.spotsimg = spotsimg == null ? null : spotsimg.trim();
    }

    public Integer getSpotsstate() {
        return spotsstate;
    }

    public void setSpotsstate(Integer spotsstate) {
        this.spotsstate = spotsstate;
    }

    public Integer getSpotsfirst() {
        return spotsfirst;
    }

    public void setSpotsfirst(Integer spotsfirst) {
        this.spotsfirst = spotsfirst;
    }

    public Integer getSpotshot() {
        return spotshot;
    }

    public void setSpotshot(Integer spotshot) {
        this.spotshot = spotshot;
    }

    public String getSpotsareaid() {
        return spotsareaid;
    }

    public void setSpotsareaid(String spotsareaid) {
        this.spotsareaid = spotsareaid == null ? null : spotsareaid.trim();
    }

    public String getSpotsareaname() {
        return spotsareaname;
    }

    public void setSpotsareaname(String spotsareaname) {
        this.spotsareaname = spotsareaname == null ? null : spotsareaname.trim();
    }

    public String getSpotsdesc() {
        return spotsdesc;
    }

    public void setSpotsdesc(String spotsdesc) {
        this.spotsdesc = spotsdesc == null ? null : spotsdesc.trim();
    }
}