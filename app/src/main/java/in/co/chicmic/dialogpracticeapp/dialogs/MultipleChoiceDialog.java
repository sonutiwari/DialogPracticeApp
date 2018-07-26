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
import in.co.chicmic.dialogpracticeapp.interfaces.MultipleChoiceDialogClickListener;

public class MultipleChoiceDialog extends DialogFragment {

    // Global objects.
    private List<Integer> mItemsList;
    private MultipleChoiceDialogClickListener mListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        mItemsList = new ArrayList<>();
        mListener = (MultipleChoiceDialogClickListener) getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(R.string.multiple_choice_title)
                .setMultiChoiceItems(R.array.choices, null
                        , new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                if (b) {
                    // If the user checked the item, add it to the selected items
                    mItemsList.add(i);
                } else if (mItemsList.contains(i)) {
                    // Else, if the item is already in the array, remove it
                    mItemsList.remove(Integer.valueOf(i));
                }
            }
        }).setPositiveButton(R.string.done, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mListener.onPositiveButtonClick(mItemsList);
                dismiss();
            }
        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mListener.onCanceled();
                dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }
}

