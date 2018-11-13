package juego.entidades;

import ifts16.pp.juego.entidades.PersonajeAbstracto;
import juego.sistemas.Combate;

/**
 *
 * @author Martin
 */
public class Enemigo extends PersonajeAbstracto {
    public Combate componenteCombate;
    
    public Enemigo() {
        super();
        this.nombre = "Enemigo " + this.getId().toString();
        this.componenteCombate = new Combate();
    }
    
    public Enemigo(String nombre) {
        super(nombre);
        this.componenteCombate = new Combate();
    }
}
