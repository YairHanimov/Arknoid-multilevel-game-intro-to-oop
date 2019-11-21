/**
 * The type Point.
 */
public class Point {
    // Fields
    private double x;
    private double y;

    /**
     * Instantiates a new Point.
     *
     * @param x the x
     * @param y the y
     */
// Constructor
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Instantiates a new Point.
     *
     * @param my the my
     */
    public Point(Point my) {
        this.x = my.x;
        this.y = my.y;
    }

    /**
     * Distance double.
     *
     * @param other the other
     * @return the double
     */
// distance -- return the distance of this point to the other point
    public double distance(Point other) {
        double distance;
        distance = Math.sqrt(((this.getX() - other.getX()) * (this.getX() - other.getX())
                + (this.getY() - other.getY()) * (this.getY() - other.getY())));
        return distance;
    }

    /**
     * Equals boolean.
     *
     * @param other the other
     * @return the boolean
     */
// equals -- return true is the points are equal, false otherwise
    public boolean equals(Point other) {
        return ((this.x == other.getX()) && (this.y == other.getY()));

    }

    /**
     * Gets x.
     *
     * @return the x
     */
// Return the x and y values of this point
    public double getX() {
        return this.x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public double getY() {
        return this.y;
    }

}
