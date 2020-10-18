package ethanmmd.mastermind.views;


import ethanmmd.mastermind.controllers.Logic;

public abstract class View {

    protected Logic logic;

    public View(Logic logic) {
        this.logic = logic;
    }

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
