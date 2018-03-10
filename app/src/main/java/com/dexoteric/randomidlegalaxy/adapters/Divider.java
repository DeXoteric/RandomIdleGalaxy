package com.dexoteric.randomidlegalaxy.adapters;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dexoteric.randomidlegalaxy.R;

public class Divider extends RecyclerView.ItemDecoration {

    private Drawable mDivider;
    private int mOrientation;

    public Divider(Context context, int orientation) {
        mDivider = ContextCompat.getDrawable(context, R.drawable.divider);
        if (orientation != LinearLayoutManager.HORIZONTAL){
            throw new IllegalArgumentException("Not HORIZONTAL");
        }
        mOrientation = orientation;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if(mOrientation == LinearLayoutManager.HORIZONTAL){
            drawVerticalDivider(c,parent,state);
        }
    }

    private void drawVerticalDivider(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left, top, right, bottom;
        top = parent.getPaddingTop();
        bottom = parent.getHeight() - parent.getPaddingBottom();
        int count = parent.getChildCount();
        for (int i = 0; i < count; i++) {
            View current = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) current.getLayoutParams();
            left = current.getRight()+ params.rightMargin ;
            right = left + mDivider.getIntrinsicWidth();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);

        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        final int position = parent.getChildAdapterPosition(view);
        final int lastPosition = parent.getAdapter().getItemCount() - 1;
        if (mOrientation == LinearLayoutManager.HORIZONTAL && position < lastPosition) {

            outRect.set (0,0,mDivider.getIntrinsicWidth(),0);
        }
    }
}
