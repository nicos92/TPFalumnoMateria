package com.nicosandoval.controller;

import com.nicosandoval.log.Log;
import com.nicosandoval.modeloEntity.Cursada;
import com.nicosandoval.modeloEntity.Materia;
import com.nicosandoval.repository.CursadaRepo;
import com.nicosandoval.repository.MateriaRepo;

import java.util.List;

import static com.nicosandoval.utils.Utils.*;

public class MateriaController implements InterController {


    boolean confirm;
    String materia;

    @Override
    public String insert() {
        do {
            System.out.println("Ingrese el nombre del Materia para insertar\n 0 - Para salir");
            materia = scanner.nextLine();
            confirm = isValidCaracteres(materia, alfaNumPattern);

            if (confirm) {
                String result =  new MateriaRepo().insertMateria(materia);
                Log.crearArchivoLog("Materia - Insert - " , result + " - " + materia) ;
                return result;

            }
            if (!materia.equals("0")) {
                System.out.println("Nombre Invalido\nIntente Nuevamente");
            }

        } while (!materia.equals("0"));
        return null;

    }

    @Override
    public Materia find() {
        do {

            System.out.println("Ingrese el ID de la Materia para buscar\n 0 - Para salir");
            materia = scanner.nextLine();
            confirm = isValidCaracteres(materia,numPattern);

            if (confirm && !materia.equals("0")) {

                Materia resultado = new MateriaRepo().findMateria(Integer.parseInt(materia));
                if (resultado != null) {
                    Log.crearArchivoLog("Materia - Find - ", resultado.toString());
                    return resultado;
                } else System.out.println("ID no existe\nIntente Nuevamente");

            } else if (!materia.equals("0")) {
                System.out.println("ID invalido\nIntente Nuevamente");
            }


        } while (!materia.equals("0"));


        return null;
    }

    @Override
    public String remove() {
        do {
            System.out.println("Ingrese el ID del Materia a Remover\n 0 - Para salir");
            materia = scanner.nextLine();
            confirm = isValidCaracteres(materia,numPattern);

            if (confirm && !materia.equals("0")) {
                Materia resultado = new MateriaRepo().findMateria(Integer.parseInt(materia));

                if (resultado != null) {
                    List<Cursada> cursadaList = new CursadaRepo().getAllCursada();
                    for (Cursada cursada : cursadaList) {
                        if (cursada.getMateria() == resultado.getIdMateria()) {
                            confirm = true;
                            break;
                        }else confirm = false;
                    }
                    if (!confirm){
                        String result = new MateriaRepo().removeMateria(Integer.parseInt(materia));
                        Log.crearArchivoLog("Materia - remove - ", result);

                        return result;
                    }else {
                        System.out.println("No se Puede eliminar, está siendo ultilizada por otra tabla");
                    }



                } else {
                    System.out.println("El ID no existe\nIntente Nuevamente");
                }

            } else if (!materia.equals("0")) {
                System.out.println("ID invalido\nIntente Nuevamente");
            }
        } while (!materia.equals("0"));
        return null;
    }

    @Override
    public Materia update() {
        String nuevoNombre;
        do {
            System.out.println("Ingrese el ID del Materia para modificar el nombre\n 0 - Para salir");
            materia = scanner.nextLine();
            confirm = isValidCaracteres(materia,numPattern);

            if (confirm && !materia.equals("0")) {
                Materia resultado = new MateriaRepo().findMateria(Integer.parseInt(materia));

                if (resultado != null) {
                    System.out.println(resultado);




                    // nombre de materia
                    do {
                        System.out.println("Ingrese el nuevo nombre de la materia\n 0 - Para Salir");
                         nuevoNombre = scanner.nextLine();
                        confirm = isValidCaracteres(nuevoNombre, alfaNumPattern);
                        if (confirm && !nuevoNombre.equals("0")) {
                            Materia resultadoNombre = new MateriaRepo().updateNameMateria(Integer.parseInt(materia), nuevoNombre);
                            Log.crearArchivoLog("Materia - Update Nombre Materia- ", resultadoNombre.toString());
                            return resultadoNombre;
                        } else if (!nuevoNombre.equals("0")){
                            System.out.println("Nombre no valido\nIntente Nuevamente");
                        }

                    } while (!nuevoNombre.equals("0"));

                    // end nombre de materia

                } else {
                    System.out.println("El ID no existe\nIntente Nuevamente");
                }

            } else if (!materia.equals("0")) {
                System.out.println("ID invalido\nIntente Nuevamente");
            }

        } while (!materia.equals("0"));


        return null;
    }

    public Materia updateMateriaCorrelativa() {

        do {
            System.out.println("Ingrese el ID del Materia para modificar el ID de la materia Correlativa\n 0 - Para salir");
            materia = scanner.nextLine();
            confirm = isValidCaracteres(materia,numPattern);

            if (confirm && !materia.equals("0")) {
                Materia resultado = new MateriaRepo().findMateria(Integer.parseInt(materia));

                if (resultado != null) {
                    System.out.println(resultado);


                    Materia resultadoNombre = insertIdCorrelativa();
                    if (resultadoNombre != null) return resultadoNombre;


                } else {
                    System.out.println("El ID no existe\nIntente Nuevamente");
                }

            } else if (!materia.equals("0")) {
                System.out.println("ID invalido\nIntente Nuevamente");
            }

        } while (!materia.equals("0"));


        return null;
    }

    private Materia insertIdCorrelativa() {
        String nuevoID;
        // ID Corrlativa
        do {
            System.out.println("Ingrese ID de la Materia Correlativa\n 0 - Para Salir");
             nuevoID = scanner.nextLine();
            confirm = isValidCaracteres(nuevoID, numPattern);
            if (confirm && !nuevoID.equals("0")) {
                Materia resultadoNombre = new MateriaRepo().updateIdCorrelativa(Integer.parseInt(materia), nuevoID);
                Log.crearArchivoLog("Materia - Update Correlativa - ", resultadoNombre.toString());
                return resultadoNombre;
            } else if (!nuevoID.equals("0")){
                System.out.println("Nombre no valido\nIntente Nuevamente");
            }

        } while (!nuevoID.equals("0"));

        // end ID Correlativa
        return null;
    }
}
