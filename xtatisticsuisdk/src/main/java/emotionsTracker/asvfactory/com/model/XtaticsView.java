package emotionsTracker.asvfactory.com.model;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import emotionsTracker.asvfactory.com.R;

/**
 * Created by nubor on 15/11/2016.
 */
public class XtaticsView extends LinearLayout {
    TextView mTxtHappy, mTxtSurprise, mTxtSad, mTxtDisgust;
    ProgressBar mPbHappy, mPbSurprise, mPbSad, mPbDisgust;
    Handler mHandler = new Handler();

    private void init() {

        LayoutInflater li =
                (LayoutInflater) getContext()
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        li.inflate(R.layout.xtatics_view, this, true);

        mTxtHappy = (TextView) findViewById(R.id.txtHappy);
        mTxtSurprise = (TextView) findViewById(R.id.txtSurprise);
        mTxtSad = (TextView) findViewById(R.id.txtSad);
        mTxtDisgust = (TextView) findViewById(R.id.txtDisgust);

        mPbHappy = (ProgressBar) findViewById(R.id.pbHappy);
        mPbSurprise = (ProgressBar) findViewById(R.id.pbSurprise);
        mPbSad = (ProgressBar) findViewById(R.id.pbSad);
        mPbDisgust = (ProgressBar) findViewById(R.id.pbDisgust);
    }

    public XtaticsView(Context context) {
        super(context);
        init();
    }

    public XtaticsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public XtaticsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    public void updateXtatics(EmotionTrackModel model) {
        final int[] happySurSadDisgustCount = calculatePerEmotions(model);
        //progreso va ser el procentaje de la emcion en el traking
        // final  int total = model.getEmotionTrackModelList().size();

        //todo el total tb puede ser la sumatori ode happySurSadDisgustCount, xq hay muchos track sin emocion

        final int total = happySurSadDisgustCount[0] + happySurSadDisgustCount[1] + happySurSadDisgustCount[2] + happySurSadDisgustCount[3];
        //fixme esto de las progress bar no tira, no actualizan el valor


        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mPbHappy.setMax(total);
                mPbSurprise.setMax(total);
                mPbSad.setMax(total);
                mPbDisgust.setMax(total);

                mPbHappy.setProgress(happySurSadDisgustCount[0]);
                mPbSurprise.setProgress(happySurSadDisgustCount[1]);
                mPbSad.setProgress(happySurSadDisgustCount[2]);
                mPbDisgust.setProgress(happySurSadDisgustCount[3]);

                System.out.println("Happy" + happySurSadDisgustCount[0] + " de " + total);
                System.out.println("Surprise" + happySurSadDisgustCount[1] + " de " + total);
                System.out.println("Sad" + happySurSadDisgustCount[2] + " de " + total);
                System.out.println("Disgust" + happySurSadDisgustCount[3] + " de " + total);
                /***********************
                 mTxtHappy.setText("Happy" + happySurSadDisgustCount[0]);
                 mTxtSurprise.setText("Surprise" + happySurSadDisgustCount[1]);
                 mTxtSad.setText("Sad" + happySurSadDisgustCount[2]);
                 mTxtDisgust.setText("Disgust" + happySurSadDisgustCount[3]);*/
            }
        });

    }

    public void updateXtatics() {
        EmotionTrackModel model = AppXtatics.mEmotionTrackModel;
        updateXtatics(model);
    }

    private int[] calculatePerEmotions(EmotionTrackModel model) {
        EmotionTrackItemModel item;
        //si no tienes una de esas emociones no cuenta
        int[] happySurSadDisgustCount = new int[4];
        for (int i = 0; i < model.getEmotionTrackModelList().size() - 1; i++) {
            item = model.getEmotionTrackModelList().get(i);
            if (item.getIsSmilingProbability() > 0.55f)
                happySurSadDisgustCount[0] += 1;
            if (item.getIsSmilingProbability() < 0.20f && item.getIsSmilingProbability() > 0.01f)
                happySurSadDisgustCount[2] += 1;
            if (item.getIsLeftEyeOpenProbability() > 0.98 && item.getIsRightEyeOpenProbability() > 0.98)//surprised
                happySurSadDisgustCount[1] += 1;
            if (item.getIsLeftEyeOpenProbability() < 0.55 && item.getIsRightEyeOpenProbability() < 0.55)
                happySurSadDisgustCount[3] += 1;
        }
        return happySurSadDisgustCount;
    }

    public void showXtaticsFromEventID(int eventId) {
        EmotionTrackModel model = AppXtatics.mEmotionTrackModel;
        List<EmotionTrackItemModel> emotionTracksItemsFromEvent =
                XtatisticManager.getEmotionTracksItemsFromEvent(model.getEmotionTrackModelList(), eventId);
        EmotionTrackModel eventIdModel = new EmotionTrackModel();
        eventIdModel.setEmotionTrackModelList((ArrayList) emotionTracksItemsFromEvent);

        System.out.println("Event id: "+eventId);
        updateXtatics(eventIdModel);

    }
}
