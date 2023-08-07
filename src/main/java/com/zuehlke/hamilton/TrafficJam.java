package com.zuehlke.hamilton;

import java.util.Optional;

public class TrafficJam {

    public String trafficJam(final String mainRoad, final String[] sideRoads) {
        display(mainRoad, sideRoads);

        // TODO our code

        return "";
    }

    public void display(final String mainRoad, final String[] sideRoads) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < mainRoad.length(); i++) {
            final var sideRoad = sideRoad(sideRoads, i);
            if (sideRoad != null) {
                result.append(padLeft(sideRoad + " " + mainRoad.charAt(i)));
            } else {
                result.append(padLeft(mainRoad.charAt(i)));
            }
            result.append('\n');
        }
        System.out.println(result);
    }

    private String sideRoad(final String[] sideRoads, final int i) {
        return i < sideRoads.length
                ? sideRoads[i]
                : null;
    }

    private static String padLeft(char inputString) {
        return padLeft(inputString + "");
    }

    private static String padLeft(String inputString) {
        return String.format("%1$" + 20 + "s", inputString);
    }
}
