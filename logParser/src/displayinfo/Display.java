package displayinfo;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class Display {

    public Display (){

    }

    public static void displayHelpInformation() {
        System.out.println("\njava -jar parser.jar [file] [value]\n");
        System.out.println("[file] - log file for parsing");
        System.out.println("[value] - top resources with highest average request duration\n");
        System.out.println("Sample: java -jar parser.jar timing.log 5");
    }

    public static void displayResult(Map<String, Double> sortedMap, int numberOfRecords) {
        Set<Map.Entry<String, Double>> setOfModifiedEntries = sortedMap.entrySet();

        System.out.println("\nTop resources with highest average request duration:\n");

        for (int i = 0; i < numberOfRecords; i++) {
            Map.Entry<String, Double> result = (new ArrayList<>(setOfModifiedEntries)).get(i);
            System.out.println(result.getKey() + " - " + result.getValue());
        }
    }
}

