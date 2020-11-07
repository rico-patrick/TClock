package com.rico.tclock.ui.tclock;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rico.tclock.R;

public class CountDownTimer extends Fragment {
    private TextView value;
    private Button button;
    EditText input;
    long Val;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.count_down_timer, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        value = view.findViewById(R.id.timer);
        button = view.findViewById(R.id.button);
        input = view.findViewById(R.id.input);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String inputValue = input.getText().toString();
                Val = Long.parseLong(inputValue)*1000;
                Timer(Val);
                Toast.makeText(getActivity(), "Timer Started" , Toast.LENGTH_SHORT).show();

            }

            public void Timer(long inVal) {
                new android.os.CountDownTimer(inVal, 1000) {
                    @Override
                    public void onTick(long millis) {
                        value.setText("" + millis / 1000);
                    }

                    @Override
                    public void onFinish() {
                        value.setText("TimesUp");
                        Toast.makeText(getActivity(), "Finished", Toast.LENGTH_SHORT).show();
                    }
                }.start();
            }
        });
    }
}
