package Media;

import java.util.Calendar;

/**
 * Created by Kravets on 22.09.2016.
 */
public class Validation {
    public static boolean isYear(int year){
        int yr = Calendar.getInstance().get(Calendar.YEAR);
        return year>=1800 && year <= yr;
    }
    public static boolean isPages(int page){
        return page>=1 && page<=2000;
    }
    public static boolean isRang(double rang){return rang>=0 && rang<=5;}
    public static boolean isId(int id){return id>=1 && id<=10000;}
    public static boolean isQuality(int quality){return quality>=1 && quality<=5;}


}