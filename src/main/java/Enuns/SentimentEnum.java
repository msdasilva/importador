package Enuns;

public enum SentimentEnum {
    ONE(0), TWO(1), THREE(2), FOUR(3), FIVE(5);

    private Integer sentiment;
    SentimentEnum(Integer sentimentLevel){
        sentiment = sentimentLevel;
    }
}
