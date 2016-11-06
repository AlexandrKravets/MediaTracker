package Media;

import java.util.*;
import java.util.List;

import static java.util.Collections.reverseOrder;

/**
 * Created by Petskov on 10.10.2016.
 */
public class Sorting {
    public static List<File> setUpYear(List<File> files) throws Exception {
        Collections.sort(files, new FileYearComparator());
        return files;
    }
    public static List<File> setDownYear(List<File> files) throws Exception {
        Collections.sort(files, reverseOrder(new FileYearComparator()));
        return files;
    }

    public static List<File> setDownRang(List<File> files) throws Exception {
        Collections.sort(files, reverseOrder(new FileRangComparator()));
        return files;
    }

    public static List<File> setUpRang(List <File> files){
        Collections.sort(files, new FileRangComparator());
        return files;
    }

}