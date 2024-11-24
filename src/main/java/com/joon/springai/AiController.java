package com.joon.springai;

import com.joon.springai.dto.ChatRequest;
import com.joon.springai.dto.ChatResponse;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
@RequiredArgsConstructor
public class AiController {

  private final AiService aiService;

  @GetMapping
  public String status() {
    return "OK";
  }

  @PostMapping("/chat")
  public ResponseEntity<ChatResponse> chat(@Valid @RequestBody ChatRequest chatRequest) {
    ChatResponse chatResponse = aiService.chat(chatRequest);
    return ResponseEntity.ok(chatResponse);
  }

}
