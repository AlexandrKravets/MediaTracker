package Media;

/**
 * Created by Kravets on 06.10.2016.
 */

    public enum FilmGenre {
    THRILLER("thriller"),
    HORROR("horror"),
    DRAMA("drama"),
    MELODRAMA("meladrama"),
    WESTERN("western"),
    COMEDY("comedy"),
    ACTION("action"),
    SCIENCE("science"),
    FANTASY("fantesy"),
    MUSICAL("musical"),
    FICTION("fiction"),
    DETECTIVE("detective"),
    CRIMINAL("criminal"),
    MILITARY("military");

    private final String genreName;

    FilmGenre(String genreName) {
        this.genreName = genreName;
    }

    public String getGenreName() {
        return genreName;
    }

    @Override
    public String toString() {
        return "FilmGenre{" +
                "genreName='" + genreName + '\'' +
                '}';
    }
}
