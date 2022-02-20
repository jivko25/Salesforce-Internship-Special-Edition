package products;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Beverage extends Product{
    private LocalDate expirationDate;
    public Beverage(String name, String brand, Double price, LocalDate expirationDate) {
        super(name, brand, price);
        this.expirationDate = expirationDate;

        discount();
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public void discount() {
        long daysToExpire = DAYS.between(LocalDate.now(), this.expirationDate);
        if(daysToExpire == 0){
            this.setPrice(this.price * 0.3);
            setPercentageDiscount(70);
        }
        else if (daysToExpire <= 5) {
            this.setPrice(this.price * 0.7);
            setPercentageDiscount(30);
        }
    }

    @Override
    public double getDiscount() {
        long daysToExpire = DAYS.between(LocalDate.now(), this.expirationDate);
        if(daysToExpire == 0){
            return this.price / 0.3 - this.price;
        }
        else if (daysToExpire <= 5) {
            return this.price / 0.7 - this.price;
        }
        return 0;
    }
}
