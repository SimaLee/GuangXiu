package com.simalee.guangxiu.data.model.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.simalee.guangxiu.data.entity.SimpleIntroduction;
import com.simalee.guangxiu.data.model.database.DBConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee Sima on 2018/5/18.
 */

public class SimpleIntroductionDao extends BaseDao<SimpleIntroduction> {

    private static final String TAG = "SimpleIntroductionDao";


    public SimpleIntroductionDao(Context context) {
        super(context);
    }

    /**
     * 保存广绣简要介绍
     * 使用replace 可以在插入unique约束的字段时 如果不存在，则更新，否则插
     * @param version     版本号需要传递进来
     * @param introduction
     * @return 是否插入成功
     */
    public boolean saveSimpleIntroduction(int version, SimpleIntroduction introduction){

        ContentValues contentValues = new ContentValues();
        contentValues.put(DBConstants.TableIntroduction.COLUMN_VERSION,version);
        contentValues.put(DBConstants.TableIntroduction.COLUMN_DESCRIPTION,introduction.getDescription());
        contentValues.put(DBConstants.TableIntroduction.COLUMN_BACKGROUND,introduction.getBackgroundImg());

        long ret = insertWithOnConflict(DBConstants.TableIntroduction.TABLE_NAME,null,contentValues, SQLiteDatabase.CONFLICT_REPLACE);

        if (ret == -1){
            return false;
        }
        return true;
    }

    /**
     * 更新指定的描述
     * @param version
     * @param introduction
     */
    public void updateSimpleIntroduction(int version, SimpleIntroduction introduction) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(DBConstants.TableIntroduction.COLUMN_DESCRIPTION,introduction.getDescription());
        contentValues.put(DBConstants.TableIntroduction.COLUMN_BACKGROUND,introduction.getBackgroundImg());

        String whereClause =  DBConstants.TableIntroduction.COLUMN_VERSION + "=?";
        String[] whereArgs = {String.valueOf(version)};

        update(DBConstants.TableIntroduction.TABLE_NAME,contentValues,whereClause,whereArgs);
    }

    /**
     * 获取指定版本号的广绣简介
     * @param version
     * @return
     */
    public SimpleIntroduction getSimpleIntroduction(int version){

        String selection = DBConstants.TableIntroduction.COLUMN_VERSION + "=?";
        String[] selectionArgs = {
                String.valueOf(version)
        };
        List<SimpleIntroduction> results = query(DBConstants.TableIntroduction.TABLE_NAME,null,selection,selectionArgs,null,null,null,null);

        if (results != null && results.size() >0){
            return results.get(0);
        }

        return null;
    }


    @Override
    List<SimpleIntroduction> queryResult(Cursor cursor) {

        List<SimpleIntroduction> result = new ArrayList<>();
        SimpleIntroduction introduction;
        while(cursor.moveToNext()){
            introduction = new SimpleIntroduction();

            introduction.setDescription(cursor.getString(cursor.getColumnIndex(DBConstants.TableIntroduction.COLUMN_DESCRIPTION)));
            introduction.setBackgroundImg(cursor.getString(cursor.getColumnIndex(DBConstants.TableIntroduction.COLUMN_BACKGROUND)));

            result.add(introduction);
        }

        return result;
    }
}
