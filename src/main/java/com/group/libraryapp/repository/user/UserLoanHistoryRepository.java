package com.group.libraryapp.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoanHistoryRepository extends JpaRepository<com.group.libraryapp.domain.user.UserLoanHistory, Long> {

    boolean existsByBookNameAndIsReturn(String name, boolean isReturn);

}
