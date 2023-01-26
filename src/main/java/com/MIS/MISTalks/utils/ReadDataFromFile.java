package com.MIS.MISTalks.utils;
import com.MIS.MISTalks.Explore.Model.VideoInfo;
import com.MIS.MISTalks.Explore.Services.ExploreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
@Component
public class ReadDataFromFile {
    private ExploreService exploreService;

    @Autowired
    public ReadDataFromFile(ExploreService exploreService){
        this.exploreService = exploreService;
    }
    public void readDataFromCsvFile(){

        try {
            readData();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void readData() throws Exception{
        Integer id = 1;
        String line;
        String columns[];
        String filePath = "C:\\Users\\Monzer Osman\\Documents\\coding\\java\\SpringBoot\\MIS-Talks\\MIS-Talks\\src\\main\\resources\\ExternalData\\";
        BufferedReader readerHeadline = new BufferedReader(new FileReader(filePath + "ted_talks_data_headline.csv"));
        BufferedReader readerSpeaker = new BufferedReader(new FileReader(filePath + "ted_talks_data_speaker&url.csv"));
        BufferedReader readerDuration = new BufferedReader(new FileReader(filePath + "ted_talks_data_duration&event.csv"));
        BufferedReader readerDescription = new BufferedReader(new FileReader(filePath + "ted_talks_data_description.csv"));
        BufferedReader readerTags = new BufferedReader(new FileReader(filePath + "ted_talks_data_tags.csv"));
        while((line = readerHeadline.readLine()) != null){
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.setId(id);
            videoInfo.setHeadLine(line);
            line = readerSpeaker.readLine();
            columns = line.split(",");
            videoInfo.setSpeaker(columns[0]);
            videoInfo.setUrl(columns[1]);
            line = readerDuration.readLine();
            columns = line.split(",");
            videoInfo.setEvent(columns[0]);
            videoInfo.setDuration(columns[1]);
            line = readerDescription.readLine();
            videoInfo.setDescription(line);
            line = readerTags.readLine();
            videoInfo.setTags(line);
            exploreService.addNewVideo(videoInfo);
            id += 1;
        }
        try {
            readerSpeaker.close();
            readerHeadline.close();
            readerDescription.close();
            readerDuration.close();
            readerTags.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
