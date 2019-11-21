import biuoop.GUI;
import biuoop.Sleeper;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Ass 5 game.
 */
class Ass6Game {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        Ass6Game run = new Ass6Game();
        run.runTheGame(args);
    }
    /**
     *
     * @param args the given arguments.
     */
    private void runTheGame(String[] args) {
        GUI gui = new GUI("title", 800, 600);
        GameFlow game = new GameFlow(new AnimationRunner(gui, new Sleeper(), 60), gui.getKeyboardSensor());
        List<LevelInformation> levels = listlevel(args);
        if (levels.isEmpty()) {
            levels.add(new Levelone());
            levels.add(new Leveltwo());
            levels.add(new Leveltre());
            levels.add(new Levelfour());
            game.runLevels(levels);
        } else {
            game.runLevels(levels);
        }
        gui.close();
    }


    /**
     * Listlevel list.
     *
     * @param args the args
     * @return the list
     */
    public List<LevelInformation> listlevel(String[] args) {
        List<LevelInformation> givenLevels = new ArrayList<LevelInformation>();
        // the loop check if the arguments are a game levels.

        for (String s : args) {
            if (s.equals("1")) {
                givenLevels.add(new Levelone());
            } else if (s.equals("2")) {
                givenLevels.add(new Leveltwo());
            } else if (s.equals("3")) {
                givenLevels.add(new Leveltre());
            } else if (s.equals("4")) {
                givenLevels.add(new Levelfour());
            }
        }
        return givenLevels;
    }


    //GameLevel game = new GameLevel(new Levelfour(),new Levelfour().numberOfBalls());
    //   game.initialize();
    //   game.run();
}
