/*
 * The MIT License
 *
 * Copyright 2018 fernando.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package juego.sistemas;

import ifts16.pp.juego.entidades.Entidad;
import ifts16.pp.juego.entidades.LugarBase;
import ifts16.pp.juego.sistemas.IOBase;
import ifts16.pp.juego.sistemas.RepositorioPrincipal;
import ifts16.pp.juego.sistemas.Sistema;
import ifts16.pp.juego.utiles.Opcion;
import ifts16.pp.juego.utiles.Opciones;
import java.awt.Color;
import juego.entidades.Personaje;
import juego.sistemas.Combates;
import juego.entidades.Vendedor;
import static juego.sistemas.Combates.nuevaLucha;
import static juego.sistemas.Transacciones.nuevaTransaccion;

public class NavegacionBase extends Sistema {
  
    public static LugarBase ubicacionActual;
    
    public static void iniciar(LugarBase inicio) throws InterruptedException {
        
        ubicacionActual = inicio;
        while (ubicacionActual != null) {
            
            IOBase.borrar();
            IOBase.mostrarTexto(ubicacionActual.getNombre(), Color.white, Color.blue);
            IOBase.mostrarTexto(ubicacionActual.getDescripcion());
            Opciones ops = ubicacionActual.opciones("Elija que hacer en este lugar\n");
            ops.agregar("ninguno", "Salir del juego");
            Opcion eleccion = IOBase.elegirOpcion(ops);
            IOBase.mostrarTexto("Eligio: " + eleccion.getTexto());
            
            if (eleccion.esComando() && eleccion.getComando().equalsIgnoreCase("ninguno")) {
                ubicacionActual = null;
            } else {
                realizarAccion(eleccion);
            }
        }
        IOBase.mostrarTexto("Fin del recorrido");
    }
    
    public static void realizarAccion(Opcion op) throws InterruptedException {
        switch (op.getComando()) {
            case "vecinos":
                irAVecino(ubicacionActual);
                break;
            case "luchadores":
                 luchar(ubicacionActual);
                break;
            case "comerciantes":
                comerciar(ubicacionActual);
                break;
            case "items":
                recolectarItems(ubicacionActual);
                break;
        }
    }
    
    public static void irAVecino(LugarBase ubicacion) {
        IOBase.borrar();
        Opciones ops = ubicacion.getVecinos()
        .opcionesActivas("Elija el lugar limítrofe a ir.\n");
        Opcion eleccion = IOBase.elegirOpcion(ops);
        IOBase.mostrarTexto("Eligio ir a " + eleccion.getTexto());
        if (eleccion.esEntidad()) {
            ubicacionActual = (LugarBase) RepositorioPrincipal.traer(eleccion.getEntidadId());
        }
    }
        
    public static void comerciar(LugarBase ubicacion) throws InterruptedException {
        Personaje p = new Personaje();
        Vendedor v = (Vendedor) RepositorioPrincipal.traer("Vendedor de Espadas");
        IOBase.borrar();
        Opciones ops = ubicacion.getComerciantes().opcionesActivas
        ("\n Elija un Comerciante ");
        
        Opcion eleccion = IOBase.elegirOpcion(ops);
        
        IOBase.mostrarTexto("Eligio ir a " + eleccion.getTexto());
        if (eleccion.esEntidad()) {
            nuevaTransaccion(v, p);
        }
    }  
    
    public static void luchar(LugarBase ubicacion) throws InterruptedException {
         // Menu principal decide con que Pirata lucha
        IOBase.borrar(); 
        
        LugarBase LaCasa = (LugarBase) RepositorioPrincipal.traer("La casa del maestro de la espada.");
        if (ubicacionActual.getNombre() == LaCasa.getNombre())
        {
            IOBase.mostrarTexto("Falta Implemetar Entrenamieto");
            Thread.sleep(2000);
        }else{
            nuevaLucha();
        }
    }
    
    public static void recolectarItems(LugarBase ubicacion) {
        
    }
}
