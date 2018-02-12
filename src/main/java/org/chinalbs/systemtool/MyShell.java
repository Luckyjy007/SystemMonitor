package org.chinalbs.systemtool;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
Create by jiangyun on 2018/2/11
*/
public class MyShell {

    private static Map<String, String> shellParams;
    private static String username;
    private static int port;
    private static List<Shell> hosts;
    private static String ipParams;
    private static String password;

   static  {
        shellParams = ShellConf.getShellParams();
        ipParams = shellParams.get("ip");
        port = Integer.parseInt(shellParams.get("port"));
        username =shellParams.get("username");
        password =shellParams.get("password");
    }

    public static List<Shell> getHostInstances() {
        hosts = new ArrayList<Shell>(10);
        String[] ips = ipParams.split(",");
        for (String ip : ips) {

            Shell shell = new Shell(ip,username,password,port);
            hosts.add(shell);

        }

        return hosts;

    }



    public static int execute(String command){
        int returnCode = 0;
        hosts = getHostInstances();
   for (Shell shell:hosts){
       shell.execute(command);
       ArrayList<String> standardOutput = shell.getStandardOutput();
       int lineNumber = 0;
       for (String s :standardOutput){
           System.out.print("line "+(++lineNumber)+"\t");
           System.out.println(s);
       }
   }

   return returnCode; }

   private static String judgeCommand(String command){

       return null;
   }

    public static void main(String[] args) {

        execute("ps -aux");
    }

}
