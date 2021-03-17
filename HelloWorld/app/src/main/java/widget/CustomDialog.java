package widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.banshion.helloworld.R;

public class CustomDialog extends Dialog implements View.OnClickListener {

    private TextView  m_TvTitle,m_TvMsg,m_TvCancel, m_TvConfirm;
    private String title,message,confirm, cancel;
    private IOnCancelListener onCancelListener;
    private IOnConfirmListener onConfirmListener;


    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public CustomDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    public CustomDialog setConfirm(String confirm, IOnConfirmListener onConfirmListener) {
        this.confirm = confirm;
        this.onConfirmListener = onConfirmListener;
        return this;
    }

    public CustomDialog setCancel(String cancel, IOnCancelListener onCancelListener) {
        this.cancel = cancel;
        this.onCancelListener = onCancelListener;
        return this;
    }

    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);
        WindowManager windowManager = getWindow().getWindowManager();
        Display defaultDisplay = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        Point size = new Point();
        defaultDisplay.getSize(size);
        attributes.width = (int) (size.x * 0.8);
        getWindow().setAttributes(attributes);


        m_TvTitle = findViewById(R.id.tv_title);
        m_TvMsg = findViewById(R.id.tv_message);
        m_TvCancel = findViewById(R.id.tv_cancel);
        m_TvConfirm = findViewById(R.id.tv_confirm);

        if (!TextUtils.isEmpty(title))
            m_TvTitle.setText(title);

        if (!TextUtils.isEmpty(message))
            m_TvMsg.setText(message);

        if (!TextUtils.isEmpty(confirm))
            m_TvCancel.setText(confirm);

        if (!TextUtils.isEmpty(cancel))
            m_TvCancel.setText(cancel);

        m_TvCancel.setOnClickListener(this);
        m_TvConfirm.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_cancel:
                if (null != onCancelListener) {
                    onCancelListener.onCancel(this);
                }
                dismiss();
                break;
            case R.id.tv_confirm:
                if (null != onConfirmListener) {
                    onConfirmListener.onConfirm(this);
                }
                dismiss();
                break;

        }
    }

    public interface IOnCancelListener {
        void onCancel(CustomDialog dialog);
    }

    public interface IOnConfirmListener {
        void onConfirm(CustomDialog dialog);
    }
}

