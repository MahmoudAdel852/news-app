package pojo;

import java.util.List;

public class MyModel {
    public MyModel(String status, int totalResults, List<pojo.articles> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    String status;
    int totalResults;
    List<articles> articles;
    public String getStatus() {
        return status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public List<pojo.articles> getArticles() {
        return articles;
    }
}

