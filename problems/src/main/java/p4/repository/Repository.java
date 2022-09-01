package p4.repository;

import p4.domain.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Repository {
    private static final Repository repository = new Repository();

    public static Repository getInstance() {
        return repository;
    }

    private Repository() {
    }

    private int sequence = 0;
    private HashMap<Integer, Post> map = new HashMap<>();

    public void save(Post post) {
        post.setId(++sequence);
        map.put(post.getId(), post);
    }

    public List<Post> getAllPosts() {
        return new ArrayList<>(map.values());
    }
}
