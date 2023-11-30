// src/hooks/useAxios.ts 파일 예시

import axios from 'axios';

export function useAxios() {
    // axios 인스턴스 또는 사용자 정의 로직
    const instance = axios.create({
        baseURL: 'http://example.com',
        // baseURL: '.',
    });

    return instance;
}
