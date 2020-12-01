package edu.etime.panda.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 景点地域实体类
 * @author zw
 */
@Table(name="sysarea")//name=对应数据表名
public class SysArea {
	
	@Id //标注主键
    private String areaid;
	
    private String areaname;

    private Integer areastate;

    private Integer areasort;

    public String getAreaid() {
        return areaid;
    }

    public void setAreaid(String areaid) {
        this.areaid = areaid == null ? null : areaid.trim();
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname == null ? null : areaname.trim();
    }

    public Integer getAreastate() {
        return areastate;
    }

    public void setAreastate(Integer areastate) {
        this.areastate = areastate;
    }

    public Integer getAreasort() {
        return areasort;
    }

    public void setAreasort(Integer areasort) {
        this.areasort = areasort;
    }
}