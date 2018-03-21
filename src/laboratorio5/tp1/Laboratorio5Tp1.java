/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio5.tp1;

/**
 *
 * @author Paula
 */
public class Laboratorio5Tp1 {
    
    public static void main(String[] args) 
    {
        BeerHouse beerHouse = new BeerHouse();
        
        BeerProducer antares = new BeerProducer(beerHouse, "antares");
        BeerProducer cheverry = new BeerProducer(beerHouse, "cheverry");
        cheverry.start();
        antares.start();
        
        BeerConsumer paula = new BeerConsumer(beerHouse, "paula");
        BeerConsumer gatin = new BeerConsumer(beerHouse, "gatin");
        paula.start();
        gatin.start();
        
        
    } 
}
