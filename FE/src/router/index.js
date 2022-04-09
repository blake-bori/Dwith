import Vue from "vue";
import VueRouter from "vue-router";

import HomePage from "../views/HomePage.vue";
import LoginPage from "../views/LoginPage.vue";
import RegisterPage from "../views/RegisterPage.vue";

// 연습용 페이지 링크
import PostSave from "../views/PostTest/PostSave.vue";
import PostSearch from "../views/PostTest/PostSearch.vue";
import PostUpdate from "../views/PostTest/PostUpdate.vue";

Vue.use(VueRouter);

const routes = [
  {
    // 홈 화면은 "/" 또는 "/main" 으로 접속 가능
    path: "/",
    alias: ["/main"],
    name: "Home",
    component: HomePage,
  },
  {
    path: "/login",
    name: "Login",
    component: LoginPage,
  },
  {
    path: "/register",
    name: "Register",
    component: RegisterPage,
  },

  // 연습용 페이지 링크
  {
    path: "/posts-save",
    name: "PostSave",
    component: PostSave,
  },
  {
    path: "/posts-search",
    name: "PostSearch",
    component: PostSearch,
  },
  {
    path: "/posts-update",
    name: "PostUpdate",
    component: PostUpdate,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,

  //페이지 이동 시 스크롤을 가장 위로 옮김
  scrollBehavior() {
    return { x: 0, y: 0, behavior: "instant" };
  },
});

export default router;
