package com.pet.travel.util;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.ImageView;

import com.pet.travel.app.App;

/**
 * Created by xinzhendi-031 on 2016/12/23.
 */
public class ObjectAnimUtil {

    public static void alphaAnim(View target, float fromAlpha, float toAlpha) {
        float x = target.getWidth() / 2.0f;
        float y = (float) (target.getHeight());
//        float[] scale = new float[]{0.6F, 1.1f, 1.0f};
        float[] alpha = new float[]{fromAlpha, toAlpha};
        ObjectAnimator[] animators = new ObjectAnimator[]{
//                ObjectAnimator.ofFloat(target, "pivotX", new float[]{x, x, x}),
//                ObjectAnimator.ofFloat(target, "pivotY", new float[]{y, y, y}),
//                ObjectAnimator.ofFloat(target, "scaleX", scale),
//                ObjectAnimator.ofFloat(target, "scaleY", scale),
                ObjectAnimator.ofFloat(target, "alpha", alpha)};
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animators);
        animatorSet.setDuration(800);
        animatorSet.start();
    }

    public static void scaleAnim(View target, boolean isOpen) {
        float x = 0;
        float y = (float) (target.getHeight());
        float[] scale = new float[]{0.0F, 1.1f, 1.0f};
        float[] scaleNomal = new float[]{1.0f, 1.0f, 1.0f};
//        float[] alpha = new float[]{0.2F, 1.0f};
        ObjectAnimator[] animators = new ObjectAnimator[]{
                ObjectAnimator.ofFloat(target, "pivotX", new float[]{x, x, x}),
                ObjectAnimator.ofFloat(target, "pivotY", new float[]{y, y, y}),
                ObjectAnimator.ofFloat(target, "scaleX", isOpen ? scale : scaleNomal),
                ObjectAnimator.ofFloat(target, "scaleY", scaleNomal)};
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animators);
        animatorSet.setDuration(600);
        animatorSet.start();
    }

    public static void translateXAnim(final View target, final boolean isOpen) {
        if (target == null)
            return;
        float x = (float) (target.getWidth());
        float y = (float) (target.getHeight());
        float startPosition = target.getTranslationX();
        float[] _open = new float[]{startPosition, UITools.SCREEN_WIDTH};
        float[] _close = new float[]{startPosition, 0.0f};
        ObjectAnimator[] animators = new ObjectAnimator[]{
                ObjectAnimator.ofFloat(target, "pivotX", new float[]{x, x}),
                ObjectAnimator.ofFloat(target, "pivotY", new float[]{y, y}),
                ObjectAnimator.ofFloat(target, "translationX", isOpen ? _open : _close)};
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                target.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (isOpen) {
                    target.setVisibility(View.GONE);
                }
                target.setTranslationX(0.0f);
                target.setEnabled(true);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animatorSet.playTogether(animators);
        animatorSet.setDuration(300);
        animatorSet.start();
    }

    public static void imageAnim(ImageView target, boolean isOpen) {
        float x = target.getWidth() / 2.0f;
        float y = (float) (target.getHeight() / 2.0f);
        float[] scaleOff = new float[]{1.0F, 1.5f, 2.0f, 2.0f};
        float[] scaleOn = new float[]{2.0f, 2.0f, 1.5f, 1.0F};
        float[] alphaOff = new float[]{1.0F, 1.0f, 1.0f, 0.0f};
        float[] alphaOn = new float[]{0.0f, 0.0f, 1.0f, 1.0f};
        ObjectAnimator[] animators = new ObjectAnimator[]{
                ObjectAnimator.ofFloat(target, "pivotX", new float[]{x, x, x, x}),
                ObjectAnimator.ofFloat(target, "pivotY", new float[]{y, y, y, y}),
                ObjectAnimator.ofFloat(target, "scaleX", isOpen ? scaleOn : scaleOff),
                ObjectAnimator.ofFloat(target, "scaleY", isOpen ? scaleOn : scaleOff),
                ObjectAnimator.ofFloat(target, "alpha", isOpen ? alphaOn : alphaOff)};
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animators);
        animatorSet.setDuration(20000);
        animatorSet.start();
    }

    public static void historyEditAnim(View target1, final View target2, final boolean isOpen) {
        float x = target1.getWidth() / 2.0f;
        float y = target1.getHeight() / 2.0f;
        float distance = UITools.dip2px(App.getInstance(),45);
        float[] _open = new float[]{0.0f, -distance};
        float[] _close = new float[]{-distance, 0.0f};
        float[] alphaOff = new float[]{1.0F, 0.0f};
        float[] alphaOn = new float[]{0.0f, 1.0f};
        ObjectAnimator[] animators = new ObjectAnimator[]{
                ObjectAnimator.ofFloat(target1, "pivotX", new float[]{x, x}),
                ObjectAnimator.ofFloat(target1, "pivotY", new float[]{y, y}),
                ObjectAnimator.ofFloat(target1, "translationX", isOpen ? _open : _close),
                ObjectAnimator.ofFloat(target2, "alpha", isOpen ? alphaOn : alphaOff)};
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                if (isOpen)
                    target2.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (!isOpen)
                    target2.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animatorSet.playTogether(animators);
        animatorSet.setDuration(500);
        animatorSet.start();
    }

    public static void progressAnim(View target, boolean isOpen) {
        float x = 0;
        float y = (float) (target.getHeight());
        float[] scale = new float[]{0.0F, 1.0f};
        float[] scaleNomal = new float[]{1.0f, 1.0f, 1.0f};
//        float[] alpha = new float[]{0.2F, 1.0f};
        ObjectAnimator[] animators = new ObjectAnimator[]{
                ObjectAnimator.ofFloat(target, "progress", new float[]{x, x, x}),
                ObjectAnimator.ofFloat(target, "pivotY", new float[]{y, y, y}),
                ObjectAnimator.ofFloat(target, "scaleX", isOpen ? scale : scaleNomal),
                ObjectAnimator.ofFloat(target, "scaleY", scaleNomal)};
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animators);
        animatorSet.setDuration(600);
        animatorSet.start();
    }
}
