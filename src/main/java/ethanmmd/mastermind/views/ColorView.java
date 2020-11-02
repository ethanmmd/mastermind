package ethanmmd.mastermind.views;


import ethanmmd.mastermind.models.Color;
import ethanmmd.utils.WithConsoleView;

public class ColorView extends WithConsoleView {

    private static final char[] INITIALS = {'r', 'b', 'y', 'g', 'o', 'p'};

    public static String allInitials() {
        StringBuilder result = new StringBuilder();
        for (char character : INITIALS) {
            result.append(character);
        }
        return result.toString();
    }

    public static Integer getInstance(char character) {
        for (int i = 0; i < INITIALS.length; i++) {
            if (INITIALS[i] == character) {
                return i;
            }
        }
        return null;
    }

    public void show(Color color) {
        this.console.write(INITIALS[color.ordinal()]);
    }

}
