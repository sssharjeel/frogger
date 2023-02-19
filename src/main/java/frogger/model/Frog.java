package frogger.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Class representing the frog/player
 */
public class Frog {
    private Position body;
    // current facing direction
    private Direction direction;
    // the last position that was removed as a result of moving
    private Position lastRemoved;

    public Frog() {
        this.body = new Position(1, 1);
        this.direction = Direction.RIGHT;
    }

    /**
     * Progresses the snake in the current direction
     */
    public void move() {
        this.body = direction.move(this.body);
    }

    /**
     * Returns whether the snake has collided
     * with a given position (either through body or head)
     */
    public boolean hasCollided(ArrayList obstaclePositions) {
        boolean collided = false;

        collided = (obstaclePositions.contains(body));

        return collided;

    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Position getBody() {
        return body;
    }

}
