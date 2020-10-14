package ethanmmd.mastermind;

import ethanmmd.utils.Console;

enum GameError {

    WRONG_PROPOSAL_LENGHT("Wrong proposed combination length"),
    WRONG_COLORES_ADVISE("Wrong colores, the must be: " + Color.getAllowedColors());

    private String message;

    GameError(String message) {
        this.message = message;
    }

    void writeln() {
        Console.instance().writeln(this.message);
    }


}
