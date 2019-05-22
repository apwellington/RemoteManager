package com.claro.rpa.app.controller;

import com.claro.rpa.app.Auxiliar;
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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

//Enviar comando por la url
@RestController
@RequestMapping("/launcher")
public class ScriptLauncher {
    private static final Logger LOGGER = Logger.getLogger(ScriptLauncher.class.getName());
    SSHClient sshClient;
    SCPClient scp;
    final File config = new File("src\\main\\resources\\config.properties");
    Properties properties;
    StringBuilder sb;


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

    //90% completado
    @PostMapping(value = "/run/{botId}")
    @ResponseBody
    public String runBot(@PathVariable("botId") int botId, @RequestParam String pass) throws IOException {
        String salida = "Ha Fallado";
        RpaRobot robot = robotService.findById(botId).get();
        LOGGER.info("Iniciando Metodo Run, para el robot" + robot.getName());
        Object current = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        properties = new Properties();
        properties.load(new FileInputStream(config.getAbsolutePath()));

        if (current instanceof UserDetails) {
            String username = ((UserDetails)current).getUsername(); // revisar porque devuelve el id
            RpaUser user = userService.findById(Integer.parseInt(username)).get();
            LOGGER.info("Usuario actual" + user.toString());

            SSHClient sshClient = new SSHClient(user.getUsername(),pass, 22, user.getDnsAddress());
            LOGGER.info("Cliente ssh creado" + sshClient.getHost());

            String directorioBot = properties.getProperty("bot_dir");
            copyBot(user.getShareDirectoryPath(),directorioBot ,robot.getName(), sshClient);
            LOGGER.info("Copiando Robot"+robot.getName() +" a:" + user.getShareDirectoryPath() + "desde" + directorioBot);


            String command = Auxiliar.buildCommand(robot, user);
            LOGGER.info("Construyendo Comando: " + command);

            LOGGER.info("Ejecutando Comando: " + command);
            List<Object> res = sshClient.execCommand(command);

            //List<Object> res = sshClient.execCommand("psexec \\\\127.0.0.1 -s -d -i C:\\Users\\IEUser\\Desktop\\share\\block_notas.exe");
            String resultado = "Resultado: " + ((DataInputStream)res.get(0)) + " -- "
                    + ((BufferedReader) res.get(1)).read() + " -- "
                    +((DataOutputStream)res.get(2)).size() + " -- "
                    +(Integer) res.get(3);

            LOGGER.info("Resultado del proceso: " + resultado);

            if (res.get(3) != null && res.get(3).toString().equals("-1")){
                salida = "Exito";
            }
            return salida;
       }
            return salida;
    }



    //Configurar cliente
    @RequestMapping(value = "/config")
    public Object config(@RequestParam("user_id") int id){
        RpaUser user = userService.findById(id).get();
        //activar ssh cliente y servidor
        try {
            //Revisar este proceso para correr bots
            Process p= Runtime.getRuntime().exec("ssh -V"); // cero cuando es efectivo
            p.waitFor();
            int s = p.exitValue();
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String  pingResult = "";
            String inputLine;
            // Bucle mientas reciba parametros del buffer
            while ((inputLine = in.readLine()) != null)
            {
                // Muestra por pantalla cada una de las lineas que recibe
                System.out.println("input" + inputLine);
                // Si deseamos capturar el resultado para posteriormente
                // utilizarlo en nuestra aplicacion
                pingResult += inputLine;
            }
            in.close();

            LOGGER.info("Salida de process: " + s + "----");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Copiar psexec
        LOGGER.info("Copiando Recursos");

        this.sshClient = new SSHClient(user.getUsername(),user.getPassword(), 22, user.getDnsAddress());
        this.scp = new SCPClient(this.sshClient);
        try {
            scp.copyDirTO(user.getShareDirectoryPath(),"resources/tools/PSTools");
        } catch (JSchException e) {
            e.printStackTrace();
        } catch (SftpException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Configurar variable de entorno para psexec
        return null;
    }


    public boolean copyBot(String remotePath, String localPath , String filename, SSHClient ssh){
        try {
            this.scp = new SCPClient(ssh);
            scp.copyFileTO(remotePath, localPath, filename);
            return true;
        } catch (IOException | JSchException | SftpException e) {
            e.printStackTrace();
        }
        return false;
    }


    public void execRuntime(String cmd){

    }




}
