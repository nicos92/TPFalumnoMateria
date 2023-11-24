package com.nicosandoval.controller;

import com.nicosandoval.modelo.Alumno;
import com.nicosandoval.modelo.InterController;
import com.nicosandoval.repository.AlumnoRepo;

import static com.nicosandoval.Main.*;

public class AlumnoController implements InterController {
    @Override
    public String insert() {
        boolean confirm;
        String alumno;


        do {
            System.out.println("Ingrese el nombre del Alumno\n 0 - Para salir");
            alumno = scanner.nextLine();
            confirm = isValidLetra(alumno);

            if (confirm ) {
                return new AlumnoRepo().insertAlumno(alumno);

            }
            if( !alumno.equals("0")){
                System.out.println("Nombre Invalido\nIntente Nuevamente");
            }

        }while (!alumno.equals("0"));
        return null;
    }

    @Override
    public Alumno find() {


        boolean confirm;
        String alumno;
        do {

            System.out.println("Ingrese el ID del Alumno\n 0 - Para salir");
            alumno = scanner.nextLine();
            confirm = isValidNum(alumno);

            if (confirm && !alumno.equals("0")) {

                Alumno resultado = new AlumnoRepo().findAlumno(Integer.parseInt(alumno));
                if (resultado != null) {
                    return resultado;
                } else System.out.println("ID no existe\nIntente Nuevamente");

            } else if (!alumno.equals("0")){
                System.out.println("ID invalido\nIntente Nuevamente");
            }




        } while (!alumno.equals("0"));


        return null;
    }

    @Override
    public String remove() {
        return null;
    }

    @Override
    public Alumno update() {
        boolean confirm;
        String alumno;

        do {
            System.out.println("Ingrese el ID del Alumno\n 0 - Para salir");
            alumno = scanner.nextLine();
            confirm = isValidNum(alumno);

            if (confirm){
                Alumno resultado = new AlumnoRepo().findAlumno(Integer.parseInt(alumno));

                if (resultado != null){
                    System.out.println(resultado);
                    do {
                        System.out.println("Ingrese el nuevo nombre del Alumno");
                        String nuevoNombre = scanner.nextLine();
                        confirm = isValidLetra(nuevoNombre);
                        if (confirm){
                            Alumno resultadoNombre = new AlumnoRepo().updateNameAlumno(Integer.parseInt(alumno), nuevoNombre);
                            System.out.println(resultadoNombre);
                        }else System.out.println("Nombre no valido");

                    }while (!confirm);


                }else {
                    System.out.println("El ID no existe");
                }

            }else {
                System.out.println("ID invalido\nIntente Nuevamente");
            }

        } while (!alumno.equals("0"));





        return null;
    }
}
