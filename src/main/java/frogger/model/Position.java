package frogger.model;

import java.util.Objects;

/**
 * Represents a position in the game space.
 */
public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position frogNode = (Position) o;
        return x == frogNode.x &&
                y == frogNode.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
