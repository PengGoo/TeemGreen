package teamgreen.abc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


@Entity
public class Parents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parents_idx;

    private String parents_id;
    private String parents_addr;
    private String parents_parttime;

}
