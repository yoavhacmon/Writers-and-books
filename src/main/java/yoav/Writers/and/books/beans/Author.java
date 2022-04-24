package yoav.Writers.and.books.beans;

import lombok.*;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 40, nullable = true)
    private String name;
    private float weight;
    @Singular("book")
    @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private List<Book> books;
}
