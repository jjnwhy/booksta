package org.booksta.store.repository;

import org.booksta.domain.dto.PopularKeywordDto;
import org.booksta.store.entity.SearchKeyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchKeywordRepository extends JpaRepository<SearchKeyword, Long> {
    List<SearchKeyword> findAllByMemberIdOrderBySearchTimeDesc(Long MemberId);

    @Query("SELECT sk.keyword as keyword, COUNT(sk.keyword) as keywordCount " +
            "FROM SearchKeyword sk " +
            "GROUP BY sk.keyword " +
            "ORDER BY keywordCount DESC")
    List<PopularKeywordDto> findPopularKeyword();

}
