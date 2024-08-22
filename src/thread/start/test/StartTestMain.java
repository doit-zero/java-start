package thread.start.test;

import static util.MyLogger.log;
public class StartTestMain {
    public static void main(String[] args) {
        Thread threadA = new Thread(new PrintWork("A",1000),"Thread-A");
        Thread threadB = new Thread(new PrintWork("B",500),"Thread-B");
        threadA.start();
        threadB.start();
    }

    static class PrintWork implements Runnable{
        private String name;
        private int time;

        public PrintWork(String name, int time) {
            this.name = name;
            this.time = time;
        }

        @Override
        public void run() {
            while (true){
                log(name);
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
