package app.mkv.translate.DataModel;

public class DictionaryModel {

    private int Id, Favorite;
    private String EnglishWord, PersianWord;

    public DictionaryModel(int id, int favorite, String englishWord, String persianWord) {
        Id = id;
        Favorite = favorite;
        EnglishWord = englishWord;
        PersianWord = persianWord;
    }

    public DictionaryModel() {

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getFavorite() {
        return Favorite;
    }

    public void setFavorite(int favorite) {
        Favorite = favorite;
    }

    public String getEnglishWord() {
        return EnglishWord;
    }

    public void setEnglishWord(String englishWord) {
        EnglishWord = englishWord;
    }

    public String getPersianWord() {
        return PersianWord;
    }

    public void setPersianWord(String persianWord) {
        PersianWord = persianWord;
    }
}
