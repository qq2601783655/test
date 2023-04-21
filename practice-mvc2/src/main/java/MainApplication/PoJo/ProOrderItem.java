package MainApplication.PoJo;

import org.springframework.stereotype.Component;

@Component
public class ProOrderItem extends ProOrderItemKey {
    private Integer cusId;
    private Integer num;

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}