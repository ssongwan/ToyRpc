package com.ssongwan.rpc.transport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class RpcServer {
    private final ExecutorService threadPool;

    private static final int corePoolSize = 5;
    private static final int maximumPoolSize = 50;
    private static final long keepAliveTime = 60;

    private static final Logger log = LoggerFactory.getLogger(RpcServer.class);

    public RpcServer() {
        this.threadPool = new ThreadPoolExecutor(corePoolSize
                , maximumPoolSize
                , keepAliveTime
                , TimeUnit.SECONDS
                , new ArrayBlockingQueue<Runnable>(500)
                , Executors.defaultThreadFactory());
    }

    public void register(Object service, int port) {
        try(ServerSocket serverSocket = new ServerSocket(port)) {
            log.info("服务器正在启动");
            Socket socket;
            while((socket = serverSocket.accept()) != null) {
                log.info("客户端连接 ip为：" + socket.getInetAddress());
                threadPool.execute(new WorkerThread(service, socket));
            }
        }catch (IOException e) {
            log.error("连接时发生错误：", e);
        }
    }
}
