/**
 * The type Lives indicator.
 */
public class LivesIndicator implements HitListener {
    private GameLevel game;
    private Counter livecount;

    /**
     * Instantiates a new Lives indicator.
     *
     * @param game      the game
     * @param livecount the livecount
     */
    public LivesIndicator(GameLevel game, Counter livecount) {
        this.game = game;
        this.livecount = livecount;
    }

    // Blocks that are hit and reach 0 hit-points should be removed
    // from the game. Remember to remove this listener from the block
    // that is being removed from the game.
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {

        game.removeSprite(beingHit);
        game.removeCollidable(beingHit);

    }
}
