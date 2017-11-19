package ohtu;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private String name;
    private String term;
    private List<Integer> exercises;

    public Course() {
        this.exercises = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public List<Integer> getExercises() {
        return exercises;
    }

    public void setExercises(List<Integer> exercises) {
        this.exercises = exercises;
    }

    @Override
    public String toString() {
        return "Kurssi:" + name + ", " + term;
    }

    public int maxExes(int week) {
        return this.exercises.get(week - 1);
    }

}
