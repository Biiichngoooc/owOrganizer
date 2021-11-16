package de.htwberlin.webtech.owOrganizer.web.api;

public class Role {
    private Integer roleId;
    private String role;
    private String heropool;
    private Integer peakSr;

    public Role(Integer roleId, String role, String heropool, Integer peakSr) {
        this.roleId = roleId;
        this.role = role;
        this.heropool = heropool;
        this.peakSr = peakSr;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}


