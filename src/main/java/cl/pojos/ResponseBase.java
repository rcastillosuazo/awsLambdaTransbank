package cl.pojos;

public class ResponseBase {

    private String code;
    private String glosa;
    private String urlToken;
    private String token;

    public String getUrlToken() {
        return urlToken;
    }

    public void setUrlToken(String urlToken) {
        this.urlToken = urlToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    @Override
    public String toString() {
        return "ResponseBase{" +
                "code='" + code + '\'' +
                ", glosa='" + glosa + '\'' +
                ", urlToken='" + urlToken + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
