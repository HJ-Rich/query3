package rich.query3.controller;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rich.query3.entity.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

import static rich.query3.entity.QChapter.chapter;
import static rich.query3.entity.QLecture.lecture;
import static rich.query3.entity.QRoadmap.roadmap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lectures")
@Transactional
public class LectureController {

    private final EntityManager entityManager;
    private JPAQueryFactory jpaQueryFactory;

    @GetMapping
    public List<Lecture> findAll() {
        jpaQueryFactory = new JPAQueryFactory(entityManager);

        return jpaQueryFactory
                .selectFrom(lecture)
                .leftJoin(lecture.chapters)
                .fetchJoin()
                .distinct()
                .orderBy(lecture.order.asc())
                .fetch();
    }

    @PostMapping
    public Lecture save(@RequestBody Lecture lecture) {
        entityManager.persist(lecture);
        return lecture;
    }


}
