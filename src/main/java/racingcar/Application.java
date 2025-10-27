package racingcar;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new CarManager(), new InputReader(), new OutputWriter());
        gameController.run();
    }
}
