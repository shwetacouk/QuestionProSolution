package com.questionPro.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BestStoryResponse {
    private String id;
    private String title;
    private String url;
    private int score;
    private String time;
    private String by;

    @Override
    public String toString() {
        return "BestStoryResponse{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", score=" + score +
                ", time='" + time + '\'' +
                ", user='" + by + '\'' +
                '}';
    }
}
