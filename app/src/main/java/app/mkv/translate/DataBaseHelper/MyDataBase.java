package app.mkv.translate.DataBaseHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

import app.mkv.translate.DataModel.DictionaryModel;

public class MyDataBase extends SQLiteAssetHelper {

    private static final String DB_NAME = "data.sqlite";
    private static final int DB_VERSION = 1;

    public MyDataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }

    public List<DictionaryModel> getAllData(){

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder sqLiteQueryBuilder = new SQLiteQueryBuilder();

        String[] sql_select = {"Id", "Favorite", "EnglishWord", "PersianWord"} ;
        String TABLE_NAME = "EnglishPersianWordDatabase" ;

        sqLiteQueryBuilder.setTables(TABLE_NAME);
        Cursor cursor = sqLiteQueryBuilder.query(db, sql_select, null, null, null, null, null);
        List<DictionaryModel> result = new ArrayList<>();

        if (cursor.moveToFirst()){
            do {

                DictionaryModel model = new DictionaryModel();
                model.setId(cursor.getInt(cursor.getColumnIndexOrThrow("Id")));
                model.setFavorite(cursor.getInt(cursor.getColumnIndexOrThrow("Favorite")));
                model.setPersianWord(cursor.getString(cursor.getColumnIndexOrThrow("PersianWord")));
                model.setEnglishWord(cursor.getString(cursor.getColumnIndexOrThrow("EnglishWord")));

                result.add(model);

            } while (cursor.moveToNext());

        }
        return result;
    }


}
