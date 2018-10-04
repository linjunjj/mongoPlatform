package com.linjun.entity;

import java.io.Serializable;

/**
 * @author 林俊
 * @create 2018/10/4.
 * @desc
 **/
public class TopicVo implements Serializable {
    private static final long serialVersionUID = 1L;
    //主键
    private Long id;
    //广告位置Id
    private Integer topic_position_id;
    //形式
    private Integer media_type;
    //广告名称
    private String name;
    //链接
    private String link;
    //图片
    private String image_url;
    //内容
    private String content;
    //结束时间
    private Integer end_time;
    //状态
    private Integer enabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer gettopic_position_id() {
        return topic_position_id;
    }

    public void settopic_position_id(Integer topic_position_id) {
        this.topic_position_id = topic_position_id;
    }

    public Integer getMedia_type() {
        return media_type;
    }

    public void setMedia_type(Integer media_type) {
        this.media_type = media_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Integer end_time) {
        this.end_time = end_time;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }
}
