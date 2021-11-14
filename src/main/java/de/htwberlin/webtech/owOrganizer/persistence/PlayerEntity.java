package de.htwberlin.webtech.owOrganizer.persistence;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "player")
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name= "player_name")
    private String playerName;

    @Column(name= "bnet_id")
    private String bnetId;

    @Column(name= "discord_tag")
    private String discordTag;

    private String gender;

    @Column(name= "first_name")
    private String firstName;

    @Column(name= "last_name")
    private String lastName;

    private LocalDate birthday;

    @Column(name= "is_student")
    private Boolean studentStatus;

    @Column(name= "is_competitive")
    private Boolean compStatus;

    //drop test column

    public PlayerEntity(String playerName, String bnetId, String discordTag,
                        String gender, String firstName, String lastName,
                        LocalDate birthday, Boolean studentStatus, Boolean compStatus) {
        this.playerName = playerName;
        this.bnetId = bnetId;
        this.discordTag = discordTag;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.studentStatus = studentStatus;
        this.compStatus = compStatus;
    }

    protected PlayerEntity() {
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public boolean isStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(Boolean studentStatus) {
        this.studentStatus = studentStatus;
    }

    public boolean isCompStatus() {
        return compStatus;
    }

    public void setCompStatus(Boolean compStatus) {
        this.compStatus = compStatus;
    }
}
