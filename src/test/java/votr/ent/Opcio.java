package votr.ent;

import org.frijoles.annotated.anno.Id;
import org.frijoles.annotated.anno.Table;

@Table("opcions")
public class Opcio {

    @Id
    OpcioId idOpcio;

    String titol;
    String descripcio;

    String hashVotacio;

    public Opcio() {
        super();
    }

    public Opcio(OpcioId idOpcio, String titol, String descripcio) {
        super();
        this.idOpcio = idOpcio;
        this.titol = titol;
        this.descripcio = descripcio;
    }

    public OpcioId getIdOpcio() {
        return idOpcio;
    }

    public void setIdOpcio(OpcioId idOpcio) {
        this.idOpcio = idOpcio;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    @Override
    public String toString() {
        return "Opcio [idOpcio=" + idOpcio + ", titol=" + titol + ", descripcio=" + descripcio + "]";
    }

}