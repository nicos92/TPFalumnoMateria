package com.nicosandoval.utils;

import com.nicosandoval.modeloEntity.Materia;
import com.nicosandoval.repository.AlumnoRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static Scanner scanner = new Scanner(System.in);

    public static final String alfaNumPattern = "^[\\w- ]+$";

    public static final String numPattern = "^(0|[1-9][0-9]*)$";
    public static final String letraPattern = "^[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]*)*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+$";

    public static boolean isValidCaracteres(String opcion, String tipoPattern) {
        Pattern miPattern = Pattern.compile(tipoPattern);
        Matcher matcher = miPattern.matcher(opcion);
        return matcher.matches();
    }
    public static List<Materia> getListMateriaInscribirse(String alumno) {

        List<Materia> materiasParaInscribirse = new ArrayList<>();

        List<Materia> NoCursadasList = new AlumnoRepo().getMateriasNoCursadas(Integer.parseInt(alumno));

        List<Materia> aprobadasList = new AlumnoRepo().getMateriasAprobadas(Integer.parseInt(alumno));

        if (!aprobadasList.isEmpty()) {
            aprobadasList.forEach(aprobada -> NoCursadasList.forEach(noCursada -> {
                        if ((aprobada.getIdMateria() == noCursada.getIdMateriaCorreletiva()
                                || noCursada.getIdMateriaCorreletiva() == 0)
                                && !materiasParaInscribirse.contains(noCursada)) {

                            System.out.println(noCursada);
                            materiasParaInscribirse.add(noCursada);
                        }
                    })
            );
        } else {
            NoCursadasList.forEach(aprobada -> {
                if (aprobada.getIdMateriaCorreletiva() == 0) {

                    System.out.println(aprobada);
                    materiasParaInscribirse.add(aprobada);
                }
            });
        }
        return materiasParaInscribirse;
    }
}
