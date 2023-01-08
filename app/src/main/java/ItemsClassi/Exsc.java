package ItemsClassi;

public class Exsc {
    String title;
    String testo;
    int image;
    String video;

    public Exsc(String title, String testo, int image,String video) {
        this.title = title;
        this.testo = testo;
        this.image = image;
        this.video=video;
    }

    public Exsc() {
    }

    public String getTitle() {
        return title;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
