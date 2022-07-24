public class User {
    private int id;
    private int amountOfMoney;
    private String firstName;
    private String secondName;

    public User(int id, int amountOfMoney, String firstName, String secondName) { //Constructor
        this.id = id;
        this.amountOfMoney = amountOfMoney;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(int amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String toString()  { //method for correct displays user's data

        return "\nID: " + this.id +";"+
        " First name: "+ this.firstName + ";"+
        " Second name: "+ this.secondName +";"+
        " Amount of money: " + this.amountOfMoney;
    }


}
