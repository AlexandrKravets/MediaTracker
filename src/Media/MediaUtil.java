package Media;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Kravets on 27.09.2016.
 */
    public class MediaUtil {



        protected static List<File> findYearOfFilm(List<File> films, int year) {
            List<File> res = new ArrayList<>();
            for (File film : films) {
                if (film.getReleaseYear() == year ) {
                    res.add(film);
                }
            }
            return res;
        }

        protected static List<Film> findNameOfFilm(List<Film> films, String name) {
            List<Film> res = new ArrayList<>();
            for (Film film : films ) {
                if (film.getName().equals(name)){
                    res.add(film);
                }
            }
            return res;
        }

        protected static List<File>  findAuthorOfFilm(List<File> films, String author){
            List<File> res = new ArrayList<>();
            for (File film : films){
                if(film.getAuthor().equals(author)){
                    res.add(film);
                }
            }
            return res;
        }
        //!!!!!!!!!!!!!!!   очень похожи
        protected static List<File> findGenreOfFilms(List<File> listFilms, List<FilmGenre> genres){
            List<File> res  = new ArrayList<>();
            for (File listFilm : listFilms) {
                for (FilmGenre genre : genres) {
                    if (listFilm.getGenre().contains(genre)){
                        res.add(listFilm);
                    }
                }

            }
            return res;
        }
        protected static List<File> findGenreOfMusic(List<File> musics, List<MusicGenre> genres){
            List<File> res  = new ArrayList<>();
            for (File music : musics) {
                for (MusicGenre genre : genres) {
                    if (music.getGenre().contains(genre)){
                        res.add(music);
                    }
                }
            }
            return res;
        }

        protected static List<File> findGenreOfBooks(List<File> books, List<BookGenre> genres){
            List<File> res  = new ArrayList<>();
            for (File book : books) {
                for (BookGenre genre : genres) {
                    if (book.getGenre().contains(genre)){
                        res.add(book);
                    }
                }
            }
            return res;
        }


        protected static List<Film> findCountryOfFilm(List<Film> films, String country){
            List<Film> res = new ArrayList<>();
            for (Film film: films) {
                if(film.getCountry().equals(country)) {
                    res.add(film);
                }
            }
            return res;
        }

        protected static List<Film> findRangOfFilm(List<Film> films, double rang){
            List<Film> res = new ArrayList<>();
            for (Film film: films) {
                if(film.getRang() >= rang && film.getRang() <=5) {
                    res.add(film);
                }
            }
            return res;
        }

        protected static List<Film> findDirecteByOfFilm(List<Film> films, String dyrectedBy){
            List<Film> res = new ArrayList<>();
            for (Film film: films) {
                if(film.getDyrectedBy().equals(dyrectedBy)) {
                    res.add(film);
                }
            }
            return res;
        }

        protected static List<File> findMainActorOfFilm(List<File> films, String mainActor){
            List<File> res = new ArrayList<>();
            for (File film: films) {
                Film f = (Film) film;
                if(f.getMainActor().equals(mainActor)) {
                    res.add(f);
                }
            }
            return res;
        }

        protected static List<Film> findQualityOfFilm(List<Film> films, int quality){
            List<Film> res = new ArrayList<>();
            for (Film film: films) {
                if(film.getQuality() >= quality && film.getQuality() <=5){
                    res.add(film);
                }
            }
            return res;
        }

        protected static List<File> findSingerOfMusic(List<File> musics, String singer) {
            List<File> res= new ArrayList<>();
            for (File music : musics ) {
                Music m = (Music) music;
                if (m.getSinger().equals(singer)){
                    res.add(m);
                }
            }
            return res;
        }

        protected static List<Music> findYearOfMusic(List<Music> musics, int year) {
            List<Music> res= new ArrayList<>();
            for (Music music : musics) {
                if (music.getReleaseYear() == year ) {
                    res.add(music);
                }
            }
            return res;
        }

        protected static List<Music> findNameOfMusic(List<Music> musics, String name) {
            List<Music> res= new ArrayList<>();
            for (Music music : musics ) {
                if (music.getName().equals(name)){
                    res.add(music);
                }
            }
            return res;
        }

        protected static List<Music> findAuthorOfMusic(List<Music> musics, String author){
            List<Music> res= new ArrayList<>();
            for (Music music: musics){
                if(music.getAuthor().equals(author)){
                    res.add(music);
                }
            }
            return res;
        }





        protected static List<Music> findCountryOfMusic(List<Music> musics, String country){
            List<Music> res= new ArrayList<>();
            for (Music music: musics) {
                if (music.getCountry().equals(country)) {
                    res.add(music);
                }
            }
            return res;
        }

        protected static List<File> findRangOfMusic(List<File> musics, double rang) {
            List<File> res= new ArrayList<>();
            for (File music : musics) {
                if (music.getRang() >= rang && music.getRang() <= 5) {
                    res.add(music);
                }
            }
            return res;
        }


        protected static List<Book> findYearOfBook(List<Book> books, int year) {
            List<Book> res= new ArrayList<>();
            for (Book book : books) {
                if (book.getReleaseYear() == year ) {
                    res.add(book);
                }
            }
            return res;
        }

        protected static List<File>findNameOfBook(List<File> books, String name) {
            List<File> res= new ArrayList<>();
            for (File book : books ) {
                if (book.getName().equals(name)) {
                    res.add(book);
                }
            }
            return res;
        }

        protected static List<File> findAuthorOfBook(List<File> books, String author){
            List<File> res= new ArrayList<>();
            for (File book : books) {
                if (book.getAuthor().equals(author)){
                    res.add(book);
                }
            }
            return res;
        }

        protected static List<Book> findCountryOfBook(List<Book> books, String country){
            List<Book> res= new ArrayList<>();
            for (Book book: books) {
                if(book.getCountry().equals(country)) {
                    res.add(book);
                }
            }
            return res;
        }

        protected static List<Book> findRangOfBook(List<Book> books, double rang){
            List<Book> res= new ArrayList<>();
            for (Book book: books) {
                if (book.getRang() >= rang && book.getRang() <= 5){
                    res.add(book);
                }
            }
            return res;
        }

        protected static List<File> findPublishingOfBook(List<File> books, String publishing){
            List<File> res= new ArrayList<>();
            for (File book: books) {
                Book b = (Book) book;
                if(b.getPublishing().equals(publishing)) {
                    res.add(b);
                }

            }
            return res;
        }

    }