package com.sg.studentquizgrades;

import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author Stuart
 */
public class App {

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    public void run() {
        userIOImpl io = new userIOImpl();
        int choice;
        boolean exitFlag = false;
        QuizBook book = new QuizBook();
        String student;
        int score;
        ArrayList<Integer> list;

        while (!exitFlag) {
            io.println("Choose an option");
            io.println("1. View Student List");
            io.println("2. Add Student");
            io.println("3. Remove Student");
            io.println("4. View Student Scores");
            io.println("5. Exit");
            choice = io.readInt("Your choice: ", 1, 5);

            // TODO: add options
            switch (choice) {
                case 1:
                    Set studentSet = book.getStudents();

                    for(String item : studentSet) {
                        io.println(student);
                    }
                            
                case 2:
                    student = io.readString("Student name: ");
                    book.addStudent(student);
                    break;
                case 3:
                    student = io.readString("Student name: ");
                    if (!book.studentExists(student)) {
                        io.println("Student does not exist");
                        break;
                    }
                    displayStudent(); // make this up
                case 4:
                    student = io.readString("Student name: ");
                    if (!book.studentExists(student)) {
                        io.println("Student does not exist");
                        break;
                    }
                    list = book.getScores(student);
                    io.print(student + ": ");
                    for (int i : list) {
                        io.print(i + ", ");
                    }
                    break;
                case 5:
                    exitFlag = true;
                    break;
                default:
                    io.println("Invalid choice, exiting...");
                    exitFlag = true;
            }
        }
    }
}
