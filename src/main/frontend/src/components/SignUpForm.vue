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

<script setup lang="ts">
import { ref } from 'vue';
import { useAxios } from '@/hooks/useAxios';

interface SignUpData {
  memberName: string;
  memberEmail: string;
  password: string;
}

interface FormErrors {
  memberName: string | null;
  memberEmail: string | null;
  password: string | null;
}

const signupData = ref<SignUpData>({
  memberName: '',
  memberEmail: '',
  password: '',
});

const formErrors = ref<FormErrors>({
  memberName: null,
  memberEmail: null,
  password: null,
});

const axios = useAxios();

const validateForm = () => {
  if (!signupData.value.memberName) {
    formErrors.value.memberName = '이름을 입력해 주세요.';
  } else {
    formErrors.value.memberName = null;
  }
  // 이메일과 비밀번호에 대한 유효성 검사 로직도 추가할 수 있습니다.
};

const submitForm = async () => {
  validateForm();
  if (!formErrors.value.memberName && !formErrors.value.memberEmail && !formErrors.value.password) {
    try {
      const response = await axios.post('/api/members/signup', signupData.value);
      // 성공 시 로직, 예를 들어 로그인 페이지로 이동
    } catch (error) {
      // 에러 처리 로직
    }
  }
};
</script>
