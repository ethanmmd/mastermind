package ethanmmd.mastermind;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class ProposedCombination extends Combination {

    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public void readInput(){
        GameError gameError;
        do {
            System.out.print(GameInfo.DECRYPTION_PROPOSAL);
            gameError = this.checkProposedCombinationFormat(readProposedCombination());
            if(Objects.nonNull(gameError)){
                gameError.writeln();
            }
            if (Objects.nonNull(gameError)) {
                this.colorMix = new ArrayList<String>();
            }

        } while (Objects.nonNull(gameError));

    }

    private GameError checkProposedCombinationFormat(String characters){
        if (characters.length() != 4) {
            return GameError.WRONG_PROPOSAL_LENGHT;
        }

        if (!checkAllowedColors(characters.toCharArray())) {
            return GameError.WRONG_COLORES_ADVISE;
        }

        return null;
    }

    private boolean checkAllowedColors(char[] characters) {
        boolean isAllowed = true;
        for (char color : characters) {

            isAllowed = Color.getAllowedColors().contains(String.valueOf(color));
        }

        return isAllowed;
    }


    private String readProposedCombination(){
            String input = null;
            System.out.println("");
            try {
                input = this.bufferedReader.readLine();
            } catch (Exception ex) {
            }
            return input;
        }

    boolean contains(String color, int position) {
        return this.colorMix.get(position).equals(color);
    }

    boolean contains(String color) {
        for (int i = 0; i < this.colorMix.size(); i++) {
            if (this.colorMix.get(i).equals(color)) {
                return true;
            }
        }
        return false;
    }

}
