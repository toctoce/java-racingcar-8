package racingcar;

import java.util.List;

public abstract class Result {

    List<Car> cars;

    public Result(List<Car> cars) {
        this.cars = cars;
    }

    public abstract String toString();
}
