public class TestThread {
   public static void main(String args[]) {
   
      Thread R1 = new Thread(new RunnableDemo("Thread-1"));
      R1.start();
      
      Thread R2 = new Thread(new RunnableDemo("Thread-2"));
      R2.start();
   }
}