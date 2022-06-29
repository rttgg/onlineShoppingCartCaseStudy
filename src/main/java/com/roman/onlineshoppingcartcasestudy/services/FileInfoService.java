package com.roman.onlineshoppingcartcasestudy.services;

import org.springframework.util.StringUtils;
import com.roman.onlineshoppingcartcasestudy.model.FileInfo;
import com.roman.onlineshoppingcartcasestudy.repository.FileInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FileInfoService {

    private FileInfoRepo fileInfoRepo;

    @Autowired
    public FileInfoService(FileInfoRepo fileInfoRepo) {
        this.fileInfoRepo = fileInfoRepo;
    }

    public FileInfo store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileInfo fileInfo = new FileInfo(fileName, file.getContentType(),file.getSize(),file.getBytes());
        return fileInfoRepo.save(fileInfo);
    }

    public FileInfo getFile(int id) throws NoSuchElementException {
        return fileInfoRepo.findById(id).orElseThrow();

    }

    public List<FileInfo> getAllFiles(){
        return fileInfoRepo.findAll();
    }
}
