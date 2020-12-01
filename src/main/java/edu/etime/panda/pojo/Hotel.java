package edu.etime.panda.pojo;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name="Hotel")
public class Hotel {
    @Id
    private String hotelid;
    private String hotelname;
    private String hotelename;
    private String hoteladdr;
    private String hoteladdr2;
    private String hotelimg;
    private String hoteldesc;
    private	String hotelopentime;
    private String hotelchildpolicy;
    private	String hotelbreakfast;
    private	String hotelpetpolicy;
    private	Integer hotelstate;
    private	String hotellable;
    private	String hoteltypeid;
    private	String hoteltypename;
    

    public String getHotelid() {
        return hotelid;
    }

    public void setHotelid(String hotelid) {
        this.hotelid = hotelid == null?null:hotelid.trim();
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname==null?null:hotelname.trim();
    }

    public String getHotelename() {
        return hotelename;
    }

    public void setHotelename(String hotelename) {
        this.hotelename = hotelename==null?null:hotelename.trim();
    }

    public String getHoteladdr() {
        return hoteladdr;
    }

    public void setHoteladdr(String hoteladdr) {
        this.hoteladdr = hoteladdr==null?null:hoteladdr.trim();
    }

    public String getHoteladdr2() {
        return hoteladdr2;
    }

    public void setHoteladdr2(String hoteladdr2) {
        this.hoteladdr2 = hoteladdr2==null?null:hoteladdr2.trim();
    }

    public String getHotelimg() {
        return hotelimg;
    }

    public void setHotelimg(String hotelimg) {
        this.hotelimg = hotelimg==null?null:hotelimg.trim();
    }
    public String getHoteldesc(){
    	return hoteldesc;
    }
    public void setHoteldesc(String hoteldesc){
    	this.hoteldesc = hoteldesc==null?null:hoteldesc.trim();
    }
    public String getHotelopentime(){
    	return hotelopentime;	
    }
    public void setHotelopentime(String hotelopentime){
    	this.hotelopentime = hotelopentime==null?null:hotelopentime.trim();
    }
    public String getHotelchildpolicy(){
    	return hotelchildpolicy;
    }
    public void setHotelchildpolicy(String hotelchildpolicy){
    	this.hotelchildpolicy = hotelchildpolicy==null?null:hotelchildpolicy.trim();
    }
    public String getHotelbreakfast(){
    	return hotelbreakfast;
    }
    public void setHotelbreakfast(String hotelbreakfast){
    	this.hotelbreakfast = hotelbreakfast==null?null:hotelbreakfast.trim();
    }
    public String getHotelpetpolicy(){
    	return hotelpetpolicy;
    }
    public void setHotelpetpolicy(String hotelpetpolicy){
    	this.hotelpetpolicy = hotelpetpolicy==null?null:hotelpetpolicy.trim();
    }
    public Integer getHotelstate(){
    	return hotelstate;
    }
    public void setHotelstate(Integer hotelstate){
    	this.hotelstate = hotelstate;
    }
    public String getHotellable(){
    	return hotellable;
    }
    public void setHotellable(String hotellable){
    	this.hotellable = hotellable==null?null:hotellable.trim();
    }

    public String getHoteltypeid() {
        return hoteltypeid;
    }

    public void setHoteltypeid(String hoteltypeid) {
        this.hoteltypeid = hoteltypeid==null?null:hoteltypeid.trim();
    }

    public String getHoteltypename(){
    	return hoteltypename;
    }
    public void setHoteltypename(String hoteltypename){
    	this.hoteltypename = hoteltypename==null?null:hoteltypename.trim();
    }
}
