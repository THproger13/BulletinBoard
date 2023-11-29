<template>
  <div class="signup-form">
    <h1>회원가입</h1>
    <form @submit.prevent="submitForm">
      <div class="form-group">
        <label for="memberName">이름</label>
        <input type="text" id="memberName" v-model="signupData.memberName" required>
        <span v-if="formErrors.memberName">{{ formErrors.memberName }}</span>
      </div>

      <div class="form-group">
        <label for="memberEmail">이메일</label>
        <input type="email" id="memberEmail" v-model="signupData.memberEmail" required>
        <span v-if="formErrors.memberEmail">{{ formErrors.memberEmail }}</span>
      </div>

      <div class="form-group">
        <label for="password">비밀번호</label>
        <input type="password" id="password" v-model="signupData.password" required>
        <span v-if="formErrors.password">{{ formErrors.password }}</span>
      </div>

      <button type="submit">가입하기</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      signupData: {
        memberName: '',
        memberEmail: '',
        password: ''
      },
      formErrors: {
        memberName: null,
        memberEmail: null,
        password: null
      }
    };
  },
  methods: {
    validateForm() {
      // 클라이언트 측 유효성 검사를 수행하고, formErrors를 업데이트합니다.
      // 백엔드에서 오는 유효성 검사 메시지를 활용하거나,
      // 프론트엔드에서 별도의 유효성 검사 메시지를 사용할 수도 있습니다.
    },
    async submitForm() {
      this.validateForm();
      if (!this.formErrors.memberName && !this.formErrors.memberEmail && !this.formErrors.password) {
        try {
          // 회원가입 API 호출
          await this.$axios.post('/api/members', this.signupData);
          // 성공적으로 회원가입이 되면, 로그인 페이지로 리다이렉트하거나
          // 회원가입 성공 메시지를 표시할 수 있습니다.
        } catch (error) {
          // 에러 처리, 예를 들면:
          // if (error.response && error.response.data) {
          //   this.formErrors = error.response.data.errors;
          // }
        }
      }
    }
  }
};
</script>

<style scoped>
/* 스타일은 여기에 추가합니다. */
.form-group {
  margin-bottom: 1rem;
}
.form-group label {
  display: block;
}
.form-group input {
  width: 100%;
  padding: 0.5rem;
  margin-top: 0.25rem;
}
.form-group span {
  color: red;
  font-size: 0.875rem;
}
</style>
