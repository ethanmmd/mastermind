package ethanmmd.mastermind.views;


public abstract class View {

    public void interact() {
        do {
            this.start();
            boolean finished;
            do {
                finished = this.propose();
            } while (!finished);
        } while (this.resume());
    }

    protected abstract void start();

    protected abstract boolean propose();

    protected abstract boolean resume();

}
