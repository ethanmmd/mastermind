package ethanmmd.mastermind;

enum GameError {
    WRONG_PROPOSAL_LENGHT("Wrong proposed combination length"),
    WRONG_COLORES_ADVISE("Wrong colores, the must be: " + Color.getAllowedColors()),
    NULL_MESSAGE();

    private String message;

    private GameError(){

    }

    private GameError(String message) {
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

    @Override
    public String toString() {
        return this.message;
    }









}
