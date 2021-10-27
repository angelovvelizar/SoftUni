package Lecture.PoinInRectangle;

public class Rectangle {
    private final Point bottomLeft;
    private final Point topRight;


    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point point){
        return isInHorizontal(point) &&
                isInVertical(point);
    }

    private boolean isInVertical(Point point) {
        return point.getY() <= topRight.getY() && point.getY() >= bottomLeft.getY();
    }

    private boolean isInHorizontal(Point point) {
        return point.getX() <= topRight.getX() && point.getX() >= bottomLeft.getX();
    }

}
