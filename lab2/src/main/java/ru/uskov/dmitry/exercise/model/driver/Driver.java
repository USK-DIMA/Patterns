package ru.uskov.dmitry.exercise.model.driver;


abstract public class Driver {
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
