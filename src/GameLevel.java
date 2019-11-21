import biuoop.DrawSurface;
import biuoop.Sleeper;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type game.
 */
public class GameLevel implements Animation {
    private biuoop.KeyboardSensor keyboard;
    // private GUI gui = new GUI("title", 800, 600);
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Sleeper sleeper = new Sleeper();
    private BlockRemover blockRemover;
    private BallRemover ballRemover;
    private ScoreTrackingListener scoreTrackingListener;
    private Counter mycounter;
    private Counter ballcounter;
    private Counter scorecouner;
    private Counter livecounter;
    private LivesIndicator livesIndicator;
    private Killerblock killerblock;
    private Counter kills = new Counter(0);
    private AnimationRunner runner;
    private boolean running;
    private Paddle pad;
    private Blackbackground blakground;
    private LevelInformation level;

    /**
     * Instantiates a new Game level.
     *
     * @param info        the info
     * @param ballcounter the ballcounter
     * @param scorecouner the scorecouner
     * @param livecounter the livecounter
     * @param mycounter   the mycounter
     * @param keyboard    the keyboard
     * @param aaar        the ar
     */
    public GameLevel(LevelInformation info, int ballcounter, int scorecouner, int livecounter, int mycounter,
                     biuoop.KeyboardSensor keyboard, AnimationRunner aaar) {
        level = info;
        this.ballcounter = new Counter(ballcounter);
        this.livecounter = new Counter(livecounter);
        this.scorecouner = new Counter(scorecouner);
        this.mycounter = new Counter(mycounter);
        this.keyboard = keyboard;
        this.runner = aaar;
    }
    /**
     * Add collidable.
     *
     * @param c the c
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * Remove collidable.
     *
     * @param c the c
     */
    public void removeCollidable(Collidable c) {
        environment.removeCollidable(c);
    }

    /**
     * Add sprite.
     *
     * @param s the s
     */
    public void addSprite(Sprite s) {

        sprites.addSprite(s);
    }

    /**
     * Remove sprite.
     *
     * @param s the s
     */
    public void removeSprite(Sprite s) {
        sprites.removeSprite(s);

    }

    /**
     * Initialize.
     */
// Initialize a new game: create the Blocks and Ball (and Paddle)
    // and add them to the game.
    public void initialize() {
        killerblock = new Killerblock(this, kills);
        blockRemover = new BlockRemover(this, mycounter);
        ballRemover = new BallRemover(this, ballcounter);
        scoreTrackingListener = new ScoreTrackingListener(this, scorecouner);
        sprites = new SpriteCollection();
        environment = new GameEnvironment();
        //keyboard = gui.getKeyboardSensor();

/*
       // int bloksizes = 45;
        //  Paddle pad = new Paddle(650, 860, 200, 30, Color.yellow, gui, keyboard);
        //pad.addToGame(this);
        Block block2 = new Block(-100, -100, 110, 1500, Color.gray, "X");
        //   block2.addHitListener(printingHitListener);
        block2.addToGame(this);
        Block block3 = new Block(790, -100, 50, 1490, Color.gray, "x");
        block3.addToGame(this);
        Block block4 = new Block(0, 590, 1500, 100, Color.blue, "1");
        block4.addHitListener(ballRemover);
        block4.addToGame(this);
        Block block = new Block(-100, -100, 1610, 130, Color.orange, "x");
        //    block.addHitListener(printingHitListener);
        block.addToGame(this);
        ScoreIndicator scoreIndicator = new ScoreIndicator(0, 0, 4000, 30, Color.orange, scorecouner);
        scoreIndicator.addToGame(this);
        Liveindicate liveindicate = new Liveindicate(0, 0, 200, 25, Color.BLACK, livecounter);
        liveindicate.addToGame(this);
*/

     /*
        Block killer = new Block(30, 40, 120, 50, Color.BLACK, "kill");
        killer.addHitListener(killerblock);
        killer.addHitListener(ballRemover);
        killer.addToGame(this);
        Block killer2 = new Block(400, 40, 120, 50, Color.BLACK, "kill");
        killer2.addHitListener(killerblock);
        killer2.addHitListener(ballRemover);
        killer2.addToGame(this);
        */

        level.getBackground().addToGame(this);
        java.util.List<Block> blocklists = new ArrayList<Block>();
        for (int k = 0; k < level.numberOfBlocksToRemove(); k++) {
            // Block newoneb = new Block(790 - bloksizes, 200, 45, 30, Color.gray, "2");
            Block newoneb = level.blocks().get(k);
            newoneb.addHitListener(blockRemover);
            newoneb.addHitListener(scoreTrackingListener);
            blocklists.add(newoneb);

            //  bloksizes = bloksizes + 45;

        }

        /*
        bloksizes = 45;
        for (int k = 0; k < 11; k++) {
            Block newoneb = new Block(790 - bloksizes, 230, 45, 30, Color.red, "1");
            newoneb.addHitListener(blockRemover);
            newoneb.addHitListener(scoreTrackingListener);
            blocklists.add(newoneb);
            bloksizes = bloksizes + 45;

        }
        bloksizes = 45;
        for (int k = 0; k < 10; k++) {
            Block newoneb = new Block(790 - bloksizes, 260, 45, 30, Color.yellow, "1");
            newoneb.addHitListener(blockRemover);
            newoneb.addHitListener(scoreTrackingListener);
            blocklists.add(newoneb);
            bloksizes = bloksizes + 45;
        }
        bloksizes = 45;
        for (int k = 0; k < 9; k++) {
            Block newoneb = new Block(790 - bloksizes, 290, 45, 30, Color.blue, "1");
            newoneb.addHitListener(blockRemover);
            newoneb.addHitListener(scoreTrackingListener);
            blocklists.add(newoneb);
            bloksizes = bloksizes + 45;

        }
        bloksizes = 45;
        for (int k = 0; k < 8; k++) {
            Block newoneb = new Block(790 - bloksizes, 320, 45, 30, Color.pink, "1");
            newoneb.addHitListener(blockRemover);
            newoneb.addHitListener(scoreTrackingListener);
            blocklists.add(newoneb);
            bloksizes = bloksizes + 45;
        }
        bloksizes = 45;
        for (int k = 0; k < 7; k++) {
            Block newoneb = new Block(790 - bloksizes, 350, 45, 30, Color.green, "2");
            newoneb.addHitListener(blockRemover);
            newoneb.addHitListener(scoreTrackingListener);
            blocklists.add(newoneb);
            bloksizes = bloksizes + 45;

        }
         */
        Block block2 = new Block(-100, -100, 110, 1500, Color.gray, "X");
        //   block2.addHitListener(printingHitListener);
        block2.addToGame(this);
        Block block3 = new Block(790, -100, 50, 1490, Color.gray, "x");
        block3.addToGame(this);
        Block block4 = new Block(0, 590, 1500, 100, Color.blue, "1");
        block4.addHitListener(ballRemover);
        block4.addToGame(this);
        Block block = new Block(-100, -100, 1610, 130, Color.orange, "x");
        //    block.addHitListener(printingHitListener);
        block.addToGame(this);
        ScoreIndicator scoreIndicator = new ScoreIndicator(0, 0, 4000, 30, Color.orange, scorecouner);
        scoreIndicator.addToGame(this);
        Liveindicate liveindicate = new Liveindicate(0, 0, 200, 25, Color.BLACK, livecounter);
        liveindicate.addToGame(this);
        List<Collidable> list = new ArrayList<Collidable>();
//        GameEnvironment env = new GameEnvironment();
        environment.addCollidable(block);
        environment.addCollidable(block2);
        environment.addCollidable(block3);
        environment.addCollidable(block4);
        // environment.addCollidable(killer);
        //  environment.addCollidable(killer2);
        // environment.addCollidable(pad);
        for (int k = 0; k < level.numberOfBlocksToRemove(); k++) {
            Block myblocl = blocklists.get(k);

            environment.addCollidable(myblocl);

            myblocl.addToGame(this);
        }


    }

    /**
     * Run.
     */
// Run the game -- start the animation loop.
    public void playOneTurn() {
        this.createBallsOnTopOfPaddle();
        this.runner.run(new CountdownAnimation(3, 3, sprites));
        this.running = true;
        this.runner.run(this);
    }
  /*
    public void playOneTurn() {

        Paddle pad = new Paddle(380, 585, 200, 30, Color.yellow, gui, keyboard);
        pad.addToGame(this);
        environment.addCollidable(pad);
        Ball ball = new Ball(400, 500, 5, java.awt.Color.BLACK);
        Ball ball2 = new Ball(390, 450, 5, java.awt.Color.BLACK);
        //Ball ball3 = new Ball(670, 700, 7, java.awt.Color.BLACK);


        ball.addToGame(this);
        ball2.addToGame(this);
        //  ball3.addToGame(this);

        Velocity v = Velocity.fromAngleAndSpeed(90, 10);
        ball.setVelocity(1, 3);
        ball2.setVelocity(1, 3);
        //    ball3.setVelocity(1,3);
        ball.setEnv(environment);
        ball2.setEnv(environment);
        //    ball3.setEnv(environment);
        this.sleeper = new Sleeper();
        int framesPerSecond = 130;
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (true) {
            int i = 3;

            if (this.mycounter.getValue() == 57) {
                scorecouner.increase(100);
                gui.close();
            }
          /* if (kills.getValue() == 2) {
                livecounter.decrease(1);
                kills.decrease(2);
            }*/


    /**
     * Run.
     */
/*         if (this.ballcounter.getValue() == 0) {
                 this.livecounter.decrease(1);
                 if (this.livecounter.getValue() == 0) {
                     gui.close();
                 } else {
                     pad.extramemove();
                     ballcounter.increase(2);

                     playOneTurn();
                 }
             }

             long startTime = System.currentTimeMillis(); // timing
             DrawSurface d = gui.getDrawSurface();
             this.sprites.drawAllOn(d);
             // gui.show(d);
             this.sprites.notifyAllTimePassed();
             d.setColor(Color.black);
             d.setColor(Color.black);
             // ScoreIndicator.removeFromGame(this);
             //  d.drawText(500, 25, "score:" + scorecouner.getValue(), 30);
             //   d.drawText(200, 25, "live :" + livecounter.getValue(), 30);

             gui.show(d);

             // timing
             long usedTime = System.currentTimeMillis() - startTime;
             long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
             if (milliSecondLeftToSleep > 0) {
                 sleeper.sleepFor(milliSecondLeftToSleep);
             }
         }
     }






    /**
     * Create balls on top of paddle.
     */
    /**
     * Create balls on top of paddle.
     */
    public void createBallsOnTopOfPaddle() {

        pad = new Paddle(390 - (level.paddleWidth() / 2), 585, level.paddleWidth(), 30, Color.yellow, keyboard);
        pad.addToGame(this);
        environment.addCollidable(pad);
        List<Velocity> velocities = this.level.initialBallVelocities();
        for (int i = 0; i < velocities.size(); i++) {
            Ball ball = new Ball(390, 500, 5, Color.lightGray);
            // ball.setVelocity(velocities.get(i));
            ball.setVelocity(level.initialBallVelocities().get(i));
            ball.addToGame(this);
            ball.setEnv(environment);
        }
        //  Ball ball2 = new Ball(390, 450, 5, java.awt.Color.BLACK);
        //  ball.addToGame(this);
        //  ball2.addToGame(this);
        Velocity v = Velocity.fromAngleAndSpeed(90, 10);
        // ball.setVelocity(levelone.initialBallVelocities().get(0));
        //   ball2.setVelocity(1, -3);
        //    ball.setEnv(environment);
        // ball2.setEnv(environment);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new PauseScreen(this.keyboard));
        }
        if (this.mycounter.getValue() == 0) {
            scorecouner.increase(100);
            this.running = false;
        }

          /* if (kills.getValue() == 2) {
                livecounter.decrease(1);
                kills.decrease(2);
            }*/


        if (this.ballcounter.getValue() == 0) {
            this.livecounter.decrease(1);
            if (this.livecounter.getValue() == 0) {
                this.running = false;
            } else {
                this.pad.extramemove();
                ballcounter.increase(level.numberOfBalls());

                playOneTurn();
            }
        }
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        d.setColor(Color.black);
        d.drawText(300, 25, "level name:" + this.level.levelName(), 20);

    }

    /**
     * Gets .
     *
     * @return the
     */
    public int getcounter() {
        return this.mycounter.getValue();
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * Gets .
     *
     * @return the
     */
    public int getscore() {
        return this.scorecouner.getValue();
    }

    /**
     * Givemelive int.
     *
     * @return the int
     */
    public int givemelive() {
        return this.livecounter.getValue();
    }
}





