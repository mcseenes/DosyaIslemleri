package com.enes.entity;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class Manager {
    private String file = "src/main/resources/";
    private String path;

    public Manager() {
    }

    public Manager(String path) {
        this.path = path;
    }

    public List<Student> getStudents(String path) {
        List<Student> st = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            st = (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return st;
    }

    // The method here reads student information and grades using the teacher's name and BufferedReader as parameters;
    // It also includes extracted method created below which creates a student class with the obtained parameters and adds it to the student list:
    public List<Student> readFromFile(String teacherName, BufferedReader reader) {
        try {
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] lineParts = makeAstudentAndAddtoList(line);
                System.out.println(teacherName + " isimli ogretmen" + " " + lineParts[0] + " isimli ogrencinin notlarini okudu.");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return Teacher.studentList;
    }

    public String[] makeAstudentAndAddtoList(String line) {
        String[] lineParts = line.split(",");
        double studentAv = scoresAverage(Arrays.stream(lineParts).toList().subList(1, 4));
        String studentName = lineParts[0];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateOfBirth = LocalDate.parse(lineParts[4], formatter);
        Student student = new Student(studentName, studentAv, dateOfBirth);
        Teacher.studentList.add(student);
        return lineParts;
    }

    //Calculates the average of the grades given.
    public double scoresAverage(List<String> notes) {
        return notes.stream().mapToDouble(Double::parseDouble).average().getAsDouble();
    }

    //It serializes the student list and saves it in a file.
    // This method will actually create a file such as teacher's name.txt and write the incoming student list into that file.
    public void createTeacherFile(List<Student> studentList, String teacherName) {
        File teacherFile = new File(file + teacherName + ".txt");
        try {
            FileOutputStream fos = new FileOutputStream(teacherFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(studentList);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Manager{");
        sb.append("file='").append(file).append('\'');
        sb.append(", path='").append(path).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
