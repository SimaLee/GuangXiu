package com.simalee.guangxiu.view.quiz;

import com.simalee.guangxiu.base.BasePresenter;
import com.simalee.guangxiu.data.DataManager;
import com.simalee.guangxiu.data.entity.QuizItem;
import com.simalee.guangxiu.data.entity.QuizOptionItem;
import com.simalee.guangxiu.data.model.DataCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee Sima on 2018/5/11.
 */

public class QuizPresenter extends BasePresenter<QuizContract.QuizView> implements QuizContract.IQuizPresenter {

    private static final String TAG = "QuizPresenter";

    @Override
    public void loadQuizList() {

        DataManager.getInstance().getQuizList(new DataCallback<List<QuizItem>>() {
            @Override
            public void onSuccess(List<QuizItem> data) {
                if (isViewAttached()){
                    if (data == null || data.size() == 0){
                        mView.showQuizList(fakeQuizList());
                    }else{
                        mView.showQuizList(data);
                    }
                }
            }

            @Override
            public void onFailure(String msg) {
                if (isViewAttached()){
                    mView.showError();
                }
            }

            @Override
            public void onError() {
                if (isViewAttached()){
                    mView.showError();
                }
            }
        });
    }

    private List<QuizItem> fakeQuizList() {
        List<QuizItem> quizItemList = new ArrayList<>();

        QuizItem item = new QuizItem();
        item.setImage("");
        item.setQuestion("广绣在哪一年被列入第一批国家级非物质文化遗产名录中的？");
        item.setExplanation("2006年5月20日，广绣经中华人民共和国国务院批准列入第一批国家级非物质文化遗产名录。" +
                "广绣是粤绣之一，指广州、佛山、南海、番禺、顺德、东莞、宝安、香山、台山等地的刺绣，也就是以广州为中心的珠江三角洲民间刺绣工艺的总称，相传与黎族织锦同出一源，以构图饱满，形象传神，纹理清晰，色泽富丽，针法多样，善于变化的艺术特色而闻名宇内。包括刺绣字画、刺绣戏服、珠绣等。");
        item.setAnswerId(0);
        item.setSequence(0);
        List<QuizOptionItem> optionItems = new ArrayList<>();
        optionItems.add(new QuizOptionItem(0,"2006年"));
        optionItems.add(new QuizOptionItem(1,"2007年"));
        optionItems.add(new QuizOptionItem(2,"2008年"));
        optionItems.add(new QuizOptionItem(3,"2005年"));
        item.setOptions(optionItems);

        quizItemList.add(item);
        quizItemList.add(item);
        quizItemList.add(item);
        quizItemList.add(item);
        quizItemList.add(item);


        QuizItem item2 = new QuizItem();
        item2.setImage("user");
        item2.setQuestion("这里是问题");
        item2.setExplanation("这里是问题解释");
        item2.setAnswerId(0);
        item2.setSequence(0);
        List<QuizOptionItem> optionItems2 = new ArrayList<>();
        optionItems2.add(new QuizOptionItem(0,"选项A"));
        optionItems2.add(new QuizOptionItem(1,"选项B"));
        optionItems2.add(new QuizOptionItem(2,"选项C"));
        item2.setOptions(optionItems2);
        quizItemList.add(item2);

        return quizItemList;
    }

    @Override
    public void loadPreQuiz() {
        if (isViewAttached()){
            mView.showPreQuiz();
        }
    }

    @Override
    public void loadNextQuiz() {
        if (isViewAttached()){
            mView.showNextQuiz();
        }
    }

    @Override
    public void checkAnswer() {
        if (isViewAttached()){
            mView.showAnswer();
        }
    }
}
