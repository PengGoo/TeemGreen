package teamgreen.abc.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @CreatedDate
    private String createdDate;

    @LastModifiedDate
    private String modifiedDate;

    @PrePersist
    public void onPrePersist(){
        this.createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        this.modifiedDate = this.createdDate;
    }

    @PreUpdate
    public void onPreUpdate(){
        this.modifiedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
    }
}

/*
- @MappedSuperClass:
JPA Entity클래스들이 BaseTimeEntity를 상속할 때
입력한 필드변수가 칼럼으로 인식하도록 함.

- @EntityListeners(AuditingEntityListener.class)
BaseTimeEntity클래스에 Auditing 기능을 포함시킴.

- @CreatedDate
Entity가 생성되어 저장될 때 시간이 자동 저장됨.

- @LastModifiedDate
조회한 Entity의 값을 변경할 때 시간이 자동 저장됨.
 */
