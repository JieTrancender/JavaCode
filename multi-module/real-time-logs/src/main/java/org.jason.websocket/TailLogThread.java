package org.jason.websocket;

import javax.websocket.Session;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by JTrancender on 2017/6/6.
 */
public class TailLogThread extends Thread {
    private BufferedReader bufferedReader;
    private Session session;

    public TailLogThread(InputStream inputStream, Session session) {
        this.bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        this.session = session;
    }

    @Override
    public void run() {
        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
//                将实时日志通过WebSocket发送给客户端，给每一行添加一个HTML换行
                session.getBasicRemote().sendText(line + "<br/>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
