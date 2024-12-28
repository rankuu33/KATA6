package model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Set;

public class Calendar {

    public Iterable<LocalDate> from(LocalDate date) {
        return () -> iteratorFrom(date);
    }

    public Iterator<LocalDate> iteratorFrom(LocalDate date) {
        return new Iterator<>() {
            LocalDate current = date;

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public LocalDate next() {
                var result = current.plusDays(1);
                while(!isWorkingDate(result)) result = result.plusDays(1);
                current = result;
                return result;
            }
        };
    }

    Set<DayOfWeek> workingDays = Set.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY);

    public boolean isWorkingDate(LocalDate date) {
        return workingDays.contains(date.getDayOfWeek());
    }
}
