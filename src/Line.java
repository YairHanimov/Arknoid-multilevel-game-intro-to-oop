import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The type Line.
 */
public class Line {
    /**
     * The Start.
     */
    private Point start;
    /**
     * The End.
     */
    private Point end;

    /**
     * Instantiates a new Line.
     *
     * @param start the start
     * @param end   the end
     */
// constructors
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;

    }

    /**
     * Instantiates a new Line.
     *
     * @param x1 the x 1
     * @param y1 the y 1
     * @param x2 the x 2
     * @param y2 the y 2
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * Length double.
     *
     * @return the double
     */
// Return the length of the line
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * Middle point.
     *
     * @return the point
     */
// Returns the middle point of the line
    public Point middle() {
        double middleX = ((this.start.getX() + this.end.getX()) / 2);
        double middleY = ((this.start.getY() + this.end.getY()) / 2);
        Point middle = new Point(middleX, middleY);
        return middle;
    }

    /**
     * Start point.
     *
     * @return the point
     */
// Returns the start point of the line
    public Point start() {
        return this.start;
    }

    /**
     * End point.
     *
     * @return the point
     */
// Returns the end point of the line
    public Point end() {
        return this.end;
    }

    /**
     * Is intersecting boolean.
     *
     * @param other the other
     * @return the boolean
     */
// Returns true if the lines intersect, false otherwise
    public boolean isIntersecting(Line other) {
        return (intersectionWith(other) != null);
    }


    /**
     * Intersection with point.
     *
     * @param other the other
     * @return the point
     */
// Returns the intersection point if the lines intersect,
    // and null otherwise.
    public Point intersectionWith(Line other) {
        double ax = this.start.getX();
        double ay = this.start.getY();
        double bx = other.start.getX();
        double by = other.start.getY();
        double ax2 = this.end.getX();
        double ay2 = this.end.getY();
        double bx2 = other.end.getX();
        double by2 = other.end.getY();
        double a1 = ay2 - ay;
        double b1 = ax - ax2;
        double c1 = a1 * (ax) + b1 * (ay);
        double a2 = by2 - by;
        double b2 = bx - bx2;
        double c2 = a2 * (bx) + b2 * (by);
        double determinant = a1 * b2 - a2 * b1;
        double intersectpiontx;
        double intersectpionty;

        if (determinant != 0) {
            intersectpiontx = Math.round(((b2 * c1 - b1 * c2) / determinant));
            intersectpionty = Math.round(((a1 * c2 - a2 * c1) / determinant));
            if ((((((intersectpiontx >= ax) && (intersectpiontx <= ax2))
                    || ((intersectpiontx <= ax) && (intersectpiontx >= ax2)))
                    && (((intersectpiontx >= bx) && (intersectpiontx <= bx2))
                    || ((intersectpiontx <= bx) && (intersectpiontx >= bx2))))
                    && (((((intersectpionty >= ay) && (intersectpionty <= ay2))
                    || ((intersectpionty <= ay) && (intersectpionty >= ay2))))
                    && (((intersectpionty >= by) && (intersectpionty <= by2))
                    || ((intersectpionty <= by) && (intersectpionty >= by2)))))) {
                Point interpoin = new Point(intersectpiontx, intersectpionty);
                return interpoin;

            } else if ((ax2 == bx) && (ay2 == by)) {
                Point interpoin2 = new Point(ax2, ay2);
                return interpoin2;
            } else if ((ax == bx2) && (ay == by2)) {
                Point interpoin3 = new Point(ax, ay);
                return interpoin3;
            } else {
                return null;
            }
        }

        if (determinant == 0) {

            if (ax2 == bx) {
                Point interpoin = new Point(ax2, ay2);
                return interpoin;
            }
            if (ax == bx2) {
                Point interpoin = new Point(ax, ay);
                return interpoin;

            }
        } else {
            return null;
        }
        return null;
    }

    /**
     * Equals boolean.
     *
     * @param other the other
     * @return the boolean
     */
// equals -- return true is the lines are equal, false otherwise
    public boolean equals(Line other) {
        if (intersectionWith(other) == null) {
            if (((this.start == other.start) || (this.start == other.end))
                    && ((this.end == other.end) || (this.end == other.start))) {
                boolean equals = true;
                return equals;
            }
            return false;

        }

        return false;
    }


    /**
     * Closest intersection to start of line point.
     *
     * @param rect the rect
     * @return the point
     */
// If this line does not intersect with the rectangle, return null.
    // Otherwise, return the closest intersection point to the
    // start of the line.
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        Line newline = new Line(this.start, this.end);
        if (rect.intersectionPoints(newline).size() == 0) {
            return null;
        } else {
            List<Double> mydistances = new ArrayList<Double>();
            List<Point> interpoints = rect.intersectionPoints(newline);
            for (int i = 0; i < rect.intersectionPoints(newline).size(); i++) {
                mydistances.add(newline.start.distance(rect.intersectionPoints(newline).get(i)));
            }

            Collections.sort(mydistances);
            for (int i = 0; i < interpoints.size(); i++) {
                if (newline.start.distance(rect.intersectionPoints(newline).get(i)) == mydistances.get(0)) {
                    return interpoints.get(i);
                }
            }
        }
        return null;
    }


}







