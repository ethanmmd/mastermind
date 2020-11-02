package ethanmmd.mastermind.views.console;


import ethanmmd.mastermind.models.Color;
import ethanmmd.utils.WithConsoleView;

public class ColorView extends WithConsoleView {

    private static final char[] INITIALS = {'r', 'b', 'y', 'g', 'o', 'p'};

    public static String allInitials() {
        StringBuilder result = new StringBuilder();
        for (char character : ColorView.INITIALS) {
            result.append(character);
        }
        return result.toString();
    }

    public static Integer getInstance(char character) {
        for (int i = 0; i < ColorView.INITIALS.length; i++) {
            if (ColorView.INITIALS[i] == character) {
                return i;
            }
        }
        return null;
    }

    public void show(Color color) {
        this.console.write(ColorView.INITIALS[color.ordinal()]);
    }

}
