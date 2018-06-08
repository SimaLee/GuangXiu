package com.simalee.guangxiu.data.model.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.simalee.guangxiu.data.entity.ArtFeature;
import com.simalee.guangxiu.data.entity.TextImageItem;
import com.simalee.guangxiu.data.model.database.DBConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee Sima on 2018/5/19.
 */

public class ArtFeatureDao extends BaseDao<TextImageItem> {


    private static final String TAG = "ArtFeatureDao";


    public ArtFeatureDao(Context context) {
        super(context);
    }

    /**
     * 保存艺术特点 保存失败则返回false
     * @param version
     * @param artFeature
     * @return
     */
    public boolean saveArtFeature(int version,ArtFeature artFeature){
        Log.d(TAG, "saveArtFeature: " + artFeature);

        if (artFeature == null){
            return false;
        }
        ContentValues contentValues;
        List<TextImageItem> textImageItems = artFeature.getItemList();

        boolean allFinished = true;

        for (TextImageItem item: textImageItems){

            contentValues = new ContentValues();

            contentValues.put(DBConstants.TabeleArtFeature.COLUMN_VERSION,version);
            contentValues.put(DBConstants.TabeleArtFeature.COLUMN_REAL_ID,item.getId());
            contentValues.put(DBConstants.TabeleArtFeature.COLUMN_SEQUENCE,item.getSequence());
            contentValues.put(DBConstants.TabeleArtFeature.COLUMN_TYPE,item.getType());
            contentValues.put(DBConstants.TabeleArtFeature.COLUMN_TEXT,item.getText());
            contentValues.put(DBConstants.TabeleArtFeature.COLUMN_IMAGE,item.getImageurl());
            contentValues.put(DBConstants.TabeleArtFeature.COLUMN_IMAGE_WIDTH,item.getWidth());
            contentValues.put(DBConstants.TabeleArtFeature.COLUMN_IMAGE_HEIGHT,item.getHeight());

            long ret = insertWithOnConflict(DBConstants.TabeleArtFeature.TABLE_NAME,null,
                    contentValues, SQLiteDatabase.CONFLICT_REPLACE);

            if (ret == -1){
                allFinished = false;
            }
        }

        return allFinished;
    }


    /**
     * 获取指定版本号的广绣艺术特点 无对应版本的数据则返回 null
     * @param version
     * @return
     */
    public ArtFeature getArtFeature(int version){

        Log.d(TAG, "getArtFeature: version: " + version);

        String selection = DBConstants.TabeleArtFeature.COLUMN_VERSION + "=?";
        String[] selectionArgs = {
                String.valueOf(version)
        };

        //按照序号升序查询
        String orderBy = DBConstants.TabeleArtFeature.COLUMN_SEQUENCE + " asc";

        List<TextImageItem> itemList = query(DBConstants.TabeleArtFeature.TABLE_NAME,null,
                selection,selectionArgs,null,null,orderBy,null);

        if (itemList != null && itemList.size() > 0 ){
            return new ArtFeature(itemList);
        }

        return null;
    }

    @Override
    List<TextImageItem> queryResult(Cursor cursor) {

        List<TextImageItem> result = new ArrayList<>();
        TextImageItem tempItem;

        while (cursor.moveToNext()){

            tempItem = new TextImageItem();

            tempItem.setId(cursor.getString(cursor.getColumnIndex(DBConstants.TabeleArtFeature.COLUMN_REAL_ID)));
            tempItem.setSequence(cursor.getInt(cursor.getColumnIndex(DBConstants.TabeleArtFeature.COLUMN_SEQUENCE)));
            tempItem.setType(cursor.getInt(cursor.getColumnIndex(DBConstants.TabeleArtFeature.COLUMN_TYPE)));
            tempItem.setText(cursor.getString(cursor.getColumnIndex(DBConstants.TabeleArtFeature.COLUMN_TEXT)));
            tempItem.setImageurl(cursor.getString(cursor.getColumnIndex(DBConstants.TabeleArtFeature.COLUMN_IMAGE)));
            tempItem.setWidth(cursor.getInt(cursor.getColumnIndex(DBConstants.TabeleArtFeature.COLUMN_IMAGE_WIDTH)));
            tempItem.setHeight(cursor.getInt(cursor.getColumnIndex(DBConstants.TabeleArtFeature.COLUMN_IMAGE_HEIGHT)));

            result.add(tempItem);
        }

        return result;
    }
}
