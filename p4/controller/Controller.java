package backendschool2.p4.controller;

import backendschool2.p4.domain.Post;
import backendschool2.p4.repository.Repository;

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

    private Repository repository = Repository.getInstance();

    public void wholeList() {
        List<Post> postList = repository.getAllPosts();
        System.out.println(LIST_ALL);
        System.out.println(TABLE_HEAD);
        for (Post post : postList) {
            System.out.printf("%2d %16s %17s\n", post.getId(), post.getTitle(), post.getLocalDate().toString());
        }
    }

    public void register() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(INPUT_TITLE);
        String title = br.readLine();
        System.out.print(INPUT_WRITER);
        String writer = br.readLine();

        Post post = new Post(title, writer);
        repository.save(post);
        System.out.println(ADD_COMPLETE);
    }
}
