
public interface RuntimeInterface {
  
   public void addRuntime(long runTime);   // Adds a runtime
   public double getAverageRunTime();   // Obtain the average runtime
   public long getLastRunTime();   // Retrieve the last runtime
   public long[] getRunTimes();   // Returns an array of long values representing the last 10 runtimes
   public void resetRunTimes();   // Reset all 10 linear search times to zero
}

