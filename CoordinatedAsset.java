public interface CoordinatedAsset {
    void setStatus(StMediator m);
    void statusChange();
    String getSecret();
    void setSecret(String secret);
    String getName();
    StMediator getMediator();
}
