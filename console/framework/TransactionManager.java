package edu.mum.cs.cs525.labs.exercises.project.console.framework;

import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    private List<Command> history = new ArrayList<>();

    public void executeCommand(Command cmd) {
        cmd.execute();
        history.add(cmd);
    }

    public void undoCommand() {
        if (!history.isEmpty()) {
            Command cmd = history.remove(history.size() - 1);
            cmd.unexecute();
        }
    }
}