package Media;

/**
 * Created by Kravets on 06.10.2016.
 */
public enum BookGenre {
    BIOGRAPHY("biography)"),
    HORROR("horror"),
    SCIENCE("science"),
    FANTASY("fantasy"),
    SCIENCE_FICTION("science fiction"),
    CHILDRENS("childrens"),
    COOKBOOKS("cookbooks"),
    BUSINESS_FINANCE("Business & Finance"),
    HISTORICAL("historical"),
    DETECTIVE("detective");


    private final String genreName;

    BookGenre(String genreName) {
        this.genreName = genreName;
    }

    public String getGenreName() {
        return genreName;
    }
}

