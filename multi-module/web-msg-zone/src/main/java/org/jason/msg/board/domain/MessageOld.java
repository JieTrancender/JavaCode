package org.jason.msg.board.domain;

/**
 * Created by JTrancender on 2017/3/17.
 */
public class MessageOld {
    private String name;
    private String phone;
    private String email;
    private String title;
    private String content;
    private String time;

    public MessageOld() {
    }

    public MessageOld(String name, String phone, String email, String title, String content, String time) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.title = title;
        this.content = content;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        return "MessageOld{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
