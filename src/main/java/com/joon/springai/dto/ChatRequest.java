package com.joon.springai.dto;

import javax.validation.constraints.NotNull;

public record ChatRequest(
    @NotNull String query
) {

}
