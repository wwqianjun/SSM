package qianjun.rdm.mapper;

public interface ProductSecKillTotalMapper {
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(BidInfo record);
//
//    int insertSelective(BidInfo record);
//
//    Role selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(BidInfo record);
//
//    int updateByPrimaryKey(BidInfo record);

    int selectTotalByProductCode(String ProductCode);

    int decryByProductCode(String ProductCode);
}