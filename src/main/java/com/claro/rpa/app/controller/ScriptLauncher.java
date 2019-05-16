package com.claro.rpa.app.controller;

import com.claro.rpa.app.model.RpaRobot;
import com.claro.rpa.app.model.RpaUser;
import com.claro.rpa.app.service.RobotService;
import com.claro.rpa.app.service.UserService;
import com.claro.rpa.app.service.UserServiceImpl;
import com.claro.rpa.app.tools.ConfigLoader;
import com.claro.rpa.app.tools.SCPClient;
import com.claro.rpa.app.tools.SSHClient;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Logger;

//Enviar comando por la url
@RestController
@RequestMapping("/launcher")
public class ScriptLauncher {

    private static final Logger LOGGER = Logger.getLogger(ScriptLauncher.class.getName());
    File config = new File("src\\main\\resources\\config.properties");
    ConfigLoader properties = new ConfigLoader(config);
    //String  localPath = properties.getLocalPath();
    //String remotePath = properties.getRemotePath();
    //test data
    String local = "C:\\";
    String remote = "/C:/Users/IEUser/Desktop/share";
    String file1 = "main.exe";
    String file2 = "block_notas.exe";

    SSHClient sshClient;
    SCPClient scp;

    @Autowired
    RobotService robotService;

    @Autowired
    UserServiceImpl userService;


    @RequestMapping(value = "/cmd/{command}")
    @ResponseBody
    public String exec(@PathVariable("command") String cmd){
        SSHClient sshClient = new SSHClient("ieuser","Passw0rd!", 22, "192.168.56.101");
        Object obj  = sshClient.execCommand(cmd);
        return obj.toString();
    }

    //80% completado
    @PostMapping(value = "/run/{botId}")
    @ResponseBody
    public String runBot(@PathVariable("botId") int botId, @RequestParam String pass) throws IOException {
        System.out.println("Metodo Run");
        Object current = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        //if (current instanceof UserDetails) {
            username = ((UserDetails)current).getUsername(); // revisar porque devuelve el id
            RpaUser user = userService.findById(Integer.parseInt(username)).get();
            SSHClient sshClient = new SSHClient(user.getUsername(),pass, 22, user.getDnsAddress());
            StringBuilder sb = new StringBuilder();
            RpaRobot robot = robotService.findById(botId).get();
            copyBot(user.getShareDirectoryPath(),local,robot.getName());

            sb.append("cmd");
            sb.append(" ");
            sb.append(user.getShareDirectoryPath());
            sb.append("test.exe");
            //sb.append(robotService.findById(botId)); Cuando este en la base de datos el bot
            String command = sb.toString();
            System.out.println("Comando: " + command);

            String calc = "cmd /c "+user.getShareDirectoryPath()+robot.getName();
            System.out.println("Comando 2: " + calc);
            List<Object> res = sshClient.execCommand("cmd /C:/Users/IEUser/Desktop/share/block_notas.exe");
       // }



        return "Resultado: " + ((DataInputStream)res.get(0)) + " -- " + ((BufferedReader) res.get(1)).read() + " -- " +((DataOutputStream)res.get(2)).size();
    }



    //Copiar Archvio
    @RequestMapping(value = "/copy/{filename}")
    public Object copyFile(@PathVariable("filename") String filename){
        return copyBot(remote, local, file2);
    }


    public Object copyBot(String remotePath, String localPath , String filename){
        try {
            sshClient = new SSHClient("ieuser","Passw0rd!", 22, "192.168.56.101");
            scp = new SCPClient(sshClient);
            System.out.println(remotePath+" "+localPath+" "+filename);
            scp.copyFileTO(remotePath, localPath, filename);

        } catch (IOException | JSchException | SftpException e) {
            e.printStackTrace();
        }
        return "Copiado";
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
