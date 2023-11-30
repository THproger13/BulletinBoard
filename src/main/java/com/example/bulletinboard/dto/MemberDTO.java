package com.example.bulletinboard.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class MemberDTO {

    @NotBlank(message = "이름은 필수 입력 값 입니다.")
    @Size(max = 20, message = "이름은 최대 20자까지 허용 됩니다.")
    private String memberName;

    @NotBlank(message = "이메일은 필수 입력 값 입니다.")
    @Email(message = "이메일 형식이 유효하지 않습니다.")
    @Size(max = 50)
    private String memberEmail;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Size(min = 8, message = "비밀번호는 최소 8자 이상이어야 합니다.")
    private String password;

    // 기본 생성자
    public MemberDTO() {
    }

    // 모든 필드를 위한 getter 및 setter
    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // 필요에 따라 유효성 검사 어노테이션을 추가할 수 있습니다.
    // 예: @NotBlank(message = "이름은 필수 항목입니다.")
}
