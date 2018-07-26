package in.co.chicmic.dialogpracticeapp.interfaces;

import java.util.List;

public interface MultipleChoiceDialogClickListener {
    void onCanceled();
    void onPositiveButtonClick(List<Integer> mItemsList);
}
