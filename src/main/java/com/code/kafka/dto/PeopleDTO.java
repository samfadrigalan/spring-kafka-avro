package com.code.kafka.dto;

/**
 * "fields": [
 *     {"name": "name", "type": "string"},
 *     {"name": "age", "type": "int"},
 *     {"name": "note", "type": ["string", "null"], "default": null}
 *   ]
 */

public class PeopleDTO {
    private String name;
    private int age;
    private String note;

    public PeopleDTO(String name, int age, String note) {
        this.name = name;
        this.age = age;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
