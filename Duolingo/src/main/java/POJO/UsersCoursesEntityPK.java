package POJO;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class UsersCoursesEntityPK implements Serializable {
    private int userId;
    private int courseId;

    @Column(name = "user_id", nullable = false)
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "course_id", nullable = false)
    @Id
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

        UsersCoursesEntityPK that = (UsersCoursesEntityPK) o;

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
