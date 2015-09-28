package org.sourceit.entities;

/**
 * Created by Valeriu on 16.09.2015.
 */
public class Result extends Entity {

    private long applicantId;
    private long subjectId;
    private int mark;
    private String firstName;
    private String lastName;
    private int entranceYear;
    private String subjectName;


    public Result() {
        this.id = -1;
    }

    public Result(long applicantId, long subjectId, int mark, String firstName, String lastName, int entranceYear, String subjectName) {
        this.applicantId = applicantId;
        this.subjectId = subjectId;
        this.mark = mark;
        this.firstName = firstName;
        this.lastName = lastName;
        this.entranceYear = entranceYear;
        this.subjectName = subjectName;
    }

    public long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(long applicantId) {
        this.applicantId = applicantId;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getEntranceYear() {
        return entranceYear;
    }

    public void setEntranceYear(int entranceYear) {
        this.entranceYear = entranceYear;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "Result{" +
                "applicantId=" + applicantId +
                ", subjectId=" + subjectId +
                ", mark=" + mark +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", entranceYear=" + entranceYear +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }
}
