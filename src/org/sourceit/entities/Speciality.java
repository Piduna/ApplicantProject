package org.sourceit.entities;

public class Speciality extends Entity {

    private long professionSubject;
    private long subjectId;
    private String professionName;
    private String subjectName;

    public Speciality() {
        this.id = -1;
    }

    public Speciality(long professionSubject, long subjectId, String professionName, String subjectName) {
        this.professionSubject = professionSubject;
        this.subjectId = subjectId;
        this.professionName = professionName;
        this.subjectName = subjectName;
    }

    public long getProfessionSubject() {
        return professionSubject;
    }

    public void setProfessionSubject(long professionSubject) {
        this.professionSubject = professionSubject;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "Speciality{" +
                "professionSubject=" + professionSubject +
                ", subjectId=" + subjectId +
                ", professionName='" + professionName + '\'' +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }
}
