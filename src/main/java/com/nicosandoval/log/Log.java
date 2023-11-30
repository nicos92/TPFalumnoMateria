package com.nicosandoval.log;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class Log {


    public static void crearArchivoLog(String titulo, String descr){
        String path = "LOG\\" + LocalDate.now().getYear()  + " " +  LocalDate.now().getMonth() +
                "\\TEP " + LocalDate.now().getYear() + " " +  LocalDate.now().getMonth() + " " +  LocalDate.now().getDayOfMonth() + ".log";

        File rutaCarpetaLog = new File("LOG\\" + LocalDate.now().getYear()  + " " +  LocalDate.now().getMonth());
        if (rutaCarpetaLog.mkdir()) {
            escribiendo( path, titulo, descr);
        }else{
            escribiendo( path, titulo, descr);
        }
    }

    private static void escribiendo(String path, String titulo, String descr) {
        try (FileWriter log = new FileWriter(path, true)){
            log.write("\n" + FechaYhora.fechaYhoraNow() + " - " + titulo + descr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
