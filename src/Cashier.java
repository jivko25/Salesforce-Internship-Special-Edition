import products.Product;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cashier {
    private ArrayList<Product> cart;
    private double sum;
    private double discount;

    public Cashier(){
        this.cart = new ArrayList<>();
        this.sum = 0;
        this.discount = 0;
    }

    public ArrayList<Product> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Product> cart) {
        this.cart = cart;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
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
        return this.cart.stream().filter(item -> item == product).count();
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public StringBuilder printReceipt(){
        StringBuilder sb = new StringBuilder();
        sb.append("Date: " + LocalDate.now() + "\n---Products---\n\n\n");
        this.cart.stream().forEach(product -> {
            sb.append("\n\n" + product.getName() + " " + product.getBrand() + "\n");
            sb.append(getRepeatsOfProduct(product) + " x $" + String.format("%.2f", product.getPrice() + product.getDiscount()) + " = " + String.format("%.2f", product.getPrice() + product.getDiscount()) + "\n");
            if(product.getDiscount() > 0){
                sb.append("#discount " + product.getPercentageDiscount() + "% - " + String.format("%.2f", getRepeatsOfProduct(product) + product.getDiscount()));
            }
            setSum(this.sum + product.getPrice());
            setDiscount(this.discount + getRepeatsOfProduct(product) + product.getDiscount());
//            for(int i = 0; i < getRepeatsOfProduct(product); i++){
//                removeItem(product);
//            }
        });
        sb.append("-----------------------------------------------------------------------------------\n");
        sb.append("SUBTOTAL: $" + String.format("%.2f", sum) + "\n");
        sb.append("DISCOUNT: -$" + String.format("%.2f", discount) + "\n\n");
        sb.append("TOTAL: $" + String.format("%.2f", sum - discount));

        return sb;
    }
}
