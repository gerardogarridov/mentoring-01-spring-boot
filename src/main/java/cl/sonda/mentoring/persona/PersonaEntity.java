package cl.sonda.mentoring.persona;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "GG_PERSONA")
public class PersonaEntity {
    
    @Id
    @Column(name = "RUT")
    private String rut;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO")
    private String apellido;
    
    public PersonaEntity() {
    }

    public PersonaEntity(PersonaDTO persona) {
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
