package de.htwberlin.webtech.owOrganizer.web.api;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

public class Player {
    protected Integer id;
    protected String playerName;
    protected String bnetId;
    protected String discordTag;
    protected String gender;
    protected String firstName;
    protected String lastName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    protected Date birthday;
    protected Boolean isStudent;
    protected Boolean isCompetitive;
    protected UniligaTeam uniligaTeam;
    protected String bnetMail;
    protected String uni;
    protected String cityOfResidence;
    protected Boolean owned;
    protected String uniMail;


    public Player(Integer id, String playerName, String bnetId, String discordTag,
                  String gender, String firstName, String lastName, Date birthday,
                  Boolean isStudent, Boolean isCompetitive, String bnetMail, String uni,
                  String cityOfResidence, Boolean owned, String uniMail) {
        this.id = id;
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
        this.cityOfResidence = cityOfResidence;
        this.owned = owned;
        this.uniMail = uniMail;
    }



    public Integer getId() {
        return id;
    }

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
