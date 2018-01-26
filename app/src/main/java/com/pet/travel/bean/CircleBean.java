package com.pet.travel.bean;

import java.io.Serializable;
import java.util.Date;

public class CircleBean implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column circle.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column circle.description
     *
     * @mbg.generated
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column circle.account
     *
     * @mbg.generated
     */
    private String account;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column circle.account_id
     *
     * @mbg.generated
     */
//    private Integer account_id;
    private Integer accountId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column circle.photos
     *
     * @mbg.generated
     */
    private String photos;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column circle.thumbs
     *
     * @mbg.generated
     */
    private String thumbs;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column circle.create_time
     *
     * @mbg.generated
     */
//    private Date create_time;
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column circle.modify_time
     *
     * @mbg.generated
     */
//    private Date modify_time;
    private Date modifyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column circle.address
     *
     * @mbg.generated
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column circle.run_id
     *
     * @mbg.generated
     */
    private Integer runId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table circle
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column circle.id
     *
     * @return the value of circle.id
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column circle.id
     *
     * @param id the value for circle.id
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column circle.description
     *
     * @return the value of circle.description
     * @mbg.generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column circle.description
     *
     * @param description the value for circle.description
     * @mbg.generated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column circle.account
     *
     * @return the value of circle.account
     * @mbg.generated
     */
    public String getAccount() {
        return account;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column circle.account
     *
     * @param account the value for circle.account
     * @mbg.generated
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column circle.account_id
     *
     * @return the value of circle.account_id
     * @mbg.generated
     */
//    public Integer getAccount_id() {
//        return account_id;
//    }
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method sets the value of the database column circle.account_id
//     *
//     * @param accountId the value for circle.account_id
//     * @mbg.generated
//     */
//    public void setAccount_id(Integer accountId) {
//        this.account_id = accountId;
//    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column circle.photos
     *
     * @return the value of circle.photos
     * @mbg.generated
     */
    public String getPhotos() {
        return photos;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column circle.photos
     *
     * @param photos the value for circle.photos
     * @mbg.generated
     */
    public void setPhotos(String photos) {
        this.photos = photos == null ? null : photos.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column circle.thumbs
     *
     * @return the value of circle.thumbs
     *
     * @mbg.generated
     */
    public String getThumbs() {
        return thumbs;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column circle.thumbs
     *
     * @param thumbs the value for circle.thumbs
     *
     * @mbg.generated
     */
    public void setThumbs(String thumbs) {
        this.thumbs = thumbs == null ? null : thumbs.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column circle.create_time
     *
     * @return the value of circle.create_time
     * @mbg.generated
     */
//    public Date getCreate_time() {
//        return create_time;
//    }
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method sets the value of the database column circle.create_time
//     *
//     * @param createTime the value for circle.create_time
//     * @mbg.generated
//     */
//    public void setCreate_time(Date createTime) {
//        this.create_time = createTime;
//    }
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method returns the value of the database column circle.modify_time
//     *
//     * @return the value of circle.modify_time
//     * @mbg.generated
//     */
//    public Date getModify_time() {
//        return modify_time;
//    }
//
//    /**
//     * This method was generated by MyBatis Generator.
//     * This method sets the value of the database column circle.modify_time
//     *
//     * @param modifyTime the value for circle.modify_time
//     * @mbg.generated
//     */
//    public void setModify_time(Date modifyTime) {
//        this.modify_time = modifyTime;
//    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column circle.address
     *
     * @return the value of circle.address
     * @mbg.generated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column circle.address
     *
     * @param address the value for circle.address
     * @mbg.generated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column circle.run_id
     *
     * @return the value of circle.run_id
     * @mbg.generated
     */
    public Integer getRunId() {
        return runId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column circle.run_id
     *
     * @param runId the value for circle.run_id
     * @mbg.generated
     */
    public void setRunId(Integer runId) {
        this.runId = runId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public CircleBean setAccountId(Integer accountId) {
        this.accountId = accountId;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public CircleBean setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public CircleBean setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }
}