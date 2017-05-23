package heping.bwie.com.myview0217demo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;


public class MyView extends ViewGroup {

    public MyView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public MyView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyView(Context context) {
        this(context, null);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d("TAG",widthMeasureSpec+"widthMeasureSpec");
       int width= MeasureSpec.getSize(widthMeasureSpec);
        int height= MeasureSpec.getSize(heightMeasureSpec);
        int widthMode= MeasureSpec.getMode(widthMeasureSpec);
        int heightMode= MeasureSpec.getMode(heightMeasureSpec);
        Log.d("TAG",width+"width");
        int lineWidth=0;
        int lineHeight=0;
        int totalWidth=0;
        int maxHeight=0;
        for(int i=0;i<getChildCount();i++)
        {
           View viewChild= getChildAt(i);
            //测量子view视图
            measureChild(viewChild,widthMeasureSpec,heightMeasureSpec);
            //得到子view布局参数
            MarginLayoutParams layoutParams= (MarginLayoutParams) viewChild.getLayoutParams();
            //子view宽  高
            int childWidth=layoutParams.width+layoutParams.leftMargin+layoutParams.rightMargin;
            int childHeight=layoutParams.height+layoutParams.bottomMargin+layoutParams.topMargin;
            //子view宽相加
            totalWidth+=childWidth;
//            {
                maxHeight=childHeight;
            Log.d("TAG","Height  "+maxHeight);
           // }

        }
       setMeasuredDimension(
      widthMode == MeasureSpec.EXACTLY?width:totalWidth+getPaddingLeft()+getPaddingLeft(),
               heightMode==MeasureSpec.EXACTLY?height:maxHeight+getPaddingTop()+getPaddingBottom()

       );

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
    int left=getPaddingLeft();
        int top=getPaddingTop();
        for(int i=0;i<getChildCount();i++)
        {
            View viewsChild=getChildAt(i);
         //获得子view布局参数
         MarginLayoutParams childParams = (MarginLayoutParams) viewsChild.getLayoutParams();
         int childLe=childParams.leftMargin+left;
         int childTo=childParams.topMargin+top;
            int childRi= childLe + viewsChild.getMeasuredWidth();
            int childBo = childTo + viewsChild.getMeasuredHeight();
            viewsChild.layout(childLe,childTo,childRi,childBo);

        }
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }
}
