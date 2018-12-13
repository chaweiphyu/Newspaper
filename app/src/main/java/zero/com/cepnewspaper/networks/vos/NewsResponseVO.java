package zero.com.cepnewspaper.networks.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsResponseVO {

    @SerializedName("status")
    private String status;

    @SerializedName("totalResults")
    private Long totalResults;

    @SerializedName("articles")
    private List<ArticlesResponseVO> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Long totalResults) {
        this.totalResults = totalResults;
    }

    public List<ArticlesResponseVO> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticlesResponseVO> articles) {
        this.articles = articles;
    }
}
