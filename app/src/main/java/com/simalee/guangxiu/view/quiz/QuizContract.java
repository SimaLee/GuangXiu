package com.simalee.guangxiu.view.quiz;

import com.simalee.guangxiu.base.BaseView;
import com.simalee.guangxiu.data.entity.QuizItem;

import java.util.List;

/**
 * Created by Lee Sima on 2018/5/11.
 */

public interface QuizContract {

    interface QuizView extends BaseView{
        void showQuizList(List<QuizItem> quizItemList);
        void showPreQuiz();
        void showNextQuiz();
        void showAnswer();
    }

    interface IQuizPresenter {
        void loadQuizList();
        void loadPreQuiz();
        void loadNextQuiz();
        void checkAnswer();
    }
}
