package task1;

import java.util.concurrent.Executor;

public class ThreadExecutors {
    public static void main(String[] args) {
        Executor executor = new Executor() {
            @Override
            public void execute(Runnable command) {

            }
        };
    }
}
