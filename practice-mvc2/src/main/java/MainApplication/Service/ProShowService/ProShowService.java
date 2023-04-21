package MainApplication.Service.ProShowService;

import MainApplication.PoJo.Production;
import MainApplication.PoJo.Proimg;

import java.util.List;

public interface ProShowService {

    List<Production> readProduction();
    Production readProDataById(int id);
    List<Proimg> readProImgByPid(int pid);


}
