package org.example.SimpleObserverPattern;

import org.example.Observable;

public interface SimpObservableInterface extends Runnable {
    public void addObserver(SimpObserverClass observerClass);
    public void removeObserver(SimpObserverClass observerClass);
}
