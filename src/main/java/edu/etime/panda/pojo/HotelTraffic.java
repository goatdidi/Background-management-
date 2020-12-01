package edu.etime.panda.pojo;

public class HotelTraffic {
    private String htrid;
    private String hotelid;
    private String htrdestination;
    private String htrdesc;
    private String htrtime;
    private Integer htrstate;
    private Integer htrsort;
    private String hotelname;

    public String getHtrid() {
        return htrid;
    }

    @Override
    public String toString() {
        return "HotelTraffic{" +
                "htrid='" + htrid + '\'' +
                ", hotelid='" + hotelid + '\'' +
                ", htrdestination='" + htrdestination + '\'' +
                ", htrdesc='" + htrdesc + '\'' +
                ", htrtime='" + htrtime + '\'' +
                ", htrstate=" + htrstate +
                ", htrsort=" + htrsort +
                ", hotelname='" + hotelname + '\'' +
                '}';
    }

    public void setHtrid(String htrid) {
        this.htrid = htrid;
    }

    public String getHotelid() {
        return hotelid;
    }

    public void setHotelid(String hotelid) {
        this.hotelid = hotelid;
    }

    public String getHtrdestination() {
        return htrdestination;
    }

    public void setHtrdestination(String htrdestination) {
        this.htrdestination = htrdestination;
    }

    public String getHtrdesc() {
        return htrdesc;
    }

    public void setHtrdesc(String htrdesc) {
        this.htrdesc = htrdesc;
    }

    public String getHtrtime() {
        return htrtime;
    }

    public void setHtrtime(String htrtime) {
        this.htrtime = htrtime;
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

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }


}
