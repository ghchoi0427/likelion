package precouse.likelion.community.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Board {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Member.class)
    private Member writer;
    private LocalDateTime createdTime;
    @OneToMany(cascade = CascadeType.ALL, targetEntity = Comment.class)
    private List<Comment> comments;
    private int like;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
