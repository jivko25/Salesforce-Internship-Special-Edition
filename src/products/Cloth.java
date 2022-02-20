package products;

import products.enums.ClothSize;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Cloth extends Product{
    private String color;
    private ClothSize size;
    public Cloth(String name, String brand, Double price, String color, ClothSize size) {
        super(name, brand, price);
        this.color = color;
        this.size = size;
        discount();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ClothSize getSize() {
        return size;
    }

    public void setSize(ClothSize size) {
        this.size = size;
    }

    @Override
    public void discount() {
        DayOfWeek day = LocalDate.now().getDayOfWeek();
        if(day != DayOfWeek.MONDAY && day != DayOfWeek.SUNDAY){
            setPrice(this.price * 0.9);
            setPercentageDiscount(10);
        }
    }

    @Override
    public double getDiscount() {
        DayOfWeek day = LocalDate.now().getDayOfWeek();
        if(day != DayOfWeek.MONDAY && day != DayOfWeek.SUNDAY){
            return this.price / 0.9 - this.price;
        }
        return 0;
    }
}
