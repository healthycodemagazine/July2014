public class Peril {
  public static void sleep(int milliseconds) {
    try { Thread.sleep(milliseconds); } catch(Exception ex) {}    
  }
  
  public static int doWork(int i) {    
    sleep(10); //crossing memory barrier
    return i + 1;
  }
  
  private static boolean keepRunning = true;
  
  public static void main(final String[] args) {
    new Thread(new Runnable() {
      public void run() {
        while(keepRunning) { doWork(0); }
        System.out.println("Done!");
      }
    }).start();
    
    sleep(2000);
    keepRunning = false;
    sleep(2000);
    System.out.println("main done");
  }
}
