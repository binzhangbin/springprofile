package cn.bin.zhang.jdbc;

import cn.bin.zhang.vo.Blog;
import java.util.List;

import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.*;

/**
 * 使用SpringJdbcTemplate测试CRUD
 */
//@Repository(value = "c")
public class crud {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public boolean addBlog(Blog blog){
        final String insertsql="insert into blog(btxt,btitle,uid) values(?,?,?)";
        final String insertsql2="insert into blog(btxt,btitle,uid) values(?,?,?)";
        KeyHolder keyHolder=new GeneratedKeyHolder();//创建一个主键持有者
        int update = this.jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement(insertsql2, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, blog.getBtxt());
                preparedStatement.setString(2, blog.getBtitle());
                preparedStatement.setInt(3, blog.getUid());

                return preparedStatement;
            }
        },keyHolder);
        System.out.println("获得主键："+keyHolder.getKey().intValue());
        return update==1&&this.jdbcTemplate.update(insertsql,new Object[]{blog.getBtxt(),blog.getBtitle(),blog.getUid()},new int[]{Types.VARCHAR,Types.VARCHAR,Types.INTEGER})==1;
    }

    public int updateBatch(List<Blog> blogs){//一次性提交数据
        String updateSql="update blog set btxt=? where bid=?";
        int[] ints = jdbcTemplate.batchUpdate(updateSql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Blog blog = blogs.get(i);
                ps.setString(1, blog.getBtxt());
                ps.setInt(2, blog.getBid());
            }

            @Override
            public int getBatchSize() {
                return blogs.size();
            }
        });
        return ints.length;
    }
    public Blog selBlogByRowCallbackHandler(int bid){
        String selSql="select bid,btxt,btitle,uid from blog where bid=?";
        Blog blog=new Blog();
        jdbcTemplate.query(selSql, new Object[]{bid}, new RowCallbackHandler() {//返回单个对象|批量-有状态
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                blog.setBid(rs.getInt(1));
                blog.setBtxt(rs.getString(2));
                blog.setBtitle(rs.getString(3));
                blog.setUid(rs.getInt(4));
            }
        });
        return blog;
    }
    public List<Blog> selBlogByMapper(int bid){
        String selSql="select bid,btxt,btitle,uid from blog where bid=?";
        return jdbcTemplate.query(selSql, new Object[]{bid}, new RowMapper<Blog>() {//无状态-自动绑定List
            @Override
            public Blog mapRow(ResultSet rs, int rowNum) throws SQLException {
                Blog blog=new Blog();
                blog.setBid(rs.getInt(1));
                blog.setBtxt(rs.getString(2));
                blog.setBtitle(rs.getString(3));
                blog.setUid(rs.getInt(4));
                return blog;
            }//返回单个对象|批量-有状态
        });
    }

    public Blog selOne(int bid){
        String selSql="select bid,btxt,btitle,uid from blog where bid=?";
        Blog blog = jdbcTemplate.queryForObject(selSql, new Object[]{13}, new RowMapper<Blog>() {
            @Override
            public Blog mapRow(ResultSet rs, int rowNum) throws SQLException {
                Blog blog1=new Blog();
                blog1.setBid(rs.getInt("bid"));
                blog1.setBtxt(rs.getString("btxt"));
                blog1.setBtitle(rs.getString("btitle"));
                blog1.setUid(rs.getInt("uid"));
                return blog1;
            }
        });
        return blog;
    }
}
