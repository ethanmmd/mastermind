package ethanmmd.mastermind;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

enum Color {

    RED("r"),
    BLUE("b"),
    YELLOW("y"),
    GREEN("g"),
    ORANGE("o"),
    PURPLE("p");

    private String reference;

    public String getReference(){
        return this.reference;
    }


    Color(String reference) {
        this.reference = reference;
    }


    static List<String> getAllowedColors() {

        return Stream.of(Color.values())
                .map(Color::getReference)
                .collect(Collectors.toList());
    }

    static boolean isValidColorCombination(List<String> uncheckedCombination) {
        return uncheckedCombination
                .stream()
                .anyMatch(s -> !getAllowedColors().contains(s));
    }

    static int length() {
        return Color.values().length-1;
    }










}
