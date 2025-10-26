package racingcar;

public class Car implements Comparable<Car>, Cloneable {
    private String name;
    private Position position;

    public Car(String name) {
        this.name = name;
        this.position = new Position(0);
    }

    public Position operate() {
        if (RandomNumberGenerator.generate() >= 4) {
            go();
        } else {
            stop();
        }
        return position;
    }

    private void go() {
        position.change(1);
    }

    private void stop() {
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car o) {
        return this.position.compareTo(o.position);
    }

    @Override
    public Car clone() {
        try {
            Car clone = (Car) super.clone();
            clone.name = this.name;
            clone.position = this.position.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}