package com.Capgemini.CapgeminiSpringBoot.Repository;

import com.Capgemini.CapgeminiSpringBoot.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CourseRepo  extends JpaRepository<Course, Long> {
    List<Course> findCoursesByCourseNameContains(String keyword);
    @Query(value = "select * from courses as c where c.course_id in (select e.course_id from enrolled_in as e where e.student_id=:studentId)", nativeQuery = true)
    List<Course> getCoursesByStudentId(@Param("studentId") Long studentId);
}
