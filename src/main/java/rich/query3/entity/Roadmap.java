package rich.query3.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roadmap")
@Getter
@Setter
@ToString(of = {"id", "name"})
@SequenceGenerator(name = "roadmapSeq", sequenceName = "roadmap_seq", initialValue = 1, allocationSize = 1)
public class Roadmap {

    @Id @GeneratedValue(generator = "roadmapSeq")
    @Column(name = "roadmap_id")
    private Integer id;

    @Column(name = "roadmap_name", unique = true)
    private String name;

    @Column(name = "roadmap_order")
    private Integer order;

    @OneToMany(mappedBy = "roadmap")
    @JsonManagedReference
    private List<Lecture> lectures = new ArrayList<>();

}
