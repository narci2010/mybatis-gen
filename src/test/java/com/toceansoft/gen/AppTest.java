package com.toceansoft.gen;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.toceansoft.dao.PermissionMapper;
import com.toceansoft.model.Permission;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	private SqlSessionFactory sqlSessionFactory;

	// 此方法是在执行findUserByIdTest之前执行
	@Before
	public void setUp() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFcatory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindUserById() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 创建Usermapper对象，mybatis自动生成mapper代理对象
		PermissionMapper mapper = sqlSession.getMapper(PermissionMapper.class);
		Permission p = mapper.selectByPrimaryKey(1);
		System.out.println(p.getName());
		sqlSession.close();
	}
	
	@Test
	public void testFindUserByName() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 创建Usermapper对象，mybatis自动生成mapper代理对象
		PermissionMapper mapper = sqlSession.getMapper(PermissionMapper.class);
		List<String> p = mapper.getPermissions("admin");
		for(String pri:p){
			System.out.println(pri+"|");
		}
		sqlSession.close();
	}

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

}
