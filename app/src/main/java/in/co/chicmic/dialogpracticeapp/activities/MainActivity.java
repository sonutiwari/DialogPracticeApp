package in.co.chicmic.dialogpracticeapp.activities;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import in.co.chicmic.dialogpracticeapp.R;
import in.co.chicmic.dialogpracticeapp.dialogs.CustomLayoutDialog;
import in.co.chicmic.dialogpracticeapp.dialogs.PickDateDialog;
import in.co.chicmic.dialogpracticeapp.dialogs.PickTimeDialog;
import in.co.chicmic.dialogpracticeapp.dialogs.SimpleDialog;
import in.co.chicmic.dialogpracticeapp.dialogs.MultipleChoiceDialog;
import in.co.chicmic.dialogpracticeapp.dialogs.SingleChoiceDialog;
import in.co.chicmic.dialogpracticeapp.interfaces.MultipleChoiceDialogClickListener;
import in.co.chicmic.dialogpracticeapp.utilities.AppConstants;

public class MainActivity extends AppCompatActivity implements MultipleChoiceDialogClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button simpleDialogButton = findViewById(R.id.simple_dialog);
        simpleDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSimpleDialog();
            }
        });

        Button multipleChoiceDialogButton = findViewById(R.id.multiple_choice_dialog);
        multipleChoiceDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMultipleChoiceDialog();
            }
        });

        Button singleChoiceDialogButton = findViewById(R.id.single_choice_dialog);
        singleChoiceDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSingleChoiceDialog();
            }
        });

        Button customDialogButton = findViewById(R.id.custom_dialog);
        customDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog();
            }
        });

        Button datePickerDialogButton = findViewById(R.id.date_picker_dialog);
        datePickerDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });

        Button timePickerDialogButton = findViewById(R.id.time_picker_dialog);
        timePickerDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog();
            }
        });
    }

    private void showTimePickerDialog() {
        DialogFragment dialogFragment = new PickTimeDialog();
        dialogFragment.show(getSupportFragmentManager(), AppConstants.TIME_PICKER);
    }

    private void showDatePickerDialog() {
        DialogFragment newFragment = new PickDateDialog();
        newFragment.show(getSupportFragmentManager(), AppConstants.DATE_PICKER);
    }

    private void showCustomDialog() {
        CustomLayoutDialog dialog = new CustomLayoutDialog();
        dialog.show(getSupportFragmentManager(), AppConstants.CUSTOM_DIALOG);
    }

    private void showSingleChoiceDialog() {
        SingleChoiceDialog dialog = new SingleChoiceDialog();
        dialog.show(getSupportFragmentManager(), AppConstants.SINGLE_CHOICE_DIALOG);
    }

    private void showMultipleChoiceDialog() {
        MultipleChoiceDialog dialog = new MultipleChoiceDialog();
        dialog.show(getSupportFragmentManager(), AppConstants.MULTIPLE_CHOICE_DIALOG);
    }

    private void showSimpleDialog() {
        SimpleDialog simpleDialog = new SimpleDialog();
        simpleDialog.show(getSupportFragmentManager(), AppConstants.SIMPLE_DIALOG_FRAGMENT_TAG);
    }

    @Override
    public void onCanceled() {
        Toast.makeText(this
                , getResources().getString(R.string.cancel), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPositiveButtonClick(List<Integer> mItemsList) {
        Toast.makeText(this
                , mItemsList.get(0).toString(), Toast.LENGTH_SHORT).show();
    }
}
