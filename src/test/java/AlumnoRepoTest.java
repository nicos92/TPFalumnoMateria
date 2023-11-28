import com.nicosandoval.modeloEntity.Alumno;
import com.nicosandoval.repository.AlumnoRepo;
import org.junit.Assert;
import org.junit.Test;

public class AlumnoRepoTest {
    Alumno alumno = new Alumno();


    @Test
    public void insert(){
        String alumnoController = new AlumnoRepo().insertAlumno("Nicolas Prueba");
        Assert.assertEquals("Alumno insertado", alumnoController);
    }


    @Test
    public void find(){

        Alumno alumno1 = new AlumnoRepo().findAlumno(maxID());
        Assert.assertSame(maxID(), alumno1.getIdAlumno());

    }
    @Test
    public void update(){
        Alumno alumno1 = new AlumnoRepo().updateNameAlumno(maxID(),"Nico update");
        Assert.assertEquals("Nico update", alumno1.getNombreAlumno());

    }
    @Test
    public void remove(){


        Alumno alumno1 = new AlumnoRepo().removeAlumno(maxID());
        Assert.assertEquals(alumno.getIdAlumno(), alumno1.getIdAlumno());


    }
    public int maxID(){
        alumno = new AlumnoRepo().maxId();
        return alumno.getIdAlumno();
    }
}
