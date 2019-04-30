package com.claro.rpa.app.controller;

import com.claro.rpa.app.tools.ConfigLoader;
import com.claro.rpa.app.tools.SCPClient;
import com.claro.rpa.app.tools.SSHClient;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.logging.Logger;

//Enviar comando por la url
@RestController
@RequestMapping("/launcher")
public class ScriptLauncher {
    private static final Logger LOGGER = Logger.getLogger(ScriptLauncher.class.getName());
    File config = new File("src\\main\\resources\\config.properties");
    String localPath;
    String remotePath;
    ConfigLoader properties;
    SSHClient sshClient;
    SCPClient scp;


    @RequestMapping(value = "/cmd/{command}")
    @ResponseBody
    public String exec(@PathVariable("command") String cmd){
        SSHClient sshClient = new SSHClient("ieuser","Passw0rd!", 22, "192.168.56.101");
        Object obj  = sshClient.execCommand(cmd);
        return obj.toString();
    }

    //Copiar Archvio
    @RequestMapping(value = "/send/{filename}")
    public Object copyFile(@PathVariable("filename") String filename){
        LOGGER.info("Inicio del Metodo");



        try {
            properties = new ConfigLoader(config);
            remotePath = properties.getRemotePath();
            localPath = properties.getLocalPath();
            //datos proveniente de la base de datos
            sshClient = new SSHClient("ieuser","Passw0rd!", 22, "192.168.56.101");
            scp = new SCPClient(sshClient);
            scp.copyFileTO(remotePath, localPath, filename);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSchException e) {
            e.printStackTrace();
        } catch (SftpException e) {
            e.printStackTrace();
        }
        return "/";
    }

    //Copiar Directorio
    public Object copyDir(){
        LOGGER.info("Inicio del Metodo");
        String localPath;
        String remotePath;
        ConfigLoader properties;

        try {
            properties = new ConfigLoader(config);
            remotePath = properties.getRemotePath();
            localPath = properties.getLocalPath();
            //datos proveniente de la base de datos
            sshClient = new SSHClient("ieuser","Passw0rd!", 22, "192.168.56.101");
            scp = new SCPClient(sshClient);
            scp.copyDirTO(remotePath, localPath);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSchException e) {
            e.printStackTrace();
        } catch (SftpException e) {
            e.printStackTrace();
        }
        return "/";
    }


}
