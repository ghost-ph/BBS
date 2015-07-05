package com.org.service;

import com.org.dao.ReplyDao;
import com.org.po.Post;
import com.org.po.Reply;

import java.util.List;

/**
 * Created by Administrator on 2015/7/4.
 */
public class ReplyService {
    private ReplyDao replyDao;

    public ReplyDao getReplyDao() {
        return replyDao;
    }

    public void setReplyDao(ReplyDao replyDao) {
        this.replyDao = replyDao;
    }

    public boolean saveReply(Reply reply) {
        return replyDao.saveReply(reply);
    }
    public List<Reply> findByPost(Post post) {return replyDao.findByPost(post);}
    public boolean deleteReply(int id) {
        return replyDao.deleteReply(id);
    }
}
