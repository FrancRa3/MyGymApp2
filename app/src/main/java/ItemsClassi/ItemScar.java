package ItemsClassi;

public class ItemScar {
    public ItemScar(String data) {
        Data = data;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    private String Data;
    private String battito;
    private String sonno;
    private String intensita;
    private int id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public ItemScar(int id) {
        this.id = id;
    }



    public ItemScar(String battito, String sonno, String intensita) {
        this.battito = battito;
        this.sonno = sonno;
        this.intensita = intensita;
    }

    public ItemScar() {
    }

    public String getBattito() {
        return battito;
    }

    public void setBattito(String battito) {
        this.battito = battito;
    }

    public String getSonno() {
        return sonno;
    }

    public void setSonno(String sonno) {
        this.sonno = sonno;
    }

    public String getIntensita() {
        return intensita;
    }

    public void setIntensita(String intensita) {
        this.intensita = intensita;
    }
}
