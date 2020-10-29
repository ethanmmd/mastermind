package ethanmmd.mastermind.models;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private static final int MAX_LONG = 10;

    private SecretCombination secretCombination;

    private List<ProposedCombination> proposedCombinations;

    private List<Result> results;

    private int attempts;

    public Game() {
        this.clear();
    }

    public void clear() {
        this.secretCombination = new SecretCombination();
        this.proposedCombinations = new ArrayList<ProposedCombination>();
        this.results = new ArrayList<Result>();
        this.attempts = 0;
    }

    public void addProposedCombination(ProposedCombination proposedCombination) {
        this.proposedCombinations.add(proposedCombination);
        this.results.add(this.secretCombination.getResult(proposedCombination));
        this.attempts++;
    }

    public boolean isLooser() {
        return this.attempts == Game.MAX_LONG;
    }

    public boolean isWinner() {
        return this.results.get(this.attempts - 1).isWinner();
    }

    public int getAttempts() {
        return this.attempts;
    }

    public ProposedCombination getProposedCombination(int position) {
        return this.proposedCombinations.get(position);
    }

    public Result getResult(int position) {
        return this.results.get(position);
    }

    public GameMemento createGameMemento() {
        return new GameMemento(this.proposedCombinations, this.results, this.attempts);
    }

    public void set(GameMemento gameMemento) {
        this.proposedCombinations = new ArrayList<>();
        this.proposedCombinations.addAll(gameMemento.getProposedCombinations());
        this.attempts = gameMemento.getAttempts();
        this.results = new ArrayList<>();
        this.results.addAll(gameMemento.getResults());

    }

}
