package edu.etime.panda.pojo;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name="sysHotelType")

public class HotelType {
    @Id
    private String typeid;
    private String typename;
    private Integer typestate;
    private Integer typesort;


    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid==null?null:typeid.trim();
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename==null?null:typename.trim();
    }

    public Integer getTypestate() {
        return typestate;
    }

    public void setTypestate(Integer typestate) {
        this.typestate = typestate;
    }

    public Integer getTypesort() {
        return typesort;
    }

    public void setTypesort(Integer typesort) {
        this.typesort = typesort;
    }
}
