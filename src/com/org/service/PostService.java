package com.org.service;

import com.org.dao.PostDao;
import com.org.po.Board;
import com.org.po.Post;

import java.util.List;

/**
 * Created by Administrator on 2015/7/4.
 */
public class PostService {
    private PostDao postDao;

    public PostDao getPostDao() {
        return postDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }


    public List<Post> findAllPosts(Board board) {
        return postDao.findByBoard(board);
    }

    public Post getPostById(int id) {
        return postDao.getPostById(id);
    }

    public boolean savePost(Post post) {
        return postDao.savePost(post);
    }

    public List<Post> findBySid(int sid) {
        return postDao.findBySid(sid);
    }
    public boolean deletePost(int id) {
        return postDao.deletePost(id);
    }

}
