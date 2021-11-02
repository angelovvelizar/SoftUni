package Lecture.HotelReservation;

public class PriceCalculator {
    private double pricePerDay;
    private int numberOfDays;
    private Season season;
    private Discount discount;


    public PriceCalculator(double pricePerDay, int numberOfDays, Season season, Discount discount) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
        this.discount = discount;
    }

    public double calculateTotalPrice(double pricePerDay, int numberOfDays, Season season, Discount discount) {
        double discountPrice = ((pricePerDay * numberOfDays) * season.getSeasonNumber()) * discount.getDiscount();
        return ((pricePerDay * numberOfDays) * season.getSeasonNumber()) - discountPrice;
    }
}
