package com.claro.rpa.app;

import com.claro.rpa.app.model.RpaRobot;
import com.claro.rpa.app.model.RpaUser;

public class Auxiliar {

    public Auxiliar(){}

    public static String formatPathToPsexec(String path){
        path = path.substring(1);
        path.replace("/", "\\\\");
        return path;
    }

    public static String buildCommand(RpaRobot robot, RpaUser user){
        StringBuilder sb = new StringBuilder();
        sb.append("psexec \\\\");
        sb.append("127.0.0.1 -s -d -i");
        sb.append(" ");
        sb.append(Auxiliar.formatPathToPsexec(user.getShareDirectoryPath()));
        sb.append(robot.getName());
        return sb.toString();
    }


}
