import java.util.ArrayList;
import java.util.List;

/**
 * The type Rectangle.
 */
public class Rectangle {
    private Point p;
    private double width;
    private double height;
    private Line up;
    private Line down;
    private Line left;
    private Line right;

    /**
     * Instantiates a new Rectangle.
     *
     * @param upperLeft the upper left
     * @param width     the width
     * @param height    the height
     */
// Create a new rectangle with location and width/height.
    public Rectangle(Point upperLeft, double width, double height) {
        this.p = upperLeft;
        this.width = width;
        this.height = height;
        this.up = new Line(upperLeft.getX(), upperLeft.getY(), upperLeft.getX() + width, upperLeft.getY());
        this.down = new Line(upperLeft.getX(),
                upperLeft.getY() + height, upperLeft.getX() + width, upperLeft.getY() + height);
        this.left = new Line(upperLeft.getX(), upperLeft.getY(), upperLeft.getX(), upperLeft.getY() + height);
        this.right = new Line(upperLeft.getX() + width, upperLeft.getY(),
                upperLeft.getX() + width, upperLeft.getY() + height);
    }

    /**
     * Intersection points java . util . list.
     *
     * @param line the line
     * @return the java . util . list
     */
// Return a (possibly empty) List of intersection points
    // with the specified line.
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> inter = new ArrayList<>();
        if (this.up.isIntersecting(line)) {
            inter.add(this.up.intersectionWith(line));
        }
        if (this.down.isIntersecting(line)) {
            inter.add(this.down.intersectionWith(line));
        }
        if (this.left.isIntersecting(line)) {
            inter.add(this.left.intersectionWith(line));
        }
        if (this.right.isIntersecting(line)) {
            inter.add(this.right.intersectionWith(line));
        }
        return inter;

    }

    /**
     * Gets width.
     *
     * @return the width
     */
// Return the width and height of the rectangle
    public double getWidth() {
        return this.width;
    }

    /**
     * Gets height.
     *
     * @return the height
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Gets upper left.
     *
     * @return the upper left
     */
// Returns the upper-left point of the rectangle.
    public Point getUpperLeft() {
        return this.p;
    }

    /**
     * Gets up.
     *
     * @return the up
     */
    public Line getUp() {
        return this.up;
    }

    /**
     * Gets down.
     *
     * @return the down
     */
    public Line getDown() {
        return this.down;
    }

    /**
     * Gets left.
     *
     * @return the left
     */
    public Line getLeft() {
        return this.left;
    }

    /**
     * Gets .
     *
     * @return the
     */
    public Line getright() {
        return this.right;
    }
}
