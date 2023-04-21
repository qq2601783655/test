package MainApplication.Bean;

import MainApplication.PoJo.ProCar;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;

@Component
public class Identify {

    public int getProIdFromCookie(Cookie[] cookies){
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("pro_id")){
                return Integer.parseInt(cookie.getValue());
            }
        }
            return 0;
    }

    public int getSlatIdFromCookie(Cookie[] cookies){
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("slat_id")){
                return Integer.parseInt(cookie.getValue());
            }
        }
        return 0;
    }
    public int getCusIdFromCookie(Cookie[] cookies){
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("cus_id")){
                return Integer.parseInt(cookie.getValue());
            }
        }
        return 0;
    }


    public boolean identifyPro_id(int pro_id){
        return false;
    }
    public boolean identifyProCar(ProCar proCar){

        return false;
    }

    public boolean identifyProCar(){

        return false;
    }




}
