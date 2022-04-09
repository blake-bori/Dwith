<template>
  <div class="container">
    <h1>게시글 등록</h1>
    <div class="col-md-4">
      <form>
        <div class="form-group">
          <label for="title">제목</label>
          <input type="text" class="form-control" id="title" placeholder="제목 입력" v-model="title" />
        </div>
        <div class="form-group">
          <label for="author">작성자</label>
          <input type="text" class="form-control" id="author" placeholder="작성자 입력" v-model="author" />
        </div>
        <div class="form-group">
          <label for="content">제목</label>
          <textarea class="form-control" id="content" placeholder="내용 입력" v-model="content" />
        </div>
      </form>

      <router-link to="/"><button>취소</button></router-link>
      <button type="button" class="btn-primary" id="btn-save" @click="postSave">등록</button>
    </div>
  </div>
</template>
<script>
import http from "@/api/http.js";

export default {
  data() {
    return {
      title: "",
      author: "",
      content: "",
    };
  },
  methods: {
    async postSave() {
      console.log("게시글 등록 요청");
      return http
        .post("/v1/posts", { title: this.title, author: this.author, content: this.content })
        .then((response) => {
          console.log(response.data);
          this.title="";
          this.author="";
          this.content="";

          if (response.data>0) {
            alert("게시글 등록 성공");
          } else {
            alert("게시글 등록 실패");
          }
        })
        .catch((error) => {
          console.log("에러" + error);
        });
    },
  },
  created() {
    console.log("PostSave created");
  },
  mounted() {
    console.log("PostSave mounted");
  },
};
</script>
