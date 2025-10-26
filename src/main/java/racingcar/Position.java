package racingcar;

public class Position implements Comparable<Position> {

    private int coordinate;

    public Position(int coordinate) {
        this.coordinate = coordinate;
    }

    private void change(int movement) {
        coordinate += movement;
    }

    @Override
    public int compareTo(Position o) {
        return Integer.compare(this.coordinate, o.coordinate);
    }

    public int getCoordinate() {
        return coordinate;
    }
}
