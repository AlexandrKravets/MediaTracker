package Media;

import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import static java.lang.String.valueOf;


public class MusicIOUtils {
    public static final String CSV_DELIMITER = ";";
    public static final String COMA_DELIMITER = ",";
    private static int yr = Calendar.getInstance().get(Calendar.YEAR);


    public static void writeMusicIntoFile(String fileName, List<File> music) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            writeMusic(writer, music);
        }
    }

    private static void writeMusic(PrintWriter writer, List<File> musics) {

        for (File music : musics) {
            Music m = (Music) music;
            writer.println(musicToOutputString(m));
        }
    }


    private static String musicToOutputString(Music music) {
        return music.getId() +
                "|" + music.getName() +
                "|" + music.getAuthor() +
                "|" + music.getReleaseYear() +
                "|" + music.getGenre() +
                "|" + music.getCountry() +
                "|" + music.getRang() +
                "|" + music.getSinger() +
                "|" + music.getLength();
    }



    public static List<File> readMusicFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(fileName))) {
            return readMusic(reader);
        }
    }


    public static List<File> readMusic(BufferedReader reader) throws IOException {
        List<File> res = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            Music file = parseMusic(line);
            if (file != null) {
                res.add(file);
            }
        }

        return res;
    }



    public static Music parseMusic(String line) {
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

        String country = tokens[5];
        Double rang = Double.parseDouble(tokens[6]);

        int lenght = Integer.parseInt(tokens[8]);
        String singer = tokens[7];


        List<MusicGenre> genres = parseGenre(tokens[4]);
        if (genres == null) {
            return null;
        }

        Music music = new Music();
        music.setId(id);
        music.setName(name);
        music.setAuthor(author);
        music.setReleaseYear(releaseYear);
        music.setRang(rang);
        music.setGenre(genres);
        music.setCountry(country);
        music.setSinger(singer);
        music.setLength(lenght);


        return music;
    }


    public static List<MusicGenre> parseGenre(String line) {
        String[] genreTokens = line.split(COMA_DELIMITER);
        List<MusicGenre> genres = new ArrayList<>();

        for (String genreToken : genreTokens) {
            try {
                MusicGenre genre = MusicGenre.valueOf(genreToken.trim());
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



