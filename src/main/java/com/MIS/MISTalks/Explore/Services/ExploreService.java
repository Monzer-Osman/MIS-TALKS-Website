package com.MIS.MISTalks.Explore.Services;

import com.MIS.MISTalks.Explore.Model.VideoInfo;
import com.MIS.MISTalks.Explore.Repositories.VideoInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ExploreService {
    private final Logger LOG = LoggerFactory.getLogger(ExploreService.class);
    private final VideoInfoRepository videoInfoRepository;

    @Autowired
    public ExploreService(VideoInfoRepository videoInfoRepository) {
        this.videoInfoRepository = videoInfoRepository;
    }

    public void addNewVideo(VideoInfo videoInfo) {
        videoInfoRepository.save(videoInfo);
    }


    public Page<VideoInfo> getVideosForPage(Integer pageNumber, String category, Integer pageSize) throws Exception {
        LOG.info("--getVideosForPage() function");
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        if ("all".equals(category)) {
            return videoInfoRepository.findAll(pageable);
        } else {
            return videoInfoRepository.findAllByName(category, pageable);
        }
    }

    public Page<VideoInfo> getVideosSimilarTo(String headTitle, Integer pageNumber, Integer pageSize) throws Exception {
        LOG.info("--getVideosSimilarTo() function");
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return videoInfoRepository.findAllByName(headTitle.toLowerCase(), pageable);
    }

}
