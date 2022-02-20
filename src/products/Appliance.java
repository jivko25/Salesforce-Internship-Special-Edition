package products;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Appliance extends Product{
    private String model;
    private LocalDate productionDate;
    private double weight;
    public Appliance(String name, String brand, Double price, String model, LocalDate productionDate, double weight) {
        super(name, brand, price);
        this.model = model;
        this.productionDate = productionDate;
        this.weight = weight;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public void discount() {
        DayOfWeek day = LocalDate.now().getDayOfWeek();
        if((day == DayOfWeek.SATURDAY || day != DayOfWeek.SUNDAY) && this.price > 999){
            setPrice(this.price * 0.93);
            setPercentageDiscount(7);
        }
    }

    @Override
    public double getDiscount() {
        DayOfWeek day = LocalDate.now().getDayOfWeek();
        if((day == DayOfWeek.SATURDAY || day != DayOfWeek.SUNDAY) && this.price > 999){
            return this.price / 0.93 - this.price;
        }
        return 0;
    }
}
