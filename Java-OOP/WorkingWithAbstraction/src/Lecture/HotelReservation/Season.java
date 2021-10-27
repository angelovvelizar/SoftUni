package Lecture.HotelReservation;

public enum Season {
    AUTUMN(1),
    SPRING(2),
    WINTER(3),
    SUMMER(4);

    private int seasonNumber;

    Season(int seasonNUmber){
        this.seasonNumber = seasonNUmber;
    }
    public int getSeasonNumber(){
        return  seasonNumber;
    }
}
