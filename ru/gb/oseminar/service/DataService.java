package ru.gb.oseminar.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import ru.gb.oseminar.data.Student;
import ru.gb.oseminar.data.User;

public class DataService {

    private List<User> users;

    public DataService() {
        this.users = new ArrayList<>();
    }

    public List<User> getAll(){
        return this.users;
    }

    public Student create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        Long countMaxId = 0L;
        for (User user : this.users) {
            if (user instanceof Student) {
                if (((Student) user).getStudentId() > countMaxId) {
                    countMaxId = ((Student) user).getStudentId();
                }
            }
        }
        countMaxId++;
        Student student = new Student(firstName, secondName, patronymic, dateOfBirth, countMaxId);
        this.users.add(student);
        return student;
    }
}
