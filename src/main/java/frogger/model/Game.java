package frogger.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Represents the Frogger as a whole
 */
public class Game {
    public static final int TICKS_PER_SECOND = 10;
    private final Frog frog = new Frog();
    private final Set<Position> obstacle = new HashSet<>();
    private ArrayList obstalcePositions = new ArrayList();
    private int score = 0;
    private boolean ended = false;
    private final int maxX;
    private final int maxY;

    public Game(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;

        obstacle.add(generateRandomPosition());
    }

    /**
     * Progresses the game state, moving the frog, and handling collisions
     */
    public void tick() {

        spawnNewObstacle();
        frog.move();
        score++;

        if (frog.hasCollided(obstalcePositions) || isOutOfBounds(frog.getBody())) {
            ended = true;
            return;
        }
    }

    /**
     * Spawns a new food item into a valid
     * position in the game
     */
    public void spawnNewObstacle() {
        Position pos = generateRandomPosition();

        while (!isValidPosition(pos)) {
            pos = generateRandomPosition();
        }

        obstalcePositions.add(pos);
        obstacle.add(pos);
    }

    /**
     * Returns whether a given position is
     * out of the game frame
     */
    public boolean isOutOfBounds(Position pos) {
        return pos.getX() < 0 ||
                pos.getY() < 0 ||
                pos.getX() > maxX ||
                pos.getY() > maxY;
    }

    /**
     * Returns whether a given position is in bounds
     * and not already occupied
     */
    public boolean isValidPosition(Position pos) {
        return  !isOutOfBounds(pos) &&
                !obstacle.contains(pos);
    }

    private boolean tooClose(Position pos) {
        return ((Math.abs(frog.getBody().getX() - pos.getX()) <= 2)
                && (Math.abs(frog.getBody().getY() - pos.getY()) <= 2));
    }

    /**
     * Generates a random position.
     * Guaranteed to be in bounds but not necessarily valid
     */
    private Position generateRandomPosition() {
        return new Position (
                ThreadLocalRandom.current().nextInt(maxX),
                ThreadLocalRandom.current().nextInt(maxY)
        );
    }

    public Frog getFrog() {
        return frog;
    }

    public Set<Position> getObstacle() {
        return obstacle;
    }

    public int getScore() {
        return score;
    }

    public boolean isEnded() {
        return ended;
    }
}
