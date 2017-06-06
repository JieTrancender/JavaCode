package org.jason.websocket;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by JTrancender on 2017/6/6.
 */
@ServerEndpoint("/log")
public class LogWebSocketHandle {
    private Process process;
    private InputStream inputStream;

    @OnOpen
    public void onOpen(Session session) {
        try {
            process = Runtime.getRuntime().exec("tail -f f:/test.rb");
            inputStream = process.getInputStream();

//            为了防止InputStream阻塞处理WebSocket线程，必须启动新线程
            TailLogThread thread = new TailLogThread(inputStream, session);
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose() {
        try {
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (process != null) {
            process.destroy();
        }
    }

    @OnError
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }
}
