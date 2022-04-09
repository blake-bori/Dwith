package com.sswon314.Dwith.serviceTest;

import com.sswon314.Dwith.webTest.domain.posts.Posts;
import com.sswon314.Dwith.webTest.domain.posts.PostsRepository;
import com.sswon314.Dwith.webTest.dto.PostsListResponseDto;
import com.sswon314.Dwith.webTest.dto.PostsResponseDto;
import com.sswon314.Dwith.webTest.dto.PostsSaveRequestDto;
import com.sswon314.Dwith.webTest.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor // final이 선언된 모든 필드를 인자값으로 하는 constructor 생성
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    // 게시글 등록 후 게시글 id 반환
    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    // 게시글 수정 후 게시글 id 반환
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    // 전체 게시글 검색 후 게시글 리스트 반환
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        // 문법 : map(PostListResponseDto::new == map(posts->new PostListResponseDto(posts))
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    // 특정 게시글 검색 후 해당 게시글 객체 반환
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }
}
