package ru.gb.oseminar.service;
import java.util.Collections;
import java.util.List;
import ru.gb.oseminar.data.StudentStream;
import ru.gb.oseminar.data.StudentStreamComparator;

public class StudentStreamService {
    public void sortStreams(List<StudentStream> streams) {
        Collections.sort(streams, new StudentStreamComparator());
    }
}