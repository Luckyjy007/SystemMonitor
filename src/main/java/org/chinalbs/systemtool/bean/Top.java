package org.chinalbs.systemtool.bean;

/*
Create by jiangyun on 2018/2/12
*/
public class Top {

    public String systemBootTime;
    public Integer numberOfUsers;
    public String loadAverageOneMinute;
    public String loadAverageFiveMinute;
    public String loadAverageFifteenMinute;

    public Integer totalTasks;
    public int runningTasks;
    public int sleepingTasks;
    public int stoppedTasks;
    public int zombieTasks;

    public Double userSpacePercentageOfCPU;
    public Double percentageOfCPUSpaceUsedByKernelSpace;
    public Double changeThePriorityOfThePercentageOfCPUProcess;
    public Double idleCPUPercentage;
    public Double percentageOfIOWaitingForCPU;
    public Double hardwareIRQ;
    public Double softwareInterrupts;

    public int totalPhysicalMemory;
    public int freeMemoryTotal;
    public int inUseOfMemory;
    public int cachedMemory;

    public int swapTotal;
    public int swapFree;
    public int swapUsed;
    public int swapAvailMem;

    public Top() {
    }

    public Top(String systemBootTime, Integer numberOfUsers, String loadAverageOneMinute, String loadAverageFiveMinute, String loadAverageFifteenMinute, Integer totalTasks, int runningTasks, int sleepingTasks, int stoppedTasks, int zombieTasks, Double userSpacePercentageOfCPU, Double percentageOfCPUSpaceUsedByKernelSpace, Double changeThePriorityOfThePercentageOfCPUProcess, Double idleCPUPercentage, Double percentageOfIOWaitingForCPU, Double hardwareIRQ, Double softwareInterrupts, int totalPhysicalMemory, int freeMemoryTotal, int inUseOfMemory, int cachedMemory, int swapTotal, int swapFree, int swapUsed, int swapAvailMem) {
        this.systemBootTime = systemBootTime;
        this.numberOfUsers = numberOfUsers;
        this.loadAverageOneMinute = loadAverageOneMinute;
        this.loadAverageFiveMinute = loadAverageFiveMinute;
        this.loadAverageFifteenMinute = loadAverageFifteenMinute;
        this.totalTasks = totalTasks;
        this.runningTasks = runningTasks;
        this.sleepingTasks = sleepingTasks;
        this.stoppedTasks = stoppedTasks;
        this.zombieTasks = zombieTasks;
        this.userSpacePercentageOfCPU = userSpacePercentageOfCPU;
        this.percentageOfCPUSpaceUsedByKernelSpace = percentageOfCPUSpaceUsedByKernelSpace;
        this.changeThePriorityOfThePercentageOfCPUProcess = changeThePriorityOfThePercentageOfCPUProcess;
        this.idleCPUPercentage = idleCPUPercentage;
        this.percentageOfIOWaitingForCPU = percentageOfIOWaitingForCPU;
        this.hardwareIRQ = hardwareIRQ;
        this.softwareInterrupts = softwareInterrupts;
        this.totalPhysicalMemory = totalPhysicalMemory;
        this.freeMemoryTotal = freeMemoryTotal;
        this.inUseOfMemory = inUseOfMemory;
        this.cachedMemory = cachedMemory;
        this.swapTotal = swapTotal;
        this.swapFree = swapFree;
        this.swapUsed = swapUsed;
        this.swapAvailMem = swapAvailMem;
    }

    public String getSystemBootTime() {
        return systemBootTime;
    }

    public void setSystemBootTime(String systemBootTime) {
        this.systemBootTime = systemBootTime;
    }

    public Integer getNumberOfUsers() {
        return numberOfUsers;
    }

    public void setNumberOfUsers(Integer numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    public String getLoadAverageOneMinute() {
        return loadAverageOneMinute;
    }

    public void setLoadAverageOneMinute(String loadAverageOneMinute) {
        this.loadAverageOneMinute = loadAverageOneMinute;
    }

    public String getLoadAverageFiveMinute() {
        return loadAverageFiveMinute;
    }

    public void setLoadAverageFiveMinute(String loadAverageFiveMinute) {
        this.loadAverageFiveMinute = loadAverageFiveMinute;
    }

    public String getLoadAverageFifteenMinute() {
        return loadAverageFifteenMinute;
    }

    public void setLoadAverageFifteenMinute(String loadAverageFifteenMinute) {
        this.loadAverageFifteenMinute = loadAverageFifteenMinute;
    }

    public Integer getTotalTasks() {
        return totalTasks;
    }

    public void setTotalTasks(Integer totalTasks) {
        this.totalTasks = totalTasks;
    }

    public int getRunningTasks() {
        return runningTasks;
    }

    public void setRunningTasks(int runningTasks) {
        this.runningTasks = runningTasks;
    }

    public int getSleepingTasks() {
        return sleepingTasks;
    }

    public void setSleepingTasks(int sleepingTasks) {
        this.sleepingTasks = sleepingTasks;
    }

    public int getStoppedTasks() {
        return stoppedTasks;
    }

    public void setStoppedTasks(int stoppedTasks) {
        this.stoppedTasks = stoppedTasks;
    }

    public int getZombieTasks() {
        return zombieTasks;
    }

    public void setZombieTasks(int zombieTasks) {
        this.zombieTasks = zombieTasks;
    }

    public Double getUserSpacePercentageOfCPU() {
        return userSpacePercentageOfCPU;
    }

    public void setUserSpacePercentageOfCPU(Double userSpacePercentageOfCPU) {
        this.userSpacePercentageOfCPU = userSpacePercentageOfCPU;
    }

    public Double getPercentageOfCPUSpaceUsedByKernelSpace() {
        return percentageOfCPUSpaceUsedByKernelSpace;
    }

    public void setPercentageOfCPUSpaceUsedByKernelSpace(Double percentageOfCPUSpaceUsedByKernelSpace) {
        this.percentageOfCPUSpaceUsedByKernelSpace = percentageOfCPUSpaceUsedByKernelSpace;
    }

    public Double getChangeThePriorityOfThePercentageOfCPUProcess() {
        return changeThePriorityOfThePercentageOfCPUProcess;
    }

    public void setChangeThePriorityOfThePercentageOfCPUProcess(Double changeThePriorityOfThePercentageOfCPUProcess) {
        this.changeThePriorityOfThePercentageOfCPUProcess = changeThePriorityOfThePercentageOfCPUProcess;
    }

    public Double getIdleCPUPercentage() {
        return idleCPUPercentage;
    }

    public void setIdleCPUPercentage(Double idleCPUPercentage) {
        this.idleCPUPercentage = idleCPUPercentage;
    }

    public Double getPercentageOfIOWaitingForCPU() {
        return percentageOfIOWaitingForCPU;
    }

    public void setPercentageOfIOWaitingForCPU(Double percentageOfIOWaitingForCPU) {
        this.percentageOfIOWaitingForCPU = percentageOfIOWaitingForCPU;
    }

    public Double getHardwareIRQ() {
        return hardwareIRQ;
    }

    public void setHardwareIRQ(Double hardwareIRQ) {
        this.hardwareIRQ = hardwareIRQ;
    }

    public Double getSoftwareInterrupts() {
        return softwareInterrupts;
    }

    public void setSoftwareInterrupts(Double softwareInterrupts) {
        this.softwareInterrupts = softwareInterrupts;
    }

    public int getTotalPhysicalMemory() {
        return totalPhysicalMemory;
    }

    public void setTotalPhysicalMemory(int totalPhysicalMemory) {
        this.totalPhysicalMemory = totalPhysicalMemory;
    }

    public int getFreeMemoryTotal() {
        return freeMemoryTotal;
    }

    public void setFreeMemoryTotal(int freeMemoryTotal) {
        this.freeMemoryTotal = freeMemoryTotal;
    }

    public int getInUseOfMemory() {
        return inUseOfMemory;
    }

    public void setInUseOfMemory(int inUseOfMemory) {
        this.inUseOfMemory = inUseOfMemory;
    }

    public int getCachedMemory() {
        return cachedMemory;
    }

    public void setCachedMemory(int cachedMemory) {
        this.cachedMemory = cachedMemory;
    }

    public int getSwapTotal() {
        return swapTotal;
    }

    public void setSwapTotal(int swapTotal) {
        this.swapTotal = swapTotal;
    }

    public int getSwapFree() {
        return swapFree;
    }

    public void setSwapFree(int swapFree) {
        this.swapFree = swapFree;
    }

    public int getSwapUsed() {
        return swapUsed;
    }

    public void setSwapUsed(int swapUsed) {
        this.swapUsed = swapUsed;
    }

    public int getSwapAvailMem() {
        return swapAvailMem;
    }

    public void setSwapAvailMem(int swapAvailMem) {
        this.swapAvailMem = swapAvailMem;
    }

    @Override
    public String toString() {
        return "Top{" +
                "systemBootTime='" + systemBootTime + '\'' +
                ", numberOfUsers=" + numberOfUsers +
                ", loadAverageOneMinute='" + loadAverageOneMinute + '\'' +
                ", loadAverageFiveMinute='" + loadAverageFiveMinute + '\'' +
                ", loadAverageFifteenMinute='" + loadAverageFifteenMinute + '\'' +
                ", totalTasks=" + totalTasks +
                ", runningTasks=" + runningTasks +
                ", sleepingTasks=" + sleepingTasks +
                ", stoppedTasks=" + stoppedTasks +
                ", zombieTasks=" + zombieTasks +
                ", userSpacePercentageOfCPU=" + userSpacePercentageOfCPU +
                ", percentageOfCPUSpaceUsedByKernelSpace=" + percentageOfCPUSpaceUsedByKernelSpace +
                ", changeThePriorityOfThePercentageOfCPUProcess=" + changeThePriorityOfThePercentageOfCPUProcess +
                ", idleCPUPercentage=" + idleCPUPercentage +
                ", percentageOfIOWaitingForCPU=" + percentageOfIOWaitingForCPU +
                ", hardwareIRQ=" + hardwareIRQ +
                ", softwareInterrupts=" + softwareInterrupts +
                ", totalPhysicalMemory=" + totalPhysicalMemory +"KB"+
                ", freeMemoryTotal=" + freeMemoryTotal +"KB"+
                ", inUseOfMemory=" + inUseOfMemory +"KB"+
                ", cachedMemory=" + cachedMemory +"KB"+
                ", swapTotal=" + swapTotal +"KB"+
                ", swapFree=" + swapFree+"KB" +
                ", swapUsed=" + swapUsed +"KB"+
                ", swapAvailMem=" + swapAvailMem+"KB" +
                '}';
    }

    public String toStringZH() {
        return "系统基本信息{" +
                "系统开机时间='" + systemBootTime + '\'' +
                ", 登陆用户数=" + numberOfUsers +
                ", 1分钟loadAverage='" + loadAverageOneMinute + '\'' +
                ", 5分钟loadAverage='" + loadAverageFiveMinute + '\'' +
                ", 15分钟loadAverage='" + loadAverageFifteenMinute + '\'' +
                ", 总任务数=" + totalTasks +
                ", 运行的任务数=" + runningTasks +
                ", 休眠的任务数=" + sleepingTasks +
                ", 已停止的任务数=" + stoppedTasks +
                ", 僵尸状态=" + zombieTasks +
                ", 用户空间占用CPU的百分比=" + userSpacePercentageOfCPU +
                ", 内核空间占用CPU的百分比=" + percentageOfCPUSpaceUsedByKernelSpace +
                ", 改变过优先级的进程占用CPU的百分比=" + changeThePriorityOfThePercentageOfCPUProcess +
                ", 空闲CPU百分比=" + idleCPUPercentage +
                ",  IO等待占用CPU的百分比=" + percentageOfIOWaitingForCPU +
                ", 硬中断占用CPU的百分比=" + hardwareIRQ +
                ",  软中断占用CPU的百分比=" + softwareInterrupts +
                ", 物理内存总量=" + totalPhysicalMemory +"KB"+
                ", 空闲内存总量=" + freeMemoryTotal +"KB"+
                ", 使用中的内存总量=" + inUseOfMemory+"KB" +
                ", 缓存的内存量=" + cachedMemory +"KB"+
                ", 交换区总量=" + swapTotal +"KB"+
                ", 空闲交换区总量=" + swapFree+"KB" +
                ", 使用的交换区总量=" + swapUsed +"KB"+
                ", 缓冲的交换区总量=" + swapAvailMem+"KB" +
                '}';
    }
}
