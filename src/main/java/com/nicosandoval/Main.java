package com.nicosandoval;

import com.nicosandoval.controller.AlumnoController;
import com.nicosandoval.repository.AlumnoRepo;
import com.nicosandoval.repository.CursadaRepo;
import com.nicosandoval.repository.MateriaRepo;
import com.nicosandoval.modelo.Alumno;
import com.nicosandoval.modelo.Cursada;
import com.nicosandoval.modelo.Materia;

import java.util.ArrayList;
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

    private static final String numPattern = "^(0|[1-9][0-9]*)$";
    private static final String letraPattern = "^[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]*)*[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+$";

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


    public static void main(String[] args) {


        String opcion;
        do {
            System.out.println("""
                    Ingrese una opcion:
                    1- Modulo Alumno
                    2- Modulo Materia

                    0- Salir""");


            opcion = scanner.nextLine();

            switch (opcion) {
                case "1" -> moduloAlumno();
                case "2" -> moduloMateria();

                case "0" -> System.out.println("Adios");

                default -> System.out.println("opcion no existe");
            }
        } while (!opcion.equals("0"));


    }

    private static void moduloMateria() {
        String opcion;
        do {
            System.out.println("""
                    Ingrese una opcion:
                    1- Obtener todas las Materias
                    2- Obtener Materia
                    3- Insertar nueva Materia
                    4- Actulizar nombre de Materia
                    5- Remover Materia

                    0- Salir""");


            opcion = scanner.nextLine();

            switch (opcion) {
                case "1" ->
                    System.out.println("1- Obtener todas las Materias");

                case "2" -> {

                    System.out.println("2- Obtener Materia");
                    System.out.println("Ingrese el ID de la Materia");
                    String idMateria = scanner.nextLine();
                    if (isValidNum(idMateria)){
                        Materia resultado = new MateriaRepo().findMateria(Integer.parseInt(idMateria));
                        if (resultado != null){
                            System.out.println(resultado);
                        }else System.out.println("ID no existe");

                    }else {
                        System.out.println("ID invalido");
                    }

                }


                case "0" -> System.out.println("Adios");

                default -> System.out.println("opcion no existe");
            }
        } while (!opcion.equals("0"));
    }

    private static void moduloAlumno() {
        String opcion;

        do {
            System.out.println("""
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
                case "1" -> new AlumnoRepo().getAllAlumno().forEach(System.out::println);

                case "2" -> {
                    Alumno alumno = new AlumnoController().find();
                    System.out.println(Objects.requireNonNullElse(alumno, ""));
                }

                case "3" -> {
                    String alumnoController = new AlumnoController().insert();
                    System.out.println(Objects.requireNonNullElse(alumnoController, ""));
                }

                case "4" -> {

                    System.out.println("Ingrese el ID del Alumno");
                    String idAumno = scanner.nextLine();

                    if (isValidNum(idAumno)){
                        Alumno resultado = new AlumnoRepo().findAlumno(Integer.parseInt(idAumno));
                        System.out.println(resultado);

                        if (resultado != null){
                            System.out.println("Ingrese el nuevo nombre del Alumno");
                            String nuevoNombre = scanner.nextLine();
                            if (isValidLetra(nuevoNombre)){
                                Alumno resultadoNombre = new AlumnoRepo().updateNameAlumno(Integer.parseInt(idAumno), nuevoNombre);
                                System.out.println(resultadoNombre);
                            }else System.out.println("Nombre no valido");



                        }else {
                            System.out.println("El ID no existe");
                        }

                    }else {
                        System.out.println("ID invalido");
                    }

                }
                case "5" -> {

                    System.out.println("Ingrese el ID del Alumno a Remover");
                    String idAumno = scanner.nextLine();

                    if (isValidNum(idAumno)){
                        Alumno resultado = new AlumnoRepo().findAlumno(Integer.parseInt(idAumno));

                        if (resultado != null){
                            String resultadoRemove = new AlumnoRepo().removeAlumno(Integer.parseInt(idAumno));
                            System.out.println(resultadoRemove);
                        }else {
                            System.out.println("El ID no existe");
                        }

                    }else {
                        System.out.println("ID invalido");
                    }
                }
                case "6" -> {
                    System.out.println("Ingrese el ID del Alumno");
                    String idAumno = scanner.nextLine();
                    if (isValidNum(idAumno)){
                        Alumno resultado = new AlumnoRepo().findAlumno(Integer.parseInt(idAumno));
                        if (resultado != null){
                            new AlumnoRepo().getMateriasAprobadas(Integer.parseInt(idAumno)).forEach(System.out::println);
                        }else System.out.println("ID no existe");

                    }else {
                        System.out.println("ID invalido");
                    }
                }
                case "7" -> {
                    System.out.println("Ingrese el ID del Alumno");
                    String idAumno = scanner.nextLine();
                    if (isValidNum(idAumno)){
                        Alumno resultado = new AlumnoRepo().findAlumno(Integer.parseInt(idAumno));
                        if (resultado != null){
                            new AlumnoRepo().getMateriasDesaprobadas(Integer.parseInt(idAumno)).forEach(System.out::println);
                        }else System.out.println("ID no existe");

                    }else {
                        System.out.println("ID invalido");
                    }
                }
                case "8" -> {
                    System.out.println("Ingrese el ID del Alumno");
                    String idAumno = scanner.nextLine();
                    if (isValidNum(idAumno)){
                        Alumno resultado = new AlumnoRepo().findAlumno(Integer.parseInt(idAumno));
                        if (resultado != null){
                            new AlumnoRepo().getMateriasCursadas(Integer.parseInt(idAumno)).forEach(System.out::println);
                        }else System.out.println("ID no existe");

                    }else {
                        System.out.println("ID invalido");
                    }
                }
                case "9" -> {
                    System.out.println("Ingrese el ID del Alumno");
                    String idAumno = scanner.nextLine();
                    if (isValidNum(idAumno)){
                        Alumno resultado = new AlumnoRepo().findAlumno(Integer.parseInt(idAumno));
                        if (resultado != null){
                            new AlumnoRepo().getMateriasNoCursadas(Integer.parseInt(idAumno)).forEach(System.out::println);
                        }else System.out.println("ID no existe");

                    }else {
                        System.out.println("ID invalido");
                    }
                }
                case "10" -> {
                    System.out.println("Ingrese el ID del Alumno");
                    String idAumno = scanner.nextLine();
                    if (isValidNum(idAumno)){
                        Alumno resultado = new AlumnoRepo().findAlumno(Integer.parseInt(idAumno));
                        if (resultado != null){
                            List<Materia> materiasParaInscribirse = new ArrayList<>();
                            List< Materia> NoCursadasList= new AlumnoRepo().getMateriasNoCursadas(Integer.parseInt(idAumno));
                            List<Materia> aprobadasList = new AlumnoRepo().getMateriasAprobadas(Integer.parseInt(idAumno));
                            aprobadasList.forEach(aprobada -> NoCursadasList.forEach(noCursada -> {
                                        if ((aprobada.getIdMateria() == noCursada.getIdMateriaCorreletiva()
                                                || noCursada.getIdMateriaCorreletiva() == 15)
                                                && !materiasParaInscribirse.contains(noCursada)) {

                                            System.out.println("materia para anotarse: " + noCursada);
                                            materiasParaInscribirse.add(noCursada);
                                        }
                                    })
                            );
                        }else System.out.println("ID no existe");

                    }else {
                        System.out.println("ID invalido");
                    }
                }
                case "11" ->{
                    System.out.println("Ingrese el ID del Alumno");
                    String idAumno = scanner.nextLine();
                    if (isValidNum(idAumno)){
                        Alumno resultado = new AlumnoRepo().findAlumno(Integer.parseInt(idAumno));

                        if (resultado != null){
                            System.out.println("Ingrese el ID de la materia");
                            String idMateria = scanner.nextLine();

                            if (isValidNum(idMateria)){
                                Materia materia = new MateriaRepo().findMateria(Integer.parseInt(idMateria));

                                if (materia != null){

                                    List<Materia> materiasParaInscribirse = new ArrayList<>();
                                    List< Materia> NoCursadasList= new AlumnoRepo().getMateriasNoCursadas(Integer.parseInt(idAumno));
                                    List<Materia> aprobadasList = new AlumnoRepo().getMateriasAprobadas(Integer.parseInt(idAumno));
                                    aprobadasList.forEach(aprobada -> NoCursadasList.forEach(noCursada -> {
                                                if ((aprobada.getIdMateria() == noCursada.getIdMateriaCorreletiva()
                                                        || noCursada.getIdMateriaCorreletiva() == 15)
                                                        && !materiasParaInscribirse.contains(noCursada)) {

                                                    materiasParaInscribirse.add(noCursada);
                                                }
                                            })
                                    );
                                    if (materiasParaInscribirse.contains(materia)){

                                        Cursada cursada = new Cursada(Integer.parseInt(idAumno), Integer.parseInt(idMateria),0);
                                        String resultInsert = new CursadaRepo().insertCursada(cursada);
                                        System.out.println(resultInsert);

                                    }else System.out.println("Ya esta inscripto en la Materia");

                                }else System.out.println("ID Materia no existe");

                            }else System.out.println("ID Materia invalido");

                        }else System.out.println("ID Alumno no existe");

                    }else {
                        System.out.println("ID Alumno invalido");
                    }

                }
                case "0" -> System.out.println("Adios");

                default -> System.out.println("opcion no existe");
            }
        } while (!opcion.equals("0"));
    }
}