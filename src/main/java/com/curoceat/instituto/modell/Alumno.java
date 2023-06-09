package curoceat.instituto.modell;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
public class Alumno {
    private int id;
    private String nombre;
    private String curso;
    private float media;
    private Date fNacimiento;

    // crear una costante  con el longitud de caracteres del nombre como esta definida en la BBDD
    private final int TAMNOMBRE=50;
    // creamos el constructor
    public Alumno(int id) {
        this.id=id;
    }
    public Alumno() {

    }
    public Alumno(int id, String nombre, String curso, float media, String fNacimiento) throws ParseException {
        this.id = id;
        setNombre(nombre);
        setCurso(curso);
        this.media = media;
        // dale formato a la fecha
        SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
        this.fNacimiento = formato.parse(fNacimiento); //puede que exista un error al intentar crear el formato y se agrega un ParseException
    }
 // este contructor lo utilizamos para crear un nuevo alumno porque BD crea automaticamente el id
    public Alumno(String nombre, String curso, float media, String fNacimiento) throws ParseException {
        setNombre(nombre);
        setCurso(curso);
        this.media = media;
        // dale formato a la fecha
        SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
        this.fNacimiento = formato.parse(fNacimiento); //puede que exista un error al intentar crear el formato y se agrega un ParseException
    }

    //metodo para delimitar caracteres del nombre ->50 caracteres
    public void setNombre(String nombre){
        //utilizamos la constante definida TAMNOMBRE -> Math pasar el min -> limitar la longitud de la cadena que pase como nombre
        this.nombre= nombre.substring(0,Math.min(TAMNOMBRE,nombre.length()));
        // math.min(50,65) -> 0,50
    }

    //metodo para deliminar caracters del curso ->2 caracteres
    public void setCurso(String curso){
        this.curso=curso.substring(0,Math.min(2,curso.length()));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public Date getfNacimiento() {

        return fNacimiento;
    }
    public void setfNacimiento(Date fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCurso() {
        return curso;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", curso='" + curso + '\'' +
                ", media=" + media +
                ", fNacimiento=" + fNacimiento +
                '}';
    }
}
