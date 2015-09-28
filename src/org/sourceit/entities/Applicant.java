package org.sourceit.entities;

public class Applicant extends Entity {

    private long professionId;
    private String professionName;
    private String lastName;
    private String firstName;
    private int entranceYear;

    public Applicant() {
        this.id = -1;
    }

    public Applicant(long professionId, String professionName, String lastName, String firstName, int entranceYear) {
        this.professionId = professionId;
        this.professionName = professionName;
        this.lastName = lastName;
        this.firstName = firstName;
        this.entranceYear = entranceYear;
    }

    public long getProfessionId() {
        return professionId;
    }

    public void setProfessionId(long professionId) {
        this.professionId = professionId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getEntranceYear() {
        return entranceYear;
    }

    public void setEntranceYear(int entranceYear) {
        this.entranceYear = entranceYear;
    }


    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "professionId=" + professionId +
                ", professionName='" + professionName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", entranceYear=" + entranceYear +
                '}';
    }
}

