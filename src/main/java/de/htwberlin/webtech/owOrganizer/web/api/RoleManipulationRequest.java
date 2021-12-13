package de.htwberlin.webtech.owOrganizer.web.api;

public class RoleManipulationRequest {
    private String role;
    private Integer roleId;
    private String heropool;
    private Integer peakSr;
    private Integer playerId;

    public RoleManipulationRequest(String role, Integer roleId, String heropool, Integer peakSr, Integer playerId) {
        this.role = role;
        this.roleId = roleId;
        this.heropool = heropool;
        this.peakSr = peakSr;
        this.playerId = playerId;
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

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }
}
