import java.util.ArrayList;
import java.util.List;

/**
 * @author safwan
 */
public class Ass6Game {
    /**
     * @param args main to run the game no args.
     */
    public static void main(String[] args) {
        List<LevelInformation> levels = new ArrayList<>();
        if (args.length == 0) {
        Level1 level1 = new Level1();
        Level2 level2 = new Level2();
        Level3 level3 = new Level3();
        Level4 level4 = new Level4();
        levels.add(level1);
        levels.add(level2);
        levels.add(level3);
        levels.add(level4);
    } else {
        for (String s: args) {
          if (s.equals("1")) {
              levels.add(new Level1());
          } else if (s.equals("2")) {
              levels.add(new Level2());
          } else if (s.equals("3")) {
              levels.add(new Level3());
          } else if (s.equals("4")) {
              levels.add(new Level4());
          }
        }
        if (levels.size() == 0) {
            Level1 level1 = new Level1();
            Level2 level2 = new Level2();
            Level3 level3 = new Level3();
            Level4 level4 = new Level4();
            levels.add(level1);
            levels.add(level2);
            levels.add(level3);
            levels.add(level4);

        }

    }
        AnimationRunner runner = new AnimationRunner();
        GameFlow flow = new GameFlow(runner, runner.getKeyboardSensor());
        flow.runLevels(levels);
}
}
