package p4.controller;

import p4.domain.Post;
import p4.repository.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Controller {
    public static final String INPUT_TITLE = "제목 : ";
    public static final String INPUT_WRITER = "작성자 : ";
    public static final String LIST_ALL = "== 게시물 리스트 ==";
    public static final String TABLE_HEAD = "  no                title                 date ";
    public static final String ADD_COMPLETE = "글이 추가되었습니다.";

    private final Repository repository = Repository.getInstance();

    public void wholeList() {     //모든 게시글을 보여주는 메서드
        List<Post> postList = repository.getAllPosts();     //레포지토리에서 Post를 받아온다.
        System.out.println(LIST_ALL);
        System.out.println(TABLE_HEAD);
        for (Post post : postList) {
            System.out.printf("%2d %16s %17s\n", post.getId(), post.getTitle(), post.getLocalDate().toString());    //형식에 맞게 출력한다.
        }
    }

    public void register() throws IOException {     //게시물을 등록하는 메서드
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(INPUT_TITLE);
        String title = br.readLine();       //제목 입력
        System.out.print(INPUT_WRITER);
        String writer = br.readLine();      //작성자 입력

        Post post = new Post(title, writer);    //새로운 객체를 생성자를 이용해 생성한다.
        repository.save(post);                  //레포지토리에 저장한다.
        System.out.println(ADD_COMPLETE);
    }
}
