/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio5.tp1;

import java.util.Random;

/**
 *
 * @author Paula
 */
public class BeerConsumer extends Thread {
    
    private final BeerHouse beerHouse;
    public final String nombre;
    private final int TIEMPOESPERA = 1000;
    private Random random;
 
    public BeerConsumer(BeerHouse beerHouse, String nombre) 
    {
        this.beerHouse = beerHouse;
        this.nombre = nombre;
        this.random = new Random();
    }
    
    public void run() 
    {
        while(Boolean.TRUE)
        {
            int cant = this.random.nextInt(50); 
            cant = beerHouse.get(cant, this);
            //System.out.println("El cliente " + this.nombre + " consume: " + cant + " unidades");
            
            try
            {
                Thread.sleep(TIEMPOESPERA);
            } 
            catch (InterruptedException e) 
            {
                System.err.println("Consumidor " + this.nombre + ": Error en run -> " + e.getMessage());
            }
        }
    }
}
