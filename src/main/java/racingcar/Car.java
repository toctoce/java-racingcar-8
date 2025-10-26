package racingcar;

public class Car implements Comparable<Car> {
    private String name;
    private Position position;
    public Position getPosition() {
        return position;
    }

    @Override
    public int compareTo(Car o) {
        return this.position.compareTo(o.position);
    }

    public String getName() {
        return name;
    }
}
