package com.zzn.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zzn.demo.pojo.Article;
import com.zzn.demo.pojo.Comment;
import com.zzn.demo.service.CommentService;

@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;

	// 根据articleID删除评论
	@RequestMapping(value = "/artComment", method = RequestMethod.GET)
	public int sbArticle(@RequestParam(value = "articleid", required = false) Integer articleid) {
		// System.out.println(articleid);
		return commentService.artComment(articleid);
	}

	// 根据articleID查看博客的评论
	@RequestMapping(value = "/searchArticleComment", method = RequestMethod.GET)
	public List<Comment> searchArticleComment(@RequestParam(value = "articleid", required = false) Integer articleid) {
		List<Comment> list2 = commentService.searchArticleComment(articleid);
		return list2;
	}

	// 分页，查询pageSize条评论
	@RequestMapping(value = "/fiveCommentList", method = RequestMethod.GET)
	public List<Comment> fiveArticleList(@RequestParam(value = "articleid") Integer articleid,
			@RequestParam(value = "page") Integer page, @RequestParam(value = "pagesize") Integer pagesize) {
		List<Comment> list = commentService.fiveCommentList(articleid, page, pagesize);
		return list;
	}

	// 分页，获取博客表总条数
	@RequestMapping(value = "/commentTotalCount", method = RequestMethod.GET)
	public int commentTotalCount(@RequestParam(value = "articleid") Integer articleid) {
		return commentService.commentTotalCount(articleid);
	}

}
