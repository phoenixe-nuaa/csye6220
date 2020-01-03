package POJO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "courses", schema = "duodb", catalog = "")
@IdClass(CoursesEntity.class)
public class CoursesEntity implements Serializable {
    private int courseId;
    private String coursename;
    private String whichlanguage;
    private Integer whichlevel;
//    @ManyToMany(fetch = FetchType.EAGER)
    private Set<UsersEntity> users;

    @Id
    @Column(name = "course_id", nullable = false)
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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
    @Column(name = "whichlanguage", nullable = true, length = 80)
    public String getWhichlanguage() {
        return whichlanguage;
    }

    public void setWhichlanguage(String whichlanguage) {
        this.whichlanguage = whichlanguage;
    }

    @Basic
    @Column(name = "whichlevel", nullable = true)
    public Integer getWhichlevel() {
        return whichlevel;
    }

    public void setWhichlevel(Integer whichlevel) {
        this.whichlevel = whichlevel;
    }

    public Set<UsersEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UsersEntity> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoursesEntity that = (CoursesEntity) o;

        if (courseId != that.courseId) return false;
        if (coursename != null ? !coursename.equals(that.coursename) : that.coursename != null) return false;
        if (whichlanguage != null ? !whichlanguage.equals(that.whichlanguage) : that.whichlanguage != null)
            return false;
        if (whichlevel != null ? !whichlevel.equals(that.whichlevel) : that.whichlevel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = courseId;
        result = 31 * result + (coursename != null ? coursename.hashCode() : 0);
        result = 31 * result + (whichlanguage != null ? whichlanguage.hashCode() : 0);
        result = 31 * result + (whichlevel != null ? whichlevel.hashCode() : 0);
        return result;
    }
}
