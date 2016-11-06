package Media;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static java.lang.String.valueOf;


public class FilmIOUtils {
    public static final String CSV_DELIMITER = ";";
    public static final String COMA_DELIMITER = ",";
    private static int yr = Calendar.getInstance().get(Calendar.YEAR);



    public static void writeFilmIntoFile(String fileName, List<File> films) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            writeFilms(writer, films);
        }
    }

    private static void writeFilms(PrintWriter writer, List<File> films) {

        for (File film : films) {
            Film f = (Film) film;
            writer.println(filmToOutputString(f));
        }
    }

    private static String filmToOutputString(Film film) {
        return film.getId() +
                "|" + film.getName() +
                "|" + film.getAuthor() +
                "|" + film.getReleaseYear() +
                "|" + film.getCountry() +
                "|" + film.getRang() +
                "|" + film.getDyrectedBy() +
                "|" + film.getQuality() +
                "|" + film.getMainActor() +
                "|" + film.getLength() +
                "|" + film.getGenre() +
                "|" + film.getActors();
    }


    public static List<File> readFilmFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(fileName))) {
            return readFilms(reader);
        }
    }


    public static List<File> readFilms(BufferedReader reader) throws IOException {
        List<File> res = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            Film file = parseFilm(line);
            if (file != null) {
                res.add(file);
            }
        }

        return res;
    }


    public static Film parseFilm(String line) {
        String[] tokens = line.split(CSV_DELIMITER);

            if (!isInt(tokens[3])) {
            return null;
        }

        int id = Integer.parseInt(tokens[0]);
        String name = tokens[1];
        String author = tokens[2];
        int releaseYear = Integer.parseInt(tokens[3]);
        if (!isReleaseYear(releaseYear)) {
            return null;
        }

        String country = tokens[4];
        Double rang = Double.parseDouble(tokens[5]);
        String directedBy = tokens[6];
        int quality = Integer.parseInt(tokens[7]);
        String mainActor = tokens[8];
        int length = Integer.parseInt(tokens[9]);


        List<FilmGenre> genres = parseGenre(tokens[10]);
        if (genres == null) {
            return null;
        }

        List<String> actors = parseActors(tokens[11]);
        if(actors==null){
            return null;
        }

        Film film = new Film();
        film.setId(id);
        film.setName(name);
        film.setAuthor(author);
        film.setReleaseYear(releaseYear);
        film.setCountry(country);
        film.setRang(rang);
        film.setDyrectedBy(directedBy);
        film.setQuality(quality);
        film.setMainActor(mainActor);
        film.setLength(length);
        film.setGenre(genres);
        film.setActors(actors);

        return film;
    }

    private static List<String> parseActors(String line) {
        String[] actorsTokens = line.split(COMA_DELIMITER);
        List<String> actors = new ArrayList<>();

        for (String actorToken : actorsTokens) {
            try{
                String actor = valueOf(actorToken.trim());
                actors.add(actor);
            }
            catch (IllegalArgumentException e){
                return null;
            }
        }
        return actors;
    }

    public static List<FilmGenre> parseGenre(String line) {
        String[] genreTokens = line.split(COMA_DELIMITER);
        List<FilmGenre> genres = new ArrayList<>();

        for (String genreToken : genreTokens) {
            try {
                FilmGenre genre = FilmGenre.valueOf(genreToken.trim());
                genres.add(genre);
            } catch (IllegalArgumentException e) {
                return null;
            }
        }
        return genres;
    }
    public static boolean isReleaseYear(int year) {
        return year >= 1000 && year <= yr;
    }


    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    
}



