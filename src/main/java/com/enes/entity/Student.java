package com.enes.entity;
import java.io.Serializable;
import java.time.LocalDate;

public class Student implements Serializable {
        private String name;
        private double scoreAverage;
        private EState state;
        private LocalDate dateOfBirth;

        //This method determines the student's status based on their grade point average and updates the status feature:
        public EState setStatus() {
            return scoreAverage >= 60 ? EState.PASSED : EState.FAILED;
        }

    public Student(String name, double scoreAverage, LocalDate dateOfBirth) {
            this.name = name;
            this.scoreAverage = scoreAverage;
            this.dateOfBirth = dateOfBirth;
            this.state = setStatus();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getScoreAverage() {
            return scoreAverage;
        }

        public void setScoreAverage(double scoreAverage) {
            this.scoreAverage = scoreAverage;
        }

        public EState getState() {
            return state;
        }

        public void setState(EState state) {
            this.state = state;
        }

        public LocalDate getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Student{");
            sb.append("name='").append(name).append('\'');
            sb.append(", scoreAverage=").append(scoreAverage);
            sb.append(", state=").append(state);
            sb.append(", dateOfBirth=").append(dateOfBirth);
            sb.append('}');
            return sb.toString();
        }
}
