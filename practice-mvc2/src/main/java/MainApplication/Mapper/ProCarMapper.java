package MainApplication.Mapper;

import MainApplication.PoJo.ProCar;
import MainApplication.PoJo.ProCarExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
public interface ProCarMapper {
    long countByExample(ProCarExample example);

    int deleteByExample(ProCarExample example);

    int insert(ProCar record);

    int insertSelective(ProCar record);

    List<ProCar> selectByExample(ProCarExample example);

    int updateByExampleSelective(@Param("record") ProCar record, @Param("example") ProCarExample example);

    int updateByExample(@Param("record") ProCar record, @Param("example") ProCarExample example);
}