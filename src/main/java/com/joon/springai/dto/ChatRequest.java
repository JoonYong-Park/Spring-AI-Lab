package com.joon.springai.dto;

import jakarta.validation.constraints.NotBlank;

public record ChatRequest(
    @NotBlank String query
) {

}
