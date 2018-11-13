package juego.sistemas;

import ifts16.pp.juego.sistemas.IOBase;

/**
 *
 * @author wily_
 */

public class Imprimir {
    String txt;
    public void mostrarEnPantalla(String txt){
        String texto = "funciona";
        this.txt= texto;
        IOBase.mostrarTexto(txt);
    }
}
