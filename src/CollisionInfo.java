/**
 * The type Collision info.
 */
public class CollisionInfo {
    private Point p;
    private Collidable col;

    /**
     * Instantiates a new Collision info.
     *
     * @param po    the po
     * @param colli the colli
     */
    public CollisionInfo(Point po, Collidable colli) {
        this.p = po;
        this.col = colli;

    }

    /**
     * Collision point point.
     *
     * @return the point
     */
// the point at which the collision occurs.
    public Point collisionPoint() {
        return this.p;
    }

    /**
     * Collision object collidable.
     *
     * @return the collidable
     */
// the collidable object involved in the collision.
    public Collidable collisionObject() {
        return this.col;
    }
}
