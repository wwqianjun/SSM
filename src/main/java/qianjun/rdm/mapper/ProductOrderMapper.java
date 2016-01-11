package qianjun.rdm.mapper;

import qianjun.rdm.model.BidInfo;

public interface ProductOrderMapper {
//    int deleteByPrimaryKey(Integer id);
//
    int insert(BidInfo record);
//
//    int insertSelective(Role record);
//
//    Role selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(Role record);
//
//    int updateByPrimaryKey(Role record);

    int countByProductCode(String productCode);

}