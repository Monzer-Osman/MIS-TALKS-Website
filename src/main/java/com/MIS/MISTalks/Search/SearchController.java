package com.MIS.MISTalks.Search;

import com.MIS.MISTalks.Explore.Model.VideoInfo;
import com.MIS.MISTalks.Explore.Services.ExploreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/MIS-TALKS")
@SessionAttributes("{sessionId}")
public class SearchController {
    private final int PAGE_SIZE = 18;
    private Logger log = LoggerFactory.getLogger(SearchController.class);
    private ExploreService exploreService;

    @Autowired
    public SearchController(ExploreService exploreService){
        this.exploreService = exploreService;
    }

    @GetMapping("/search")
    public String searchVideos(@PathParam("headLine") String headLine, Model model, HttpSession httpSession){
        log.info("--searchVideos() url(/MIS-TALKS/search)");
        return searchVideos(headLine,1, model, httpSession);
    }

    @GetMapping("/search/page/{pageNumber}")
    public String searchVideos(@PathParam("headLine") String headLine,
                               @PathVariable int pageNumber,
                               Model model,
                               HttpSession httpSession){
        log.info("--searchVideos() url(/MIS-TALKS/search/page/{pageNumber})");
        try {
            addModelAttributes(model, httpSession, headLine, pageNumber);
            return "searchResult";
        }  catch (Exception e){
            log.info("Error encountered");
            log.info("Error Message : " + e.getMessage());
            return "ServerErrorPage";
        }
    }

    private void addModelAttributes(Model model, HttpSession httpSession, String headLine, Integer pageNumber) throws Exception{
        log.info("--addModelAttributes() function");
        Page<VideoInfo> page = exploreService.getVideosSimilarTo(headLine, pageNumber, PAGE_SIZE);
        log.info("head line : " + headLine);
        log.info("total pages founded: " + page.getTotalPages());
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("pageSize", PAGE_SIZE);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("videos_info", page.getContent());
        model.addAttribute("search_value", headLine);
        model.addAttribute("login_status", httpSession.getAttribute("sessionId"));
    }
}
