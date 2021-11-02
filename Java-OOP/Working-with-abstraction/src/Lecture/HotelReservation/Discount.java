package Lecture.HotelReservation;

public enum Discount {
    VIP(0.2),
    SECOND_VISIT(0.1),
    NONE(0.0);

    private double discount;

    Discount(double discount){
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public static Discount parseDiscount(String discountType){
        switch (discountType){
            case "VIP":
                return VIP;
            case "SecondVisit":
                return SECOND_VISIT;
            case "None":
                return NONE;
            default:
                throw new IllegalArgumentException("No such discount!");
        }
    }
}
