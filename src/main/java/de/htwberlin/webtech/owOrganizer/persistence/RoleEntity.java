package de.htwberlin.webtech.owOrganizer.persistence;
import javax.persistence.*;

@Entity(name = "role")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

    private String role;

    private String heropool;

    @Column(name = "peak_sr")
    private Integer peakSr;

    @OneToOne
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private PlayerEntity playerEntity;

    public RoleEntity(String role, String heropool, Integer peakSr, PlayerEntity playerEntity) {
        this.role = role;
        this.heropool = heropool;
        this.peakSr = peakSr;
        this.playerEntity = playerEntity;
    }

    public RoleEntity() {
    }

    public Integer getRoleId() {
        return roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getHeropool() {
        return heropool;
    }

    public void setHeropool(String heropool) {
        this.heropool = heropool;
    }

    public Integer getPeakSr() {
        return peakSr;
    }

    public void setPeakSr(Integer peakSr) {
        this.peakSr = peakSr;
    }

    public PlayerEntity getPlayerEntity() {
        return playerEntity;
    }

    public void setPlayerEntity(PlayerEntity playerEntity) {
        this.playerEntity = playerEntity;
    }
}
