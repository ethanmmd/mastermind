package ethanmmd.mastermind;

import ethanmmd.utils.Console;

enum GameInfo {

    TITLE("[*][*][*][*]WELCOME TO THE MASTERMIND[*][*][*][*]" + "\n"),
    SECRET_CODE_MESSAGE("---The secret code is waiting for you, are you ready?---"+ "\n"),
    DECRYPTION_ATTEMPT("Decryption attempts: %d/10"),
    DECRYPTION_PROPOSAL("Input your combination: "),
    DECRYPTION_RESULTS("Your decryption:  %s --> %d blacks and %d whites"),
    LOOSER_INFO("YOU LOSE!"),
    WIN_MESSAGE("WE HAVE A WINNER!!!"),
    RESUME("Do you want to %s again?");

    private String message;

    private Console console = Console.instance();

    GameInfo(String message) {
        this.message = message;
    }

    void write() {
        Console.instance().write(this.message);
    }

    void writeln() {
        Console.instance().writeln(this.message);
    }

    void writeln(int attempts) {
        assert this == GameInfo.DECRYPTION_ATTEMPT;
        this.console.writeln(String.format(this.message, attempts));
    }

    void writeln(String combination, int blacks, int whites) {
        assert this == GameInfo.DECRYPTION_RESULTS;
        this.console.writeln(String.format(this.message, combination, whites, blacks));
    }

    public String getMessage() {
        return message;
    }


}
