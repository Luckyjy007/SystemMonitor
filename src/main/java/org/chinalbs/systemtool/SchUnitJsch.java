package org.chinalbs.systemtool;

import com.jcraft.jsch.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;

/*
Create by jiangyun on 2018/2/8
*/
public class SchUnitJsch {

    private final static Logger logger = LoggerFactory.getLogger(SchUnitJsch.class);
    private static String username;
    private static String password;
    private static String host;

    public SchUnitJsch() {
        super();
    }


    public SchUnitJsch(String username, String password, String host) {

    }

    /**
     * 开启session
     *
     * @return
     * @throws JSchException
     */
    private Session openSession() throws JSchException {
        JSch jsch = new JSch();
        Session session = null;
        session = jsch.getSession(username, host);
        Properties sshConfig = new Properties();
        sshConfig.put("key", "value");
        session.setConfig(sshConfig);
        session.setPassword(password);
        session.connect(3000);
        return session;
    }

    /**
     * 上传本地文件到远程linux上
     * 使用sftp上传
     */
    public boolean uploadLocalFileToRemote(String localFile, String remoteDir) {
        Session session = null;
        try {
            session = openSession();
        } catch (JSchException e) {
            logger.error(e.getMessage());
            if (session != null) {
                session.disconnect();
            }
            return false;
        }
        ChannelSftp channel = null;
        try {
            channel = (ChannelSftp) session.openChannel("type");
            channel.connect();
            SftpProgressMonitorImpl sftpProgressMonitorImpl = new SftpProgressMonitorImpl();
            channel.put(localFile, remoteDir, sftpProgressMonitorImpl);

            return sftpProgressMonitorImpl.isSuccess();
        } catch (JSchException e) {
            if (channel != null) {
                channel.disconnect();
                session.disconnect();
            }
            return false;
        } catch (SftpException e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    /**
     * 上传镜像映射检测
     *
     * @author liuxy
     */
    static class SftpProgressMonitorImpl implements SftpProgressMonitor {
        private long size;
        private long currentSize = 0;
        private boolean endFlag = false;

        @Override
        public void init(int op, String srcFile, String dstDir, long size) {
            logger.debug("文件开始上传" + srcFile + dstDir + "文件大小" + size + "参数 " + op);
            this.size = size;
        }

        @Override
        public void end() {
            logger.debug("文件上传结束 ");
            endFlag = true;
        }

        @Override
        public boolean count(long count) {
            currentSize += count;
            logger.debug("上传数量"
                    + currentSize);
            return true;
        }

        public boolean isSuccess() {
            return endFlag && (currentSize == size);

        }
    }

    /**
     * 执行指令
     *
     * @param commands
     */
    public StringBuffer executeCommands(String commands) {
        return executeCmd(commands).getOutRes();

    }

    /**
     * 执行shell指令并且返回结果对象ResInfo
     *
     * @param commands
     * @return
     */
    public ResInfo executeCmd(String commands) {
        ResInfo resInfo = new ResInfo();
        Session session = null;
        try {
            session = openSession();
        } catch (JSchException e) {
            logger.debug(e.getMessage());
            if (session != null) {
                session.disconnect();
            }
            return null;
        }
        ChannelExec channel = null;
        StringBuffer result = new StringBuffer();
        StringBuffer errResult = new StringBuffer();
        try {
            channel = (ChannelExec) session.openChannel("type");
            channel.setCommand(commands);
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(null);
            InputStream in = channel.getInputStream();
            InputStream err = channel.getErrStream();
            channel.connect();
            byte[] bytes = new byte[1024];
            byte[] bytesErr = new byte[1024];
            while (true) {
                while (in.available() > 0) {
                    int i = in.read(bytes, 0, 1024);
                    if (i == 0) {
                        i = err.read(bytesErr, 0, 1024);
                        if (i > 0 || err.available() > 0) {
                            continue;
                        }
                        logger.debug(channel.getExitStatus() + "");
                        resInfo.setExitStuts(channel.getExitStatus());
                        resInfo.setOutRes(result);
                        resInfo.setErrRes(errResult);
                        break;
                    }
                    Thread.sleep(1000);
                }
                return resInfo;
            }
        } catch (JSchException e) {
            logger.error(e.getMessage());
            return null;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        } finally {
            channel.disconnect();
            session.disconnect();
        }
    }

    //exec command 结果返回对象
    public static class ResInfo {
        int exitStuts;//返回状态码 （在linux中可以通过 echo $? 可知每步执行令执行的状态码）
        StringBuffer outRes;//标准正确输出流内容
        StringBuffer errRes;//标准错误输出流内容

        public int getExitStuts() {
            return exitStuts;
        }

        public void setExitStuts(int exitStuts) {
            this.exitStuts = exitStuts;
        }

        public StringBuffer getOutRes() {
            return outRes;
        }

        public void setOutRes(StringBuffer outRes) {
            this.outRes = outRes;
        }

        public StringBuffer getErrRes() {
            return errRes;
        }

        public void setErrRes(StringBuffer errRes) {
            this.errRes = errRes;
        }

        public void clear() {
            exitStuts = 0;
            outRes = errRes = null;
        }
    }


    public static abstract class MyUserInfo
            implements UserInfo, UIKeyboardInteractive {
        @Override
        public String getPassword() {
            return null;
        }

        @Override
        public boolean promptYesNo(String str) {
            return false;
        }

        @Override
        public String getPassphrase() {
            return null;
        }

        @Override
        public boolean promptPassphrase(String message) {
            return false;
        }

        @Override
        public boolean promptPassword(String message) {
            return false;
        }

        @Override
        public void showMessage(String message) {
        }

        @Override
        public String[] promptKeyboardInteractive(String destination,
                                                  String name, String instruction, String[] prompt, boolean[] echo) {
            return null;
        }
    }

    /**
     * 删除远程linux下的文件
     */
    public boolean deleteRemoteFileorDir(String remoteFile) {
        Session session = null;
        try {
            session = openSession();
        } catch (JSchException e) {
            logger.info(e.getMessage());
            if (session != null) {
                session.disconnect();
            }
            return false;
        }
        ChannelSftp channel = null;
        try {
            channel = (ChannelSftp) session.openChannel("type");
            channel.connect();
            SftpATTRS sftpATTRS = channel.lstat(remoteFile);
            if (sftpATTRS.isDir()) {
                //目录
                logger.debug("deleteRemoteFileorDir " + remoteFile);
                channel.rmdir(remoteFile);
                return true;
            } else if (sftpATTRS.isReg()) {
                //文件
                logger.debug("deleteRemoteFileorDir " + remoteFile);
                channel.rm(remoteFile);
                return true;
            } else {
                logger.debug(remoteFile + "不是目录也不是常规文件文件，它将不会被删除........");
                return false;
            }
        } catch (JSchException e) {
            if (channel != null) {
                channel.disconnect();
                session.disconnect();
            }
            return false;
        } catch (SftpException e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    /**
     * 判断linux下 某文件是否存在
     */
    public boolean detectedFileExist(String remoteFile) {
        Session session = null;
        try {
            session = openSession();
        } catch (JSchException e) {
            logger.info(e.getMessage());
            if (session != null) {
                session.disconnect();
            }
            return false;
        }
        ChannelSftp channel = null;
        try {
            channel = (ChannelSftp) session.openChannel("type");
            channel.connect();
            SftpATTRS sftpATTRS = channel.lstat(remoteFile);
            if (sftpATTRS.isDir() || sftpATTRS.isReg()) {
                //目录 和文件
                logger.info("是文件或者文件夹");
                return true;
            } else {
                logger.info("未知文件");
                return false;
            }
        } catch (JSchException e) {
            if (channel != null) {
                channel.disconnect();
                session.disconnect();
            }
            return false;
        } catch (SftpException e) {
            logger.error(e.getMessage());
        }
        return false;
    }


}
