package de.htwberlin.webtech.owOrganizer.web.api;

public class UniligaTeamManipulationRequest {
        private Integer id;
        private String name;
        private String uni;

        public UniligaTeamManipulationRequest(Integer id, String name, String uni) {
            this.id = id;
            this.name = name;
            this.uni = uni;
        }

        public UniligaTeamManipulationRequest() {}

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


