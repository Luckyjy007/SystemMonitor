package org.chinalbs.systemtool;

import org.chinalbs.systemtool.bean.Top;
import org.hyperic.sigar.cmd.Free;
import sun.plugin2.gluegen.runtime.CPU;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
Create by jiangyun on 2018/2/11
*/
public class Command {

    private static Map<String, String> shellParams;
    private static String username;
    private static int port;
    private static List<Shell> hosts;
    private static String ipParams;
    private static String password;

    private static final String TOP = "top";
    private static final String LS = "ls";
    private static final String LL = "ll";
    private static final String JPS = "jps";
    private static final String SENSORS = "sensors";
    private static final String PS = "ps";
    private static final String PWD = "pwd";
    private static final String DU = "du";

    static {
        shellParams = ShellConf.getShellParams();
        ipParams = shellParams.get("ip");
        port = Integer.parseInt(shellParams.get("port"));
        username = shellParams.get("username");
        password = shellParams.get("password");
    }


    private static List<Shell> getHostInstances() {
        hosts = new ArrayList<Shell>(10);
        String[] ips = ipParams.split(",");
        for (String ip : ips) {

            Shell shell = new Shell(ip, username, password, port);
            hosts.add(shell);

        }

        return hosts;

    }



    public static String execute( String command) {
        List<Shell> hostInstances = getHostInstances();
        for (Shell shell : hostInstances) {
            judgeCommandAndRun(shell, command);
        }

        return "";
    }

    public static Shell judgeCommandAndRun(Shell shell, String command) {
        if (null == command || "" == command) {
            throw new IllegalArgumentException("linux 命令不能为空");
        }
        if (command.startsWith(TOP)) {
            execTop(shell, command);
        }
        return shell;
    }

    private static int execTop(Shell shell, String command) {

        ArrayList<String> standardOutput = shell.execute(command);
        String line1 = standardOutput.get(0);
        String line2 = standardOutput.get(1);
        String line3 = standardOutput.get(2);
        String line4 = standardOutput.get(3);
        String line5 = standardOutput.get(4);


        String[] line1s = line1.split(",");
        String systemBootTime = line1s[0].split("up")[1] + line1s[1];
        Integer numberOfUsers = Integer.parseInt(line1s[2].trim().split(" ")[0].trim());
        String loadAverageOneMinute = line1s[3].split(":")[1];
        String loadAverageFiveMinute = line1s[4];
        String loadAverageFifteenMinute = line1s[5];


        String[] line2s = line2.split(",");
        Integer totalTasks = Integer.parseInt(line2s[0].replace("Tasks:", "").replace("total", "").trim());
        int runningTasks = Integer.parseInt(line2s[1].replace("running", "").trim());
        int sleepingTasks = Integer.parseInt(line2s[2].replace("sleeping", "").trim());
        int stoppedTasks = Integer.parseInt(line2s[3].replace("stopped", "").trim());
        int zombieTasks = Integer.parseInt(line2s[4].replace("zombie", "").trim());


        String[] line3s = line3.split(",");
        Double userSpacePercentageOfCPU = Double.parseDouble(line3s[0].split(":")[1].replace("us", "").trim());
        Double percentageOfCPUSpaceUsedByKernelSpace = Double.parseDouble(line3s[1].replace("sy", "").trim());
        Double changeThePriorityOfThePercentageOfCPUProcess = Double.parseDouble(line3s[2].replace("ni", "").trim());
        Double idleCPUPercentage = Double.parseDouble(line3s[3].replace("id", "").trim());
        Double percentageOfIOWaitingForCPU = Double.parseDouble(line3s[4].replace("wa", "").trim());
        Double hardwareIRQ = Double.parseDouble(line3s[5].replace("hi", "").trim());
        Double softwareInterrupts = Double.parseDouble(line3s[6].replace("si", "").trim());

        String[] line4s = line4.split(",");
        int totalPhysicalMemory = Integer.parseInt(line4s[0].split(":")[1].replace("total", "").trim());
        int freeMemoryTotal = Integer.parseInt(line4s[1].replace("free", "").trim());
        int inUseOfMemory = Integer.parseInt(line4s[2].replace("used", "").trim());
        int cachedMemory = Integer.parseInt(line4s[3].replace("buff/cache", "").trim());


        String[] line5s = line5.split(",");
        int swapTotal = Integer.parseInt(line5s[0].split(":")[1].replace("total", "").trim());
        int swapFree = Integer.parseInt(line5s[1].replace("free", "").trim());
        String[] useds = line5s[2].split("used.");
        int swapUsed = Integer.parseInt(useds[0].trim());
        int swapAvailMem = Integer.parseInt(useds[1].replace("avail Mem", "").trim());


        Top systemInfo = new Top(systemBootTime, numberOfUsers, loadAverageOneMinute,
                loadAverageFiveMinute, loadAverageFifteenMinute, totalTasks, runningTasks, sleepingTasks,
                stoppedTasks, zombieTasks, userSpacePercentageOfCPU, percentageOfCPUSpaceUsedByKernelSpace,
                changeThePriorityOfThePercentageOfCPUProcess, idleCPUPercentage, percentageOfIOWaitingForCPU,
                hardwareIRQ, softwareInterrupts, totalPhysicalMemory, freeMemoryTotal, inUseOfMemory, cachedMemory,
                swapTotal, swapFree, swapUsed,
                swapAvailMem);
        System.out.println(systemInfo.toStringZH());
        return 1;
    }

    private static Shell execLs(Shell shell, String command) {
        shell.execute(command);
        ArrayList<String> standardOutput = shell.getStandardOutput();
        return shell;
    }

    private static Shell execLL(Shell shell, String command) {
        shell.execute(command);
        ArrayList<String> standardOutput = shell.getStandardOutput();
        return shell;
    }

    private static Shell execJps(Shell shell, String command) {
        shell.execute(command);
        ArrayList<String> standardOutput = shell.getStandardOutput();
        return shell;
    }

    private static Shell execSensors(Shell shell, String command) {
        shell.execute(command);
        ArrayList<String> standardOutput = shell.getStandardOutput();
        return shell;
    }

    private static Shell execPs(Shell shell, String command) {
        shell.execute(command);
        ArrayList<String> standardOutput = shell.getStandardOutput();
        return shell;
    }

    private static Shell execPwd(Shell shell, String command) {
        shell.execute(command);
        ArrayList<String> standardOutput = shell.getStandardOutput();
        return shell;
    }

    private static Shell execDu(Shell shell, String command) {
        shell.execute(command);
        ArrayList<String> standardOutput = shell.getStandardOutput();
        return shell;
    }

    public static void main(String[] args) {

execute("top -bcn 1");
    }
}


