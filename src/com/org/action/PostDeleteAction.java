package com.org.action;

import com.opensymphony.xwork2.ActionSupport;
import com.org.po.Post;
import com.org.po.Reply;
import com.org.service.PostService;
import com.org.service.ReplyService;

import java.util.List;

/**
 * Created by Administrator on 2015/7/5.
 */
public class PostDeleteAction extends ActionSupport{
    private  int[] ids;
    private PostService postService;
    private ReplyService replyService;


    public ReplyService getReplyService() {
        return replyService;
    }

    public void setReplyService(ReplyService replyService) {
        this.replyService = replyService;
    }

    public PostService getPostService() {
        return postService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    public int[] getIds() {
        return ids;
    }

    public void setIds(int[] ids) {
        this.ids = ids;
    }
    public String delete(){//删除自己的帖子
        Post post = new Post();
        for(int id:ids){
            post.setId(id);
            List<Reply> replies=replyService.findByPost(post);
            for (Reply r : replies) {
                replyService.deleteReply(r.getId());
            }
            postService.deletePost(id);
        }
        return "success";
    }
}
