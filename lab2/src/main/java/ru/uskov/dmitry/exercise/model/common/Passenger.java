package ru.uskov.dmitry.exercise.model.common;

public class Passenger {

    Category category;

    public Passenger(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public enum Category{
        benefit, child, adult
    }
}
