package com.qqq.workout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    private WorkoutDetailFragment mWorkoutDetailFragment;
    private int mWorkoutId;

    // Константа определяет имя доп. информации, передавамой в интенте,
    // чтобы гаранитровано использовать одну и ту же строку.
    public static final String EXTRA_WORKOUT_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mWorkoutDetailFragment = (WorkoutDetailFragment) getFragmentManager().findFragmentById(R.id.detail_frag);
        mWorkoutId = getIntent().getExtras().getInt(EXTRA_WORKOUT_ID);
        mWorkoutDetailFragment.setWorkout(mWorkoutId);
    }
}
