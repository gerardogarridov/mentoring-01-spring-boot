package cl.sonda.mentoring.persona;

public class PersonaDTO {

    private String rut;
    private String nombre;
    private String apellido;

    public PersonaDTO() {
    }

    public PersonaDTO(PersonaEntity persona) {
        this.rut = persona.getRut();
        this.nombre = persona.getNombre();
        this.apellido = persona.getApellido();
    }
    
    public String getRut() {
        return rut;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
