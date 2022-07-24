public class Purchase {
    /*
    *   This class is created for the following reason's:
    *   When user buying any product, program create object "Purchase"
    *  which contain two fields: User who bought and product which bought.
    *   It seems to me as a good way to realize the process of purchasing
    */
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    private Product product;

    public User getUser_purchased() {
        return user_purchased;
    }

    public void setUser_purchased(User user_purchased) {
        this.user_purchased = user_purchased;
    }

    private User user_purchased;
    public Purchase() {

    }

    public Purchase(Product product, User user_purchased) {
        this.product = product;
        this.user_purchased = user_purchased;
    }
}
