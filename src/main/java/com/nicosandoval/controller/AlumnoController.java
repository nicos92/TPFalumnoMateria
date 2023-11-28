package com.nicosandoval.controller;

import com.nicosandoval.log.Log;
import com.nicosandoval.modeloEntity.Alumno;
import com.nicosandoval.modeloEntity.Cursada;
import com.nicosandoval.modeloEntity.Materia;
import com.nicosandoval.repository.AlumnoRepo;
import com.nicosandoval.repository.CursadaRepo;

import java.util.ArrayList;
import java.util.List;

import static com.nicosandoval.Main.*;

public class AlumnoController implements InterController {

    boolean confirm;
    String alumno;

    @Override
    public String insert() {

        do {
            System.out.println("Ingrese el nombre del Alumno para insertar\n 0 - Para salir");
            alumno = scanner.nextLine();
            confirm = isValidLetra(alumno);

            if (confirm) {
                String result = new AlumnoRepo().insertAlumno(alumno);
                Log.crearArchivoLog("Alumno - Insert - ", result + " - " + alumno);

                return result;

            }
            if (!alumno.equals("0")) {
                System.out.println("Nombre Invalido\nIntente Nuevamente");
            }

        } while (!alumno.equals("0"));
        return null;
    }

    @Override
    public Alumno find() {


        do {

            System.out.println("Ingrese el ID del Alumno para buscar\n 0 - Para salir");
            alumno = scanner.nextLine();
            confirm = isValidNum(alumno);

            if (confirm && !alumno.equals("0")) {

                Alumno resultado = new AlumnoRepo().findAlumno(Integer.parseInt(alumno));
                if (resultado != null) {
                    Log.crearArchivoLog("Alumno - Find - ", resultado.toString());
                    return resultado;
                } else System.out.println("ID no existe\nIntente Nuevamente");

            } else if (!alumno.equals("0")) {
                System.out.println("ID invalido\nIntente Nuevamente");
            }


        } while (!alumno.equals("0"));


        return null;
    }

    @Override
    public Alumno remove() {

        do {
            System.out.println("Ingrese el ID del Alumno a Remover\n 0 - Para salir");
            alumno = scanner.nextLine();
            confirm = isValidNum(alumno);

            if (confirm && !alumno.equals("0")) {
                Alumno resultado = new AlumnoRepo().findAlumno(Integer.parseInt(alumno));

                if (resultado != null) {
                    List<Cursada> cursadaList = new CursadaRepo().getAllCursada();
                    for (Cursada cursada : cursadaList) {
                        if (cursada.getAlumno() == resultado.getIdAlumno()) {
                            confirm = true;
                            break;
                        }else confirm = false;
                    }
                    if (!confirm){
                        System.out.println("Removiendo");
                        Alumno result = new AlumnoRepo().removeAlumno(Integer.parseInt(alumno));
                        Log.crearArchivoLog("Alumno - Remove - ", resultado.toString());

                        return result;
                    }else {
                        System.out.println("No se Puede eliminar, está siendo ultilizada por otra tabla");
                    }
                } else {
                    System.out.println("El ID no existe\nIntente Nuevamente");
                }

            } else if (!alumno.equals("0")) {
                System.out.println("ID invalido\nIntente Nuevamente");
            }
        } while (!alumno.equals("0"));

        return null;
    }

    @Override
    public Alumno update() {


        do {
            System.out.println("Ingrese el ID del Alumno para modificar el nombre\n 0 - Para salir");
            alumno = scanner.nextLine();
            confirm = isValidNum(alumno);

            if (confirm && !alumno.equals("0")) {
                Alumno resultado = new AlumnoRepo().findAlumno(Integer.parseInt(alumno));

                if (resultado != null) {
                    System.out.println(resultado);
                    do {
                        System.out.println("Ingrese el nuevo nombre del Alumno");
                        String nuevoNombre = scanner.nextLine();
                        confirm = isValidLetra(nuevoNombre);
                        if (confirm) {
                            Alumno resultadoNombre = new AlumnoRepo().updateNameAlumno(Integer.parseInt(alumno), nuevoNombre);
                            System.out.println(resultadoNombre);
                            Log.crearArchivoLog("Alumno - update - ", resultadoNombre.toString());
                        } else System.out.println("Nombre no valido");

                    } while (!confirm);


                } else {
                    System.out.println("El ID no existe\nIntente Nuevamente");
                }

            } else if (!alumno.equals("0")) {
                System.out.println("ID invalido\nIntente Nuevamente");
            }

        } while (!alumno.equals("0"));


        return null;
    }

    public List<Materia> getMateriasAprobadas() {

        do {
            System.out.println("Ingrese el ID del Alumno para obtener materias aprobadas\n 0 - Para Salir");
            alumno = scanner.nextLine();
            confirm = isValidNum(alumno);

            if (confirm && !alumno.equals("0")) {
                Alumno resultado = new AlumnoRepo().findAlumno(Integer.parseInt(alumno));
                if (resultado != null) {
                    List<Materia> materiaList = new AlumnoRepo().getMateriasAprobadas(Integer.parseInt(alumno));
                    Log.crearArchivoLog("Alumno - get Materias Aprobadas - ", materiaList.size() + " - " + resultado);
                    return materiaList;
                } else System.out.println("ID no existe\nIntente Nuevamente");

            } else if (!alumno.equals("0")) {
                System.out.println("ID invalido\nIntente Nuevamente");
            }

        } while (!alumno.equals("0"));
        return null;

    }

    public List<Materia> getMateriasDesaprobadas() {

        do {
            System.out.println("Ingrese el ID del Alumno para obtener materias Desaprobadas\n 0 - Para Salir");
            alumno = scanner.nextLine();
            confirm = isValidNum(alumno);

            if (confirm && !alumno.equals("0")) {
                Alumno resultado = new AlumnoRepo().findAlumno(Integer.parseInt(alumno));
                if (resultado != null) {
                    List<Materia> materiaList = new AlumnoRepo().getMateriasDesaprobadas(Integer.parseInt(alumno));
                    Log.crearArchivoLog("Alumno - get Materias Desaprobadas - ", materiaList.size() + " - " + resultado);
                    return materiaList;
                } else System.out.println("ID no existe\nIntente Nuevamente");

            } else if (!alumno.equals("0")) {
                System.out.println("ID invalido\nIntente Nuevamente");
            }

        } while (!alumno.equals("0"));
        return null;
    }

    public List<Materia> getMateriasCursadas() {

        do {
            System.out.println("Ingrese el ID del Alumno para obtener materias Cursadas\n 0 - Para Salir");
            alumno = scanner.nextLine();
            confirm = isValidNum(alumno);

            if (confirm && !alumno.equals("0")) {
                Alumno resultado = new AlumnoRepo().findAlumno(Integer.parseInt(alumno));
                if (resultado != null) {
                    List<Materia> materiaList =new AlumnoRepo().getMateriasCursadas(Integer.parseInt(alumno));
                    Log.crearArchivoLog("Alumno - get Materias Cursadas - ",materiaList.size() + " - " + resultado);
                    return materiaList;
                } else System.out.println("ID no existe\nIntente Nuevamente");

            } else if (!alumno.equals("0")) {
                System.out.println("ID invalido\nIntente Nuevamente");
            }

        } while (!alumno.equals("0"));
        return null;
    }

    public List<Materia> getMateriasNoCursadas() {

        do {
            System.out.println("Ingrese el ID del Alumno para obtener materias No Cursadas\n 0 - Para Salir");
            alumno = scanner.nextLine();
            confirm = isValidNum(alumno);

            if (confirm && !alumno.equals("0")) {
                Alumno resultado = new AlumnoRepo().findAlumno(Integer.parseInt(alumno));
                if (resultado != null) {
                    List<Materia> materiaList = new AlumnoRepo().getMateriasNoCursadas(Integer.parseInt(alumno));
                    Log.crearArchivoLog("Alumno - get Materias No Cursadas ", materiaList.size() + " - " + resultado);
                    return materiaList;
                } else System.out.println("ID no existe\nIntente Nuevamente");

            } else if (!alumno.equals("0")) {
                System.out.println("ID invalido\nIntente Nuevamente");
            }

        } while (!alumno.equals("0"));
        return null;
    }

    public List<Materia> getMateriasParaInscribirse() {


        do {
            System.out.println("Ingrese el ID del Alumno para obtener materias a inscribirse\n 0 - Para Salir");
            alumno = scanner.nextLine();
            confirm = isValidNum(alumno);

            if (confirm && !alumno.equals("0")) {
                Alumno resultado = new AlumnoRepo().findAlumno(Integer.parseInt(alumno));

                if (resultado != null) {
                    List<Materia> materiaList = getListMateriaInscribirse(alumno);
                    Log.crearArchivoLog("Alumno - get Materias Para inscribirse - ", materiaList.size() + " - " + resultado);
                    return materiaList;
                } else System.out.println("ID no existe\nIntente Nuevamente");

            } else if (!alumno.equals("0")) {
                System.out.println("ID invalido\nIntente Nuevamente");
            }

        } while (!alumno.equals("0"));

        return null;
    }

    public String alumnoMateriaInscripcion() {

        return new CursadaController().insert();


    }

    public List<Materia> getListMateriaInscribirse(String alumno) {

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
