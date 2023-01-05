package org.booksta.store.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table
public class SearchKeyword {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "member_id")
    private Long memberId;

    @Column(length = 200, nullable = false)
    private String keyword;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime searchTime = LocalDateTime.now();

    private LocalDateTime created = LocalDateTime.now();
    private LocalDateTime updated;

    public SearchKeyword() {
    }

    @Builder
    public SearchKeyword(Long id, Long memberId, String keyword) {
        this.id = id;
        this.memberId = memberId;
        this.keyword = keyword;
    }
}
