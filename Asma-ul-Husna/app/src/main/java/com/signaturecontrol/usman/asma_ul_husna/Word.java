package com.signaturecontrol.usman.asma_ul_husna;

/**
 * Created by Usman on 3/13/2017.
 */
public class Word {
    String englishTranslation;
    String arabic;
    String urduTranslation;
    int audioID;
    int playIcon;



     public Word(String englishTranslation, String urduTranslation) {
        this.englishTranslation = englishTranslation;
        this.urduTranslation = urduTranslation;
    }
    public Word(String englishTranslation, String urduTranslation, String arabic, int audioID) {

        this.englishTranslation = englishTranslation;
        this.urduTranslation = urduTranslation;
        this.arabic = arabic;
        this.audioID = audioID;
    }
    public String getArabic() {
        return arabic;
    }

    public int getAudioID() {
        return audioID;
    }


    public Word(String englishTranslation, String urduTranslation, String arabic) {
        this.englishTranslation = englishTranslation;
        this.urduTranslation = urduTranslation;
        this.arabic = arabic;
    }

    public int getPlayIcon() {

        return playIcon;
    }
 public String getUrduTranslation() {
        return urduTranslation;
    }
 public String getEnglishTranslation() {
        return englishTranslation;
    }
}
