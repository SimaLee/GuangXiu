package com.simalee.guangxiu.data.model.database;

/**
 * Created by Lee Sima on 2018/5/14.
 */

public interface DBConstants {

    String DATABASE_NAME = "guangxiu.db";
    int DATABASE_VERSION = 1;

    String SEPERATOR = ",";

    //版本信息表
    interface TableVersion {

        String TABLE_NAME = "version";
        String COLUMN_ID = "id";
        String COLUMN_NAME = "name";
        String COLUMN_OLD_VERSION = "oldVersion";
        String COLUMN_NEW_VERSION = "newVersion";
        String COLUMN_DESCRIPTION = "description";

        //版本号
        String SQL_CREATE_TABLE =
                "create table if not exists " +TABLE_NAME +
                        "("
                        +COLUMN_ID + " integer primary key autoincrement" + SEPERATOR
                        +COLUMN_NAME + " text NOT NULL"+ SEPERATOR
                        +COLUMN_OLD_VERSION + " integer NOT NULL "+ SEPERATOR
                        +COLUMN_NEW_VERSION + " integer NOT NULL "+ SEPERATOR
                        +COLUMN_DESCRIPTION + " text"
                        +")";

        String SQL_DROP_TABLE = "drop table " + TABLE_NAME;

    }

    /**
     * 广绣简要介绍
     */
    interface TableIntroduction{

        String TABLE_NAME = "simpleIntroduction";
        String COLUMN_ID = "id";
        String COLUMN_VERSION = "version";
        String COLUMN_DESCRIPTION = "desc";
        String COLUMN_BACKGROUND = "backgroundUrl";

        String SQL_CREATE_TABLE =
                "create table if not exists " +TABLE_NAME +
                        "("
                        +COLUMN_ID + " integer primary key autoincrement" + SEPERATOR
                        +COLUMN_VERSION + " integer UNIQUE NOT NULL"+ SEPERATOR
                        +COLUMN_DESCRIPTION + " text " + SEPERATOR
                        +COLUMN_BACKGROUND + " text "
                        +")";

        String SQL_DROP_TABLE = "drop table " + TABLE_NAME;

    }

    interface TabeleArtFeature{

        String TABLE_NAME = "artFeature";

        String COLUMN_DB_ID = "_id";
        String COLUMN_VERSION = "version";//版本号
        String COLUMN_REAL_ID = "id";
        String COLUMN_SEQUENCE = "sequence";
        String COLUMN_TYPE = "type";//0 为图片 1为文字
        String COLUMN_TEXT = "text";
        String COLUMN_IMAGE = "imageUrl";//图片url
        String COLUMN_IMAGE_WIDTH  = "width";
        String COLUMN_IMAGE_HEIGHT = "height";


        String SQL_CREATE_TABLE =
                "create table if not exists " +TABLE_NAME +
                        "("
                        +COLUMN_DB_ID + " integer primary key autoincrement" + SEPERATOR
                        +COLUMN_VERSION + " integer NOT NULL"+ SEPERATOR
                        +COLUMN_REAL_ID + " text NOT NULL" + SEPERATOR
                        +COLUMN_SEQUENCE + " integer NOT NULL" + SEPERATOR
                        +COLUMN_TYPE + " integer DEFAULT 1" + SEPERATOR
                        +COLUMN_TEXT + " text " + SEPERATOR
                        +COLUMN_IMAGE + " text " + SEPERATOR
                        +COLUMN_IMAGE_WIDTH + " integer " + SEPERATOR
                        +COLUMN_IMAGE_HEIGHT + " integer "
                        +")";

        String SQL_DROP_TABLE = "drop table " + TABLE_NAME;

    }





}
