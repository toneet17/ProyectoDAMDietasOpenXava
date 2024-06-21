package com.antoni.proyectodamdietasadmin.run;

import org.openxava.util.*;

/**
 * Ejecuta esta clase para arrancar la aplicaci�n.
 *
 * Con OpenXava Studio/Eclipse: Bot�n derecho del rat�n > Run As > Java Application
 */

public class proyectodamdietasadmin {

    public static void main(String[] args) throws Exception {
        //DBServer.start("proyectodamdietasadmin-db"); // Para usar tu propia base de datos comenta esta l�nea y configura src/main/webapp/META-INF/context.xml
        AppServer.run("proyectodamdietasadmin"); // Usa AppServer.run("") para funcionar en el contexto ra�z
    }
}
