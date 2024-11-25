package com.joon.springai.controller;

import com.joon.springai.dto.ChatResponse;
import com.joon.springai.service.ImageService;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ai")
public class imageController {

  private final ImageService imageService;

  @PostMapping(path = "/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<ChatResponse> Image(@RequestParam("photos") MultipartFile file) throws IOException {
    ChatResponse chatResponse = imageService.image(file);
    return ResponseEntity.ok(chatResponse);
  }

}
