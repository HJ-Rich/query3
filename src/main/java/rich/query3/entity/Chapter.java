package rich.query3.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "chapter")
@Getter
@Setter
@ToString(of = {"id", "name"})
@SequenceGenerator(name = "chapterSeq", sequenceName = "chapter_seq", initialValue = 1, allocationSize = 1)
public class Chapter {

    @Id @GeneratedValue(generator = "chapterSeq")
    @Column(name = "chapter_id")
    private Integer id;

    @Column(name = "chapter_name", unique = true)
    private String name;

    @Column(name = "chapter_order")
    private Integer order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id")
    @JsonBackReference
    private Lecture lecture;

}
