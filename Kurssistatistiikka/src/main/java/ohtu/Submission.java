package ohtu;

import java.util.ArrayList;
import java.util.List;

public class Submission {

    private int hours;
    private int week;
    private List<Integer> exercises;

    public Submission() {
        this.exercises = new ArrayList<>();
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public List<Integer> getExercises() {
        return exercises;
    }

    public void setExercises(List<Integer> exercises) {
        this.exercises = exercises;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getWeek() {
        return week;
    }

    @Override
    public String toString() {
        String loop = "";
        for (int i = 0; i < this.exercises.size() - 1; i++) {
            loop += this.exercises.get(i) + " ";
        }
        return "viikko " + this.week + ": \n tehtyjä tehtäviä yhteensä: " + this.exercises.size() + ", aikaa kului " + this.hours + " tuntia, tehdyt tehtävät:" + loop;
         
    }
    
        public String printSub(int max) {
        String loop = "";
        for (int i = 0; i < this.exercises.size() - 1; i++) {
            loop += this.exercises.get(i) + " ";
        }
        return "viikko " + this.week + ": \n tehtyjä tehtäviä yhteensä: " + this.exercises.size() + " (maksimi: "+ max + ")" + ", aikaa kului " + this.hours + " tuntia, tehdyt tehtävät:" + loop;
         
    }

}
