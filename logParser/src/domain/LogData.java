package domain;

final public class LogData {
    final private String sourceName;
    final private double duration;
    final private Integer timeStamp;

    public LogData(Integer timeStamp, String sourceName, double duration){
        this.sourceName = sourceName;
        this.duration = duration;
        this.timeStamp = timeStamp;
    }

    public String getSourceName() {
        return sourceName;
    }

    public double getDuration() {
        return duration;
    }

    public Integer getTimeStamp() {
        return timeStamp;
    }
}
