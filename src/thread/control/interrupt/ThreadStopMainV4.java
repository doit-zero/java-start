package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV4 {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task,"work");
        thread.start();

        sleep(1000);
        log("작업 중단 지시 - thread.interrupt()");
        thread.interrupt(); // 스레드 인터럽트 상태가 true가 된다
        log("work 스레드 인터럽트 상태1 = " + thread.isInterrupted());
    }

    static class MyTask implements Runnable{
        /*
        * Thread.interrupted()는 스레드 인터럽트 상태가 true이면 true 값을 반환하고 스레드 인터럽트 상태를 false로 반환
        * 스레드 인터럽트 상태가 fasle이면 false값을 반환하고 해당 스레드 인터럽트 상태를 변경하지 않는다.
        * */
        @Override
        public void run() {
            while(!Thread.interrupted()){
                log("작업 중");
            }
            log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted());

            try {
                log("자원 정리 시도");
                Thread.sleep(1000);
                log("자원 정리 완료");
            } catch (InterruptedException e){
                log("자원 정리 실패 - 자원 정리 중 인터럽트 발생");
                log("work 스레드 인터럽트 상태3 = " + Thread.currentThread().isInterrupted());
            }
            log("작업 종료");
        }
    }
}
