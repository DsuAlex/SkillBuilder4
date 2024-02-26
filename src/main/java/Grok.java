/**
 * Groks are bad actors in a game.  Groks have the ability to ingest
 * a PowerPill to replenish their energy.  This makes them difficult
 * to kill.
 *
 * @author (You Again)
 * @version (0.1)
 */

public class Grok {
    private static final int DEFAULT_POWER_LEVEL = 50;
    private static final int MAX_POWER_LEVEL = 100;

    private int powerLevel;
    private boolean isAlive;

    public Grok() {
        setPowerLevel(DEFAULT_POWER_LEVEL);
    }

    public Grok(int powerLevel) {
        setPowerLevel(powerLevel);
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public boolean isDead() {
        return !isAlive || powerLevel <= 0;
    }

    public void setPowerLevel(int powerLevel) {
        if (powerLevel <= 0) {
            this.powerLevel = 0;
            isAlive = false;
        } else if (powerLevel > MAX_POWER_LEVEL) {
            this.powerLevel = MAX_POWER_LEVEL;
            isAlive = true;
        } else {
            this.powerLevel = powerLevel;
            isAlive = true;
        }
    }

    public void takePowerPill(PowerPill pill) {
        if (isAlive) {
            setPowerLevel(Math.min(powerLevel + pill.getPower(), MAX_POWER_LEVEL));
        }
    }

    public void tookHit() {
        if (isAlive) {
            setPowerLevel(Math.max(powerLevel - 5, 0));
        }
    }

    //================== Do Not Touch Code Below this line =============================
    public String toString(){
        return "Grok:("+powerLevel+","+isAlive+")";

    }
}
