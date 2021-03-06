package laboratorio5.tp1;

import java.util.Random;

/**
 *
 * @author Paula
 */
public class BeerProducer extends Thread
{   
    private BeerHouse beerHouse;
    public String nombre;
    private final int TIEMPOESPERA = 1000 ;
    private Random random;
 
    public BeerProducer(BeerHouse beerHouse, String nombre) 
    {
        this.beerHouse = beerHouse;
        this.nombre = nombre;
        this.random = new Random();
    }
 
    public void run() 
    {
        do
        {   
            int cant = this.random.nextInt(100);
            beerHouse.put(cant, this);
            
            try
            {
                Thread.sleep(TIEMPOESPERA);
            } 
            catch (InterruptedException e) 
            {
                System.err.println("Productor " + this.nombre + ": Error en run -> " + e.getMessage());
            }
        }while(beerHouse.stock > 0);
        
        System.out.println("No hay mas stock de cervezas");
        this.stop();
        
    }
}

