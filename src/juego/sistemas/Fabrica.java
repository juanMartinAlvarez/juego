package juego.sistemas;

import ifts16.pp.juego.entidades.LugarBase;
import ifts16.pp.juego.entidades.PersonajeAbstracto;
import ifts16.pp.juego.sistemas.FabricaPrincipal;
import ifts16.pp.juego.sistemas.RepositorioPrincipal;
import juego.entidades.Vendedor;

/**
 *
 * @author Martin
 */
public class Fabrica extends FabricaPrincipal {

    public static void crearLugares() {
        LugarBase inicio = new LugarBase("Aldea inicial", 
            "martin");
        
        LugarBase practica = new LugarBase("Campo de practica",
            "Lugar de practica para el heroe de esta aventura");
        
        LugarBase desierto = new LugarBase("Desierto", "Lugar desolado, aqui hay un portal");
        
        LugarBase feria  = new LugarBase("Feria",
            "Lugar donde se adquieren elementos");
         
        inicio.agregarVecino(feria.referencia("Feria, Centro de comercio"));
        inicio.agregarVecino(practica.referencia("Campo de Practica"));
        inicio.agregarVecino(desierto.referencia("Desierto desolador"));
        feria.agregarVecino(inicio.referencia("Aldea de inicio"));
        practica.agregarVecino(inicio.referencia("La aldea de inicio"));
        desierto.agregarVecino(inicio.referencia("Aldea de inicio"));
        desierto.agregarAPortal(inicio.referencia("Teletransportacion al inicio"));
        
        RepositorioPrincipal.agregar(feria, "feria");
        RepositorioPrincipal.agregar(inicio, "inicio");
        Fabrica.agregarIdLugar(inicio.getId());
        RepositorioPrincipal.agregar(practica, "practica");
        //Fabrica.agregarIdLugar(practica.getId());
        RepositorioPrincipal.agregar(desierto, "desierto");
    }
    
    public static void crearPersonajes () {

        Vendedor Martin  = new Vendedor("Martin");
        RepositorioPrincipal.agregar(Martin, "martin");
        LugarBase feria = (LugarBase) RepositorioPrincipal.traer("feria");
        feria.agregarComerciante(Martin.referencia("El vendedor Martin"));
        
        
    } 
    
}
