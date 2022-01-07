package de.htwberlin.webtech.owOrganizer.web.api;

import javax.validation.constraints.NotBlank;
import java.sql.Date;

public class PlayerManipulationRequest {
    @Size(min = 5, message = "Please provide a player name with 5 characters or more.")
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
    private String bnetMail;
    private String uni;
    private String cityOfResidence;
    private Boolean owned;
    private String uniMail;

    public PlayerManipulationRequest(String playerName, String bnetId,
                                     String discordTag, String gender,
                                     String firstName, String lastName,
                                     Date birthday, Boolean isStudent,
                                     Boolean isCompetitive, String bnetMail,
                                     String uni, String cityOfResidence,
                                     Boolean owned, String uniMail) {
        this.playerName = playerName;
        this.bnetId = bnetId;
        this.discordTag = discordTag;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.isStudent = isStudent;
        this.isCompetitive = isCompetitive;
        this.bnetMail = bnetMail;
        this.uni = uni;
        this.cityOfResidence =cityOfResidence;
        this.owned = owned;
        this.uniMail = uniMail;
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

    public String getBnetMail() {
        return bnetMail;
    }

    public void setBnetMail(String bnetMail) {
        this.bnetMail = bnetMail;
    }

    public String getUni() {
        return uni;
    }

    public void setUni(String uni) {
        this.uni = uni;
    }

    public String getCityOfResidence() {
        return cityOfResidence;
    }

    public void setCityOfResidence(String cityOfResidence) {
        this.cityOfResidence = cityOfResidence;
    }

    public Boolean getOwned() {
        return owned;
    }

    public void setOwned(Boolean owned) {
        this.owned = owned;
    }

    public String getUniMail() {
        return uniMail;
    }

    public void setUniMail(String uniMail) {
        this.uniMail = uniMail;
    }
}
