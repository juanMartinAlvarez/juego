package juego.sistemas;

import ifts16.pp.juego.entidades.LugarBase;
import ifts16.pp.juego.entidades.PersonajeAbstracto;
import ifts16.pp.juego.sistemas.FabricaPrincipal;
import ifts16.pp.juego.sistemas.RepositorioPrincipal;
import juego.componentes.Comercio;
import juego.entidades.Enemigo;
import juego.entidades.Espada;
import juego.entidades.Vendedor;


/**
 *
 * @author Martin
 */
public class Fabrica extends FabricaPrincipal {

    public static void crearLugares() {
        // Crea el lugar de Inicio
        LugarBase inicio = new LugarBase(
            "Aldea inicial",
            "        ~            Éres un aspirante a pirata\n" +
            "    ~ )_)_~         Tu objetivo es aprender\n" +
            "   )_))_))_)         a dominar la espada.\n" +
            "   _!__!__!_\n" +
            "  \\_______/           Compra una espada\n" +
            "~~~~~~~~~~~     y luego gana 3 batallas\n" +
            "\n");
            
        
        LugarBase feria  = new LugarBase("Feria de comercio",// Lugar para el comerciante
            "\nSi quieres ser pirata debes conseguir una espada primero.\n");
        LugarBase barrio = new LugarBase("Barrio pirata", // Lugar para los combates
            "\nDebes desafiar a 3 piratas\n");
        LugarBase maestro = new LugarBase("La casa del maestro de la espada.", 
           "\nEl maestro entrena para poder desafiar a los piratas\n");
           
        // Agrega los lugares al inicio        
        inicio.agregarVecino(feria.referencia("Feria, Ve al centro comercial"));
        inicio.agregarVecino(barrio.referencia("Busca piratas para luchar"));
        inicio.agregarVecino(maestro.referencia("Aprende a dominar la espada"));
        //Agrega Inicio a lugares
        feria.agregarVecino(inicio.referencia("Volver al inicio"));
        barrio.agregarVecino(inicio.referencia("Volver al de inicio"));
        maestro.agregarVecino(inicio.referencia("Volver al inicio"));
        //Agreaga lugares al repositorio
        RepositorioPrincipal.agregar(inicio, "inicio");
        RepositorioPrincipal.agregar(feria, "feria");
        RepositorioPrincipal.agregar(maestro, "La casa del maestro de la espada.");
        RepositorioPrincipal.agregar(barrio, "Barrio pirata");
    }
    
    public static void crearPersonajes () {
        
        Espada Espada = new Espada();
        
        Vendedor Comerciante  = new Vendedor("Vendedor de Espadas");
        RepositorioPrincipal.agregar(Comerciante, "Vendedor de Espadas");
        LugarBase feria = (LugarBase) RepositorioPrincipal.traer("feria");
        feria.agregarComerciante(Comerciante.referencia("Vendedor de Espadas"));
        
        Enemigo Master = new Enemigo ("swordTeacher");
        RepositorioPrincipal.agregar(Master, "swordTeacher");
        LugarBase LaCasa = (LugarBase) RepositorioPrincipal.traer("La casa del maestro de la espada.");
        LaCasa.agregarLuchador(Master.referencia("swordTeacher"));
        
        Enemigo Piratas = new Enemigo ("Unos piratas malvados");
        LugarBase elBarrio = (LugarBase) RepositorioPrincipal.traer("Barrio pirata");
        elBarrio.agregarLuchador(Piratas.referencia("Unos piratas malvados"));
        
        /**
        * LugarBase elBarrio = (LugarBase) RepositorioPrincipal.traer("Barrio pirata");
        *
        * Enemigo Pirata1 = new Enemigo ("lechuck");
        * RepositorioPrincipal.agregar(Pirata1, "lechuck");
        * elBarrio.agregarLuchador(Pirata1.referencia("lechuck"));
        *
        * Enemigo Pirata2 = new Enemigo ("guybrush");
        * RepositorioPrincipal.agregar(Pirata2, "guybrush");
        * elBarrio.agregarLuchador(Pirata2.referencia("guybrush"));
        *
        * Enemigo Pirata3 = new Enemigo ("barba");
        * RepositorioPrincipal.agregar(Pirata3, "barba");
        * elBarrio.agregarLuchador(Pirata3.referencia("barba"));
        */    
   } 
}
