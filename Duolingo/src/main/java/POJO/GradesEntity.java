package POJO;

import javax.persistence.*;

@Entity
@Table(name = "grades", schema = "duodb", catalog = "")
public class GradesEntity {
    private int gradeId;
    private String username;
    private String coursename;
    private Integer score;

    @Id
    @Column(name = "grade_id", nullable = false)
    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    @Basic
    @Column(name = "username", nullable = true, length = 30)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "coursename", nullable = true, length = 80)
    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    @Basic
    @Column(name = "score", nullable = true)
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GradesEntity that = (GradesEntity) o;

        if (gradeId != that.gradeId) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (coursename != null ? !coursename.equals(that.coursename) : that.coursename != null) return false;
        if (score != null ? !score.equals(that.score) : that.score != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gradeId;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (coursename != null ? coursename.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        return result;
    }
}
