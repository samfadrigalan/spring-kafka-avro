package com.code.kafka.dto;

public class StudentActivityDTO {
    private String id;
    private String name;
    private int universityId;
    private ActivityDTO courseDetails;

    public StudentActivityDTO(String id, String name, int universityId, ActivityDTO courseDetails) {
        this.id = id;
        this.name = name;
        this.universityId = universityId;
        this.courseDetails = courseDetails;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUniversityId() {
        return universityId;
    }

    public void setUniversityId(int universityId) {
        this.universityId = universityId;
    }

    public ActivityDTO getCourseDetails() {
        return courseDetails;
    }

    public void getCourseDetails(ActivityDTO courseDetails) {
        this.courseDetails = courseDetails;
    }
}
