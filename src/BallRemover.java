/**
 * The type Ball remover.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBall;

    /**
     * Instantiates a new Ball remover.
     *
     * @param game          the game
     * @param removedBlocks the removed blocks
     */
    public BallRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBall = removedBlocks;
    }


    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        game.removeSprite(hitter);

        this.remainingBall.decrease(1);
    }
}


