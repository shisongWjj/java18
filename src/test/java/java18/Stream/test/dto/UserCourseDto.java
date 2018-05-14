package java18.Stream.test.dto;

public class UserCourseDto/* implements Comparable<UserCourseDto>*/{

    private Long courseId;
    private Long recruitId;
    private Long companyId;
    private Long classId;
    private Long userId;

    public UserCourseDto(Long courseId, Long recruitId, Long companyId, Long classId, Long userId) {
        this.courseId = courseId;
        this.recruitId = recruitId;
        this.companyId = companyId;
        this.classId = classId;
        this.userId = userId;
    }

    public UserCourseDto() {
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getRecruitId() {
        return recruitId;
    }

    public void setRecruitId(Long recruitId) {
        this.recruitId = recruitId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserCourseDto{" +
                "courseId=" + courseId +
                ", recruitId=" + recruitId +
                ", companyId=" + companyId +
                ", classId=" + classId +
                ", userId=" + userId +
                '}';
    }


   /* @Override
    public int compareTo(UserCourseDto o) {
        int i = (int)(this.getClassId() - o.getClassId());//先按照年龄排序
        return i;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserCourseDto that = (UserCourseDto) o;

        if (courseId != null ? !courseId.equals(that.courseId) : that.courseId != null) return false;
        if(courseId.equals(600165l)){
            if (recruitId != null ? !recruitId.equals(that.recruitId) : that.recruitId != null) return false;
        }
        /*if (companyId != null ? !companyId.equals(that.companyId) : that.companyId != null) return false;
        if (classId != null ? !classId.equals(that.classId) : that.classId != null) return false;*/
        return userId != null ? userId.equals(that.userId) : that.userId == null;
    }

    @Override
    public int hashCode() {
        int result = courseId != null ? courseId.hashCode() : 0;
        result = 31 * result + (recruitId != null ? recruitId.hashCode() : 0);
        /*result = 31 * result + (companyId != null ? companyId.hashCode() : 0);
        result = 31 * result + (classId != null ? classId.hashCode() : 0);*/
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
