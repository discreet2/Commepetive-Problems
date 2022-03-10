package leetcode;

import java.util.concurrent.*;

public class Timeout {

    public static class MyJob implements Callable<String> {

        @Override
        public String call() throws Exception {
            // Do something
            return "result";
        }

    }

    public static void main(String[] args) {

        Future<String> control
                = Executors.newSingleThreadExecutor().submit(new MyJob());

        try {

            String result = control.get(5, TimeUnit.SECONDS);
            System.out.println(result);

        } catch (TimeoutException ex) {

            // 5 seconds expired, we cancel the job !!!
            control.cancel(true);

        } catch (InterruptedException ex) {

        } catch (ExecutionException ex) {

        }

    }

}