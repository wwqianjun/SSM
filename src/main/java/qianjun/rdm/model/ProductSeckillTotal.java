package qianjun.rdm.model;

import java.util.Date;

/**
 * Created by ZiJun
 * Description:
 * Date: 2016/1/11 :17:08.
 */
public class ProductSeckillTotal {
    private String id;

    private Integer total;

    private String productCode;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
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
        return "productSeckillTotal{" +
                "id='" + id + '\'' +
                ", total=" + total +
                ", productCode='" + productCode + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
