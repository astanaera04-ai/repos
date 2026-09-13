# Builder Pattern - Workout Plan Generator

## 1. Project Description
This project implements the Builder creational design pattern in Java to construct complex `WorkoutPlan` objects. It features a `WorkoutPlanBuilder` with a fluent API (method chaining) and a `WorkoutDirector` to orchestrate predefined standard workout plans (Weight Loss).

## 2. Clean Code Principles Applied (Section 3 of the assignment)

**1. Meaningful, intention-revealing names:**
Variables and methods clearly state their purpose.
*Before (Bad):* `public void addC(String c)`
*After (Good):* `public WorkoutPlanBuilder addCardio(String cardio)`

**2. Method Chaining (Fluent API):**
Small, focused setter methods in the Builder return the current instance, making the client code very readable.
*Code Excerpt:*
```java
public WorkoutPlanBuilder setDuration(int minutes) {
    this.durationInMinutes = minutes;
    return this; // Allows chained calls like .setGoal("X").setDuration(60)
}