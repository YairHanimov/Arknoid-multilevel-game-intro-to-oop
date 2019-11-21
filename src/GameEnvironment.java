import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The type game environment.
 */
public class GameEnvironment {

    private List<Collidable> collidables;

    /**
     * Instantiates a new game environment.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<>();
    }

    /**
     * Add collidable.
     *
     * @param c the c
     */
    public void addCollidable(Collidable c) {

        collidables.add(c);
    }

    /**
     * Remove collidable.
     *
     * @param c the c
     */
    public void removeCollidable(Collidable c) {
        collidables.remove(c);
    }

    /**
     * Gets closest collision.
     *
     * @param trajectory the trajectory
     * @return the closest collision
     */
// Assume an object moving from line.start() to line.end().
    // If this object will not collide with any of the collidables
    // in this collection, return null. Else, return the information
    // about the closest collision that is going to occur.
    public CollisionInfo getClosestCollision(Line trajectory) {
        List<Point> listpoints = new ArrayList<Point>();
        List<Double> mydistances = new ArrayList<Double>();
        int j = 0;
        for (int i = 0; i < collidables.size(); i++) {
            if (trajectory.closestIntersectionToStartOfLine(this.collidables.get(i).getCollisionRectangle()) != null) {
                listpoints.add(trajectory.closestIntersectionToStartOfLine(this.
                        collidables.get(i).getCollisionRectangle()));
                j = i;
            }
        }
        for (int i = 0; i < listpoints.size(); i++) {
            mydistances.add(listpoints.get(i).distance(trajectory.start()));
        }
        Collections.sort(mydistances);

        for (int i = 0; i < listpoints.size(); i++) {
            if (listpoints.get(i).distance(trajectory.start()) == mydistances.get(0)) {
                return new CollisionInfo(listpoints.get(i), this.collidables.get(j));
            }
        }
        return null;
    }

    /**
     * Cheakifinto boolean.
     *
     * @param trajectory the trajectory
     * @return the boolean
     */
    public boolean cheakifinto(Line trajectory) {
        for (int i = 0; i < collidables.size(); i++) {
            if ((((((trajectory.start().getX() > this.collidables.get(i).
                    getCollisionRectangle().getDown().start().getX()))
                    && ((trajectory.start().getX() < this.collidables.get(i).getCollisionRectangle()
                    .getDown().end().getX())))) && ((
                    ((trajectory.start().getY() > this.collidables.get(i).getCollisionRectangle()
                            .getLeft().start().getY()))))) && ((
                    trajectory.start().getY() < this.collidables.get(i).
                            getCollisionRectangle().getLeft().end().getY()))) {

                return true;
            }
        }
        return false;
    }
}