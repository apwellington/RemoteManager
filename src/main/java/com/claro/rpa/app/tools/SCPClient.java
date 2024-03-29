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

        this.session = this.ssh.getSession();
        this.session.setPassword(this.ssh.getPassword());
        this.session.setConfig("StrictHostKeyChecking", "no");

        try {
            channel = (ChannelSftp)session.openChannel("sftp");
        } catch (JSchException e) {
            e.printStackTrace();
        }
    }

    public void copyFileTO(String remotePath, String localPath, String filename) throws JSchException, SftpException, FileNotFoundException {
        localPath = localPath + "\\" + filename;
        channel.connect();
        localFile = new File(localPath);
        channel.cd(remotePath);
        channel.put(new FileInputStream(localFile),localFile.getName());
        channel.disconnect();
        session.disconnect();
    }

    public void copyDirTO(String remotePath, String localPath) throws JSchException, SftpException, FileNotFoundException {
        channel.connect();
        channel.cd(remotePath);
        channel.put(new FileInputStream(localPath), localFile.getName());
        channel.disconnect();
        session.disconnect();
    }


}
