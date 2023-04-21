package MainApplication.Service.ProOrderService;
import MainApplication.PoJo.ProOrder;
import org.apache.ibatis.annotations.Mapper;

public interface ProOrderService {
        void OrderItemGenerate(int[] pro_num,int[] pro_id,ProOrder proOrder);
        void deleteItem(int[] pro_id);
}
