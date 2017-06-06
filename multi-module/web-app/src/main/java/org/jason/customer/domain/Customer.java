package org.jason.customer.domain;

/**
 * Created by JTrancender on 2017/5/26.
 */
public class Customer {
    private String ip;
    private int times;
    private String created;
    private String updated;

    public Customer() {
    }

    public Customer(String ip, int times, String created, String updated) {
        this.ip = ip;
        this.times = times;
        this.created = created;
        this.updated = updated;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "ip='" + ip + '\'' +
                ", times=" + times +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                '}';
    }
}
