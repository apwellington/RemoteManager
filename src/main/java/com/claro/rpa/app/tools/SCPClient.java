package com.claro.rpa.app.tools;


import com.claro.rpa.app.controller.ScriptLauncher;
import com.jcraft.jsch.*;

import java.io.*;
import java.util.Properties;
import java.util.logging.Logger;

public class SCPClient {
    private static final Logger LOGGER = Logger.getLogger(ScriptLauncher.class.getName());
    JSch jsch;
    Session session;
    ChannelSftp channel;
    File localFile;
    SSHClient ssh;

    public SCPClient(SSHClient ssh) {
        this.jsch = new JSch();
        this.ssh = ssh;
    }

    public SCPClient() {

    }

    public void copyFileTO(String remotePath, String localPath) throws JSchException, SftpException, FileNotFoundException {
        session = this.ssh.getSession();
        session.setPassword(this.ssh.getPassword());
        session.setConfig("StrictHostKeyChecking", "no");
        //session.connect();
        channel = (ChannelSftp)session.openChannel("sftp");
        channel.connect();
        localFile = new File(localPath);
        //If you want you can change the directory using the following line.
        //"//C:"
        channel.cd(remotePath);
        channel.put(new FileInputStream(localFile),localFile.getName());
        channel.disconnect();
        session.disconnect();
    }

    public void copyDirTO(SSHClient ssh, String remotePath, String localPath) throws JSchException, SftpException, FileNotFoundException {
        JSch jsch = new JSch();
        Session session = null;
        session = ssh.getSession();
        session.setPassword(ssh.getPassword());
        session.setConfig("StrictHostKeyChecking", "no");
        //session.connect();
        ChannelSftp channel = null;
        channel = (ChannelSftp)session.openChannel("sftp");
        channel.connect();
        File localFile = new File(localPath);
        //If you want you can change the directory using the following line.
        //"//C:"
        channel.cd(remotePath);
        channel.put(new FileInputStream(localFile),localFile.getName());
        channel.disconnect();
        session.disconnect();
    }


}
