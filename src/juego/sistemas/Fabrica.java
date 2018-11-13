package juego.sistemas;

import ifts16.pp.juego.entidades.LugarBase;
import ifts16.pp.juego.entidades.PersonajeAbstracto;
import ifts16.pp.juego.sistemas.FabricaPrincipal;
import ifts16.pp.juego.sistemas.RepositorioPrincipal;
import juego.componentes.Comercio;
import juego.entidades.Vendedor;


/**
 *
 * @author Martin
 */
public class Fabrica extends FabricaPrincipal {

    public static void crearLugares() {
        LugarBase inicio = new LugarBase("Aldea inicial", 
            "                 ~\n" +
            "            _~ )_)_~\n" +
            "            )_))_))_)\n" +
            "            _!__!__!_\n" +
            "            \\_______/\n" +
            "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
            "\n" +
            "Bienvenido al juego, puede que te suene la historia.\n" +
            "Tú eres un aspirante a pirata, y tienes como objetivo aprender "+
            "el arte de dominar la espada.\n" +
            "Para ello deberás conseguir una espada en la Feria del pueblo, y ganar 3 batallas");
        
        LugarBase feria  = new LugarBase("Feria",
            "Lugar donde se adquieren elementos");
        
        LugarBase practica = new LugarBase("Campo de practica",
            "Lugar de practica para el heroe de esta aventura");
        
        LugarBase maestro = new LugarBase("La casa del maestro de la espada.", 
        "El maestro entrena para poder desafiar a los piratas");
        
        Fabrica.agregarIdLugar(inicio.getId()); 
        
        inicio.agregarVecino(feria.referencia("Feria, Centro de comercio"));
        inicio.agregarVecino(practica.referencia("Campo de Practica"));
        inicio.agregarVecino(maestro.referencia("La casa del maestro de la espada."));
        
        feria.agregarVecino(inicio.referencia("Aldea de inicio"));
        practica.agregarVecino(inicio.referencia("La aldea de inicio"));
        maestro.agregarVecino(inicio.referencia("Aldea de inicio"));
                
        RepositorioPrincipal.agregar(inicio, "inicio");
        RepositorioPrincipal.agregar(feria, "feria");
        RepositorioPrincipal.agregar(practica, "practica");
        RepositorioPrincipal.agregar(maestro, "La casa del maestro de la espada.");
    }
    
    public static void crearPersonajes () {

        Vendedor Martin  = new Vendedor("Martin");
        RepositorioPrincipal.agregar(Martin, "martin");
        LugarBase feria = (LugarBase) RepositorioPrincipal.traer("feria");
        feria.agregarComerciante(Martin.referencia("El vendedor Martin"));
        
           
        /*
        Maestro Jhon = new Maestro ("Jhon");
        RepositorioPrincipal.agregar(Jhon, "Jhon");
        LugarBase LaCasa = (LugarBase) RepositorioPrincipal.traer("La casa del maestro de la espada.");
        LaCasa.*/
    } 
}
