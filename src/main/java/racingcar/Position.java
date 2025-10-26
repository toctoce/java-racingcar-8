package racingcar;

public class Position implements Comparable<Position>, Cloneable {

    private int coordinate;

    public Position(int coordinate) {
        this.coordinate = coordinate;
    }

    public void change(int movement) {
        coordinate += movement;
    }

    public int getCoordinate() {
        return coordinate;
    }

    @Override
    public int compareTo(Position o) {
        return Integer.compare(this.coordinate, o.coordinate);
    }

    @Override
    public Position clone() {
        try {
            Position clone = (Position) super.clone();
            clone.coordinate = this.coordinate;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
