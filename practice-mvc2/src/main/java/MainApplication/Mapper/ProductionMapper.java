package MainApplication.Mapper;

import MainApplication.PoJo.Production;
import MainApplication.PoJo.ProductionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductionMapper {
    long countByExample(ProductionExample example);

    int deleteByExample(ProductionExample example);

    int deleteByPrimaryKey(Integer proId);

    int insert(Production record);

    int insertSelective(Production record);

    List<Production> selectByExampleWithBLOBs(ProductionExample example);

    List<Production> selectByExample(ProductionExample example);

    Production selectByPrimaryKey(Integer proId);

    int updateByExampleSelective(@Param("record") Production record, @Param("example") ProductionExample example);

    int updateByExampleWithBLOBs(@Param("record") Production record, @Param("example") ProductionExample example);

    int updateByExample(@Param("record") Production record, @Param("example") ProductionExample example);

    int updateByPrimaryKeySelective(Production record);

    int updateByPrimaryKeyWithBLOBs(Production record);

    int updateByPrimaryKey(Production record);
}