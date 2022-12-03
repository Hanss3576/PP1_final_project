package com.crud.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class BoardDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String BOARD_INSERT = "insert into BOARD (title, writer, content) values (?,?,?)";
    private final String BOARD_UPDATE = "update BOARD set title=?, writer=?, content=? where seq=?";
    private final String BOARD_DELETE = "delete from BOARD  where seq=?";
    private final String BOARD_GET = "select * from BOARD  where seq=?";
    private final String BOARD_LIST = "select * from BOARD order by seq desc";

    public int insertBoard(BoardVO vo) {

        return jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
    }

    public int deleteBoard(int seq) {
        String sql = "delete from BOARD  where seq=" + seq;
        return jdbcTemplate.update(sql);
    }

    public int updateBoard(BoardVO vo) {
        String sql = "update BOARD set title=" + vo.getTitle() + ", writer=" + vo.getWriter() + ", content=" + vo.getContent() + " where seq=" + vo.getSeq();
        return jdbcTemplate.update(sql);
    }

    class BoardRowMapper implements RowMapper<BoardVO>{
        @Override
        public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
            BoardVO board = new BoardVO();
            board.setSeq(rs.getInt("seq"));
            board.setTitle(rs.getString("title"));
            board.setWriter(rs.getString("writer"));
            board.setContent(rs.getString("content"));
            return board;
        }
    }

    public BoardVO getBoard(int seq) {
        String sql = "select * from BOARD  where seq=" + seq;
        return jdbcTemplate.queryForObject(sql, new BoardRowMapper());
    }

    public List<BoardVO> getBoardList() {
        String sql = "select * from BOARD order by seq desc";
        return jdbcTemplate.query(sql, new BoardRowMapper());
    }
}
