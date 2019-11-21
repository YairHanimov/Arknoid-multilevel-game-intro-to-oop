/**
 * The type Score tracking listener.
 */
public class ScoreTrackingListener implements HitListener {
    private GameLevel game;
    private Counter remainingscore;

    /**
     * Instantiates a new Score tracking listener.
     *
     * @param game          the game
     * @param removedBlocks the removed blocks
     */
    public ScoreTrackingListener(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingscore = removedBlocks;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {

        if (beingHit.getch() == "2") {
            this.remainingscore.increase(5);
        } else {
            this.remainingscore.increase(10);
        }

    }


}
