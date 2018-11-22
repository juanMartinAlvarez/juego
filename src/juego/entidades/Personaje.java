package juego.entidades;

import ifts16.pp.juego.entidades.PersonajeAbstracto;
import ifts16.pp.juego.sistemas.IOBase;
/*
 * @author Martin
 */
public class Personaje extends  PersonajeAbstracto{
    
    public Personaje() {
        super();
        this.nombre = "Personaje principal" + this.getId().toString();        
    }   
}

