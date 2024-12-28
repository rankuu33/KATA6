package view;

import control.CommandFactory;
import io.javalin.Javalin;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WorkingDaysService implements Service {

    private final int port;
    private final CommandFactory factory;

    public WorkingDaysService(int port, CommandFactory factory) {
        this.port = port;
        this.factory = factory;
    }



    @Override
    public void start() {
        Javalin app = Javalin.create()
                .get("/working-days", ctx -> execute(ctx.req(), ctx.res()))
                .start(port);
    }

    private void execute(HttpServletRequest req, HttpServletResponse res) {
        factory.with(req, res).build("working-days").execute();
    }
}
