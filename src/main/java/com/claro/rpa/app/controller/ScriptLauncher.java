package com.claro.rpa.app.controller;

import com.claro.rpa.app.tools.SCPClient;
import com.claro.rpa.app.tools.SSHClient;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.Properties;
import java.util.logging.Logger;

@RestController
@RequestMapping("/launcher")
public class ScriptLauncher {
    private static final Logger LOGGER = Logger.getLogger(ScriptLauncher.class.getName());

    //Enviar comando por la url
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
        String localPath;
        String remotePath;
        Properties prop = new Properties();
        try {
            File config = new File("src\\main\\resources\\config.properties");
            //load a properties file from class path, inside static method
            LOGGER.info("Cargando Propiedades" + config.getAbsolutePath());
            prop.load(new FileInputStream(config.getAbsolutePath()));
            remotePath = prop.getProperty("remote_path");
            LOGGER.info("Directorio Remoto: "+ remotePath);
            localPath = prop.getProperty("local_path");
            LOGGER.info("Direcotrio Local: " + localPath);
            localPath = localPath + "\\" + filename;
            LOGGER.info("Nombre Del Archivo: "+ filename);

            SSHClient sshClient = new SSHClient("ieuser","Passw0rd!", 22, "192.168.56.101");
            SCPClient scp = new SCPClient(sshClient);

            scp.copyFileTO(remotePath, localPath);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSchException e) {
            e.printStackTrace();
        } catch (SftpException e) {
            e.printStackTrace();
        }
        return "mundo";
    }
}
