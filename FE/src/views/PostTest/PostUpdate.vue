<template>
  <div>
    <h1>게시글 수정</h1>
    <div class="col-md-12">
      <div class="col-md-4">
        <form>
          <div class="form-group">
            <label for="title">글 번호</label>
            <input type="text" class="form-control" id="id" :value="post.id" readonly />
          </div>
          <div class="form-group">
            <label for="title">제목</label>
            <input type="text" class="form-control" id="title" v-model="post.title" />
          </div>
          <div class="form-group">
            <label for="author">작성자</label>
            <input type="text" class="form-control" id="aurhor" :value="post.author" readonly />
          </div>
          <div class="form-group">
            <label for="content">내용</label>
            <textarea class="form-control" id="content" v-model="post.content"></textarea>
          </div>
        </form>
        <router-link to="/"><button>취소</button></router-link>
        <button type="button" class="btn btn-primary" id="btn-update" @click="postUpdate">수정 완료</button>
        <button type="button" class="btn btn-primary" id="btn-delete" @click="postDelete">삭제</button>
      </div>
    </div>
  </div>
</template>
<script>
import http from "@/api/http.js";

export default {
  data() {
    return {
      post: {
        id: "id",
        title: "title",
        author: "author",
        content: "content",
      },
    };
  },
  methods: {
    async getPostData() {
      console.log("게시글 데이터 요청");
      return http
        .get("/v1/posts/6")
        .then((response) => {
          console.log(response.data);
          this.post=response.data;
        })
        .catch((error) => {
          console.log("에러" + error);
        });
    },
    async postUpdate() {
      console.log("게시글 수정 요청");
      return http
        .put("/v1/posts/" + this.post.id, { title: this.post.title, content: this.post.content })
        .then((response) => {
          console.log(response.data);

          if (response.data > 0) {
            alert("게시글 수정 성공");
          } else {
            alert("게시글 수정 실패");
          }
        })
        .catch((error) => {
          console.log("에러" + error);
        });
    },
    async postDelete() {
      console.log("게시글 수정 요청");
      return http
        .put("/v1/posts" + this.post.id, { title: this.post.title, content: this.post.content })
        .then((response) => {
          console.log(response.data);

          if (response.data > 0) {
            alert("게시글 수정 성공");
          } else {
            alert("게시글 수정 실패");
          }
        })
        .catch((error) => {
          console.log("에러" + error);
        });
    },
  },
  created() {
    console.log("Post Update created");
  },
  mounted() {
    console.log("Post Update mounted");
    this.getPostData();
  },
};
</script>
