package ethanmmd.mastermind.views.graphics;


import ethanmmd.mastermind.models.Color;
import ethanmmd.utils.WithGraphicsView;

class ColorView extends WithGraphicsView {

    private static final char[] INITIALS = {'r', 'b', 'y', 'g', 'o', 'p'};

    private Color color;

    ColorView(Color color) {
        this.color = color;
    }

    static String allInitials() {
        StringBuilder result = new StringBuilder();
        for (char character : ColorView.INITIALS) {
            result.append(character);
        }
        return result.toString();
    }

    static Color getInstance(char character) {
        for (int i = 0; i < ColorView.INITIALS.length; i++) {
            if (ColorView.INITIALS[i] == character) {
                return Color.values()[i];
            }
        }
        return null;
    }

    void write() {
        this.console.write(ColorView.INITIALS[this.color.ordinal()]);
    }

}
