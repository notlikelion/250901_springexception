package com.example.springexception.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDTO {
    @NotEmpty(message = "상품 이름은 필수입니다.") // null과 빈 문자열 x
    private String itemName;
    @NotNull(message = "가격을 입력해주세요.") // null을 허용 X
    @Min(value = 100, message = "가격은 100원 이상이어야 합니다.") // 최소값 제약
    private Integer price;
}
