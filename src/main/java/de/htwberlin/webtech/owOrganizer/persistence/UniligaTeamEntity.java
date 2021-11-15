package de.htwberlin.webtech.owOrganizer.persistence;

import javax.persistence.*;

@Entity(name = "uniliga_team")
public class UniligaTeamEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String uni;

    public UniligaTeamEntity(String name, String uni) {
        this.name = name;
        this.uni = uni;
    }

    public UniligaTeamEntity() {
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUni() {
        return uni;
    }

    public void setUni(String uni) {
        this.uni = uni;
    }
}
