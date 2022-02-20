package products;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> cart;

    public Cart(ArrayList<Product> cart) {
        this.cart = new ArrayList<>();
    }

    public ArrayList<Product> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Product> cart) {
        this.cart = cart;
    }

    public int getSize(){
        return this.cart.size();
    }

    public void addItem(Product product){
        this.cart.add(product);
    }

    public void removeItem(Product product){
        this.cart.remove(product);
    }

    public void getProductByIndex(int index){
        this.cart.get(index);
    }

    public long getRepeatsOfProduct(Product product){
        return this.cart.stream().filter(item -> item != product).count();
    }
}
