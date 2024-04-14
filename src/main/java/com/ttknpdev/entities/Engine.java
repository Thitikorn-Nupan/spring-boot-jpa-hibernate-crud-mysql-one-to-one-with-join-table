package com.ttknpdev.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "engines")
public class Engine {
    @Id
    // @JsonIgnore if it is not be auto_increment when you created No using @JsonIgnore it will close you get/set ter!!!
    private String eid;
    private String code;

    public Engine(String eid, String code) {
        this.eid = eid;
        this.code = code;
    }

    public Engine() {
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "eid='" + eid + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
