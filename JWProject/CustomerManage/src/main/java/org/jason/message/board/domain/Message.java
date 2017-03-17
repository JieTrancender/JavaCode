package org.jason.message.board.domain;

/**
 * Created by JTrancender on 2017/3/17.
 */
public class Message {
    private String name;
    private String phone;
    private String email;
    private String title;
    private String content;

    public Message() {
    }

    public Message(String name, String phone, String email, String title, String content) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.title = title;
        this.content = content;
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

    @Override
    public String toString() {
        return "Message{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
