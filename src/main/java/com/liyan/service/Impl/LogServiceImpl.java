package com.liyan.service.Impl;

import com.liyan.file.PageInfo;
import com.liyan.pojo.Log;
import com.liyan.service.LogService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import javax.servlet.annotation.WebServlet;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LogServiceImpl implements LogService {

    @Override
    public PageInfo findpaeg(int pageSize, int pageNumber) throws Exception {
        InputStream config = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(config);
        SqlSession sqlSession = factory.openSession();
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageSize(pageSize);
        pageInfo.setPageNumber(pageNumber);
        Map<String, Object> map = new HashMap<>();
        map.put("pageStart", pageSize * (pageNumber - 1));
        map.put("pageSize", pageSize);
        List<Log> logs = sqlSession.selectList("mapper.LogMapper.findpage",map);
        Long count = sqlSession.selectOne("mapper.LogMapper.findcount");
        pageInfo.setList(logs);
        pageInfo.setPageSize(pageSize);
        pageInfo.setPageNumber(pageNumber);
        pageInfo.setTotal(count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
        return pageInfo;
    }
}
