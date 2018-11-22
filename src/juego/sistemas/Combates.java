/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.sistemas;

import ifts16.pp.juego.entidades.LugarBase;
import ifts16.pp.juego.sistemas.IOBase;
import ifts16.pp.juego.sistemas.RepositorioPrincipal;
import ifts16.pp.juego.utiles.Opcion;
import ifts16.pp.juego.utiles.Opciones;
import juego.entidades.Enemigo;
import juego.entidades.Personaje;
import juego.sistemas.Fabrica;
import static juego.sistemas.NavegacionBase.ubicacionActual;
import static juego.sistemas.NavegacionBase.irAVecino;
/**
 *
 * @author Martin
 */

public class Combates {
    
    public static Opcion opcionElegida;
    public static boolean viveGuybrush = true;
    public static boolean viveLechuck = true;
    public static boolean viveBarba = true;
    
  
    public static void nuevaLucha() throws InterruptedException{
                
        // Menu principal decide con que Pirata lucha
        IOBase.borrar();
        Opciones ops = new Opciones("Con que Pirata deseas Luchar \n");
        if (viveGuybrush)ops.agregar("guybrush", "Pelear con el consagrado Guybrush Threepwood");
        if (viveLechuck)ops.agregar("lechuck", "Batirse a duelo con el temido LeChuck");
        if (viveBarba)ops.agregar("barba", "Desafiar a Barba Azul");
        ops.agregar("ninguno", "Volver al barrio pirata");
                
        Opcion eleccion = IOBase.elegirOpcion(ops);
        IOBase.borrar();
        if(eleccion.getComando() != "ninguno"){
            pelearCon(eleccion);
        }
        if (eleccion.getComando() == "ninguno") {      
            ubicacionActual = (LugarBase) RepositorioPrincipal.traer("Barrio pirata");
            NavegacionBase.iniciar(ubicacionActual);   
        }
    }
    
    
    public static void pelearCon(Opcion op)throws InterruptedException{
       
        boolean error1 = false;// Si se equivoca deja sin efecto la opcion
        boolean error2 = false;// Si se equivoca deja sin efecto la opcion
        boolean error3 = false;// Si se equivoca deja sin efecto la opcion
        boolean incorrecta = true; //Recorre prenguntas mientras elija una incorrecta
        int errores = 0; //Contador de errores , *** implementar ***
        
        while(errores <= 2){
            switch (op.getComando()){
                    case "guybrush":
                        while(incorrecta){
                        Opciones ops = new Opciones("\nEres como un tesoro... ¿y tu dices ? \n");
                        if (!error1)ops.agregar("error1", "Te pareces a King Kong");
                        if (!error2)ops.agregar("error2", "Pareces un barre fondo");
                        if (!error3)ops.agregar("error3", "Gracias Camarada, Tu tienes un corazón de Oro. !");
                        ops.agregar("correcta","Voy a enterrarte en las profundidades de la Isla.");                    
                                             
                        Opcion eleccion = IOBase.elegirOpcion(ops);
                        
                        switch (eleccion.getComando()){
                            case "error1":
                                IOBase.borrar();
                                IOBase.mostrarTexto(ops.getMensaje() + eleccion.getTexto()+"\n");
                                IOBase.mostrarTexto("\n Se ve q no entiendes de que va esto"
                                                       +"\n PERDISTE LA CONTIENDA");
                                Thread.sleep(5000);
                                error1 = true;// Elimina la opcion del menu
                                break;

                            case "error2":
                                IOBase.borrar();
                                IOBase.mostrarTexto(ops.getMensaje() + eleccion.getTexto() +"\n" );
                                IOBase.mostrarTexto("\n Parece que voy a barrer el piso contigo."
                                                    +"\n PERDISTE LA CONTIENDA");
                                Thread.sleep(5000);
                                error2 = true;// Elimina la opcion del menu
                                break;

                            case "error3": 
                                IOBase.borrar();
                                IOBase.mostrarTexto(ops.getMensaje() + eleccion.getTexto()+"\n");
                                IOBase.mostrarTexto("\n Eres patético no ganaras esta contienda "
                                                    + "diciendo halagos.");
                                Thread.sleep(6000);
                                error3 = true;// Elimina la opcion del menu
                                break;

                            case "correcta":  
                                IOBase.borrar();
                                IOBase.mostrarTexto(ops.getMensaje() + eleccion.getTexto()+"\n");
                                IOBase.mostrarTexto("\nFELICITACIONES.\n"
                                                    +"\n GANASTE LA CONTIENDA");
                                Thread.sleep(4000);
                                incorrecta = true;
                                viveGuybrush = false;
                                Combates.nuevaLucha();
                                break;
                            }
                        }
                        break;
                
                case "lechuck":    
                    while(incorrecta)
                        {
                            Opciones ops = new Opciones("\n¿Has nacido así de feo?... ¿y tu dices ? \n");
                            if (!error1)ops.agregar("error1", "Mi madre nunca ha dicho que soy feo.");
                            if (!error2)ops.agregar("error2", "Eso es algo que nunca pienso.");
                            if (!error3)ops.agregar("error3", "Si a tu hermana yo le agrado.");
                            ops.agregar("correcta","¿Y tú? Seguro te has perfeccionado con el tiempo.");                    
                            
                            Opcion eleccion = IOBase.elegirOpcion(ops);
                            switch (eleccion.getComando()){
                                case "error1":
                                    IOBase.borrar();
                                    IOBase.mostrarTexto(ops.getMensaje() + eleccion.getTexto()+"\n");
                                    IOBase.mostrarTexto("\n Ella debe de ser ciega y/o muda.\n" 	
                                                        +"\n PERDISTE LA CONTIENDA");
                                    Thread.sleep(5000);
                                    error1 = true;
                                    break;

                                case "error2":
                                    IOBase.borrar();
                                    IOBase.mostrarTexto(ops.getMensaje() + eleccion.getTexto()+"\n");
                                    IOBase.mostrarTexto("\n Queda claro que tú no piensas mucho en nada"
                                                        +"\n PERDISTE LA CONTIENDA");
                                    Thread.sleep(5000);
                                    error2 = true;
                                    break;

                                case "error3": 
                                    IOBase.borrar();
                                    IOBase.mostrarTexto(ops.getMensaje() + eleccion.getTexto()+"\n");
                                    IOBase.mostrarTexto("\n ¿Mi hermana? Si es más ciega que un murciélago."
                                                        +"\n PERDISTE LA CONTIENDA");
                                    Thread.sleep(6000);
                                    error3 = true;
                                    break;

                                case "correcta":  
                                    IOBase.borrar();
                                    IOBase.mostrarTexto(ops.getMensaje() + eleccion.getTexto()+"\n");
                                    IOBase.mostrarTexto("\n Me has derrotado!\n"
                                                        +"\nFELICITACIONES.\n"
                                                        +"\n GANASTE LA CONTIENDA");
                                    Thread.sleep(4000);
                                    incorrecta = true;
                                    viveLechuck = false;
                                    Combates.nuevaLucha();
                                    break;
                            }
                        }
                        break;
                        
                        case "barba":
                        while(incorrecta)
                            {
                            Opciones ops = new Opciones("Barba Azul dice: Cando acabe contigo..... ¿y tu dices ? \n");
                            ops.agregar("correcta","No te recogerá ni el recolector de basura."); 
                            if (!error1)ops.agregar("error1", "Ni tu madre va a reconocerte.");
                            if (!error2)ops.agregar("error2", "Haré empanadas con tus restos");
                            if (!error3)ops.agregar("error3", "Iré con mis amigos");


                            Opcion eleccion = IOBase.elegirOpcion(ops);
                            switch (eleccion.getComando()){
                                case "error1":
                                    IOBase.borrar();
                                    IOBase.mostrarTexto(ops.getMensaje() + eleccion.getTexto()+"\n");
                                    IOBase.mostrarTexto("\n Dalo por hecho, pero la tuya si me reconoce."
                                                           +"\n PERDISTE LA CONTIENDA");
                                    Thread.sleep(5000);
                                    error1 = true;
                                    break;

                                case "error2":
                                    IOBase.borrar();
                                    IOBase.mostrarTexto(ops.getMensaje() + eleccion.getTexto()+"\n");
                                    IOBase.mostrarTexto("\n Siempre supe que eras un muerto de hambre."
                                                        +"\n PERDISTE LA CONTIENDA");
                                    Thread.sleep(5000);
                                    
                                    error2 = true;
                                    break;

                                case "error3": 
                                    IOBase.borrar();
                                    IOBase.mostrarTexto(ops.getMensaje() + eleccion.getTexto()+"\n");
                                    IOBase.mostrarTexto("\n Es no es posible, tú no tienes ningún amigo."
                                                        +"\n PERDISTE LA CONTIENDA");
                                    Thread.sleep(6000);
                                    
                                    error3 = true;
                                    break;

                                case "correcta":  
                                    IOBase.borrar();
                                    IOBase.mostrarTexto("\n"+ ops.getMensaje() + eleccion.getTexto()+"\n");
                                    IOBase.mostrarTexto("Me has derrotado trash collector.\n"
                                                        +"\n FELICITACIONES\n"
                                                        +"\n GANASTE LA CONTIENDA\n");
                                    
                                    Thread.sleep(4000);
                                    incorrecta = true;
                                    viveBarba = false;
                                    Combates.nuevaLucha();
                                    break;
                            }
                        }
                        break;
                }
            }
    }
}

        
      