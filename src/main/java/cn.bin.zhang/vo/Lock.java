package cn.bin.zhang.vo;

import java.io.Serializable;

public class Lock implements Serializable {
    private static final long serialVersionUID = -8209037090733370849L;
    private Integer lock;
    private String ip;

    public Integer getLock() {
        return lock;
    }

    public void setLock(Integer lock) {
        this.lock = lock;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "Lock{" +
                "lock=" + lock +
                ", ip='" + ip + '\'' +
                '}';
    }
}
