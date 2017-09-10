package threads.executors.implementing_callable;

import java.util.concurrent.*;

public class RockScissorsPaper {
    public static class PlayerCallable implements Callable {
        String name;
        int call_sequence = 0;
        static String[] SelectionTable = {
            "Rock", "Scissors", "Paper"
        };
        PlayerCallable(String given_name) {
            name = given_name;
        }
        public String call() throws InterruptedException {
            int delay = (int) (2000 * Math.random());
            call_sequence++;
            System.out.format("%s pauses %d microseconds on the %d-th invocation.\n", name, delay, call_sequence);
            Thread.sleep(delay);
            String choice = SelectionTable[three_sided_coin()];
            System.out.format("%s selects %s.\n", name, choice);
            return choice;
        }
    }
    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        PlayerCallable player1 = new PlayerCallable("player1");
        PlayerCallable player2 = new PlayerCallable("player2");
        for (int i = 10; i > 0; i--) {
            Future future1 = pool.submit(player1);
            Future future2 = pool.submit(player2);
            System.out.println(payoff((String) future1.get(),
                                      (String) future2.get()));
        }
        pool.shutdown();
    }
    public void run() {
        FutureTask player1 = new FutureTask(new ThisCallable());
    }
    public static int three_sided_coin() {
        return (int)(Math.random() * 3);
    }
    public static String payoff (String first_hand, String second_hand) {
    if (first_hand.equals(second_hand)) {
        return String.format("'%s' from both hands is a tie.", 
              first_hand);
    }
        if ((first_hand.equals("Rock") & second_hand.equals("Scissors")) ||
            (first_hand.equals("Scissors") & second_hand.equals("Paper")) ||
            (first_hand.equals("Paper") & second_hand.equals("Rock"))) {
            return String.format("One's '%s' beats Two's '%s'.", first_hand, second_hand);
        }
        return String.format("Two's '%s' beats One's '%s'.", second_hand, first_hand);
    }
    public class ThisCallable implements Callable {
        public Integer call() throws java.io.IOException {
           return 1;
        }
    }
}