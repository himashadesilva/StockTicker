package stockTicker;

import java.util.*;
import java.util.logging.*;

public class Stock extends Thread {
    final Random rand = new Random();
    protected int price = -1;

    /**
     * Periodically updates stock price and notifies sevlet threads.
     */
    @Override
    public void run() {
        while (!Thread.interrupted())
            try {
                synchronized (this) {
                    price = 90 + rand.nextInt(20);
                    notifyAll();
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Logger.getGlobal().log(Level.INFO, "Stock updates terminated!");
                break;
            }
    }
}
