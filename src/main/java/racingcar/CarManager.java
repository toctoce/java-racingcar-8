package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class CarManager {

    private List<Car> cars;

    public void makeAllCars(List<String> carNames) {
        cars = carNames.stream()
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
    }

    public void operateAllCars() {
        cars.forEach(car -> car.operate());
    }

    public StepResult makeStepResult() {
        return new StepResult(cars);
    }

    public FinalResult makeFinalResult() {
        return new FinalResult(cars);
    }
}
