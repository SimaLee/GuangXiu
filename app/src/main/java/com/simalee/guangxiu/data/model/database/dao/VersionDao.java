package com.simalee.guangxiu.data.model.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.simalee.guangxiu.data.entity.Version;
import com.simalee.guangxiu.data.model.database.DBConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee Sima on 2018/5/14.
 */

public class VersionDao extends BaseDao<VersionPair> {


    private static final String TAG = "VersionDao";

    private static final int FIRST_PAIR_INDEX = 0;

    public static final String[] nameArray = {
               "ver_origin",//起源版本号
               "ver_meaning",//寓意版本号
               "ver_phase",//发展过程版本号
               "ver_development",//未来发展版本号
               "ver_art",//艺术特点版本号
               "ver_embroidery",//绣种版本号
               "ver_stitch",//针法版本号
               "ver_thread",//线版本号
               "ver_pergola",//花架版本号
               "ver_desc",//(logo)广绣介绍版本号
               "ver_master",//名家版本号
               "ver_masterdesc",//名家简介版本号
               "ver_masterwork",//名家作品版本号
               "ver_video",//视频教学版本号
               "ver_answer",//答题闯关版本号
               "ver_needle",//针的版本号(与针法不同)
    };
    //对应的index
    public static final int INDEX_VER_ORIGIN = 0;
    public static final int INDEX_VER_MEANING = 1;
    public static final int INDEX_VER_PHASE= 2;
    public static final int INDEX_VER_DEVELOPMENT = 3;
    public static final int INDEX_VER_ART = 4;
    public static final int INDEX_VER_EMBROIDERY_ = 5;
    public static final int INDEX_VER_STITCH = 6;
    public static final int INDEX_VER_THREAD = 7;
    public static final int INDEX_VER_PERGOLA = 8;
    public static final int INDEX_VER_DESC = 9;
    public static final int INDEX_VER_MASTER = 10;
    public static final int INDEX_VER_MASTER_DESC = 11;
    public static final int INDEX_VER_MASTER_WORK = 12;
    public static final int INDEX_VER_VIDEO = 13;
    public static final int INDEX_VER_ANSWER = 14;
    public static final int INDEX_VER_NEEDLE = 15;


    public VersionDao(Context context) {
        super(context);
    }

    /**
     * 将获取的新version数据保存到数据库里
     * 当且仅当第一次安装成功之后 第一次请求版本信息时被调用
     * @param version
     */
    public void initVersion(Version version){

        List<VersionPair> pairList = getVersionPairList(version);

        int size = pairList.size();
        ContentValues contentValues = new ContentValues();
        VersionPair versionPair;

        for (int i = 0; i < size; i++) {

            versionPair = pairList.get(i);

            contentValues.put(DBConstants.TableVersion.COLUMN_NAME,versionPair.getName());
            contentValues.put(DBConstants.TableVersion.COLUMN_OLD_VERSION,versionPair.getOldVersion());
            contentValues.put(DBConstants.TableVersion.COLUMN_NEW_VERSION,versionPair.getNewVersion());

            insert(DBConstants.TableVersion.TABLE_NAME,null,contentValues);
        }

    }

    /**
     * 保存从服务器获取的newVersion
     * @param newVersion
     */
    public void saveNewVersion(Version newVersion){
        List<VersionPair> pairList = getVersionPairList(newVersion);

        int size = pairList.size();
        ContentValues contentValues = new ContentValues();
        VersionPair versionPair;

        //更新获得的资料版本号
        for (int i = 0; i < size; i++) {
            versionPair = pairList.get(i);

            String whereClause = "name=?";
            String[] whereArgs = {versionPair.getName()};
            contentValues.put(DBConstants.TableVersion.COLUMN_NEW_VERSION,versionPair.getNewVersion());

            update(DBConstants.TableVersion.TABLE_NAME,contentValues,whereClause,whereArgs);
        }
    }

    /**
     * 获取指定位置的version pair
     * @param index
     * @return
     */
    public VersionPair getVersionPairAt(int index){
        if (index < 0 || index >= nameArray.length){
            throw  new IllegalArgumentException("version index out of bound: " + index);
        }

        String selection = "name=?";
        String[] selectionArgs = {nameArray[index]};

        List<VersionPair> versionPairList = query(DBConstants.TableVersion.TABLE_NAME,null,
                selection,selectionArgs,null,null,null,null);
        if (versionPairList != null && versionPairList.size() > 0){
            return versionPairList.get(FIRST_PAIR_INDEX);
        }

        return null;
    }

    /**
     * 前提：当前数据库中已经获取更新后的版本数据
     *
     * 更新指定index的数据的版本号,需要将
     * 指定index位置的oldVersion 更新为newVersion的值
     * @param index
     * @return -1 插入失败 or 插入的行坐标
     */
    public int updateVersion(int index){
        VersionPair targetPair = getVersionPairAt(index);
        int ret = -1;
        if (targetPair != null){

            ContentValues contentValues = new ContentValues();
            contentValues.put(DBConstants.TableVersion.COLUMN_OLD_VERSION,targetPair.getNewVersion());

            String whereClause = "name=?";
            String[] whereArgs = {nameArray[index]};

           ret =  update(DBConstants.TableVersion.TABLE_NAME,contentValues,whereClause,whereArgs);
        }
        return ret;
    }




    @Override
    List<VersionPair> queryResult(Cursor cursor) {

        List<VersionPair> versionPairList = new ArrayList<>();
        VersionPair pair;
        while(cursor.moveToNext()){

            pair = new VersionPair();
            pair.setName(cursor.getString(cursor.getColumnIndex(DBConstants.TableVersion.COLUMN_NAME)));
            pair.setOldVersion(cursor.getInt(cursor.getColumnIndex(DBConstants.TableVersion.COLUMN_OLD_VERSION)));
            pair.setNewVersion(cursor.getInt(cursor.getColumnIndex(DBConstants.TableVersion.COLUMN_NEW_VERSION)));

            versionPairList.add(pair);
        }
        return versionPairList;
    }

    /**
     * 解析versionpair
     * @param version
     * @return
     */
    private List<VersionPair> getVersionPairList(Version version){
        List<VersionPair> versionPairs = new ArrayList<>();
        int size = nameArray.length;
        VersionPair pair;
        for (int i = 0; i < size; i++) {
            pair = getVersionPairWithIndex(version,i);
            versionPairs.add(pair);
        }
        return versionPairs;
    }

    /**
     * 设置version pair
     * @param version
     * @param i
     * @return
     */
    private VersionPair getVersionPairWithIndex(Version version, int i) {

        VersionPair pair = new VersionPair();

        switch (i){

            case INDEX_VER_ORIGIN:
                pair.setName(nameArray[INDEX_VER_ORIGIN]);
                pair.setOldVersion(-1);
                pair.setNewVersion(version.getVer_origin());
                break;

            case INDEX_VER_MEANING:
                pair.setName(nameArray[INDEX_VER_MEANING]);
                pair.setOldVersion(-1);
                pair.setNewVersion(version.getVer_meaning());
                break;

            case INDEX_VER_PHASE:
                pair.setName(nameArray[INDEX_VER_PHASE]);
                pair.setOldVersion(-1);
                pair.setNewVersion(version.getVer_phase());
                break;

            case INDEX_VER_DEVELOPMENT:
                pair.setName(nameArray[INDEX_VER_DEVELOPMENT]);
                pair.setOldVersion(-1);
                pair.setNewVersion(version.getVer_development());
                break;

            case INDEX_VER_ART:
                pair.setName(nameArray[INDEX_VER_ART]);
                pair.setOldVersion(-1);
                pair.setNewVersion(version.getVer_art());
                break;

            case INDEX_VER_EMBROIDERY_:
                pair.setName(nameArray[INDEX_VER_EMBROIDERY_]);
                pair.setOldVersion(-1);
                pair.setNewVersion(version.getVer_embroidery());
                break;

            case INDEX_VER_STITCH:
                pair.setName(nameArray[INDEX_VER_STITCH]);
                pair.setOldVersion(-1);
                pair.setNewVersion(version.getVer_stitch());
                break;

            case INDEX_VER_THREAD:
                pair.setName(nameArray[INDEX_VER_THREAD]);
                pair.setOldVersion(-1);
                pair.setNewVersion(version.getVer_thread());
                break;

            case INDEX_VER_PERGOLA:
                pair.setName(nameArray[INDEX_VER_PERGOLA]);
                pair.setOldVersion(-1);
                pair.setNewVersion(version.getVer_pergola());
                break;

            case INDEX_VER_DESC:
                pair.setName(nameArray[INDEX_VER_DESC]);
                pair.setOldVersion(-1);
                pair.setNewVersion(version.getVer_desc());
                break;

            case INDEX_VER_MASTER:
                pair.setName(nameArray[INDEX_VER_MASTER]);
                pair.setOldVersion(-1);
                pair.setNewVersion(version.getVer_master());
                break;

            case INDEX_VER_MASTER_DESC:
                pair.setName(nameArray[INDEX_VER_MASTER_DESC]);
                pair.setOldVersion(-1);
                pair.setNewVersion(version.getVer_masterdesc());
                break;

            case INDEX_VER_MASTER_WORK:
                pair.setName(nameArray[INDEX_VER_MASTER_WORK]);
                pair.setOldVersion(-1);
                pair.setNewVersion(version.getVer_masterwork());
                break;

            case INDEX_VER_VIDEO:
                pair.setName(nameArray[INDEX_VER_VIDEO]);
                pair.setOldVersion(-1);
                pair.setNewVersion(version.getVer_video());
                break;

            case INDEX_VER_ANSWER:
                pair.setName(nameArray[INDEX_VER_ANSWER]);
                pair.setOldVersion(-1);
                pair.setNewVersion(version.getVer_answer());
                break;

            case INDEX_VER_NEEDLE:
                pair.setName(nameArray[INDEX_VER_NEEDLE]);
                pair.setOldVersion(-1);
                pair.setNewVersion(version.getVer_needle());
                break;
            default:
                break;

        }
        return pair;
    }

}
