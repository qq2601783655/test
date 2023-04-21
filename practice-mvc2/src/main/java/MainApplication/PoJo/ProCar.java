package MainApplication.PoJo;

import org.springframework.stereotype.Component;

@Component
public class ProCar {
    private Integer pId;

    private Integer cusId;

    private Integer num;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

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