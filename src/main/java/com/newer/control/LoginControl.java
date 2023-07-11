package com.newer.control;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.newer.demo.entity.Article;
import com.newer.demo.entity.Comment;
import com.newer.demo.entity.ResponseData.ArticleResponseData;
import com.newer.demo.entity.Statistic;
import com.newer.demo.entity.TbsUsers;
import com.newer.service.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.context.SecurityContextHolder;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;


@Controller
public class LoginControl {
    private static final Logger logger = LoggerFactory.getLogger(LoginControl.class);


    @Autowired
    private SendEmailService sendEmailService;

    @Autowired
    ArticleService articleService;
    @Autowired
    StatisticService statisticService;

    @Autowired
    CommentService commentService;

    @Autowired
    AService aService;



    public LoginControl(){
        System.out.println("登录控制器实例化");
    }

    @GetMapping("/userLogin")
    public String toLoginPage(){
        System.out.println("启动方法login");
        return "comm/login";//跳转到login/login
    }

    @RequestMapping("/selectpage")
    public String  toIndexPage(HttpServletRequest request, @RequestParam(value = "pageNo",defaultValue = "0")Integer pageNo, Model model){
        System.out.println("登录成功");
//        String to="2926052196@qq.com";
//        String subject="【纯文本邮件】标题";
//        String text="用户已经登录";
//        // 发送简单邮件
//        sendEmailService.sendSimpleEmail(to,subject,text);

        Page<Article> page=new Page<>(pageNo,5);
        IPage<Article> articles= articleService.page(page);
        List<Article> articleList=aService.getHeatArticles();
        System.out.println(articleList.toString());
        System.out.println(1234);
        System.out.println(articles.getCurrent());
        model.addAttribute("articles",articles);
        model.addAttribute("articleList",articleList);
        return "client/index";
    }

    @GetMapping("/article/{id}")
    public String getArticleById(@PathVariable("id") Integer id, HttpServletRequest request){
        System.out.println(123);
        Article article=aService.selectById(id);
        if(article!=null){
            List<Comment> list=commentService.selectByArticleId(id);
            request.setAttribute("comments",list);
            System.out.println(list);
        }
        System.out.println(article);
        request.setAttribute("article",article);
        return "client/articleDetails";
    }

    @PostMapping("/publish")
    @ResponseBody
    public ArticleResponseData publicComment(HttpServletRequest request, @RequestParam Integer aid, @RequestParam String text){
        User users=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(123412);
        Comment comments=new Comment();
        comments.setArticleid(aid);
        comments.setIp(request.getRemoteAddr());
        comments.setCreated(String.valueOf(new Date()));
        comments.setAuthor(users.getUsername());
        comments.setContent(text);
        commentService.pushComment(comments);
        try {
            commentService.pushComment(comments);
            logger.info("发布评论成功，对应文章id: "+aid);
            return ArticleResponseData.ok();
        } catch (Exception e) {
            logger.error("发布评论失败，对应文章id: "+aid +";错误描述: "+e.getMessage());
            return ArticleResponseData.fail();
        }
    }




}
