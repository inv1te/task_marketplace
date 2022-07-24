public class Product {
    private String name;
    private float price;
    private int id;

    public Product(int id, String name, float price) { //Constructor
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public String toString()  { //method for correct displays product's data
        return "\nID: " + this.id +";"+
                " Name: " + name + ";"+
                " Price: "+ this.price + ";";
    }

}
