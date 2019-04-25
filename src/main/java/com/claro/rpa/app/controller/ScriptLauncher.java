package com.claro.rpa.app.controller;

import com.claro.rpa.app.tools.SSHClient;
import org.springframework.web.bind.annotation.*;
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
    @RequestMapping(value = "/launcger/send")
    @ResponseBody
    public String copyFile(){
        return "copiado";
    }
}
