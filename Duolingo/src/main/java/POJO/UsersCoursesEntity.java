package POJO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users_courses", schema = "duodb", catalog = "")
@IdClass(UsersCoursesEntity.class)
public class UsersCoursesEntity implements Serializable {
    private int userId;
    private int courseId;

    @Id
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "course_id", nullable = false)
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersCoursesEntity that = (UsersCoursesEntity) o;

        if (userId != that.userId) return false;
        if (courseId != that.courseId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + courseId;
        return result;
    }
}
