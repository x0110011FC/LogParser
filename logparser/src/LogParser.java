import data.DataManipulator;
import data.LogReader;
import domain.LogData;
import filereader.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static displayinfo.Display.displayHelpInformation;
import static displayinfo.Display.displayResult;
import static histogram.Histogram.displayHistogram;

public class LogParser {

    private static List<LogData> logDataList = new ArrayList<>();
    /*                                                             timestamp            source                          */
    private static Pattern uriAndQueryPattern = Pattern.compile("((\\d+):\\d+:\\d+).*(\\/([a-zA-Z]+).+(\\s\\d+)(\\n|\\z))+");
    /*                                                             timestamp            source                          */
    private static Pattern sourcePattern = Pattern.compile("((\\d+):\\d+:\\d+).*((\\]\\s)([a-zA-Z]+).+(\\s\\d+)(\\n|\\z))+");

    public static void main(String[] args) {

        final long startTime = System.currentTimeMillis();
        int numberOfRecords;

        if (args.length > 0) {
            if (args[0].equals("-h")) {
                displayHelpInformation();
            } else {
                FileReader fileReader = new FileReader(args[0]);
                numberOfRecords = Integer.parseInt(args[1]);

                try {
                    String logFileContent = fileReader.readFile();
                    LogReader logReader = new LogReader(logFileContent, uriAndQueryPattern, sourcePattern);
                    logDataList = logReader.getLog();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                DataManipulator dataManipulator = new DataManipulator(logDataList);
                Map<String, Double> aggregatedMap = dataManipulator.getSortedData(dataManipulator.getGroupedBySourceName());
                displayResult(aggregatedMap, numberOfRecords);
                displayHistogram(dataManipulator.getGroupedByTimeStamp());

                final long duration = System.currentTimeMillis() - startTime;
                System.out.print("\nExecution time is " + duration + "ms");
            }
        }
    }
}
