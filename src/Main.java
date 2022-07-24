
import java.util.InputMismatchException;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the marketplace!");

        ArrayList<Product> productArr = new ArrayList<>();
        ArrayList<Purchase> purchaseArr = new ArrayList<>();
        ArrayList<User> userArr = new ArrayList<>();

//        ---------------------------------------------- Part of code to make 2 test products and 2 test users

//        productArr.add(new Product(0, "Apple", 300));
//        productArr.add(new Product(1, "Banana", 400));

//        userArr.add(new User(0, 1100, "Daniil", "Ivanov"));
//        userArr.add(new User(1, 1200, "Slavik", "Grechnev"));
//        ----------------------------------------------


        while (true) {
            //  Display starting menu
            System.out.println("""  
                    Choose an option:
                    1 - Display list of all users
                    2 - Display list of all products
                    3 - Create new Users
                    4 - Create new product
                    5 - Make a purchase
                    6 - Display list of user's purchases
                    7 - Display users who bought specific product
                    8 - Delete Product by id\s
                    9 - Delete user by id""");


            Scanner in = new Scanner(System.in); // Scanner object to get input data
            String menuDecision = in.nextLine();

            //  Getting the user's choose from menu and providing it
            switch (menuDecision) {
                case "1" -> {
                    System.out.println("List of users:");
                    System.out.println(userArr);
                }
                case "2" -> {
                    System.out.println("List of products:");
                    System.out.println(productArr);
                }
                case "3" -> {
                    int newUserMoney;
                    int newUsersAmount;
                    System.out.println("Creation of new user\n" +
                            "Enter the amount of new users:");
                    try {
                        newUsersAmount = in.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Wrong input");
                        continue;
                    }

                    for (int i = 0; i < newUsersAmount; i++) {

                        System.out.println("Enter user's name:");
                        String newUserFirstName = in.next();
                        if (newUserFirstName.matches("[0-9]+"))
                            continue;
                        System.out.println("Enter user's last name:");
                        String newUserSecondName = in.next();
                        System.out.println("Enter user's amount of money:");
                        try {
                            newUserMoney = in.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Wrong input");
                            continue;
                        }

                        User new_user = new User(i, newUserMoney, newUserFirstName, newUserSecondName);
                        userArr.add(new_user);
                    }
                }
                case "4" -> {
                    System.out.println("Creation of new product\n" +
                            "Enter the amount of new products:");
                    int newProductAmount = in.nextInt();
                    for (int i = 0; i < newProductAmount; i++) {
                        System.out.println("Enter product's name:");
                        String newProductName = in.next();
                        if (newProductName.matches("[0-9]+"))
                            continue;
                        System.out.println("Enter product's price:");
                        int newUserMoney = in.nextInt();
                        Product new_product = new Product(i, newProductName, newUserMoney);
                        productArr.add(new_product);
                    }
                }
                case "5" -> {
                    System.out.println("""
                            Making a purchase:
                            To make a purchase enter the command in this format:
                            {User's id}_{Product's id}
                            Example: 1_1""");
                    String input_data = in.next();

                    Purchase newPurchase = new Purchase();

                    String findIDUser = String.valueOf(input_data.split("_")[0]);
                    String findIDproduct = String.valueOf(input_data.split("_")[1]);

                    System.out.println(findIDUser);

                    int users_money;
                    float product_price = 0f;

                    for (Product a : productArr) { //Searching for exact object Product with correct id
                        if (a.getId() == Integer.parseInt(findIDproduct)) {
                            newPurchase.setProduct(a);
                            product_price = (a.getPrice());
                            break;
                        }

                    }
                    for (User a : userArr) { //Searching for exact object User with correct id
                        if (a.getId() == Integer.parseInt(findIDUser)) {
                            newPurchase.setUser_purchased(a);
                            users_money = (a.getAmountOfMoney());
                            try {
                                if (users_money < product_price) {
                                    throw new ArithmeticException("User don't have enough money");
                                }
                            } catch (ArithmeticException e) {
                                System.out.println(e.getMessage());
                            }
                            a.setAmountOfMoney((int) (users_money - product_price));
                        }
                    }
                    System.out.println("You have successfully bought " + newPurchase.getProduct().getName() + " " +
                            "for " + newPurchase.getProduct().getPrice() + "\n" +
                            "Balance: " + newPurchase.getUser_purchased().getAmountOfMoney());
                    purchaseArr.add(newPurchase);
                    // User 100$ - 3$ = 97$ productArr -> purchaseArr
                }
                case "6" -> {
                    System.out.println("Enter user's id:");
                    int usersId = in.nextInt();
                    for (var a : purchaseArr)
                        if (a.getUser_purchased().getId() == usersId)
                            System.out.println(a.getProduct());
                }
                case "7" -> {
                    System.out.println("Enter product id: ");
                    int product_id = in.nextInt();
                    for (var a : purchaseArr)
                        if (a.getProduct().getId() == product_id)
                            System.out.println(a.getUser_purchased().getFirstName() + a.getUser_purchased().getSecondName());
                }
                case "8" -> {
                    System.out.println("Enter product's id to delete it:");
                    int product_id;
                    try {
                        product_id = in.nextInt();
                    } catch (Exception e) {
                        continue;
                    }
                    productArr.removeIf(a -> a.getId() == product_id);
                    purchaseArr.removeIf(a -> a.getProduct().getId() == product_id);

                }
                case "9" -> {
                    System.out.println("Enter user's id to delete it:");
                    int user_id;
                    try {
                        user_id = in.nextInt();
                    } catch (Exception e) {
                        continue;
                    }
                    userArr.removeIf(a -> a.getId() == user_id);
                    purchaseArr.removeIf(a -> a.getUser_purchased().getId() == user_id);

                }
                case "exit" -> System.exit(69);
                default -> System.out.println("Please enter the number from menu list");
            }
        }
    }


}