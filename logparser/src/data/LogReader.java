package data;

import domain.LogData;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogReader {

    private String logFileContent;
    private Pattern uriAndQueryPattern;
    private Pattern sourcePattern;

    public LogReader(String logFileContent, Pattern uriAndQueryPattern, Pattern sourcePattern) {
        this.logFileContent = logFileContent;
        this.uriAndQueryPattern = uriAndQueryPattern;
        this.sourcePattern = sourcePattern;
    }

    public List<LogData> getLog() {
        List<LogData> logDataList = new ArrayList<>();

        Matcher matcherUriAndQueryPattern = uriAndQueryPattern.matcher(logFileContent);
        Matcher matcherSourcePattern = sourcePattern.matcher(logFileContent);

        while (matcherUriAndQueryPattern.find()) {
            LogData logData = new LogData(Integer.parseInt(matcherUriAndQueryPattern.group(2)), matcherUriAndQueryPattern.group(4), Integer.parseInt(matcherUriAndQueryPattern.group(5).trim()));
            logDataList.add(logData);
        }
        while (matcherSourcePattern.find()) {
            LogData logData = new LogData(Integer.parseInt(matcherSourcePattern.group(2)), matcherSourcePattern.group(5), Integer.parseInt(matcherSourcePattern.group(6).trim()));
            logDataList.add(logData);
        }
        return logDataList;
    }
}
