package laboratorio5.tp1;

import java.util.ArrayList;

/**
 *
 * @author Paula
 */
public class BeerHouse {
    private int stock = 0;
    //private int stocklleno = Boolean.FALSE;

    public synchronized void put(int value) 
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
 
        stock += value;
        if (stock > 100) {
            stock = 100;
            //stocklleno = Boolean.TRUE;
        }
       
        notifyAll();
    }
    
    public synchronized int get(int value)
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
            notifyAll();
            return value;
        }
        
        value = stock;
        stock = 0;
        notifyAll();
        return value;
    }
}
