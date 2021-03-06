package ca.aemc.rex1;

public class ScoreModel
{
    private int attempts;
    private int successes;
    private long startTime;
    private long elapsedTime;

    /**
     * Constructor
     */
    public ScoreModel()
    {
        attempts = 0;
        successes = 0;
        startTime = System.currentTimeMillis();
    }

    /**
     * Returns the number of attemps.
     *
     * @return The number attempts.
     */
    public int getAttempts()
    {
        return attempts;
    }

    /**
     * Returns the number of successful attempts.
     *
     * @return Returns the number of successful attempts.
     */
    public int getSuccess()
    {
        return successes;
    }

    /**
     * Returns the start time.
     *
     * @return Returns the start time.
     */
    public long getStart()
    {
        return startTime;
    }

    /**
     * Returns the difference between the curren time and the start time.
     *
     * @return Returns the elapsed time.
     */
    public long getElapsedTime()
    {
        elapsedTime = System.currentTimeMillis();
        long difference = (elapsedTime - startTime) / 1000;
        return difference;
    }

    /**
     * Increments the number of successes and attempts.
     *
     * @param success A boolean variable that indiciates if the user was successful.
     */
    public void record(boolean success)
    {
        if (success) successes++;
        attempts++;
    }

    /**
     * Returns the average score by the user.
     *
     * @return A double variable calculated from the number of successes and attempts.
     */
    public double getAverageScore()
    {
        return ((double) successes / attempts) * 100;
    }

    /**
     * Resets the timer back to zero.
     */
    public void resetTimer()
    {
        startTime = System.currentTimeMillis();
    }

    public static void main(String[] args)
    {
        ScoreModel sm = new ScoreModel();
        System.out.println("Start TIme: " + sm.getStart());
        sm.record(false);
        sm.record(false);
        sm.record(true);
        sm.record(false);
        System.out.println("Elapsed Time: " + sm.getElapsedTime() + "ms");
        System.out.println("Attempts: " + sm.getAttempts());
        System.out.println("Success: " + sm.getSuccess());
        System.out.println("Average Score: " + sm.getAverageScore());
        sm.resetTimer();
    }
}