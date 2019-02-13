package com.wings.toasterlibrary;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ToasterMessage {

    /**
     * Colors
     */
    public static final int TYPE_ERROR = 0xffff0000; //red
    public static final int TYPE_NOTICE = 0xffffff33; //yellow
    public static final int TYPE_SUCCESS = 0xff66cc33; //green

    /**
     * Lengths
     */
    public static final int LENGTH_LONG = Toast.LENGTH_LONG;
    public static final int LENGTH_SHORT = Toast.LENGTH_SHORT;

    /**
     * Coordinates
     */
    private int mXOffset = 10;
    private int mYOffset = 10;

    /**
     * Gravities
     */
    public static final int GRAVITY_TOP_LEFT = Gravity.TOP | Gravity.LEFT;
    public static final int GRAVITY_TOP_RIGHT = Gravity.TOP | Gravity.RIGHT;
    public static final int GRAVITY_TOP_CENTER = Gravity.TOP | Gravity.CENTER;

    public static final int GRAVITY_BOTTOM_LEFT = Gravity.BOTTOM | Gravity.LEFT;
    public static final int GRAVITY_BOTTOM_RIGHT = Gravity.BOTTOM | Gravity.RIGHT;
    public static final int GRAVITY_BOTTOM_CENTER = Gravity.BOTTOM | Gravity.CENTER;

    public static final int GRAVITY_CENTER_LEFT = Gravity.CENTER | Gravity.LEFT;
    public static final int GRAVITY_CENTER_RIGHT = Gravity.CENTER | Gravity.RIGHT;
    public static final int GRAVITY_CENTER_CENTER = Gravity.CENTER | Gravity.CENTER;

    private int mGravity = GRAVITY_TOP_LEFT;


    /**
     * Commons
     */
    private Toast mToast;
    private Activity mActivity;
    private Context mContext;

    /**
     * Constructor
     *
     * @param activity Activity
     */
    public ToasterMessage(Activity activity) {
        this.mActivity = activity;
        mContext = mActivity.getApplicationContext();
    }

    /**
     * Show simple toast
     *
     * @param message       CharSequence
     * @param messageLength int
     */
    public void showToast(CharSequence message, int messageLength) {
        Toast.makeText(mContext, message, messageLength).show();
    }

    /**
     * @param message        CharSequence
     * @param messageLength  int
     * @param messageBgColor int
     * @param imageDrawable  Drawable
     */
    public void showCustomToast(CharSequence message, int messageLength, int messageBgColor, Drawable imageDrawable) {
        LayoutInflater inflater = mActivity.getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast, (ViewGroup) mActivity.findViewById(R.id.toast_layout_root));
        layout.setBackgroundColor(messageBgColor);

        TextView tvToast = layout.findViewById(R.id.text_toast);
        tvToast.setText(message);

        ImageView ivToast = layout.findViewById(R.id.image_toast);
        ivToast.setImageDrawable(imageDrawable);

        mToast = new Toast(mContext);
        mToast.setGravity(mGravity, mXOffset, mYOffset);
        mToast.setDuration(messageLength);
        mToast.setView(layout);
        mToast.show();
    }


    /**
     * @param message        CharSequence
     * @param messageLength  int
     * @param messageBgColor int
     * @param imageDrawable  Drawable
     * @param toastGravity   int
     */
    public void showCustomToast(CharSequence message, int messageLength, int messageBgColor, Drawable imageDrawable, int toastGravity) {
        LayoutInflater inflater = mActivity.getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast, (ViewGroup) mActivity.findViewById(R.id.toast_layout_root));
        layout.setBackgroundColor(messageBgColor);

        TextView text = layout.findViewById(R.id.text_toast);
        text.setText(message);

        ImageView ivToast = layout.findViewById(R.id.image_toast);
        ivToast.setImageDrawable(imageDrawable);

        mToast = new Toast(mContext);
        mToast.setGravity(toastGravity, mXOffset, mYOffset);
        mToast.setDuration(messageLength);
        mToast.setView(layout);
        mToast.show();
    }

    /**
     * Setter for X coordinate
     *
     * @param mXOffset int
     */
    public void setXOffset(int mXOffset) {
        this.mXOffset = mXOffset;
    }

    /**
     * Setter for Y coordinate
     *
     * @param mYOffset int
     */
    public void setYOffset(int mYOffset) {
        this.mYOffset = mYOffset;
    }

    /**
     * Setter for gravity parameter
     *
     * @param mGravity int
     */
    public void setGravity(int mGravity) {
        this.mGravity = mGravity;
    }
}
