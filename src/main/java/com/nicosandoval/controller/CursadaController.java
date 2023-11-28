package com.nicosandoval.controller;

import com.nicosandoval.log.Log;
import com.nicosandoval.modeloEntity.Alumno;
import com.nicosandoval.modeloEntity.Cursada;
import com.nicosandoval.modeloEntity.Materia;
import com.nicosandoval.repository.AlumnoRepo;
import com.nicosandoval.repository.CursadaRepo;
import com.nicosandoval.repository.MateriaRepo;

import java.util.ArrayList;
import java.util.List;

import static com.nicosandoval.Main.*;

public class CursadaController implements InterController {
    private boolean confirm;

    private String cursada;

    @Override
    public String insert() {
        String materia;
        String alumno;
        do {

            System.out.println("Ingrese el ID del Alumno para hacer una nueva inscripcion\n 0 - Para salir");
            alumno = scanner.nextLine();
            confirm = isValidNum(alumno);

            if (confirm && !alumno.equals("0")) {
                Alumno resultado = new AlumnoRepo().findAlumno(Integer.parseInt(alumno));

                if (resultado != null) {
                    List<Materia> materiasParaInscribirse = getListMateriaInscribirse(alumno);

                    if (!materiasParaInscribirse.isEmpty()){

                        do {
                            System.out.println("Ingrese el ID de la materia\n 0 - Para salir");
                            materia = scanner.nextLine();
                            confirm = isValidNum(materia);

                            if (confirm && !materia.equals("0")) {
                                Materia materiaResult = new MateriaRepo().findMateria(Integer.parseInt(materia));

                                if (materiaResult != null) {

                                    if (!materiasParaInscribirse.contains(materiaResult)) {

                                        Cursada cursada = new Cursada();
                                        cursada.setAlumno(Integer.parseInt(alumno));
                                        cursada.setMateria(Integer.parseInt(materia));
                                        cursada.setAprobada(0);
                                        String result = new CursadaRepo().insertCursada(cursada);
                                        Log.crearArchivoLog("Alumno - incripcion Cursada - " , result + " - " + resultado + " - " + materiaResult);
                                        return result;

                                    } else System.out.println("Ya esta inscripto en la Materia");

                                } else System.out.println("ID Materia no existe\n Intente Nuevamente");

                            } else if (!materia.equals("0"))
                                System.out.println("ID Materia invalido\n Intente Nuevamente");

                        } while (!materia.equals("0"));

                    }else System.out.println("No tiene materias para inscribirse");



                } else System.out.println("ID Alumno no existe\n Intente Nuevamente");

            } else if (!alumno.equals("0")) {
                System.out.println("ID Alumno invalido\n Intente Nuevamente");
            }
        } while (!alumno.equals("0"));
        return null;
    }

    @Override
    public Object find() {
        do {

            System.out.println("Ingrese el ID del Cursada para buscar\n 0 - Para salir");
            cursada = scanner.nextLine();
            confirm = isValidNum(cursada);

            if (confirm && !cursada.equals("0")) {

                Cursada resultado = new CursadaRepo().findCursada(Integer.parseInt(cursada));
                if (resultado != null) {
                    Log.crearArchivoLog("Cursada - Find - ", resultado.toString());

                    return resultado;
                } else System.out.println("ID no existe\nIntente Nuevamente");

            } else if (!cursada.equals("0")) {
                System.out.println("ID invalido\nIntente Nuevamente");
            }


        } while (!cursada.equals("0"));
        return null;
    }

    @Override
    public String remove() {
        do {
            System.out.println("Ingrese el ID de la Cursada a Remover\n 0 - Para salir");
            cursada = scanner.nextLine();
            confirm = isValidNum(cursada);

            if (confirm && !cursada.equals("0")) {
                Cursada resultado = new CursadaRepo().findCursada(Integer.parseInt(cursada));

                if (resultado != null) {
                    String result = new CursadaRepo().removeCursada(Integer.parseInt(cursada));
                    Log.crearArchivoLog("Cursada - Remove - ", result + " - " + resultado);
                    return result;
                } else {
                    System.out.println("El ID no existe\nIntente Nuevamente");
                }

            } else if (!cursada.equals("0")) {
                System.out.println("ID invalido\nIntente Nuevamente");
            }
        } while (!cursada.equals("0"));
        return null;
    }

    @Override
    public Cursada update() {
        do {
            System.out.println("Ingrese el ID de la Cursada para modificar la aprobacion\n 0 - Para salir");
            cursada = scanner.nextLine();
            confirm = isValidNum(cursada);

            if (confirm && !cursada.equals("0")) {
                Cursada resultado = new CursadaRepo().findCursada(Integer.parseInt(cursada));

                if (resultado != null) {
                    System.out.println(resultado);
                    do {
                        System.out.println("""
                                Ingrese la aprobacion:
                                0 - DesAprobado
                                1- Aprobado
                                """);
                        String aprobacion= scanner.nextLine();

                        switch (aprobacion){
                            case "0" ->{
                                Cursada resultCursada = new CursadaRepo().updateAprobacion(Integer.parseInt(cursada), 0);
                                System.out.println(resultCursada);
                                Log.crearArchivoLog("Cursada - update - ", resultCursada.toString());
                            }
                            case  "1"->{
                                Cursada resultCursada = new CursadaRepo().updateAprobacion(Integer.parseInt(cursada), 1);
                                System.out.println(resultCursada);
                                Log.crearArchivoLog("Cursada - update - ", resultCursada.toString());

                            }
                            default -> System.out.println("opcion no existe");

                        }

                    } while (!confirm);

                } else {
                    System.out.println("El ID no existe\nIntente Nuevamente");
                }

            } else if (!cursada.equals("0")) {
                System.out.println("ID invalido\nIntente Nuevamente");
            }

        } while (!cursada.equals("0"));


        return null;
    }

    public List<Materia> getListMateriaInscribirse(String alumno){

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
