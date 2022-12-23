package teamgreen.abc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


@Entity
public class Helper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long helper_idx;

    private String helper_id;
    private String helper_location;
    private String helper_parttime;
    private Long helper_reccount;
}
