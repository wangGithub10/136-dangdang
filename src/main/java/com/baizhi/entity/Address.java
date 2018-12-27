package com.baizhi.entity;

import java.io.Serializable;

/**
 * @author wyq
 * @description 地址表实体类
 * @日期：
 */
public class Address implements Serializable {
    /**
     * 表id
     */
    private Integer id;
    /**
     * 收件人姓名
     */
    private String receive_name;
    /**
     * 收件人地址
     */
    private String full_address;
    /**
     * 邮政编码
     */
    private String zipcode;
    /**
     * 电话
     */
    private String receive_tel;
    /**
     * 手机
     */
    private String receive_phone;
    /**
     * 用户id
     */
    private Integer user_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReceive_name() {
        return receive_name;
    }

    public void setReceive_name(String receive_name) {
        this.receive_name = receive_name;
    }

    public String getFull_address() {
        return full_address;
    }

    public void setFull_address(String full_address) {
        this.full_address = full_address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getReceive_tel() {
        return receive_tel;
    }

    public void setReceive_tel(String receive_tel) {
        this.receive_tel = receive_tel;
    }

    public String getReceive_phone() {
        return receive_phone;
    }

    public void setReceive_phone(String receive_phone) {
        this.receive_phone = receive_phone;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Address [id=" + id + ", receive_name=" + receive_name
                + ", full_address=" + full_address + ", zipcode="
                + zipcode + ", receive_tel=" + receive_tel
                + ", receive_phone=" + receive_phone + ", user_id="
                + user_id + "]";
    }
}
