package Media;

/**
 * Created by Kravets on 06.10.2016.
 */
public enum MusicGenre {
    POP("Pop music"),
    JAZZ("Jazz music"),
    PHUNK("Phunk music"),
    HIP_HOP("Hip-Hop music"),
    REGGY("Reggy"),
    BALLADA("Ballada"),
    ROCK("Rock music"),
    RNB("RNB music"),
    RAP("Rep music"),
    ELECTRO("Electro music"),
    METAL("Metall rock"),
    CLASSIC("Classic music"),
    TRANS("Trans music");

    private final String  genreName;

    MusicGenre(String genreName) {
        this.genreName = genreName;
    }

    public String getGenreName() {
        return genreName;
    }
}
