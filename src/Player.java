public class Player {
    private String playerName;
    private int score;
    private int frame;

    /**
     * Constructor to initialize a player with a given name.
     *
     * @param playerName The name of the player
     */
    public Player (String playerName) {
        this.playerName = playerName;
        this.score = 0;
        this.frame = 1;
    }

    /**
     * Updates the player's score with the given points.
     *
     * @param points The points to add to the player's score
     */
    public void updateScore (int points) {
        this.score += points;
    }

    /**
     * Retrieves the current score of the player.
     *
     * @return The current score of the player
     */
    public int getScore () {
        return this.score;
    }

    /**
     * Retrieves the current frame number the player is on.
     *
     * @return The current frame number
     */
    public int getFrame () {
        return this.frame;
    }

    /**
     * Advances the player to the next frame.
     */
    public void nextFrame () {
        this.frame++;

    }
}