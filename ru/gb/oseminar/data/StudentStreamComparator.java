package ru.gb.oseminar.data;
import java.util.Comparator;

public class StudentStreamComparator implements Comparator<StudentStream> {
    @Override
    public int compare(StudentStream s1, StudentStream s2) {
        return Integer.compare(s1.getStudentGroups().size(), s2.getStudentGroups().size());
    }
}