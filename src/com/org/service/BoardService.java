package com.org.service;

import com.org.dao.BoardDao;
import com.org.po.Board;

import java.util.List;

/**
 * Created by Administrator on 2015/7/4.
 */
public class BoardService {
    private BoardDao  boardDao;

    public BoardDao getBoardDao() {
        return boardDao;
    }

    public void setBoardDao(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
    public List<Board> getAllBoards() {
        return boardDao.getAllBoards();
    }
}
