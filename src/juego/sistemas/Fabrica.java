package juego.sistemas;

import ifts16.pp.juego.entidades.LugarBase;
import ifts16.pp.juego.entidades.PersonajeAbstracto;
import ifts16.pp.juego.sistemas.FabricaPrincipal;
import ifts16.pp.juego.sistemas.RepositorioPrincipal;
import ifts16.pp.juego.sistemas.NavegacionBase;
import juego.componentes.Comercio;
import juego.entidades.Enemigo;
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
        
        LugarBase barrio = new LugarBase("Barrio pirata", 
        "Barrio donde desafiar a los piratas");
        
        Fabrica.agregarIdLugar(inicio.getId()); 
        
        inicio.agregarVecino(feria.referencia("Feria, Centro de comercio"));
        inicio.agregarVecino(practica.referencia("Campo de Practica"));
        inicio.agregarVecino(maestro.referencia("La casa del maestro de la espada."));
        inicio.agregarVecino(barrio.referencia("Barrio pirata"));
        
        feria.agregarVecino(inicio.referencia("La aldea de inicio"));
        practica.agregarVecino(inicio.referencia("La aldea de inicio"));
        maestro.agregarVecino(inicio.referencia("La aldea de inicio"));
        barrio.agregarVecino(inicio.referencia("La aldea de inicio"));
                
        RepositorioPrincipal.agregar(inicio, "inicio");
        RepositorioPrincipal.agregar(feria, "feria");
        RepositorioPrincipal.agregar(practica, "practica");
        RepositorioPrincipal.agregar(maestro, "La casa del maestro de la espada.");
        RepositorioPrincipal.agregar(barrio, "Barrio pirata");
    }
    
    public static void crearPersonajes () {

        Vendedor Martin  = new Vendedor("Martin");
        RepositorioPrincipal.agregar(Martin, "martin");
        LugarBase feria = (LugarBase) RepositorioPrincipal.traer("feria");
        feria.agregarComerciante(Martin.referencia("El vendedor Martin"));              
        
        Enemigo Master = new Enemigo ("swordTeacher");
        RepositorioPrincipal.agregar(Master, "swordTeacher");
        LugarBase LaCasa = (LugarBase) RepositorioPrincipal.traer("La casa del maestro de la espada.");
        LaCasa.agregarLuchador(Master.referencia("swordTeacher"));
        
        Enemigo Pirata1 = new Enemigo ("LeChuck");
        RepositorioPrincipal.agregar(Pirata1, "LeChuck");
        LugarBase elBarrio = (LugarBase) RepositorioPrincipal.traer("Barrio pirata");
        elBarrio.agregarLuchador(Pirata1.referencia("LeChuck"));
        
        Enemigo Pirata2 = new Enemigo ("Guybrush");
        RepositorioPrincipal.agregar(Pirata2, "Guybrush");
        elBarrio.agregarLuchador(Pirata2.referencia("Guybrush"));
        
        Enemigo Pirata3 = new Enemigo ("Barba Azul");
        RepositorioPrincipal.agregar(Pirata3, "Barba Azul");
        elBarrio.agregarLuchador(Pirata3.referencia("Barba Azul"));
    } 
}
