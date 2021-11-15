package de.htwberlin.webtech.owOrganizer.web.api;

import java.sql.Date;

public class Player {
    protected Integer id;
    protected String playerName;
    protected String bnetId;
    protected String discordTag;
    protected String gender;
    protected String firstName;
    protected String lastName;
    protected Date birthday;
    protected Boolean isStudent;
    protected Boolean isCompetitive;


    public Player(Integer id, String playerName, String bnetId, String discordTag,
                  String gender, String firstName, String lastName, Date birthday,
                  Boolean isStudent, Boolean isCompetitive) {
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
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}