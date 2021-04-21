package Enuns;

public enum SourceEnum {
    YOUTUBE("youtube"), TWITTER("twitter"), FACEBOOK("facebook");

    public String source;
    SourceEnum(String sourceOption){
        source = sourceOption;
    }
}
