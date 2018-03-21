package laboratorio5.tp1;

import java.util.ArrayList;

/**
 *
 * @author Paula
 */
public class BeerHouse {
    protected int stock = 0;
    int control = 0;

    public synchronized int put(int value, BeerProducer a) 
    {
        while (stock >= 100) 
        {
            try
            {
                wait();
            } 
            catch (InterruptedException e) 
            {
                
                System.err.println("Contenedor: Error en put -> " + e.getMessage());
                
            }
        }
        
        
        int diferencia = 100 - stock;
        if(value < diferencia){
            stock += value;
            System.out.println("El productor " + a.nombre  + " provee: " + value + " unidades");
            notifyAll();
            return value;
        }
        if (value > diferencia){
            stock += diferencia;
            System.out.println("El productor " + a.nombre  + " provee: " + diferencia + " unidades");
            return diferencia;
        }
        /*if (stock <= 0){
            a.stop();
            control = 1;
            System.out.println("No quedan cervezas en stock, los clientes se retiran");
            
        }*/
       return 0; 
    }
    
    public synchronized int get(int value, BeerConsumer a)
    {
        while (stock == 0)
        {
            try
            {
                wait();
            } 
            catch (InterruptedException e) 
            {
                System.err.println("Contenedor: Error en get -> " + e.getMessage());
            }
        }
        
        if (stock >= value) {
            stock -= value;
            System.out.println("El cliente " + a.nombre  + " consume: " + value + " unidades");
            notifyAll();
            return value;
        }
        
            value = stock;
            stock = 0;
            System.out.println("El cliente " + a.nombre  + " consume: " + value + " unidades");
            notifyAll();
        return 0;
    }
}
