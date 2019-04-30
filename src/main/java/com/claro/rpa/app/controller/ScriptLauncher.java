package com.claro.rpa.app.controller;

import com.claro.rpa.app.tools.SCPClient;
import com.claro.rpa.app.tools.SSHClient;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
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
    @RequestMapping(value = "/send")
    public Object copyFile(){
        String remotePath = "";
        String localPath = "";
        LOGGER.info("Crear Cliente SCP");
        SCPClient scp = new SCPClient();
        SSHClient sshClient = new SSHClient("ieuser","Passw0rd!", 22, "192.168.56.101");

        try {
            scp.copyDirTO(sshClient, remotePath, localPath);
        } catch (JSchException e) {
            e.printStackTrace();
        } catch (SftpException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "mundo";
    }
}
