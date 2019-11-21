import biuoop.DrawSurface;


/**
 * The type Ball.
 */
public class Ball implements Sprite {
    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity v;
    private GameEnvironment colcol;
    private GameLevel game;


    /**
     * Instantiates a new Ball.
     *
     * @param x     the x
     * @param y     the y
     * @param size  the size
     * @param color the color
     */
// Constructor
    public Ball(int x, int y, int size, java.awt.Color color) {
        this.center = new Point(x, y);
        this.r = size;
        this.color = color;
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public double getX() {
        return center.getX();
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public double getY() {
        return center.getY();
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize() {
        return r;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * Sets velocity.
     *
     * @param n the n
     */
    public void setVelocity(Velocity n) {
        this.v = n;
    }

    /**
     * Sets velocity.
     *
     * @param dx the dx
     * @param dy the dy
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);

    }

    /**
     * Gets velocity.
     *
     * @return the velocity
     */
    public Velocity getVelocity() {
        return this.v;
    }

    /**
     * Move one step.
     */
    public void moveOneStep() {

        CollisionInfo collisionInfo = this.colcol.getClosestCollision(mylinevectorball());
        if (this.colcol.getClosestCollision(mylinevectorball()) != null) {
            this.setVelocity(collisionInfo.collisionObject().hit(this, collisionInfo.collisionPoint(), this.v));
        }


        this.center = this.getVelocity().applyToPoint(this.center);
    }

    /**
     * Mylinevectorball line.
     *
     * @return the line
     */
    public Line mylinevectorball() {
        double olddx;
        double olddy;
        double newdx;
        double newdy;
        olddx = this.center.getX();
        olddy = this.center.getY();
        newdx = this.getVelocity().applyToPoint(this.center).getX();
        newdy = this.getVelocity().applyToPoint(this.center).getY();
        Line vector = new Line(olddx, olddy, newdx, newdy);
        return vector;
    }

    /**
     * Draw on.
     *
     * @param surface the surface
     */
// draw the ball on the given DrawSurface

    /**
     * Draw on.
     *
     * @param surface the surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.getX(), (int) this.getY(), r);
    }

    @Override
    /**
     * Time passed.
     */
    public void timePassed() {
        moveOneStep();

    }

    /**
     * Sets env.
     *
     * @param e the e
     */
    public void setEnv(GameEnvironment e) {
        this.colcol = e;
    }

    /**
     * Add to game.
     *
     * @param g the g
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);

    }
}

