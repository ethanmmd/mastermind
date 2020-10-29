package ethanmmd.utils;

public abstract class AbstractCommand {

    private final String title;

    protected AbstractCommand(String title) {
        this.title = title;
    }

    protected abstract void execute();

    protected abstract boolean isActive();

    public String getTitle() {
        return this.title;
    }
}
