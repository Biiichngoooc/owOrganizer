package de.htwberlin.webtech.owOrganizer.web.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.sql.Date;

public class PlayerManipulationRequest {
    @NotBlank(message = "Must not be empty.")
    private String playerName;
    @NotBlank(message = "Must not be empty.")
    private String bnetId;
    @NotBlank(message = "Must not be empty.")
    private String discordTag;
    @NotBlank(message = "Must not be empty.")
    private String gender;
    @NotBlank(message = "Must not be empty.")
    private String firstName;
    @NotBlank(message = "Must not be empty.")
    private String lastName;
    private Date birthday;
    private Boolean isStudent;
    private Boolean isCompetitive;

    public PlayerManipulationRequest(String playerName, String bnetId,
                                     String discordTag, String gender,
                                     String firstName, String lastName,
                                     Date birthday, Boolean isStudent,
                                     Boolean isCompetitive) {
        this.playerName = playerName;
        this.bnetId = bnetId;
        this.discordTag = discordTag;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.isStudent = isStudent;
        this.isCompetitive = isCompetitive;
    }

    public PlayerManipulationRequest() {}

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getBnetId() {
        return bnetId;
    }

    public void setBnetId(String bnetId) {
        this.bnetId = bnetId;
    }

    public String getDiscordTag() {
        return discordTag;
    }

    public void setDiscordTag(String discordTag) {
        this.discordTag = discordTag;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Boolean getStudent() {
        return isStudent;
    }

    public void setStudent(Boolean student) {
        isStudent = student;
    }

    public Boolean getCompetitive() {
        return isCompetitive;
    }

    public void setCompetitive(Boolean competitive) {
        isCompetitive = competitive;
    }
}
