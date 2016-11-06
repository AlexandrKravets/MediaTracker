package Media;

/**
 * Created by Kravets on 18.10.2016.
 */
import java.util.Comparator;

/**
 * Created by PRO on 11.10.2016.
 */
public class FileYearComparator implements Comparator<File> {
    @Override
    public int compare(File file1, File file2) {
        return Integer.compare(file1.getReleaseYear(),file2.getReleaseYear());

    }
}
