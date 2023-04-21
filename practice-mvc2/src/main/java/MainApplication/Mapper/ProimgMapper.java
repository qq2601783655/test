package MainApplication.Mapper;

import MainApplication.PoJo.Proimg;
import MainApplication.PoJo.ProimgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProimgMapper {
    long countByExample(ProimgExample example);

    int deleteByExample(ProimgExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Proimg record);

    int insertSelective(Proimg record);

    List<Proimg> selectByExample(ProimgExample example);

    Proimg selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Proimg record, @Param("example") ProimgExample example);

    int updateByExample(@Param("record") Proimg record, @Param("example") ProimgExample example);

    int updateByPrimaryKeySelective(Proimg record);

    int updateByPrimaryKey(Proimg record);
}