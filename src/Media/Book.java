package Media;

import java.util.List;

/**
 * Created by Kravets on 22.09.2016.
 */
public class Book extends File{


    private String publishing;
    private int pages;
    private List <BookGenre> genreOfBooks;

    public Book() {
    }

    @Override
    public List<?> getGenre() {
        return super.getGenre();
    }

    @Override
    public void setGenre(List<?> genreOfBooks) {
        super.setGenre(genreOfBooks);
        this.genreOfBooks = (List<BookGenre>) genreOfBooks;
    }

    public String getPublishing() {
        return publishing;
    }

    public Book setPublishing(String publishing) {
        this.publishing = publishing;
        return this;
    }


    public int getPages() {
        return pages;
    }

    public Book setPages(int pages) {
        checkPages(pages);
        this.pages = pages;
        return this;
    }



    private void checkPages(int pages){
        if(!Validation.isPages(pages)){
            throw new IllegalArgumentException("Illegal pages");
        }
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", author='" + getAuthor() + '\'' +
                ", year=" + getReleaseYear() +
                ", country='" + getCountry() + '\'' +
                ", rang=" + getRang() + '\''+
                "publishing='" + publishing + '\'' +
                ", pages=" + pages +
                ", genreOfBooks=" + genreOfBooks +
                '}';
    }
}