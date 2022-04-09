package com.sswon314.Dwith.webTest;

import com.sswon314.Dwith.serviceTest.PostsService;
import com.sswon314.Dwith.webTest.dto.PostsListResponseDto;
import com.sswon314.Dwith.webTest.dto.PostsResponseDto;
import com.sswon314.Dwith.webTest.dto.PostsSaveRequestDto;
import com.sswon314.Dwith.webTest.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    // RequestBody : 보낼 데이터
    // pathVariable : {id}에서 id에 해당
    // 게시글 등록
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    // 게시글 수정
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    // 특정 게시글 검색
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    // 드윗 임시 api 테스트
    @PostMapping("/api/login")
    public String login() {
        return "login";
    }

    // 전체 게시글 검색
    @GetMapping("api/v1/postSearch")
    public List<PostsListResponseDto> postSearch(Model model) {
        return postsService.findAllDesc();
    }
}
