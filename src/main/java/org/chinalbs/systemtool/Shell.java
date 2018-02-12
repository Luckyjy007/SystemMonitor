package org.chinalbs.systemtool;

import com.jcraft.jsch.*;
import org.apache.commons.io.IOUtils;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Properties;

/*
Create by jiangyun on 2018/2/8
*/
public class Shell {


    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Shell.class);
    //远程主机的ip地址
    private String ip;
    //远程主机登录用户名
    private String username;
    //远程主机的登录密码
    private String password;
    //设置ssh连接的远程端口
    private int port = 22;
    //保存输出内容的容器
    private ArrayList<String> stdout;
    private Properties config;

    /**
     * 初始化登录信息
     *
     * @param ip
     * @param username
     * @param password
     */
    public Shell(final String ip, final String username, final String password, final int port) {
        this.ip = ip;
        this.username = username;
        this.password = password;
        stdout = new ArrayList<String>();
        this.config = new Properties();
        this.port = port;
    }

    public Shell(final String ip, final String username, final String password) {
        this.ip = ip;
        this.username = username;
        this.password = password;
        stdout = new ArrayList<String>();
        this.config = new Properties();
    }

    /**
     * 执行shell命令
     *
     * @param command
     * @return
     */
    public int execute(final String command) {
        int returnCode = 0;
        JSch jsch = new JSch();
        MyUserInfo userInfo = new MyUserInfo();


        try {
            //创建session并且打开连接，因为创建session之后要主动打开连接
            Session session = jsch.getSession(username, ip, port);
            session.setPassword(password);
            session.setUserInfo(userInfo);
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.setTimeout(6000);
            session.connect();

            //打开通道，设置通道类型，和执行的命令
            Channel channel = session.openChannel("exec");
            ChannelExec channelExec = (ChannelExec) channel;
            channelExec.setCommand(command);
            channelExec.setErrStream(System.err);
            channelExec.setInputStream(null);
            channelExec.connect();


            // InputStream inputStream = channelExec.getInputStream();
            //  String out = IOUtils.toString(inputStream, "UTF-8");
            BufferedReader input = new BufferedReader(new InputStreamReader
                    (channelExec.getInputStream()));


            System.out.println("The remote host "+ip +" command is :" + command);

            //接收远程服务器执行命令的结果
            String line;
            while ((line = input.readLine()) != null) {
                stdout.add(line);
            }
            input.close();

            // 得到returnCode
            if (channelExec.isClosed()) {
                returnCode = channelExec.getExitStatus();
            }

            // 关闭通道
            channelExec.disconnect();
            //关闭session
            session.disconnect();

        } catch (JSchException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnCode;
    }

    /**
     * get stdout
     *
     * @return
     */
    public ArrayList<String> getStandardOutput() {
        return stdout;
    }

    public static void main(final String[] args) {
        Shell shell = new Shell("172.169.0.89", "root", "cloud@us12", 22);
        //shell.execute("/opt/jdk1.8.0_152/bin/jps" );//记得做软连接
        // shell.execute("top -bcn 1");//直接top不可以 top试试刷新的
        //      shell.execute("sar -P ALL ");
        //shell.execute("ps  aux ");
        // shell.execute("jps" );
        //shell.execute("hadoop fs -mkdir /hadooptest" );
        shell.execute("sensors");//.yum install lm_sensors;sensors-detect .sensors 需要安装sensors
        //   shell.execute("du sh *" );
        //shell.execute("pwd" );
        // shell.execute("ps -eLf | grep java |wc -l" );
        // shell.execute("ps -eLf | grep java " );

        ArrayList<String> stdout = shell.getStandardOutput();

        for (String str : stdout) {
            System.out.println(str);
        }
    }

}
