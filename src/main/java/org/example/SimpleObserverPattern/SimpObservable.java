package org.example.SimpleObserverPattern;

import org.example.Observable;

import java.util.ArrayList;
import java.util.List;

public class SimpObservable implements SimpObservableInterface {

    private int[] samples;
    private ArrayList<SimpObserverClass> observers = new ArrayList<>();


    int randomNumber;
    public SimpObservable(){


        /* Denne her klasse indeholder metoder til at generere random tal. - Men de skal være deterministiske når det er spændingsmålinger.
        hver objekt af det er sin egen kopi af klassen - dvs. flere forskellige objekter kan have forskellige

        størrelser
         */
        int min,max;
        min= 70;
        max=90;
       randomNumber= (int) (Math.random()*(max-min)) + min;
        samples = new int[250];

    }


    private int[] makeSamples (){
        //make a random number of samples, representative of the 250-300 ish samples.
        //random methods https://www.delftstack.com/howto/java/java-random-number-between-1-and-10/#random.nextint-to-generate-a-random-number-between-1-and-10

        for(int i : samples){
            i = randomNumber;
        }

        return samples;
    }
    @Override
    public void run() {


    }

    @Override
    public void addObserver(SimpObserverClass observable) {
        observers.add(observable);
    }

    @Override
    public void removeObserver(SimpObserverClass observable) {

    }
}
