package Media;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Media.Sorting.setDownRang;
import static Media.Sorting.setDownYear;
import static Media.Sorting.setUpYear;


public class Runner {

    public static final String INPUT_FILE_FILM = "file/Films.csv";
    public static final String OUTPUT_FILE_FILM = "file/films.out";

    public static final String INPUT_FILE_MUSIC = "file/Music.csv";
    public static final String OUTPUT_FILE_MUSIC = "file/music.out";

    public static final String INPUT_FILE_BOOKS = "file/Books.csv";
    public static final String OUTPUT_FILE_BOOKS = "file/books.out";

    public static void main(String[] args) throws Exception {
        List<File> books = createBooks();
        List<File> films = createFilms();
        List<File> musics = createMusics();
        List<Client> clients = createClients();

   // IO
        List<File> filmsFromFile = new ArrayList<>();
        List<File> booksFromFile = new ArrayList<>();
        List<File> musicsFromFile = new ArrayList<>();

        try {

            filmsFromFile = FilmIOUtils.readFilmFromFile(INPUT_FILE_FILM);
            FilmIOUtils.writeFilmIntoFile(OUTPUT_FILE_FILM, films);

            musicsFromFile = MusicIOUtils.readMusicFromFile(INPUT_FILE_MUSIC);
            MusicIOUtils.writeMusicIntoFile(OUTPUT_FILE_MUSIC, musics);

            booksFromFile = BookIOUtils.readBookFromFile(INPUT_FILE_BOOKS);
            BookIOUtils.writeBookIntoFile(OUTPUT_FILE_BOOKS, books);



        } catch (IOException e) {
            System.out.println("Something wrong: " + e.getMessage());
        }
// print IO
        printFile(musicsFromFile);
        printFile(booksFromFile);
        printFile(filmsFromFile);

        System.out.println("DONE");

// find
        MediaUtil.findNameOfBook(books, "Alice in Wonderland");
        MediaUtil.findAuthorOfBook(books, "Bruce Eckel");
        MediaUtil.findPublishingOfBook(books, "Piter");
        MediaUtil.findAuthorOfFilm(films, "Dry Pirs");
        MediaUtil.findYearOfFilm(films, 2011);
        MediaUtil.findMainActorOfFilm(films, "Tom Cruze");
        MediaUtil.findRangOfMusic(musics, 4.00);
        MediaUtil.findSingerOfMusic(musics,"RHCP");

        System.out.println("Find films of this genre " + FilmGenre.SCIENCE.getGenreName() + " is " + MediaUtil.findGenreOfFilms(films, Arrays.asList(FilmGenre.SCIENCE)) + "\n");
        System.out.println("Find books of this genre " + BookGenre.CHILDRENS.getGenreName() + " is " + MediaUtil.findGenreOfBooks(books, Arrays.asList(BookGenre.CHILDRENS)) + "\n");
        System.out.println("Find music of this genre " + MusicGenre.ELECTRO.getGenreName() + " is " + MediaUtil.findGenreOfMusic(musics, Arrays.asList(MusicGenre.ELECTRO)) + "\n");


        Client client1 = clients.get(0);
        client1.addMarkedFile(films.get(0));
        client1.addMarkedFile(films.get(0));
        client1.addLoadedFiles(books.get(1));
        client1.addLoadedFiles(films.get(1));
        client1.addActiveFiles(musics.get(0));

        System.out.println(client1.toString() + "\n");

        clients.get(1).addMarkedFile(books.get(0));
        clients.get(1).addMarkedFile(films.get(2));

        System.out.println(clients.get(1).toString() + "\n");


// sorting
        films = setDownYear(films);
        printFile(films);

        musics = setDownRang(musics);
        printFile(musics);

        books=setUpYear(books);
        printFile(books);

    }

    private static void printFile(List<File> files) {
        for (File file : files) {
            System.out.println("Year: " + file.getReleaseYear() + ", Name of sort1: " + file.getName() + ", Country: " + file.getCountry() + ", Rang:  " + file.getRang());

        }
    }

    // create
    public   static List createClients () {
        List<Client> clients = new ArrayList();
        Client roman = new Client("Petskoff","petskov23@gmail.com");
        Client oleksandr = new Client("Kitealex","alexandr.kravetc@gmail.com");
        clients.add(roman);
        clients.add(oleksandr);
        clients.add( new Client("Rosomaha","roso@i.ua"));

        return  clients;
    }

    public    static List createBooks (){
        Book book1 = new Book();
        book1.setId(444);
        book1.setName("Harry Potter");
        book1.setAuthor("Joahn Rowling");
        book1.setCountry("Britain");
        book1.setGenre(Arrays.asList(BookGenre.CHILDRENS, BookGenre.FANTASY));
        book1.setRang(4.68);
        book1.setReleaseYear(2001);
        book1.setPublishing("Piter");
        book1.setPages(890);

        Book book2 = new Book();
        book2.setId(445);
        book2.setName("Alice in Wonderland");
        book2.setAuthor("Lewis Karoll");
        book2.setCountry("Britain");
        book2.setGenre(Arrays.asList(BookGenre.FANTASY, BookGenre.CHILDRENS));
        book2.setRang(4.88);
        book2.setReleaseYear(1865);
        book2.setPublishing("PablikIzdat");
        book2.setPages(990);

        Book book3 = new Book();
        book3.setId(444);
        book3.setName("Thinking in Java, 4th edition ");
        book3.setAuthor("Bruce Eckel");
        book3.setCountry("USA");
        book3.setGenre(Arrays.asList(BookGenre.SCIENCE));
        book3.setRang(4.98);
        book3.setReleaseYear(2006);
        book3.setPublishing("Prentice Hall");
        book3.setPages(1079);

        return new ArrayList(Arrays.asList(
                book1, book2, book3));
    }

    public    static  List createFilms(){

            Film film1 = new Film();
            film1.setId(123);
            film1.setName("Mission imposible 5");
            film1.setAuthor("Dry Pirs");
            film1.setReleaseYear(2015);
            film1.setCountry("USA");
            film1.setRang(4.35);
            film1.setDyrectedBy("Kristopher McCuorry");
            film1.setQuality(5);
            film1.setMainActor("Tom Cruze");
            film1.setLength(131);
            film1.setGenre(Arrays.asList(FilmGenre.ACTION, FilmGenre.COMEDY));
            film1.setActors(Arrays.asList("Том Хэнкс","Дэвид Морс","Майкл Кларк Дункан","Бонни Хант","Джеймс Кромуэлл","Майкл Джитер","Грэм Грин"));

            Film film2 = new Film();
            film2.setId(135);
            film2.setName("Captain America: Civil War");
            film2.setAuthor("Kristopher Marcus");
            film2.setReleaseYear(2016);
            film2.setCountry("Usa");
            film2.setRang(4.78);
            film2.setDyrectedBy("Entony Russo");
            film2.setQuality(5);
            film2.setMainActor("Robert Dauny jr.");
            film2.setLength(147);
            film2.setGenre(Arrays.asList(FilmGenre.ACTION, FilmGenre.COMEDY, FilmGenre.FANTASY));
            film2.setActors(Arrays.asList("Тим Роббинс","Морган Фриман","Боб Гантон","Уильям Сэдлер","Клэнси Браун","Джил Беллоуз","Марк Ролстон"));


            Film film3 = new Film();
            film3.setId(142);
            film3.setName("Sherlock Holmes: A Game of Shadows");
            film3.setAuthor("Kiral Markuni");
            film3.setReleaseYear(2011);
            film3.setCountry("Britain");
            film3.setRang(4.99);
            film3.setDyrectedBy("Guy Richi");
            film3.setQuality(5);
            film3.setMainActor("Robert Dauny jr.");
            film3.setLength(128);
            film3.setGenre(Arrays.asList(FilmGenre.FICTION, FilmGenre.SCIENCE, FilmGenre.ACTION));
            film3.setActors(Arrays.asList("Эдвард Нортон","Брэд Питт","Хелена Бонем Картер","Мит Лоаф","Зэк Гренье","Холт МакКэллани"));

            return new ArrayList(Arrays.asList(
                    film1, film2, film3
            ));
        }

    public    static List createMusics(){
        Music music1 = new Music();
        music1.setId(255);
        music1.setName("Lost on You");
        music1.setAuthor("Laura Pergolizzi");
        music1.setReleaseYear(2016);
        music1.setGenre(Arrays.asList(MusicGenre.POP, MusicGenre.PHUNK));
        music1.setCountry("Britain");
        music1.setRang(4.99);
        music1.setSinger("LP");
        music1.setLength(4);

        Music music2 = new Music();
        music2.setId(257);
        music2.setName("Una Mattina");
        music2.setAuthor("Ludovico Einaudi");
        music2.setReleaseYear(2011);
        music2.setGenre(Arrays.asList(MusicGenre.CLASSIC, MusicGenre.BALLADA));
        music2.setCountry("France");
        music2.setRang(4.65);
        music2.setSinger("Ludovico Einaudi");
        music2.setLength(5);

        Music music3 = new Music();
        music3.setId(253);
        music3.setName("Snow");
        music3.setAuthor("Olivia Hill");
        music3.setReleaseYear(2006);
        music3.setGenre(Arrays.asList(MusicGenre.ELECTRO, MusicGenre.ROCK));
        music3.setCountry("USA");
        music3.setRang(3.95);
        music3.setSinger("RHCP");
        music3.setLength(5);

        return new ArrayList(Arrays.asList(
                music1, music2, music3
        ));
    }


}