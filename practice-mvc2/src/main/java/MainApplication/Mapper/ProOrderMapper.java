package MainApplication.Mapper;

import MainApplication.PoJo.ProOrder;
import MainApplication.PoJo.ProOrderExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
public interface ProOrderMapper {
    long countByExample(ProOrderExample example);

    int deleteByExample(ProOrderExample example);

    int deleteByPrimaryKey(String ordercode);

    int insert(ProOrder record);

    int insertSelective(ProOrder record);

    List<ProOrder> selectByExample(ProOrderExample example);

    ProOrder selectByPrimaryKey(String ordercode);

    int updateByExampleSelective(@Param("record") ProOrder record, @Param("example") ProOrderExample example);

    int updateByExample(@Param("record") ProOrder record, @Param("example") ProOrderExample example);

    int updateByPrimaryKeySelective(ProOrder record);

    int updateByPrimaryKey(ProOrder record);
}