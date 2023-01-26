package com.MIS.MISTalks.Explore.Model;
import javax.persistence.*;

@Table(name="videos")
@Entity
public class VideoInfo {
//    @SequenceGenerator(
//            name = "id_generator",
//            initialValue = 1,
//            allocationSize = 1)
    @Id()
    @Column(name = "video_id")
    Integer id;
    String speaker;
    @Column(columnDefinition = "varchar(400)")
    String headLine;
    @Column(columnDefinition = "text")
    String description;
    String duration;
    String url;
    String event;
    @Column(columnDefinition = "text")
    String tags;

    public VideoInfo(){}
    public VideoInfo(String speaker, String headLine, String url, String description, String event, String duration) {
        this.headLine = headLine;
        this.speaker = speaker;
        this.description = description;
        this.duration = duration;
        this.url = url;
        this.event = event;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeadLine() {
        return headLine;
    }

    public void setHeadLine(String headLine) {
        this.headLine = headLine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", speaker='" + speaker + '\'' +
                ", headLine='" + headLine + '\'' +
                ", description='" + description + '\'' +
                ", duration='" + duration + '\'' +
                ", url='" + url + '\'' +
                ", event='" + event + '\'' +
                ", tags=" + tags +
                '}';
    }
}
