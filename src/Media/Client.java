package Media;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private static int nextId = 0;

    private final int id = nextId++;
    private String nickName;
    private String mail;


    protected List<File> markedFiles = new ArrayList<>();
    protected List<File> activeFiles = new ArrayList<>();
    protected List<File> loadedFiles = new ArrayList<>();
    protected List<File> reviewedFiles = new ArrayList<>();



    public Client(String nickName, String mail) {
        this.nickName = nickName;
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public String getNickName() {
        return nickName;
    }

    public Client setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public String getMail() {
        return mail;
    }

    public Client setMail(String mail) {
        this.mail = mail;
        return this;
    }

    public List<File> getMarkedFiles() {
        return markedFiles;
    }

    public boolean addMarkedFile(File markedFile) {
        if (!markedFiles.contains(markedFile)) {
            markedFiles.add(markedFile);
            return true;
        }
        return false;
    }
    public List<File> getActiveFiles() {
        return activeFiles;
    }

    public boolean addActiveFiles(File activeFile) {
        if(!activeFiles.contains(activeFile)){
            activeFiles.add(activeFile);
            return true;
        }
        return false;
    }


    public List<File> getLoadedFiles() {
        return loadedFiles;
    }

    public boolean addLoadedFiles(File loadedFile) {
        if(!loadedFiles.contains(loadedFile)){
            this.loadedFiles.add(loadedFile);
            return true;
        }
        return false;
    }

    public List<File> getReviewedFiles() {
        return reviewedFiles;
    }

    public boolean addReviewedFiles(File reviewedFile) {
        if(!reviewedFiles.contains(reviewedFile)) {
            this.reviewedFiles.add(reviewedFile);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", mail='" + mail + '\'' +
                ", markedFiles=" + markedFiles +
                ", activeFiles=" + activeFiles +
                ", loadedFiles=" + loadedFiles +
                ", reviewedFiles=" + reviewedFiles +
                '}';
    }


}
