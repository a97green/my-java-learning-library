import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "linkedpurchaselist")
public class LinkedPurchaseList {
    @EmbeddedId
    private Key id;

    @Embeddable
    public class Key implements Serializable {
        @Column(name = "student_id", insertable = false, updatable = false)
        private int studentId;

        @Column(name = "course_id", insertable = false, updatable = false)
        private int courseId;

        public Key(int studentId, int courseId) {
            this.studentId = studentId;
            this.courseId = courseId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key = (Key) o;

            if (studentId != key.studentId) return false;
            return courseId == key.courseId;
        }

        @Override
        public int hashCode() {
            int result = studentId;
            result = 31 * result + courseId;
            return result;
        }

        public int getStudentId() {
            return studentId;
        }

        public void setStudentId(int studentId) {
            this.studentId = studentId;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }
    }

}
