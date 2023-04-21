package MainApplication.Mapper;

import MainApplication.PoJo.ProOrderItem;
import MainApplication.PoJo.ProOrderItemExample;
import MainApplication.PoJo.ProOrderItemKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProOrderItemMapper {
    long countByExample(ProOrderItemExample example);

    int deleteByExample(ProOrderItemExample example);

    int deleteByPrimaryKey(ProOrderItemKey key);

    int insert(ProOrderItem record);

    int insertSelective(ProOrderItem record);

    List<ProOrderItem> selectByExample(ProOrderItemExample example);

    ProOrderItem selectByPrimaryKey(int key);

    int updateByExampleSelective(@Param("record") ProOrderItem record, @Param("example") ProOrderItemExample example);

    int updateByExample(@Param("record") ProOrderItem record, @Param("example") ProOrderItemExample example);

    int updateByPrimaryKeySelective(ProOrderItem record);

    int updateByPrimaryKey(ProOrderItem record);
}