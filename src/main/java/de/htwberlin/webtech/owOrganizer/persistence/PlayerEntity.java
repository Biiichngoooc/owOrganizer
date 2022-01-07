package de.htwberlin.webtech.owOrganizer.persistence;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "player")
@Inheritance(strategy = InheritanceType.JOINED)
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "player_name")
    private String playerName;
    @Column(name = "bnet_id")
    private String bnetId;
    @Column(name = "discord_tag")
    private String discordTag;
    private String gender;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Basic
    private Date birthday;
    @Column(name = "is_student", columnDefinition = "boolean default false")
    private Boolean student;
    @Column(name = "is_competitive", columnDefinition = "boolean default false")
    private Boolean competitive;
    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "uniliga_team_id")
    private UniligaTeamEntity uniligaTeamEntity;
    @Column(name = "bnet_mail")
    private String bnetMail;
    @Column(name = "uni")
    private String uni;
    @Column(name = "city_of_residence")
    private String cityOfResidence;
    @Column(name = "is_owned")
    private Boolean owned;
    @Column(name = "uni_mail")
    private String uniMail;

    public PlayerEntity(String playerName, String bnetId, String discordTag,
                        String gender, String firstName, String lastName,
                        Date birthday, Boolean student, Boolean competitive,
                        String bnetMail, String uni, String cityOfResidence,
                        Boolean owned, String uniMail) {
        this.playerName = playerName;
        this.bnetId = bnetId;
        this.discordTag = discordTag;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.student = student;
        this.competitive = competitive;
        this.bnetMail = bnetMail;
        this.uni = uni;
        this.cityOfResidence = cityOfResidence;
        this.owned = owned;
        this.uniMail = uniMail;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isStudent() {
        return Boolean.TRUE.equals(student);
    }

    public void setStudent(Boolean studentStatus) {
        this.student = studentStatus;
    }

    public boolean isCompetitive() {
        return Boolean.TRUE.equals(competitive);
    }

    public void setCompetitive(Boolean compStatus) {
        this.competitive = compStatus;
    }

    public String getBnetMail() {
        return bnetMail;
    }

    public void setBnetMail(String bnetMail) {
        this.bnetMail = bnetMail;
    }

    public UniligaTeamEntity getUniligaTeamEntity() {
        return uniligaTeamEntity;
    }

    public void setUniligaTeamEntity(UniligaTeamEntity uniligaTeamEntity) {
        this.uniligaTeamEntity = uniligaTeamEntity;
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
        return Boolean.TRUE.equals(owned);
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
