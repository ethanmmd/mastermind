package ethanmmd.mastermind;

enum GameInfo {
    TITLE("[*][*][*][*]WELCOME TO THE MASTERMIND[*][*][*][*]"),
    SECRET_CODE_MESSAGE("***The secret code is waiting for you, are you ready?"),
    DECRYPTION_ATTEMPT("Decryption attempts: %d (10 TRIES MAX!!!"),

    DECRYPTION_PROPOSAL("Input your combination: "),

    RESULT(" --> #blacks blacks and #whites whites"),
    WIN_MESSAGE("You've won!!! ;-)"),
    RESUME("RESUME? (y/n):"),
    NULL_MESSAGE();

    private String message;

    private GameInfo(){

    }

    private GameInfo(String message) {
        this.message = message;
    }

    void write(String parameterizedMessage) {
        Console.instance().write(parameterizedMessage);
    }

    void write(){
        Console.instance().write(this.message);
    }

    void writeln() {
        Console.instance().writeln(this.message);
    }

    void writeln(String parameterizedMessage){Console.instance().writeln(parameterizedMessage);}

    void writeln(int blacks, int whites) {
        assert this == GameInfo.RESULT;

        Console.instance().writeln(this.message.replaceFirst("#blacks", "" + blacks).replaceFirst("#whites", "" + whites));
    }

    @Override
    public String toString() {
        return this.message;
    }









}
