package ru.gb.oseminar;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import ru.gb.oseminar.controller.*;
import ru.gb.oseminar.data.*;

public class Main {
    public static void main(String[] args) {
        UserController controller = new UserController();

        // Создание учителей
        List<Teacher> teachers = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            String firstName = "Teacher" + i;
            String lastName = "Lastname" + i;
            String patronymic = "Patronymic" + i;
            LocalDate dateOfBirth = LocalDate.of(1980, 1, 1).plusDays(i);
            Teacher teacher = new Teacher(firstName, lastName, patronymic, dateOfBirth);
            teachers.add(teacher);
        }

        // Формирование групп студентов
        List<StudentGroup> studentGroups = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            List<Student> groupStudents = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                String firstName = "Student" + (i * 5 + j + 1);
                String lastName = "Lastname" + (i * 5 + j + 1);
                String patronymic = "Patronymic" + (i * 5 + j + 1);
                LocalDate dateOfBirth = LocalDate.of(2000, 1, 1).plusDays(i * 5 + j + 1);
                Student student = controller.dataService.create(firstName, lastName, patronymic, dateOfBirth);
                groupStudents.add(student);
            }
            StudentGroup group = new StudentGroup(teachers.get(i), groupStudents);
            studentGroups.add(group);
        }

        // Создание потоков
        StudentStream stream1 = new StudentStream();
        StudentStream stream2 = new StudentStream();
        for (int i = 0; i < studentGroups.size(); i++) {
            if (i < 2) {
                stream1.addStudentGroup(studentGroups.get(i));
            } else {
                stream2.addStudentGroup(studentGroups.get(i));
            }
        }

        List<StudentStream> streams = new ArrayList<>();
        streams.add(stream1);
        streams.add(stream2);

        // Сортировка потоков по количеству входящих в них групп
        controller.sortStreams(streams);

        // Вывод отсортированных потоков
        for (StudentStream stream : streams) {
            System.out.println("Stream with " + stream.getStudentGroups().size() + " groups:");
            for (StudentGroup group : stream) {
                System.out.println(group);
            }
            System.out.println();
        }
    }
}