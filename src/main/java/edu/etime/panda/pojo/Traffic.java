package edu.etime.panda.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="hotelTraffic")
public class Traffic {
    @Id
    private String htrid;
    private String hotelid;
    private String htrdestination;
    private String htrdesc;
    private String htrtime;
    private Integer htrstate;
    private Integer htrsort;
    public String getHtrid() {
        return htrid;
    }

    public void setHtrid(String htrid) {
        this.htrid = htrid==null?null:htrid.trim();
    }

    public String getHotelid() {
        return hotelid;
    }

    public void setHotelid(String hotelid) {
        this.hotelid = hotelid==null?null:hotelid.trim();
    }

    public String getHtrdestination() {
        return htrdestination;
    }

    public void setHtrdestination(String htrdestination) {
        this.htrdestination = htrdestination==null?null:htrdestination.trim();
    }

    public String getHtrdesc() {
        return htrdesc;
    }

    public void setHtrdesc(String htrdesc) {
        this.htrdesc = htrdesc==null?null:htrdesc.trim();
    }

    public String getHtrtime() {
        return htrtime;
    }

    public void setHtrtime(String htrtime) {
        this.htrtime = htrtime==null?null:htrtime.trim();
    }

    public Integer getHtrstate() {
        return htrstate;
    }

    public void setHtrstate(Integer htrstate) {
        this.htrstate = htrstate;
    }

    public Integer getHtrsort() {
        return htrsort;
    }

    public void setHtrsort(Integer htrsort) {
        this.htrsort = htrsort;
    }

}
