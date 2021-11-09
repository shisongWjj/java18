package com.taimei.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@JsonIgnoreProperties(value = {"startDate", "endDate", "startSummary", "endSummary", "startTimestamp", "endTimestamp"}, ignoreUnknown = true)
public class Duration {

    static final DateTimeFormatter PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
    static final DateTimeFormatter PATTERN_SUMMARY = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    @JsonProperty("start")
    private String start;

    @JsonProperty("end")
    private String end;

    @JsonProperty("step")
    private String step;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Duration() {
    }

    public Duration(LocalDateTime startDate, LocalDateTime endDate, String step) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.step = step;
        this.start = startDate.format(PATTERN);
        this.end = endDate.format(PATTERN);
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public String getStartSummary() {
        return startDate.format(PATTERN_SUMMARY);
    }

    public String getEndSummary() {
        return endDate.format(PATTERN_SUMMARY);
    }

    public long getStartTimestamp() {
        return startDate.atZone(ZoneId.systemDefault()).toEpochSecond();
    }

    public long getEndTimestamp() {
        return endDate.atZone(ZoneId.systemDefault()).toEpochSecond();
    }

    @Override
    public String toString() {
        return "Duration{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", step='" + step + '\'' +
                '}';
    }
}
