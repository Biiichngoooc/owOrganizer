package de.htwberlin.webtech.owOrganizer.persistence;


import javax.persistence.*;

@Entity(name = "student_player")
@PrimaryKeyJoinColumn(name = "player_id")
public class StudentPlayerEntity {

    @Id
    @Column(name = "s_player_id")
    private Integer sPlayerId;

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

    public Integer getsPlayerId() {
        return sPlayerId;
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
