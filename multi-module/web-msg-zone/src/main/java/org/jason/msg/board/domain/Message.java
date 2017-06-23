package org.jason.msg.board.domain;

/**
 * Created by JTrancender on 2017/6/22.
 */
public class Message {
    private String hostId;
    private String friendId;
    private String content;
    private String time;

    public Message() {
    }

    public Message(String hostId, String friendId, String content, String time) {
        this.hostId = hostId;
        this.friendId = friendId;
        this.content = content;
        this.time = time;
    }

    public String getHostId() {
        return hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Message{" +
                "hostId='" + hostId + '\'' +
                ", friendId='" + friendId + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
