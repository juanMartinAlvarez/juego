package juego.componentes;

import ifts16.pp.juego.componentes.Componente;
import ifts16.pp.juego.componentes.item.Inventariable;
import ifts16.pp.juego.componentes.personaje.Comerciante;
import ifts16.pp.juego.sistemas.IOBase;

/**
 *
 * @author Martin
 */
public class Comercio extends Componente implements Comerciante {
    protected int dinero;
    protected int comprar;
    
    public Comercio(){
        //this.comprar = 1;
        //IOBase.ingresarTexto("llego aca");
        
    }
 /*   
    public int establecerSalud(int cantidad) {
        if(!(cantidad > this.saludMaxima)){
            this.saludActual = cantidad;
        }else{
            IOBase.ingresarTexto
            ("ATENCION: La salud establecida no puede ser mayor que "
                    + this.saludMaxima
                    + " se ha establecido por salud máxima el limite maximo (" 
                    + this.saludMaxima + ")");
            this.saludActual = this.saludMaxima;
        }
    return this.saludActual;
    }
*/
    @Override
    public int comprar(Inventariable item) {
        System.out.println("llego");
        if(item.cantidad()>=1){
            return item.agregar(comprar);
        }
    return 0;
    }

    @Override
    public int comprar(Inventariable item, int cantidad) {
    return 0;
    }

    @Override
    public Inventariable vender(int dinero) {
        return null;
    }

    @Override
    public Inventariable vender(int dinero, int cantidad) {
    return null;
    }
}