package com.example;

import com.example.entity.Student;
import com.example.model.StudentList;

import java.util.*;

public class Application {
    private static Scanner input = new Scanner(System.in);
    private static StudentList list;

    public static void menu(){
        System.out.println("1. Add a new student");
        System.out.println("2. Delete a student");
        System.out.println("3. Search by name");
        System.out.println("4. Search nny id");
        System.out.println("5. Print student info descending order of mark");
        System.out.println("6. Exit");
    }

    public static void main(String[] args) {
        list = new StudentList();
        menu();

        while (true) {
            int choice;
            System.out.println("#: ");
            choice = input.nextInt();
            if (choice == 1) {
                addStudent();
                menu();
            } else if (choice == 2) {
                deleteStudent();
                menu();
            } else if (choice == 3) {
                searchByName();
                menu();
            } else if (choice == 4) {
                searchById();
                menu();
            } else if (choice == 5) {
                printSorted();
                menu();
            } else if (choice == 6) {
                System.exit(0);
            }
        }
    }

    private static void addStudent() {
        int id = 0;
        String fn;
        String ln;
        double mark;
        System.out.println("ID: ");
        id = input.nextInt();
        System.out.println("First name: ");
        fn = input.next();
        System.out.println("Last name: ");
        ln = input.next();
        System.out.println("Mark: ");
        mark = input.nextDouble();
        Student s = new Student(id, fn, ln, mark);
        list.add(s);
    }

    public static void deleteStudent() {
        int id;
        System.out.println("ID: ");
        id = input.nextInt();
        list.remove(id);
    }

    public static void searchByName() {
        String name;
        System.out.println("Name: ");
        name = input.next();
        ArrayList<Student> found = list.findByName(name);
        list.showList(found);
    }

    public static void searchById() {
        int id;
        System.out.println(" ID: ");
        id = input.nextInt();
        Student s = list.findById(id);
        if (s == null) {
            System.out.println("Not found");
        } else {
            s.printInfo();
        }

    }

    public static void printSorted() {
        list.sortByMarks();
        list.showList();
    }


}
