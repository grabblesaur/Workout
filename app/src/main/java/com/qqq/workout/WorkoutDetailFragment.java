package com.qqq.workout;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WorkoutDetailFragment extends Fragment{
    // Идентификатор комплекса упражнений выбранного пользователем
    private long workoutId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (savedInstanceState != null) {
            workoutId = savedInstanceState.getLong(getString(R.string.workoudId_key));
        }
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    // Метод для присваивания идентификатора. Метод исп-ся активностью для передачи значения идентификатора фрагменту
    public void setWorkout(long id) {
        workoutId = id;
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            TextView titleText = (TextView) view.findViewById(R.id.textTitle);
            TextView textDescription = (TextView) view.findViewById(R.id.textDescription);
            Workout currentWorkout = Workout.workouts[(int) workoutId];

            titleText.setText(currentWorkout.getName());
            textDescription.setText(currentWorkout.getDescription());
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putLong(getString(R.string.workoudId_key), workoutId);
    }
}
