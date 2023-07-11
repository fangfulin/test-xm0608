package com.newer.control;

import com.newer.demo.entity.Article;
import com.newer.demo.entity.Comment;
import com.newer.demo.entity.ResponseData.ArticleResponseData;
import com.newer.service.AService;
import com.newer.service.CommentService;
import com.newer.service.StatisticService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BackController {
    @Autowired
    StatisticService statisticService;

    @Autowired
    CommentService commentService;

    @Autowired
    AService aService;

    private static final Logger logger = LoggerFactory.getLogger(BackController.class);

    @GetMapping("/admin")
    public String index(HttpServletRequest request) {
        long comments = statisticService.selectCountComment();
        long s = statisticService.selectCountSta();
        System.out.println(comments);
        System.out.println(s);
        List<Comment> list = commentService.CommentNew();
        List<Article> list1 = aService.selectNew();
        request.setAttribute("comments", comments);
        request.setAttribute("s", s);
        request.setAttribute("commentes", list);
        request.setAttribute("articles", list1);
        System.out.println(list.size());
        return "back/index";
    }


    //后台跳转发布文章
    @GetMapping(value = "/article/toEditPage")
    public String newArticle() {
        return "back/article_edit";
    }


    @PostMapping(value = "/article/publish")
    @ResponseBody
    public ArticleResponseData publishArticle(Article article) {

        try {
            aService.insertArticle(article);
            logger.info("文章发布成功");
            return ArticleResponseData.ok();
        } catch (Exception e) {
            logger.error("文章发布失败，错误信息: " + e.getMessage());
            return ArticleResponseData.fail();
        }
    }

    @RequestMapping("/article/articleList")
    public String  SelectList(HttpServletRequest request){
        List<Article> list=aService.select();
        request.setAttribute("articleList",list);
        return "back/article_list";
    }

    @RequestMapping("/article")
    public String findByIdArticle(@RequestParam("Id")Integer id, Model model){
        Article article=aService.selectById(id);
        model.addAttribute("contents",article);
        model.addAttribute("categories",article.getCategories());
        return "back/article_edit";
    }

    //文章删除
    @RequestMapping("/article/delete")
    public String delete(@RequestParam("Id")Integer id){
        String s = "";
        System.out.println(1234);
        try{
            this.aService.removeById(id);
                s="/article/articleList";
        }catch (Exception e){
            e.printStackTrace();
        }
        return s;
    }

}

