package com.sg.classroster.ui;

import com.sg.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author Stuart
 */
public class ClassRosterView {

    public ClassRosterView(UserIO io) {
        this.io = io;
    }

    UserIO io;

    public int printMenuAndGetSelection() {
        io.println("Main Menu");
        io.println("1. List Student IDs");
        io.println("2. Create New Student");
        io.println("3. View a Student");
        io.println("4. Remove a Student");
        io.println("5. Exit");

        return io.readInt("Please select from the above choices: ", 1, 5);

    }

    public Student getNewStudentInfo() {
        String studentId = io.readString("Please enter Student ID: ");
        String firstName = io.readString("Please enter First Name: ");
        String lastName = io.readString("Please enter Last Name: ");
        String cohort = io.readString("Please enter Cohort: ");
        Student currentStudent = new Student(studentId);
        currentStudent.setFirstName(firstName);
        currentStudent.setLastName(lastName);
        currentStudent.setCohort(cohort);
        return currentStudent;
    }

    public void displayCreateStudentBanner() {
        io.println("=== Create Student ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString("Student successfully created. \n Please hit enter to continue.");
    }

    public void displayStudentList(List<Student> studentList) {
        for (Student currentStudent : studentList) {
            io.println(currentStudent.getStudentId() + ":"
                    + currentStudent.getFirstName() + " "
                    + currentStudent.getLastName());
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.println("=== Display All Students ===");
    }

    public void displayDisplayStudentBanner() {
        io.println("=== Display Student ===");
    }

    public String getStudentIdChoice() {
        return io.readString("Please enter the Student ID: ");
    }

    public void displayStudent(Student student) {
        if (student != null) {
            io.println(student.getStudentId());
            io.println(student.getFirstName() + " " + student.getLastName());
            io.println(student.getCohort());
            io.println("");
        } else {
            io.println("No such student.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveStudentBanner() {
        io.println("=== Remove Student ===");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("Student successfully removed. \n Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.println("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
