package rich.query3.controller;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rich.query3.entity.Chapter;
import rich.query3.entity.QRoadmap;
import rich.query3.entity.Roadmap;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static rich.query3.entity.QRoadmap.roadmap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/roadmaps")
@Transactional
public class RoadmapController {

    private final EntityManager entityManager;
    private JPAQueryFactory jpaQueryFactory;

    @GetMapping
    public List<Roadmap> findAll() {
        jpaQueryFactory = new JPAQueryFactory(entityManager);

        return jpaQueryFactory
                .selectFrom(roadmap)
                .leftJoin(roadmap.lectures)
                .fetchJoin()
                .distinct()
                .orderBy(roadmap.order.asc())
                .fetch();
    }

    @PostMapping
    public Roadmap save(@RequestBody Roadmap newRoadmap) {
        jpaQueryFactory = new JPAQueryFactory(entityManager);

        newRoadmap.setOrder(getMaxOrder());
        entityManager.persist(newRoadmap);
        return newRoadmap;
    }

    private Integer getMaxOrder() {
        Roadmap roadmap = jpaQueryFactory
                                .selectFrom(QRoadmap.roadmap)
                                .orderBy(QRoadmap.roadmap.order.desc())
                                .fetchFirst();

        if (Objects.isNull(roadmap.getOrder())) {
            return 0;
        }
        return roadmap.getOrder();
    }

}
