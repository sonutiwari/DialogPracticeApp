package in.co.chicmic.dialogpracticeapp.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import java.util.ArrayList;
import java.util.List;

import in.co.chicmic.dialogpracticeapp.R;

public class SingleChoiceDialog extends DialogFragment {

    // Global objects.
    private List<Integer> mItemsList;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        mItemsList = new ArrayList<>();
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(R.string.multiple_choice_title)
                .setSingleChoiceItems(R.array.choices, -1
                        , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (mItemsList.contains(i)) {
                            // if the item is already in the array, remove it
                            mItemsList.remove(Integer.valueOf(i));
                        } else {
                            mItemsList.add(i);
                        }
                    }
                }).setPositiveButton(R.string.done, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dismiss();
            }
        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }
}
