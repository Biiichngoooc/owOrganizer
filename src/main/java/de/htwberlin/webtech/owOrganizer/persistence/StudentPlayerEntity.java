package de.htwberlin.webtech.owOrganizer.persistence;


import javax.persistence.*;

@Entity(name = "student_player")
@PrimaryKeyJoinColumn(name = "s_player_id")
public class StudentPlayerEntity extends PlayerEntity {

    @Column(name = "bnet_mail")
    private String bnetMail;

    private String uni;

    @Column(name = "city_of_residence")
    private String cityOfResidence;

    @Column(name = "is_owned")
    private Boolean ownedPlayer;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private PlayerEntity playerEntity;

    public StudentPlayerEntity(String bnetMail, String uni,
                               String cityOfResidence, Boolean foreignPlayer,
                               Boolean ownedPlayer) {
        this.bnetMail = bnetMail;
        this.uni = uni;
        this.cityOfResidence = cityOfResidence;
        this.ownedPlayer = ownedPlayer;
    }

    public StudentPlayerEntity() {
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

    public Boolean getOwnedPlayer() {
        return ownedPlayer;
    }

    public void setOwnedPlayer(Boolean ownedPlayer) {
        this.ownedPlayer = ownedPlayer;
    }
}
