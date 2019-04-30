package com.claro.rpa.app.tools;

import com.claro.rpa.app.controller.ScriptLauncher;
import com.jcraft.jsch.*;
import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.util.Hashtable;
import java.util.logging.Logger;

//"cmd.exe /c calc"
public class SSHClient {
    private static final java.util.logging.Logger LOGGER = Logger.getLogger(ScriptLauncher.class.getName());
    @Getter @Setter private String username;
    @Getter @Setter private String password;
    @Getter @Setter private int port;
    @Getter @Setter private String host;
    private JSch jsch;
    private Session session;
    private  Channel channel;

    DataInputStream dataIn = null;
    BufferedReader reader = null;
    DataOutputStream dataOut = null;

    Hashtable<String, Object> commandResult;

    public SSHClient(String username, String password, int port, String host) {
        this.username = username;
        this.password = password;
        this.port = port;
        this.host = host;
        jsch = new JSch();
    }


    public Session getSession(){
            try {
                this.session = this.jsch.getSession(this.username,this.host,this.port);
                this.session.setPassword(this.password);
                this.session.setConfig("StrictHostKeyChecking", "no");
                this.session.connect();
            } catch (JSchException e) {
                e.printStackTrace();
            }
        return this.session;
    }

    public Channel getChannel(String type){

            try {
                this.channel = getSession().openChannel(type);
            } catch (JSchException e) {
                e.printStackTrace();
            }

        return this.channel;
    }


    public Hashtable execCommand(String command){
        try {
            Channel chann = getChannel("exec");
            ((ChannelExec)chann).setCommand(command);
            chann.connect();

            this.dataIn = new DataInputStream(channel.getInputStream());
            this.reader = new BufferedReader(new InputStreamReader(dataIn));
            this.dataOut = new DataOutputStream(channel.getOutputStream());
            this.dataOut.writeBytes("Hola Mundo \r\n");

            this.commandResult = new Hashtable<String, Object>();
            commandResult.put("dataInput", this.dataIn);
            commandResult.put("dataReader", this.reader);
            commandResult.put("dataInput", this.dataOut);

        } catch (JSchException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return commandResult;
    }

}




