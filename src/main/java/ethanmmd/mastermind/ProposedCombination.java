package ethanmmd.mastermind;

import ethanmmd.utils.Console;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

public class ProposedCombination extends Combination {

    private Result result;

    public ProposedCombination() {
        this.result = new Result(0, 0);
    }

    public void write() {
        String colorCombination = this.colors.stream().map(Color::getReference).map(Object::toString).collect(Collectors.joining());
        GameInfo.DECRYPTION_RESULTS.writeln(colorCombination, this.result.getWhitePegs(), this.result.getBlackPegs());
    }


    public void readUserInput() {
        GameError gameError;
        do {
            GameInfo.DECRYPTION_PROPOSAL.write();
            gameError = this.checkProposedCombinationFormat(readProposedCombination());
            if (nonNull(gameError)) {
                gameError.writeln();
            }
            if (nonNull(gameError)) {
                this.colors = new ArrayList<Color>();
            }
        } while (nonNull(gameError));

    }

    private GameError checkProposedCombinationFormat(String characters) {
        if (characters.length() != COMBINATION_LENGHT) {
            return GameError.WRONG_PROPOSAL_LENGHT;
        } else if (!checkAllowedColors(characters.toCharArray())) {
            return GameError.WRONG_COLORES_ADVISE;
        }
        return null;
    }

    private boolean checkAllowedColors(char[] characters) {
        boolean isAllowed = true;
        for (char color : characters) {
            isAllowed = Color.getAllowedColors()
                    .stream()
                    .map(Color::getReference)
                    .collect(Collectors.toList())
                    .contains(String.valueOf(color));
            if(isAllowed){
                this.colors.add(Color.getByReference(String.valueOf(color)));
            }else{
                this.colors.clear();
                break;
            }
        }
        return isAllowed;
    }


    private String readProposedCombination() {
        String input = null;
        try {
            input = Console.instance().readString();
        } catch (Exception ex) {
        }
        return input;
    }

    boolean contains(Color color, int position) {
        return this.colors.get(position).equals(color);
    }

    boolean contains(Color color) {
        for (int i = 0; i < this.colors.size(); i++) {
            if (this.colors.get(i).equals(color)) {
                return true;
            }
        }
        return false;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

}
