package Media;

import java.util.List;

/**
 * Created by Kravets on 22.09.2016.
 */
public class Music extends File {
    private  String singer;
    private int length;
    private List <MusicGenre> genreOfMusics;

    public Music() {
    }

    @Override
    public List<?> getGenre() {
        return super.getGenre();
    }

    @Override
    public void setGenre(List<?> genreOfMusics) {
        super.setGenre(genreOfMusics);
        this.genreOfMusics = (List<MusicGenre>) genreOfMusics;
    }

    public String getSinger() {
        return singer;
    }

    public Music setSinger(String singer) {
        this.singer = singer;
        return this;
    }

    public int getLength() {
        return length;
    }

    public Music setLength(int length) {
        this.length = length;
        return this;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", author='" + getAuthor() + '\'' +
                ", year=" + getReleaseYear() +
                ", country='" + getCountry() + '\'' +
                ", rang=" + getRang() + '\''+
                "singer='" + singer + '\'' +
                ", length=" + length +
                ", genreOfMusics=" + genreOfMusics +
                '}';
    }
}
