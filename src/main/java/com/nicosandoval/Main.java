package com.nicosandoval;

import com.nicosandoval.controller.AlumnoController;
import com.nicosandoval.controller.CursadaController;
import com.nicosandoval.controller.MateriaController;
import com.nicosandoval.log.Log;
import com.nicosandoval.modeloEntity.Alumno;
import com.nicosandoval.modeloEntity.Cursada;
import com.nicosandoval.modeloEntity.Materia;
import com.nicosandoval.repository.AlumnoRepo;
import com.nicosandoval.repository.CursadaRepo;
import com.nicosandoval.repository.MateriaRepo;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    // martes 28 examen online
    // juevese 30 entrega tp final
    //
    public static Scanner scanner = new Scanner(System.in);

    public static final String alfaNumPattern = "^[\\w- ]+$";

    public static final String numPattern = "^(0|[1-9][0-9]*)$";
    public static final String letraPattern = "^[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]*)*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+$";

    private static final Pattern patternNum = Pattern.compile(numPattern);
    private static final Pattern patternLetra = Pattern.compile(letraPattern);

    public static boolean isValidNum(String opcion) {
        Matcher matcher = patternNum.matcher(opcion);
        return matcher.matches();
    }

    public static boolean isValidLetra(String opcion) {
        Matcher matcher = patternLetra.matcher(opcion);
        return matcher.matches();
    }

    public static boolean isValidCaracteres(String opcion, String tipoPattern) {
        Pattern miPattern = Pattern.compile(tipoPattern);
        Matcher matcher = miPattern.matcher(opcion);
        return matcher.matches();
    }


    public static void main(String[] args) {


        String opcion;
        do {
            System.out.println("""
                    --------------------------------------------------
                    Ingrese una opcion:
                    1- Modulo Alumno
                    2- Modulo Materia
                    3- Modulo Cursada

                    0- Salir""");


            opcion = scanner.nextLine();

            switch (opcion) {
                case "1" -> moduloAlumno();
                case "2" -> moduloMateria();
                case "3" -> moduloCursada();

                case "0" -> System.out.println("Adios");

                default -> System.out.println("opcion no existe");
            }
        } while (!opcion.equals("0"));


    }

    private static void moduloCursada() {
        String opcion;
        do {
            System.out.println("""
                    ---------------------------------------------------
                    Ingrese una opcion:
                    1- Obtener todas las Cursadas
                    2- Obtener Cursada
                    3- Insertar nueva Cursada
                    4- Actulizar aprobacion de Cursada
                    5- Remover Cursada

                    0- Salir""");


            opcion = scanner.nextLine();

            switch (opcion) {
                case "1" -> {
                    List< Cursada> cursadaList = new CursadaRepo().getAllCursada();
                    cursadaList.forEach(System.out::println);
                    Log.crearArchivoLog("Cursada - get all Cursada - ", String.valueOf(cursadaList.size()));

                }

                case "2" -> System.out.println(Objects.requireNonNullElse(new CursadaController().find(), ""));

                case "3" -> System.out.println(Objects.requireNonNullElse(new CursadaController().insert(), ""));

                case "4" -> System.out.println(Objects.requireNonNullElse(new CursadaController().update(), ""));

                case "5" -> System.out.println(Objects.requireNonNullElse(new CursadaController().remove(), ""));


                case "0" -> System.out.println("Adios");

                default -> System.out.println("opcion no existe");
            }
        } while (!opcion.equals("0"));

    }

    private static void moduloMateria() {
        String opcion;
        do {
            System.out.println("""
                    ---------------------------------------------------
                    Ingrese una opcion:
                    1- Obtener todas las Materias
                    2- Obtener Materia
                    3- Insertar nueva Materia
                    4- Actulizar nombre de Materia
                    5- Remover Materia

                    0- Salir""");


            opcion = scanner.nextLine();

            switch (opcion) {
                case "1" -> {
                    List<Materia> materiaList = new MateriaRepo().getAllMateria();
                    materiaList.forEach(System.out::println);
                    Log.crearArchivoLog("Materia - get All Materia - ", String.valueOf(materiaList.size()));
                }

                case "2" -> System.out.println(Objects.requireNonNullElse(new MateriaController().find(), ""));

                case "3" -> System.out.println(Objects.requireNonNullElse(new MateriaController().insert(), ""));

                case "4" -> System.out.println(Objects.requireNonNullElse(new MateriaController().update(), ""));

                case "5" -> System.out.println(Objects.requireNonNullElse(new MateriaController().remove(), ""));


                case "0" -> System.out.println("Adios");

                default -> System.out.println("opcion no existe");
            }
        } while (!opcion.equals("0"));
    }

    private static void moduloAlumno() {
        String opcion;

        do {
            System.out.println("""
                    --------------------------------------------------
                    Ingrese una opcion:
                    1- Obtener todos los alumnos
                    2- Obtener alumno por ID
                    3- Insertar nuevo alumno
                    4- Actulizar nombre de alumno por ID
                    5- Remover Alumno por ID
                    6- materias aprobadas
                    7- Materias Desaprobadas
                    8- Materias Cursadas
                    9- Materias que No Cursa Alumno
                    10- Materias para inscribirse
                    11- Inscribirse a Materia
                    0- Salir""");


            opcion = scanner.nextLine();

            switch (opcion) {
                case "1" -> {
                    List< Alumno> alumnoList = new AlumnoRepo().getAllAlumno();
                    alumnoList.forEach(System.out::println);
                    Log.crearArchivoLog("Alumno - get all Alumnos - ", String.valueOf(alumnoList.size()));
                }

                case "2" -> System.out.println(Objects.requireNonNullElse(new AlumnoController().find(), ""));

                case "3" ->
                    System.out.println(Objects.requireNonNullElse(new AlumnoController().insert(), ""));


                case "4" ->
                    System.out.println(Objects.requireNonNullElse(new AlumnoController().update(), ""));


                case "5" ->
                    System.out.println(Objects.requireNonNullElse(new AlumnoController().remove(), ""));


                case "6" -> {
                    List<Materia> materiaList = new AlumnoController().getMateriasAprobadas();
                    if (materiaList != null && !materiaList.isEmpty()) {
                        materiaList.forEach(System.out::println);
                    }
                }
                case "7" -> {
                    List<Materia> materiaList = new AlumnoController().getMateriasDesaprobadas();
                    if (materiaList != null && !materiaList.isEmpty()) {
                        materiaList.forEach(System.out::println);
                    }
                }
                case "8" -> {
                    List<Materia> materiaList = new AlumnoController().getMateriasCursadas();
                    if (materiaList != null && !materiaList.isEmpty()) {
                        materiaList.forEach(System.out::println);
                    }
                }
                case "9" -> {
                    List<Materia> materiaList = new AlumnoController().getMateriasNoCursadas();
                    if (materiaList != null && !materiaList.isEmpty()) {
                        materiaList.forEach(System.out::println);
                    }
                }
                case "10" -> {
                    List<Materia> materiaList = new AlumnoController().getMateriasParaInscribirse();

                }

                case "11" ->
                    System.out.println(Objects.requireNonNullElse(new AlumnoController().alumnoMateriaInscripcion(), ""));


                case "0" -> System.out.println("Adios");

                default -> System.out.println("opcion no existe");
            }
        } while (!opcion.equals("0"));
    }
}