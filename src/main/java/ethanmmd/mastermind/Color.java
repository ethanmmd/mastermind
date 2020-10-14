package ethanmmd.mastermind;

import java.util.Arrays;
import java.util.List;

enum Color {

    RED("r"),
    BLUE("b"),
    YELLOW("y"),
    GREEN("g"),
    ORANGE("o"),
    PURPLE("p");

    private String reference;

    public String getReference() {
        return this.reference;
    }

    Color(String reference) {
        this.reference = reference;
    }

    static List<Color> getAllowedColors() {
        return Arrays.asList(Color.values());
    }

    static Color getByReference(String reference) {
        return Color.getAllowedColors().stream().filter(color -> color.getReference().equals(reference)).findFirst().get();
    }


}
