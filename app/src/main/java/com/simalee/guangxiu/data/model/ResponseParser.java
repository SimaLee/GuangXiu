package com.simalee.guangxiu.data.model;

import com.simalee.guangxiu.data.entity.ArtFeature;
import com.simalee.guangxiu.data.entity.PergolaIntroduction;
import com.simalee.guangxiu.data.entity.SimpleIntroduction;
import com.simalee.guangxiu.data.entity.TextImageItem;
import com.simalee.guangxiu.data.entity.Version;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee Sima on 2018/5/8.
 */

public class ResponseParser {

    private ResponseParser(){

    }

    /**
     * @param jsonObject
     * @return
     * @throws JSONException
     */
    public static Version parseVersion(JSONObject jsonObject) throws JSONException{
        int versionCode = jsonObject.getInt("data");
        return new Version(versionCode);
    }

    public static SimpleIntroduction parseSimpleIntroduction(JSONObject jsonObject) throws JSONException{
        String backgroundUrl = jsonObject.getString("background");
        String desc = jsonObject.getString("desc");
        return new SimpleIntroduction(desc,backgroundUrl);
    }
    /**
     * @param jsonObject
     * @return
     * @throws JSONException
     */
    public static ArtFeature parseArtFeature(JSONObject jsonObject) throws JSONException{
        ArtFeature artFeature = new ArtFeature();
        artFeature.setItemList(parseItemList(jsonObject));
        return artFeature;
    }


    public static PergolaIntroduction parsePergolaIntroduction(JSONObject jsonObject) throws JSONException{
        PergolaIntroduction pergolaIntroduction = new PergolaIntroduction();
        pergolaIntroduction.setItemList(parseItemList(jsonObject));
        return pergolaIntroduction;
    }


    private static List<TextImageItem> parseItemList(JSONObject jsonObject) throws JSONException{

        int len = jsonObject.getInt("len");
        JSONArray jsonArray = jsonObject.getJSONArray("item");
        List<TextImageItem> textImageItemList = new ArrayList<>(len);
        TextImageItem textImageItem;
        JSONObject item;
        for (int i = 0; i < len; i++){

            item = jsonArray.getJSONObject(i);

            textImageItem = new TextImageItem();
            textImageItem.setId(item.getString("id"));
            textImageItem.setSequence(item.getInt("seq"));
            textImageItem.setType(item.getInt("type"));
            textImageItem.setText(item.getString("text"));
            textImageItem.setImageurl(item.getString("image"));
            textImageItem.setHeight(item.getInt("height"));
            textImageItem.setWidth(item.getInt("width"));

            textImageItemList.add(textImageItem);
        }
        return textImageItemList;
    }
}
