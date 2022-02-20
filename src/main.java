import products.Appliance;
import products.Beverage;
import products.Cloth;
import products.Food;
import products.enums.ClothSize;

import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        Food apple = new Food("apples", "test", 1.50, LocalDate.of(2021, 6, 14));
        Beverage milk = new Beverage("milk", "BrandM", 0.99, LocalDate.of(2022, 2, 2));
        Cloth shirt = new Cloth("shirt", "HM", 15.99, "violet", ClothSize.M);
        Appliance laptop = new Appliance("laptop", "BrandL", 2345.01, "ModelL", LocalDate.of(2021, 3, 3), 1.125);

        Cashier cashier = new Cashier();
        cashier.addItem(apple);
        cashier.addItem(milk);
        cashier.addItem(milk);
        cashier.addItem(shirt);
        cashier.addItem(laptop);
        System.out.println(cashier.printReceipt());
    }
}
