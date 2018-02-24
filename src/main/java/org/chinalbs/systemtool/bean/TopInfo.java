package org.chinalbs.systemtool.bean;

import sun.plugin2.gluegen.runtime.CPU;

/*
Create by jiangyun on 2018/2/12
*/
public class TopInfo {

    public String pid;
    public String user;
    public String pr;
    public String ni;
    public String virt;
    public String res;
    public String share;
    public String processStatus;
    public String cpuPercentage;
    public String memoryPercentage;
    public String totalCPUTimeUsedByProcess;
    public String cmmand;


    public TopInfo(String pid, String user, String pr, String ni, String virt, String res, String share, String processStatus, String cpuPercentage, String memoryPercentage, String timePercentage, String cmmand) {
        this.pid = pid;
        this.user = user;
        this.pr = pr;
        this.ni = ni;
        this.virt = virt;
        this.res = res;
        this.share = share;
        this.processStatus = processStatus;
        this.cpuPercentage = cpuPercentage;
        this.memoryPercentage = memoryPercentage;
        this.totalCPUTimeUsedByProcess = totalCPUTimeUsedByProcess;
        this.cmmand = cmmand;
    }

    public TopInfo() {
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPr() {
        return pr;
    }

    public void setPr(String pr) {
        this.pr = pr;
    }

    public String getNi() {
        return ni;
    }

    public void setNi(String ni) {
        this.ni = ni;
    }

    public String getVirt() {
        return virt;
    }

    public void setVirt(String virt) {
        this.virt = virt;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    public String getCpuPercentage() {
        return cpuPercentage;
    }

    public void setCpuPercentage(String cpuPercentage) {
        this.cpuPercentage = cpuPercentage;
    }

    public String getMemoryPercentage() {
        return memoryPercentage;
    }

    public void setMemoryPercentage(String memoryPercentage) {
        this.memoryPercentage = memoryPercentage;
    }

    public String getTimePercentage() {
        return totalCPUTimeUsedByProcess;
    }

    public void setTimePercentage(String timePercentage) {
        this.totalCPUTimeUsedByProcess = timePercentage;
    }

    public String getCmmand() {
        return cmmand;
    }

    public void setCmmand(String cmmand) {
        this.cmmand = cmmand;
    }

    @Override
    public String toString() {
        return "TopInfo{" +
                "pid=" + pid +
                ", user='" + user + '\'' +
                ", pr=" + pr +
                ", ni=" + ni +
                ", virt=" + virt +
                ", res=" + res +
                ", share=" + share +
                ", processStatus='" + processStatus + '\'' +
                ", cpuPercentage=" + cpuPercentage +
                ", memoryPercentage=" + memoryPercentage +
                ", timePercentage=" + totalCPUTimeUsedByProcess +
                ", cmmand='" + cmmand + '\'' +
                '}';
    }

    public String toStringZH() {
        return "进程信息{" +
                "进程id=" + pid +
                ", 进程所有者='" + user + '\'' +
                ", 进程优先级=" + pr +
                ", nice值=" + ni +
                ", 虚拟内存总量=" + virt +
                ", 进程使用未被交换出来的物理内存=" + res +
                ", 共享内存=" + share +
                ", 进程状态='" + processStatus + '\'' +
                ", 上次更新到现在CPU占用时间百分比=" + cpuPercentage +
                ", 进程使用的物理内存百分比=" + memoryPercentage +
                ", 进程使用的cpu时间总计=" + totalCPUTimeUsedByProcess +
                ", 进程名称='" + cmmand + '\'' +
                '}';
    }
}
