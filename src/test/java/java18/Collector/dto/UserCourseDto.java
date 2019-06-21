package java18.Collector.dto;

public class UserCourseDto/* implements Comparable<UserCourseDto>*/ {

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
}
