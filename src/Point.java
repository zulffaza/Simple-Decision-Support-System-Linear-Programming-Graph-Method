/**
 * Merupakan model dari koordinat
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 20 Oktober 2017
 */
public class Point {

    private Double mX, mY;

    public Point() {

    }

    public Point(Double x, Double y) {
        mX = x;
        mY = y;
    }

    public Double getX() {
        return mX;
    }

    public void setX(Double x) {
        mX = x;
    }

    public Double getY() {
        return mY;
    }

    public void setY(Double y) {
        mY = y;
    }
}
