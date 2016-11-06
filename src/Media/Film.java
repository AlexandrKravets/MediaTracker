package Media;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Kravets on 22.09.2016.
 */
public class Film extends File implements Comparator<Film> {

    private String dyrectedBy;
    private int quality;
    private String mainActor;
    private int length;
    private  List<String> actors;
    private  List<FilmGenre> genreOfFilms;

    public Film() {
    }

    @Override
    public List<?> getGenre() {
        return super.getGenre();
    }

    @Override
    public void setGenre(List<?> genreOfFilms) {
        super.setGenre(genreOfFilms);
        this.genreOfFilms = (List<FilmGenre>) genreOfFilms;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }



    public String getDyrectedBy() {
        return dyrectedBy;
    }

    public Film setDyrectedBy(String dyrectedBy) {
        this.dyrectedBy = dyrectedBy;
        return this;
    }

    public int getQuality() {
        return quality;
    }

    public Film setQuality(int quality) {
        checkQuality(quality);
        this.quality = quality;
        return this;
    }

    public String getMainActor() {
        return mainActor;
    }

    public Film setMainActor(String mainActor) {
        this.mainActor = mainActor;
        return this;
    }

    public int getLength() {
        return length;
    }

    public Film setLength(int length) {
        this.length = length;
        return this;
    }

    private void checkQuality(int quality) {
        if (!Validation.isQuality (quality)) {
            throw new IllegalArgumentException("Illegal id");
        }
    }


    @Override
    public String toString() {
        return "Film{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", author='" + getAuthor() + '\'' +
                ", year=" + getReleaseYear() +
                ", country='" + getCountry() + '\'' +
                ", rang=" + getRang() + '\''+
                "dyrectedBy='" + dyrectedBy + '\'' +
                ", quality=" + quality +
                ", mainActor='" + mainActor + '\'' +
                ", length=" + length +
                ", actors=" + actors +
                ", GenreOfFilm=" + genreOfFilms +
                '}';
    }


    @Override
    public int compare(Film o1, Film o2) {
        return Integer.compare(o1.getReleaseYear(), o2.getReleaseYear());
    }
}

