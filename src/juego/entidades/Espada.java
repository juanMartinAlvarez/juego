package juego.entidades;

import ifts16.pp.juego.entidades.ItemAbstracto;

/**
 *
 * @author martin
 */
public class Espada extends ItemAbstracto{
    public String mensaje;

    public Espada(){
        
        this.mensaje = "\n"
                + "      (@_\n" +
                " _     ) \\____________________________________________\n" +
                "(_)@8@8{}<____________________________________________>\n" +
                "       )_/\n" +
                "      (@";
    }
    
}
