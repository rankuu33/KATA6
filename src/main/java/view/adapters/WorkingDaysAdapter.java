package view.adapters;

import control.commands.WorkingDaysCommand;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

public class WorkingDaysAdapter {
    public WorkingDaysCommand.Input inputFor(HttpServletRequest req) {
        return new WorkingDaysCommand.Input() {
            @Override
            public LocalDate start() {
                return LocalDate.parse(req.getParameter("start"));
            }

            @Override
            public LocalDate end() {
                return LocalDate.parse(req.getParameter("end"));
            }
        };
    }

    public WorkingDaysCommand.Output outputFor(HttpServletResponse res) {
        return days -> {
            try {
                res.getWriter().println(days);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

}
