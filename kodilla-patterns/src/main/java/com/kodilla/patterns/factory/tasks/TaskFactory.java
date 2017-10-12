package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPING = "Shopping Task";
    public static final String PAINTING = "Painting Task";
    public static final String DRIVING = "Driving Task";

    public final Task makeTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPING:
                return new ShoppingTask("Shopping addiction", "Happiness", 999.999);
            case PAINTING:
                return new PaintingTask("Painting rage", "Yellow", "The Sky with Stars");
            case DRIVING:
                return new DrivingTask("Driving pleasure", "To the future", "DeLorean DMC-12");
            default:
                return null;
        }
    }
}
