import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Levelone.
 */
public class Levelone implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> ballsVelocity = new ArrayList<Velocity>();
        ballsVelocity.add(new Velocity(0, -5));
        return ballsVelocity;
    }

    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 70;
    }

    @Override
    public String levelName() {
        return "one target";
    }

    @Override
    public Sprite getBackground() {
        Blackbackground b = new Blackbackground();
        return b;
    }

    @Override
    public List<Block> blocks() {
        List<Block> myblock = new ArrayList<>();
        Block newoneb = new Block(350, 160, 45, 30, Color.gray, "1");
        myblock.add(newoneb);
        return myblock;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }

}
