package MainApplication.Service.ProCarService;

import MainApplication.PoJo.ProCar;
import MainApplication.PoJo.Production;

import java.util.List;

public interface ProCarService {

   boolean subPro(ProCar proCar);
    List<ProCar> readProByCookie(ProCar proCar);
    void deletePro(int[] pro_id);



}
