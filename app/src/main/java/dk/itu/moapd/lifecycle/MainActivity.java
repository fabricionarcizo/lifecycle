package dk.itu.moapd.lifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private CheckBox mCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.text_view);

        Button trueButton = findViewById(R.id.true_button);
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText(R.string.true_text);
            }
        });

        Button falseButton = findViewById(R.id.false_button);
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText(R.string.false_text);
            }
        });

        mCheckBox = findViewById(R.id.check_box);
        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String status = isChecked ? "checked" : "unchecked";
                mTextView.setText(String.format("You %s the checkbox", status));
            }
        });

        if (savedInstanceState != null) {
            boolean status = savedInstanceState.getBoolean(CHECK, false);
            mCheckBox.setChecked(status);

            String state = savedInstanceState.getString(STATE, "");
            mTextView.setText(state);
        }
    }

    private static final String STATE = "state";
    private static final String CHECK = "check";

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        String state = mTextView.getText().toString();
        outState.putString(STATE, state);

        boolean status = mCheckBox.isChecked();
        outState.putBoolean(CHECK, status);

        super.onSaveInstanceState(outState);
    }
}
