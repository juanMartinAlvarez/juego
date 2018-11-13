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