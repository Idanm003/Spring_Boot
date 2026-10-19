package ecom.firstProject.responses.show;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TvMazeResponse {
    private Integer id;

    @JsonProperty("url")
    private String imageUrl;
    private String name;

    public TvMazeResponse(Integer id, String imageUrl, String name) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }
    public String getImageUrl() {
        return this.imageUrl;
    }
    public String getName() {
        return this.name;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public void setName(String name) {
        this.name = name;
    }
}
