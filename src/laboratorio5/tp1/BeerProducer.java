package laboratorio5.tp1;

import java.util.Random;

/**
 *
 * @author Paula
 */
public class BeerProducer extends Thread
{   
    private BeerHouse beerHouse;
    private String nombre;
    private final int TIEMPOESPERA = 1000;
    private Random random;
 
    public BeerProducer(BeerHouse beerHouse, String nombre) 
    {
        this.beerHouse = beerHouse;
        this.nombre = nombre;
        this.random = new Random();
    }
 
    @Override
    /**
     * Implementación de la hebra
     */
    public void run() 
    {
        while(Boolean.TRUE)
        {   
            int cant = this.random.nextInt(100);
            System.out.println("El productor " + this.nombre + " provee: " + cant + " unidades");
            beerHouse.put(cant);
            
            try
            {
                Thread.sleep(TIEMPOESPERA);
            } 
            catch (InterruptedException e) 
            {
                System.err.println("Productor " + this.nombre + ": Error en run -> " + e.getMessage());
            }
        }
    }
}

