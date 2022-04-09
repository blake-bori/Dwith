<template>
  <div>
    <h1>스프링 부트로 시작하는 웹 서비스 Ver.2</h1>
    <div class="col-md-12">
      <div class="row">
        <div class="col-md-6">
          <router-link to="/posts-save"><button>글 등록</button></router-link>
          <router-link to="/posts-update"><button>글 수정</button></router-link>
        </div>
      </div>
      <br />

      <table class="table table-horizontal table-bordered">
        <thead class="thead-strong">
          <tr>
            <th>게시글 번호</th>
            <th>제목</th>
            <th>작성자</th>
          </tr>
        </thead>
        <tbody id="tbody">
          <tr v-for="post in posts" :key="post.id">
            <td>{{ post.id }}</td>
            <td>{{ post.title }}</td>
            <td>{{ post.author }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import http from "@/api/http.js";

export default {
  data() {
    return {
      posts:[],
    };
  },
  methods: {
    async postSearch() {
      console.log("게시글 불러오기");
      return http
        .get("/v1/postSearch")
        .then((response) => {
          if (response.data.length>0) {
            console.log("게시글 로드 성공");
            this.posts=response.data;
          } else {
            console.log("게시글 로드 실패");
          }
        })
        .catch((error) => {
          console.log("에러" + error);
        });
    },
  },
  created() {
    console.log("Post Search created");
  },
  mounted() {
    console.log("Post Search mounted");
    this.postSearch();
  },
};
</script>
