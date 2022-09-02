package p4.repository;

import p4.domain.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Repository {
    private static final Repository repository = new Repository();      //싱글톤 패턴으로 정의한다.

    public static Repository getInstance() {
        return repository;
    }

    private Repository() {
    }

    private int sequence = 0;       //기본키 변수 선언
    private HashMap<Integer, Post> map = new HashMap<>();   //Post 객체를 담을 해쉬맵 선언

    public void save(Post post) {
        post.setId(++sequence);     //키 값을 설정한다.
        map.put(post.getId(), post);    //해쉬맵에 Post 객체를 저장한다.
    }

    public List<Post> getAllPosts() {
        return new ArrayList<>(map.values());
    }   //모든 게시글을 List<Post> 형식으로 반환한다.
}
