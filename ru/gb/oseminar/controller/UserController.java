package ru.gb.oseminar.controller;

import java.time.LocalDate;
import java.util.List;
import ru.gb.oseminar.data.Student;
import ru.gb.oseminar.data.StudentStream;
import ru.gb.oseminar.data.Teacher;
import ru.gb.oseminar.data.User;
import ru.gb.oseminar.service.DataService;
import ru.gb.oseminar.service.StudentGroupService;
import ru.gb.oseminar.service.StudentStreamService;
import ru.gb.oseminar.view.UserView;


public class UserController {

    public final DataService dataService = new DataService();
    private final StudentGroupService studentGroupService = new StudentGroupService();
    private final UserView userView = new UserView();

    public void createStudent(String firstName, String secondName, String patronymic, LocalDate dateOfBirth){
        dataService.create(firstName, secondName, patronymic, dateOfBirth);
        List<User> userList = dataService.getAll();
        userView.sendOnConsole(userList);
    }

    public void createStudentGroup(Teacher teacher, List<Student> students){
        studentGroupService.createStudentGroup(teacher, students);
    }

    public Student getStudentInStudentGroup(String firstName, String secondName){
        return studentGroupService.getStudentFromStudentGroup(firstName, secondName);
    }

    public List<Student> getSortedListStudentFromStudentGroup(){
        return studentGroupService.getSortedStudentGroup();
    }

    public List<Student> getSortedListByFIOStudentFromStudentGroup(){
        return studentGroupService.getSortedByFIOStudentGroup();
    }
    private final StudentStreamService streamService = new StudentStreamService();
    public void sortStreams(List<StudentStream> streams) {
        streamService.sortStreams(streams);
    }
}
