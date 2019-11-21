/**
 * The type Killerblock  bonus part.
 */
public class Killerblock implements HitListener {
    private GameLevel game;
    private Counter killers;

    /**
     * Instantiates a new Killerblock.
     *
     * @param game    the game
     * @param killers the killers
     */
    public Killerblock(GameLevel game, Counter killers) {
        this.game = game;
        this.killers = killers;
    }

    // Blocks that are hit and reach 0 hit-points should be removed
    // from the game. Remember to remove this listener from the block
    // that is being removed from the game.

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        if (beingHit.getch() == "kill") {
            game.removeSprite(beingHit);
            game.removeCollidable(beingHit);
            this.killers.increase(1);
        }
    }
}