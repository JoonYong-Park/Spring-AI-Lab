package com.joon.springai;

import com.joon.springai.dto.ChatRequest;
import com.joon.springai.dto.ChatResponse;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AiService {

  private final OpenAiChatModel openAiChatModel;


  public ChatResponse chat(ChatRequest chatRequest) {
    PromptTemplate promptTemplate = new PromptTemplate(
        """
        당신은 감정분석 전문가야
        사용자의 감정을 분석해줘
        사용자: {query}
        """
    );
    Prompt prompt = promptTemplate.create(Map.of("query", chatRequest.query()));

    String aiResponse = openAiChatModel.call(prompt).getResult().getOutput().getContent();

    log.info("사용자 요청: {}", chatRequest.query());
    log.info("AI 응답: {}", aiResponse);

    return ChatResponse.builder()
        .answer(aiResponse)
        .build();
  }

}
