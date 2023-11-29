import { fileURLToPath, URL } from 'node:url';

import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';
import vueJsx from '@vitejs/plugin-vue-jsx';

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue(),
    vueJsx(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url)),
    },
  },
  build: {
    outDir: '../../target/classes/static', // Maven의 기본 빌드 디렉토리
    emptyOutDir: true, // 빌드 디렉토리를 빌드 전에 비움
    rollupOptions: {
      // 정적 자산을 처리하기 위한 설정
      output: {
        chunkFileNames: 'js/[name]-[hash].js',
        entryFileNames: 'js/[name]-[hash].js',
        assetFileNames: '[ext]/[name]-[hash].[ext]',
      },
    },
  },
  server: {
    proxy: {
      // 개발 중 CORS 문제를 해결하기 위한 프록시 설정
      '/api': {
        target: 'http://localhost:8083', // Spring Boot 백엔드 API
        changeOrigin: true,
        secure: false,
      },
    },
  },
});
