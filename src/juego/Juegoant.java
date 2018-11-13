package juego;

import ifts16.pp.juego.entidades.LugarBase;
import ifts16.pp.juego.sistemas.IOBase;
import ifts16.pp.juego.sistemas.RepositorioPrincipal;
import ifts16.pp.juego.utiles.Opcion;
import ifts16.pp.juego.utiles.Opciones;
import java.awt.EventQueue;
import juego.sistemas.Fabrica;
import juego.sistemas.Imprimir;
import juego.sistemas.Navegacion;

/**
 *
 * @author Martin
 */
public class Juegoant {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IOBase ventana = new IOBase();
        EventQueue.invokeLater(ventana);
        Fabrica.crearLugares();
        Fabrica.crearPersonajes();
        LugarBase lugarDeInicio = (LugarBase) RepositorioPrincipal.traer("inicio");
        Navegacion.iniciar(lugarDeInicio);
    }
    
}
