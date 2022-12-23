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
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long review_idx;

    private Long review_hidx;
    private Long review_pidx;
    private String review_title;
    private String review_cont;
//    private Data review_regdate;
    private Long review_recommend;
    private String review_menuidx;


}
