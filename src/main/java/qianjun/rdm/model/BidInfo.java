package qianjun.rdm.model;

import java.util.Date;

/**
 * Created by ZiJun
 * Description:
 * Date: 2016/1/11 :16:14.
 */
public class BidInfo {
    private String id;

    private Integer userId;

    private String moblie;

    private String productCode;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMoblie() {
        return moblie;
    }

    public void setMoblie(String moblie) {
        this.moblie = moblie;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BidInfo{" +
                "id='" + id + '\'' +
                ", userId=" + userId +
                ", moblie='" + moblie + '\'' +
                ", productCode='" + productCode + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
