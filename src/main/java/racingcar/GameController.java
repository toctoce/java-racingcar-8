package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameController {

    private final CarManager carManager;
    private final InputReader inputReader;
    private final OutputWriter outputWriter;

    public GameController(CarManager carManager, InputReader inputReader, OutputWriter outputWriter) {
        this.carManager = carManager;
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
    }

    public void run() {
        makeCars();
        int attemptCount = getAttemptCount();
        List<StepResult> stepResults = repeatOperationAndGetStepResults(attemptCount);
        FinalResult finalResult = getFinalResult();
        printResults(stepResults, finalResult);
    }

    private void makeCars() {
        String carNamesString = inputReader.readCarNames();
        List<String> carNameList = Parser.carNamesInputToNameList(carNamesString);
        carManager.makeAllCars(carNameList);
    }

    private int getAttemptCount() {
        String attemptCountString = inputReader.readAttemptCount();
        return Parser.stringToInt(attemptCountString);
    }

    private List<StepResult> repeatOperationAndGetStepResults(int attemptCount) {
        return IntStream.range(0, attemptCount)
                .peek(i -> carManager.operateAllCars())
                .mapToObj(i -> carManager.makeStepResult())
                .collect(Collectors.toList());
    }

    private FinalResult getFinalResult() {
        return carManager.makeFinalResult();
    }

    private void printResults(List<StepResult> stepResults, FinalResult finalResult) {
        outputWriter.writeStepResult(stepResults);
        outputWriter.writeFinalResult(finalResult);
    }

}
