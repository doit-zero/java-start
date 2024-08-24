package thread.control;

import thread.start.HelloRunnable;

import static util.MyLogger.log;
public class ThreadInfoMain {
    public static void main(String[] args) {
        // main 스레드
        Thread mainThread = Thread.currentThread();
        log("mainThread = " + mainThread);
        log("mainThread.getId() = " + mainThread.getId());
        log("mainThread.getName() = " + mainThread.getName());
        log("mainThread.getPriority() = " +mainThread.getPriority());
        log("mainThread.getThreadGroup() = " +mainThread.getThreadGroup());
        log("mainThread.getState() = " + mainThread.getState());

        System.out.println("=======");
        // myThread 스레드
        Thread myThread = new Thread(new HelloRunnable(), "myThread");
        log("myThread = " + myThread);
        log("myThread.getId() = " + myThread.getId());
        log("myThread.getName() = " + myThread.getName());
        log("myThread.getPriority() = " +myThread.getPriority());
        log("myThread.getThreadGroup() = " +myThread.getThreadGroup());
        log("myThread.getState() = " + myThread.getState());


    }
}
