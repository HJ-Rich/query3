package rich.query3.controller;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rich.query3.entity.Chapter;
import rich.query3.entity.Lecture;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

import static rich.query3.entity.QChapter.chapter;
import static rich.query3.entity.QLecture.lecture;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chapters")
@Transactional
public class ChapterController {

    private final EntityManager entityManager;
    private JPAQueryFactory jpaQueryFactory;

    @GetMapping
    public List<Chapter> findAll() {
        jpaQueryFactory = new JPAQueryFactory(entityManager);

        return jpaQueryFactory
                .selectFrom(chapter)
                .orderBy(chapter.order.asc())
                .fetch();
    }

    @PostMapping
    public Chapter save(@RequestBody Chapter chapter) {
        entityManager.persist(chapter);
        return chapter;
    }

}
