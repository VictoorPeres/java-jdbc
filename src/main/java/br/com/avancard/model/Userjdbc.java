package br.com.avancard.model;

public class Userjdbc {
    private long cd_user;
    private String nm_user;
    private String email;

    public long getCd_user() {
        return cd_user;
    }

    public void setCd_user(long cd_user) {
        this.cd_user = cd_user;
    }

    public String getNm_user() {
        return nm_user;
    }

    public void setNm_user(String nm_user) {
        this.nm_user = nm_user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
