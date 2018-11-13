package juego.entidades;

import ifts16.pp.juego.entidades.PersonajeAbstracto;
import juego.componentes.Educar;

/**
 *
 * @author wily_
 */
public class Maestro extends PersonajeAbstracto {

    protected Educar componenteEducar;
    
    public Maestro(String MaestroDeLaEspada){
        super();
        this.nombre = "El Maestro de la espada" + this.getId().toString();
        this.componenteEducar = new Educar();
    }
}
