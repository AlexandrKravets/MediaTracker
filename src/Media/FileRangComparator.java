package Media;

import java.util.Comparator;

/**
 * Created by Kravets on 13.10.2016.
 */
public class FileRangComparator implements Comparator<File> {
    @Override
    public int compare(File file1, File file2) {
        return Double.compare(file1.getRang(),file2.getRang());
    }
}
