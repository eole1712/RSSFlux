package application.model;

import java.util.List;

public class Feed {
    private String url;
//    private List<FluxElement> fluxElements;

    public Feed() {
    }

    public Feed(String url) {
            this.url = url;
    }

    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
}