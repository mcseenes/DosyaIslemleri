package com.enes;

import com.enes.entity.Manager;
import com.enes.entity.Student;
import com.enes.entity.Teacher;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static com.enes.entity.Teacher.studentList;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        ///////////////========================== MANAGER CLASS METHODS' RUN==================================//////////////////////////
        Manager manager = new Manager();
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\ESMANUR\\eclipse-workspace\\DosyaIslemleri\\src\\main\\resources\\ogrenciler.txt"));

        List<Student> studentList = manager.readFromFile("Hatice", reader);
        System.out.println(studentList);

        manager.createTeacherFile(studentList, "Orhan");

        List<String> scores = List.of("95", "76", "65", "98", "70");
        System.out.println(manager.scoresAverage(scores));


        //////////////============================TEACHER CLASS METHODS' RUN================================//////////////////////////
        Teacher teacher = new Teacher("SAMET", studentList);
        teacher.readScoresAndMakeList();
        System.out.println(studentList);
        teacher.createTeacherfromManager();
        System.out.println(teacher.getStudentsFromFile("C:\\Users\\ESMANUR\\eclipse-workspace\\DosyaIslemleri\\src\\main\\resources\\Samet.txt"));



    }
}

