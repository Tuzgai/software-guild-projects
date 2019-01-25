package com.sg.studentquizgrades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Stuart
 */
public class QuizBook {
    HashMap <String, ArrayList<Integer>> studentMap;
    
    public Set<String> getStudents () {
        return studentMap.keySet();
    }
    
    public boolean studentExists(String student) {
        return studentMap.containsKey(student);
    }
    
    public void addStudent(String student) {
        ArrayList<Integer> list = new ArrayList<>();
        studentMap.put(student, list);
    }
    
    public void addScore(String student, int score) {
        ArrayList<Integer> list = studentMap.get(student);
        list.add(score);
        studentMap.put(student, list);
    }
    
    public void removeStudent(String student) {
        studentMap.remove(student);
    }
    
    public double averageScore(String student) {
        ArrayList<Integer> list = studentMap.get(student);
        double sum = 0;
        for(int grade : list) {
            sum += grade;
        }
        
        return sum / list.size();
    }
    
    public ArrayList<Integer> getScores(String student) {
        return studentMap.get(student);
    }
}
