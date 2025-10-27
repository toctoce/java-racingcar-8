package racingcar;

import java.util.List;

public class OutputWriter {

    private static final String STEP_RESULT_MESSAGE = "실행 결과\n";
    private static final String FINAL_RESULT_MESSAGE = "최종 우승자 : ";

    public void writeStepResult(List<StepResult> results) {
        System.out.print(STEP_RESULT_MESSAGE);
        for (StepResult result : results) {
            System.out.println(result);
            System.out.println();
        }
    }

    public void writeFinalResult(FinalResult result) {
        System.out.print(FINAL_RESULT_MESSAGE);
        System.out.println(result);
    }
}
