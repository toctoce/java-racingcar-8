package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Result {

    List<Car> cars;

    public Result(List<Car> cars) {
        this.cars = cars.stream()
                .map(car -> car.clone())
                .collect(Collectors.toList());
    }

    public abstract String toString();
}
