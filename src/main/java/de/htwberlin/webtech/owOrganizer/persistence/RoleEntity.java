package de.htwberlin.webtech.owOrganizer.persistence;

import javax.persistence.*;
import java.net.Inet4Address;

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

    @ManyToOne
    @JoinColumn(name = "player_id")
    private PlayerEntity playerEntity;

    public RoleEntity( String role, String heropool, Integer peakSr ) {
        this.role = role;
        this.heropool = heropool;
        this.peakSr = peakSr;
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
}
