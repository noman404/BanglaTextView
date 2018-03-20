package com.al.tobangla.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

import com.al.tobangla.R;
import com.al.tobangla.processor.ToBN;
import com.al.tobangla.utils.ProcessType;

import static com.al.tobangla.utils.ProcessType.DEFAULT;
import static com.al.tobangla.utils.ProcessType.NUMBER;
import static com.al.tobangla.utils.ProcessType.ORDINAL_INDICATOR_FOR_DATE;
import static com.al.tobangla.utils.ProcessType.ORDINAL_INDICATOR_FOR_NUMERIC_ORDER;

/**
 * Created by Noman on 24/1/2018.
 */

public class BNTextView extends AppCompatTextView {

    private ProcessType processType;
    private final ToBN toBN = ToBN.getInstance();
    private final String WHITE_SPACE = " ";
    private final String PATTERN_MISSING_EXCEPTION = "Required Text Pattern Missing";

    public void setProcessType(ProcessType processType) {
        this.processType = processType;
    }

    public ProcessType getProcessType() {
        return processType;
    }

    public BNTextView(Context context) {
        super(context, null, 0);
    }

    public BNTextView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);

        init(context, attrs);
    }

    public BNTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context, attrs);
    }

    private void init(Context context,
                      @Nullable AttributeSet attrs) {

        if (attrs != null) {

            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BNTextView);

            int processTypeAttr = typedArray.getInt(R.styleable.BNTextView_processType, 0);

            ProcessType processTypes[] = ProcessType.values();

            for (ProcessType pt : processTypes) {
                if (pt.getValue() == processTypeAttr) {
                    processType = pt;
                    break;
                }
            }

            setProcessType(processType);

            typedArray.recycle();
        }

        setText(getText().toString());
    }


    public void setText(String text) {

        switch (getProcessType() == null ? DEFAULT : getProcessType()) {

            case DATE:
                super.setText(toBN.getDate(text));
                return;

            case NUMBER:
                super.setText(toBN.getNumber(text));
                return;

            case TIME:
                super.setText(toBN.getNumber(text));
                return;

            case AMOUNT:
                String tk = "৳" + WHITE_SPACE;
                super.setText(tk + toBN.getNumber(text));
                return;

            case ORDINAL_INDICATOR_FOR_DATE:
                try {
                    String date = getOrdinalDate(text);
                    super.setText(date);

                } catch (Exception e) {
                    super.setText(PATTERN_MISSING_EXCEPTION + e.getMessage());
                }
                return;

            case ORDINAL_INDICATOR_FOR_NUMERIC_ORDER:
                super.setText(toBN.getOrdinalIndicator(text, ORDINAL_INDICATOR_FOR_NUMERIC_ORDER));
                return;

            case ORDINAL_INDICATOR_TODAY:
                super.setText(toBN.getTodayDate());
                return;

            case TODAY:
                super.setText(toBN.getToday());
                return;

            case TIME_NOW:
                super.setText(toBN.getCurrentTime());
                return;

            case NOW_DATE_TIME:
                super.setText(toBN.getTodayDate() + WHITE_SPACE + toBN.getCurrentTime());
                return;

            default:
                super.setText(text);

        }
    }

    @NonNull
    private String getOrdinalDate(String text) {
        String[] dates = new String[3];//YYYY-/.MM-/.DD

        if (text.contains("-")) {
            dates = text.split("-");
        } else if (text.contains("/")) {
            dates = text.split("/");
        } else if (text.contains(".")) {
            dates = text.split(".");
        }
        return (toBN.getOrdinalIndicator(dates[2], ORDINAL_INDICATOR_FOR_DATE) + " " + toBN.getMonthByNumber(dates[1]) + ", " + toBN.getNumber(dates[0]));
    }


}
