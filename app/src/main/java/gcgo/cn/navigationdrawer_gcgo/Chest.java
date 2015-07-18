package gcgo.cn.navigationdrawer_gcgo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2015/7/18
 */
public class Chest extends Fragment implements GestureDetector.OnGestureListener {

    private GestureDetector detector = new GestureDetector(getActivity(), this);
    private needOpenListener needOpenListener;

    public static Chest newInstance() {

        return new Chest();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.chest_main, container, false);
//在该Fragment的构造函数中注册mTouchListener的回调
        ((MainActivity) this.getActivity()).registerMyTouchListener(nTouchListener);

        return rootView;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }


    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        float x = e2.getX() - e1.getX();
        Log.e("X的值为", "need_x=" + x);
        int verticalMinDistance = 300;
        int minVelocity = 0;
        needOpenListener.needOpenOrNot(x > verticalMinDistance && Math.abs(velocityX) > minVelocity);

        return false;
    }

    public interface needOpenListener {
        void needOpenOrNot(boolean drawerOpen);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            needOpenListener = (needOpenListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " 必须实现该接口方法");
        }

    }

    private MainActivity.MyTouchListener nTouchListener = new MainActivity.MyTouchListener() {
        @Override
        public void onTouchEvent(MotionEvent event) {
            // TODO Auto-generated method stub
            detector.onTouchEvent(event);
        }
    };
}
