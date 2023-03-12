package com.MIS.MISTalks.Explore.Controllers;

import com.MIS.MISTalks.Explore.Model.VideoInfo;
import com.MIS.MISTalks.Explore.Services.ExploreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/MIS-TALKS/explore")
@SessionAttributes("{sessionId}")
public class ExploreController {
    private final int PAGE_SIZE = 18;
    private final Logger log = LoggerFactory.getLogger(ExploreController.class);
    private final ExploreService exploreService;

    @Autowired
    public ExploreController(ExploreService exploreService) {
        this.exploreService = exploreService;
    }

    @GetMapping("")
    public String getExplore(Model model, HttpSession httpSession) {
        try {
            log.info("getExplore() function");
            return getExplorePage("all", 1, model, httpSession);
        } catch (Exception e) {
            log.info(e.getMessage());
            return "serverErrorPage";
        }
    }

    @GetMapping("/category/{category}")
    public String getExplorePage(@PathVariable String category,
                                 Model model,
                                 HttpSession httpSession) {
        log.info("getExplorePage() function");
        try {
            return getExplorePage(category, 1, model, httpSession);
        } catch (Exception e) {
            log.info("error encountered");
            log.info("Error Message : " + e.getMessage());
            return "serverErrorPage";
        }
    }

    @GetMapping("/category/{category}/page/{pageNumber}")
    public String getExplorePage(@PathVariable String category,
                                 @PathVariable int pageNumber,
                                 Model model,
                                 HttpSession httpSession) {
        log.info("--getExplorePage() function");
        try {
            if(category.toString().equals("null")){
                return "redirect:/MIS-TALKS/explore/category/all/page/"+pageNumber;
            }
            initializeModel(model, httpSession, category, pageNumber);
            return "explore";
        } catch (Exception e) {
            log.info("error encountered");
            log.info("Error Message : " + e.getMessage());
            return "serverErrorPage";
        }
    }

    private void initializeModel(Model model,
                                 HttpSession httpSession,
                                 String category,
                                 int pageNumber) throws Exception {
        log.info("--initializeModel() function");
        Page<VideoInfo> page = exploreService.getVideosForPage(pageNumber, category, PAGE_SIZE);
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("pageSize", PAGE_SIZE);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("videos_info", page.getContent());
        model.addAttribute(category, "active");
        model.addAttribute("login_status", httpSession.getAttribute("sessionId"));
    }
}
