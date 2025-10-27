package racingcar;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FinalResult extends Result {

    List<Car> headCars;

    public FinalResult(List<Car> cars) {
        super(cars);
        calculateWinners();
    }

    public void calculateWinners() {

        if (cars.isEmpty()) {
            headCars = List.of();
            return;
        }

        Car headCar = Collections.max(cars);
        headCars = cars.stream()
                .filter(car -> car.compareTo(headCar) == 0)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return headCars.stream()
                .map(car -> car.getName())
                .collect(Collectors.joining(", "));
    }
}
