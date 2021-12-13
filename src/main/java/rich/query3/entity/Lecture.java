package rich.query3.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lecture")
@Getter
@Setter
@ToString(of = {"id", "name"})
@SequenceGenerator(name = "lectureSeq", sequenceName = "lecture_seq", initialValue = 1, allocationSize = 1)
public class Lecture {

    @Id @GeneratedValue(generator = "lectureSeq")
    @Column(name = "lecture_id")
    private Integer id;

    @Column(name = "lecture_name", unique = true)
    private String name;

    @Column(name = "lecture_order")
    private Integer order;

    @ManyToOne
    @JoinColumn(name = "roadmap_id")
    @JsonBackReference
    private Roadmap roadmap;

    @JsonManagedReference
    @OneToMany(mappedBy = "lecture", fetch = FetchType.LAZY)
    private List<Chapter> chapters = new ArrayList<>();

}
