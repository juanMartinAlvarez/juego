package juego.sistemas;

import ifts16.pp.juego.sistemas.IOBase;
import ifts16.pp.juego.utiles.Opcion;
import ifts16.pp.juego.utiles.Opciones;
import juego.entidades.Personaje;
import juego.entidades.Vendedor;

/**
 *
 * @author Martin
 */
public class Transacciones {
    String mensaje  = ("      (@_\n" +
                              " _     ) \\____________________________________________\n" +
                              "(_)@8@8{}<____________________________________________>\n" +
                              "       )_/\n" +
                              "      (@");
    
    public static void nuevaTransaccion(Vendedor v,Personaje p) throws InterruptedException{
        IOBase.ingresarTexto("\n¿Te vas a quedar ahí parado todo el día? \n" +
                            "No hagas que pierda mi tiempo.\n"+
                            " ¿Te interesa algún objeto? \n");
        
        
        Opciones articulos = new Opciones("Elige un articulo");
        articulos.agregar("espada","Espada pirata");
        //articulos.agregar("pollo","Es solo un pollo de hule");
        //articulos.agregar("remera","Remera que reza yo venci al maestro de la espada");
        Opcion eleccion = IOBase.elegirOpcion(articulos);
        
        if ( eleccion.getComando() == "espada")
        {
            String mensaje  = ("      (@_\n" +
                              " _     ) \\____________________________________________\n" +
                              "(_)@8@8{}<____________________________________________>\n" +
                              "       )_/\n" +
                              "      (@");
            
            IOBase.mostrarTexto(mensaje);
            
        }
        Thread.sleep(5000);
    }
    
}
