package org.example;

public interface Observable {
    //slap this on a sensor class
    public void notify(Object listener);

}
