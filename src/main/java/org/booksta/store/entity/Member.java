package org.booksta.store.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 20, nullable = false)
    private String email;
    @Column(length = 100, nullable = false)
    private String password;

    public Member() {
    }

    @Builder
    public Member(long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
}
