import com.sun.xml.internal.ws.util.CompletedFuture;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class AsyncFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        log.info("主线程开始");
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            log.info("子线程开始");
            Integer i = 1324/3;
            log.info("线程名称:{},线程执行结果{}" , Thread.currentThread().getName(), i);
            log.info("子线程结束");
            return i;
        }).thenApply((Integer)->{
            log.info("thenRun子线程开始{}",Integer);
            log.info("thenRun子线程计算结果{}",Integer*5);
            return Integer*5;
        });
        future.get();
        log.info("主线程结束");
    }

}
