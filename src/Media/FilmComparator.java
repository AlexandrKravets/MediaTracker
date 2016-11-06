package Media;

import java.util.Comparator;

/**
 * Created by Kravets on 06.10.2016.
 */
class FilmComparator implements Comparator<Film> {

    @Override
    public int compare(Film o1, Film o2) {
        return Integer.compare(o1.getReleaseYear(), o2.getReleaseYear());
    }
}

