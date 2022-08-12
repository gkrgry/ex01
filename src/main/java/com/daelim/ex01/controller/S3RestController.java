package com.daelim.ex01.controller;

import com.daelim.ex01.service.S3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/s3rest")
public class S3RestController {

    private final S3Service s3Service;

    /**
     * S3 파일 다운로드
     * @return 성공 시 파일 다운
     */
    @GetMapping("/file")
    public ResponseEntity<byte[]> downloadFile(@RequestParam String fileName) throws IOException {
        return s3Service.getObject(fileName);
    }

    /**
     * S3에 파일 업로드
     * @return 성공 시 200 Success와 함께 업로드 된 파일의 파일명 리스트 반환
     */
    @PostMapping("/file")
    public ResponseEntity<List<String>> uploadFile(@RequestPart List<MultipartFile> multipartFile) {
        return ResponseEntity.status(HttpStatus.OK).body(s3Service.uploadFile(multipartFile));
    }

    /**
     * S3에 업로드 된 파일을 삭제
     * @return 성공 시 200 Success
     */
    @DeleteMapping("/file")
    public ResponseEntity<String> deleteFile(@RequestParam String fileName){
        s3Service.deleteFile(fileName);
        return ResponseEntity.status(HttpStatus.OK).body("파일삭제 성공");
    }
}
