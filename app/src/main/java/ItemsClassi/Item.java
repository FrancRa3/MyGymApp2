package ItemsClassi;

public class Item {


    public Item(int id, String itemName, String itemRep, String itemPeso, String data, String itemRest) {
        this.id = id;
        this.itemName = itemName;
        this.itemRep = itemRep;
        this.itemPeso = itemPeso;
        this.data = data;
        this.itemRest = itemRest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemRep() {
        return itemRep;
    }

    public void setItemRep(String itemRep) {
        this.itemRep = itemRep;
    }

    public String getItemPeso() {
        return itemPeso;
    }

    public void setItemPeso(String itemPeso) {
        this.itemPeso = itemPeso;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getItemRest() {
        return itemRest;
    }

    public void setItemRest(String itemRest) {
        this.itemRest = itemRest;
    }

    private int id;
    private String itemName;
    private String itemRep;
    private String itemPeso;
    private String data;
    private String itemRest;



    public Item() {
    }
}
