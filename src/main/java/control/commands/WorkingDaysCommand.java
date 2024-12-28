package control.commands;

import control.Command;
import model.Calendar;
import org.eclipse.jetty.http.HttpTester;

import java.time.LocalDate;
import java.util.Iterator;

public class WorkingDaysCommand implements Command {

    private final Input input;
    private final Output output;

    public WorkingDaysCommand(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void execute() {
        output.workingDays(calculateWorkingDates());
    }

    private int calculateWorkingDates() {
        Iterator<LocalDate> from = new Calendar().iteratorFrom(input.start());
        LocalDate current = input.start();
        int workingDays = 0;
        while(current.isBefore(input.end())) {
            workingDays++;
            current = from.next();
        }
        return workingDays;
    }

    public interface Input {
        LocalDate start();
        LocalDate end();
    }

    public interface Output {
        void workingDays(int workingDays);
    }
}
