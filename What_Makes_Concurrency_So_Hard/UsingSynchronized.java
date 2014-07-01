public class UsingSynchronized {

  public static int doWork(int i) {    
    return i + 1;
  }
  
  private static boolean keepRunning = true;
  
  public static void main(final String[] args) {
    new Thread(new Runnable() {
      public void run() {
        while(keepRunning) { 
          synchronized (this) {
            doWork(0);
          } 
        }
        System.out.println("Done!");
      }
    }).start();
    
    try { Thread.sleep(2000); } catch(Exception ex) {}
    keepRunning = false;
  }
}
