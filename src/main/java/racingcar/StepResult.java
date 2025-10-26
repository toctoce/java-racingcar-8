package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class StepResult extends Result {

    public StepResult(List<Car> cars) {
        super(cars);
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(car -> formatResult(car))
                .collect(Collectors.joining("\n"));
    }

    private String formatResult(Car car) {
        String carName = car.getName();

        Position carPosition = car.getPosition();
        String distance = "-".repeat(carPosition.getCoordinate());

        return carName + " : " + distance;
    }

}
