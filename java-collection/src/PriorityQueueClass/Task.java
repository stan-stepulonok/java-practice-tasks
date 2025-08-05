package PriorityQueueClass;

import java.util.Comparator;

public class Task {

    private String name;
    private Integer priority;

    Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return String.format("Task %s: priority %d", name, priority);
    }

    public String getName() {
        return this.name;
    }

    public Integer getPriority() {
        return this.priority;
    }


}
