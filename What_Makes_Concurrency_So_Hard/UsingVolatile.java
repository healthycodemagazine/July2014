public class UsingVolatile {

  public static int doWork(int i) {    
    return i + 1;
  }
  
  private static volatile boolean keepRunning = true;
  
  public static void main(final String[] args) {
    new Thread(new Runnable() {
      public void run() {
        while(keepRunning) { doWork(0); }
        System.out.println("Done!");
      }
    }).start();
    
    try { Thread.sleep(2000); } catch(Exception ex) {}
    keepRunning = false;
  }
}
