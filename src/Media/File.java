package Media;

import java.util.List;

/**
 * Created by Kravets on 22.09.2016.
 */
public class File  {


    private  int id ;
    private  String name;
    private  String author;
    private int releaseYear;
    private String country;
    private double rang;
    private List<?> genre;
    public File() {
    }

    public List<?> getGenre() {
        return genre;
    }

    public void setGenre(List<?> genre) {
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public File setId(int id) {
        checkId(id);
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public File setName(String name) {
        this.name = name;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public File setAuthor(String author) {
        this.author = author;
        return this;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public File setReleaseYear(int releaseYear) {
        checkYear(releaseYear);
        this.releaseYear = releaseYear;
        return this;
    }


    public String getCountry() {
        return country;
    }

    public File setCountry(String country) {
        this.country = country;
        return this;
    }

    public double getRang() {
        return rang;
    }

    public File setRang(double rang) {
        checkRang(rang);
        this.rang = rang;
        return this;
    }


    private void checkId(int id) {
        if (!Validation.isId (id)) {
            throw new IllegalArgumentException("Illegal id");
        }
    }

    private void checkYear(int year) {
        if (!Validation.isYear(year)) {
            throw new IllegalArgumentException("Illegal releaseYear");
        }
    }

    private void checkRang(double rang) {
        if (!Validation.isRang(rang)) {
            throw new IllegalArgumentException("Illegal rang");
        }
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", releaseYear=" + releaseYear +
                ", country='" + country + '\'' +
                ", rang=" + rang +
                '}';
    }



}
