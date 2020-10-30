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
		this.proposedCombinations = new ArrayList<>();
		this.results = new ArrayList<>();
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

	GameVersion createGameVersion() {
		return new GameVersion(this.proposedCombinations, this.results, this.attempts);
	}

	void setGameVersion(GameVersion gameVersion) {

		this.proposedCombinations = gameVersion.getProposedCombinations();
		this.results = gameVersion.getResults();
		this.attempts = gameVersion.getAttempts();

	}

	static class GameVersion {
		private final List<ProposedCombination> proposedCombinations;
		private final List<Result> results;
		private final int attempts;

		GameVersion(List<ProposedCombination> proposedCombinations, List<Result> results, int attempts) {
			this.proposedCombinations = new ArrayList<>(proposedCombinations);
			this.results = new ArrayList<>(results);
			this.attempts = attempts;
		}

		public List<ProposedCombination> getProposedCombinations() {
			return proposedCombinations;
		}

		public List<Result> getResults() {
			return results;
		}

		public int getAttempts() {
			return attempts;
		}
	}

}
