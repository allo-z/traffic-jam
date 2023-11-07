package com.zuehlke.hamilton;

import java.util.ArrayList;
import java.util.List;

public class TrafficJam {

    public String trafficJam(final String mainRoad, final String[] sideRoads) {
        display(mainRoad, sideRoads);

        char currentChar = 0;

        var mainRoadList = CharUtil.toCharList(mainRoad);
        String result = "";

        List<SideRoad> sideRoadsWithCars = new ArrayList<>();
        for (int i = 0; i < sideRoads.length; i++) {
            if (!sideRoads[i].isEmpty()) {
                sideRoadsWithCars.add(new SideRoad(i, CharUtil.toCharList(sideRoads[i])));
            }
        }



        while (currentChar != 'X') {
            currentChar = mainRoadList.remove(0);


            result += currentChar;

            if(sideRoadsWithCars.isEmpty()) {
                continue;

            }

            SideRoad currentSideRoad = sideRoadsWithCars.remove(0);

            char lastCar = result.charAt(result.length()-1);

            char carToMerge = currentSideRoad.dequeueFirstCar();

            mainRoadList.add(currentSideRoad.index, carToMerge);


            if(currentSideRoad.hasCars()) {
                sideRoadsWithCars.add(currentSideRoad);
            }
        }


        return result;
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


    class SideRoad {
        private final int index;
        private final List<Character> cars;

        SideRoad(int index, List<Character> cars) {
            this.index = index;
            this.cars = cars;
        }

        boolean hasCars() {
            return !cars.isEmpty();
        }

        char dequeueFirstCar() {
            return cars.remove(0);
        }
    }
}