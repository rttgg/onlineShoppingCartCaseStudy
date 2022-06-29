package com.roman.onlineshoppingcartcasestudy.repository;

import com.roman.onlineshoppingcartcasestudy.model.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileInfoRepo extends JpaRepository<FileInfo, Integer> {

    FileInfo findByFileName(String name);
}
