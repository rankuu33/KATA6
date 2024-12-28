import control.CommandFactory;
import control.commands.WorkingDaysCommand;
import view.WorkingDaysService;
import view.adapters.WorkingDaysAdapter;

public class Main {

    public static void main(String[] args) {
        CommandFactory factory = new CommandFactory();

        factory.register("working-days", workingDaysBuilder());
        new WorkingDaysService(7070, factory).start();
    }

    private static CommandFactory.Builder workingDaysBuilder() {
        return (req, res) ->
                new WorkingDaysCommand( new WorkingDaysAdapter().inputFor(req),
                        new WorkingDaysAdapter().outputFor(res));
    }
}
