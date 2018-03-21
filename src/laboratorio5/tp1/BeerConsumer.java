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
        while(beerHouse.stock >0)
        {
            int cant = this.random.nextInt(100); 
            beerHouse.get(cant, this);
            
            try
            {
                Thread.sleep(TIEMPOESPERA);
            } 
            catch (InterruptedException e) 
            {
                System.err.println("Consumidor " + this.nombre + ": Error en run -> " + e.getMessage());
            }
        }
        System.out.println("No hay mas stock de cervezas");
        this.stop();
        
    }
}
