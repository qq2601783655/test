package MainApplication.Service.OrderShowService;

import MainApplication.PoJo.Production;

import java.util.List;

public interface OrderItemShowService {

    List<Production> proOrderItemShow(String ordercode, int cus_id);



}
