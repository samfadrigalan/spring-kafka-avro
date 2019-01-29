package com.code.kafka.dto;

/**
 {
 "name": "course_details",
 "type": {
 "name": "Activity",
 "type": "record",
 "fields": [
 {
 "name": "course_id",
 "type": "int"
 },
 {
 "name": "enroll_date",
 "type": "string"
 },
 {
 "name": "verb",
 "type": "string"
 },
 {
 "name": "result_score",
 "type": "double"
 }
 ]
 }
 }
 */
public class ActivityDTO {
    private int courseId;
    private String enrollDate;
    private String verb;
    private double resultScore;

    public ActivityDTO(int courseId, String enrollDate, String verb, double resultScore) {
        this.courseId = courseId;
        this.enrollDate = enrollDate;
        this.verb = verb;
        this.resultScore = resultScore;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(String enrollDate) {
        this.enrollDate = enrollDate;
    }

    public String getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public double getResultScore() {
        return resultScore;
    }

    public void setResultScore(double resultScore) {
        this.resultScore = resultScore;
    }
}
