/**
 * The type Velocity.
 */
// Velocity specifies the change in position on the `x` and the `y` axes.
public class Velocity {
    /**
     * The Dx.
     */
// constructor
    private double dx;
    /**
     * The Dy.
     */
    private double dy;

    /**
     * Instantiates a new Velocity.
     *
     * @param dx the dx
     * @param dy the dy
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Gets dx.
     *
     * @return the dx
     */
    public double getDx() {
        return dx;
    }

    /**
     * Gets dy.
     *
     * @return the dy
     */
    public double getDy() {
        return dy;
    }

    /**
     * From angle and speed velocity.
     *
     * @param angle the angle
     * @param speed the speed
     * @return the velocity
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = Math.round((speed * (Math.cos((Math.toRadians(angle - 90.0))))));
        double dy = Math.round((speed * (Math.sin((Math.toRadians(angle - 90.0))))));
        return new Velocity(dx, dy);
    }

    /**
     * Tospeed double.
     *
     * @param dx the dx
     * @param dy the dy
     * @return the double
     */
    public static double tospeed(double dx, double dy) {
        double speed = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        return speed;

    }

    /**
     * Apply to point point.
     *
     * @param p the p
     * @return the point
     */
// Take a point with position (x,y) and return a new point
    // with position (x+dx, y+dy)
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);

    }
}
