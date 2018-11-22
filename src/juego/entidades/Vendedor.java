package juego.entidades;

import ifts16.pp.juego.entidades.PersonajeAbstracto;
import ifts16.pp.juego.sistemas.IOBase;
import juego.componentes.Comercio;
   
public class Vendedor extends PersonajeAbstracto {
    public Comercio componenteComercio;
    
    public Vendedor(String martin) {
        super();
        this.nombre = "El vendedor Martin" + this.getId().toString();
        this.componenteComercio = new Comercio();
    }
}

  