package data;

import domain.LogData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataManipulator {
    private static List<LogData> logDataList;

    public DataManipulator(List<LogData> logDataList) {
        this.logDataList = logDataList;
    }

    public Map<Integer, Long> getGroupedByTimeStamp() {
        Map<Integer, Long> groupedMap = logDataList.stream()
                .collect(Collectors.groupingBy(LogData::getTimeStamp, Collectors.counting()));
        return groupedMap;
    }

    public Map<String, Double> getGroupedBySourceName() {
        Map<String, Double> groupedMap = logDataList.stream()
                .collect(Collectors.groupingBy(LogData::getSourceName, Collectors.averagingDouble(LogData::getDuration)));
        return groupedMap;
    }

    public Map<String, Double> getSortedData(Map<String, Double> groupedMap) {
        Map<String, Double> sortedMap = new LinkedHashMap<>();
        groupedMap.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue()
                        .reversed()).forEachOrdered(e -> sortedMap.put(e.getKey(), e.getValue()));
        return sortedMap;
    }
}
