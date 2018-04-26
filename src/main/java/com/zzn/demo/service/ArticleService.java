package com.zzn.demo.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zzn.demo.mapper.ArticleMapper;
import com.zzn.demo.pojo.Article;


@Service
public class ArticleService {
	
	@Autowired
	private ArticleMapper articleMapper;
	
	//获取所有博客
	public List<Article> allArticleList(){
		List<Article> list = articleMapper.getArticleList(); 
		return list;
	} 
	
	//获取所有个人的博客
	public List<Article> sbArticleList(Integer userID){
		List<Article> list1 = articleMapper.getSbArticleList(userID);
		return list1;
	}
	
	//删除博客
	public int sbArticle(Integer articleID) {
		return articleMapper.deleteSbArticle(articleID);
	}
	
	//获取，显示博客
	public Article article(Integer articleID) {
		return articleMapper.getArticle(articleID);
	}
	
	//添加,写博客
	public int insertArt(String articleName,String articleContent,Integer userID) {
		return articleMapper.insertArticle(articleName, articleContent, userID);
	}
	
	//更新博客
	public int updateArt(Integer aticleID,String articleContent) {
		return articleMapper.updateArticle(aticleID,articleContent);
	}
	
}
