package gcgo.cn.navigationdrawer_gcgo;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MotionEvent;

import java.util.ArrayList;

import br.liveo.Model.HelpLiveo;
import br.liveo.interfaces.OnItemClickListener;
import br.liveo.interfaces.OnPrepareOptionsMenuLiveo;
import br.liveo.navigationliveo.NavigationLiveo;


public class MainActivity extends NavigationLiveo implements OnItemClickListener
        , Chest.needOpenListener {
    private HelpLiveo mHelpLiveo;

    @Override
    public void onInt(Bundle savedInstanceState) {



        // Creating items navigation
        mHelpLiveo = new HelpLiveo();
        mHelpLiveo.add(getString(R.string.chest), R.drawable.chest);
        mHelpLiveo.add(getString(R.string.shoulder), R.drawable.shoulder);
        mHelpLiveo.add(getString(R.string.back), R.drawable.back);
        mHelpLiveo.add(getString(R.string.leg), R.drawable.leg);


        with(this).startingPosition(0) //Starting position in the list
                .addAllHelpItem(mHelpLiveo.getHelp())

                        //{optional} - List Customization "If you remove these methods and the list will take his white standard color"
                        //.selectorCheck(R.drawable.selector_check) //Inform the background of the selected item color
                        //.colorItemDefault(R.color.nliveo_blue_colorPrimary) //Inform the standard color name, icon and counter
                        //.colorItemSelected(R.color.nliveo_purple_colorPrimary) //State the name of the color, icon and meter when it is selected
                        //.backgroundList(R.color.nliveo_black_light) //Inform the list of background color
                        //.colorLineSeparator(R.color.nliveo_transparent) //Inform the color of the subheader line

                        //{optional} - SubHeader Customization
                .colorItemSelected(R.color.nliveo_blue_colorPrimary)
                .colorNameSubHeader(R.color.nliveo_blue_colorPrimary)
                        //.colorLineSeparator(R.color.nliveo_blue_colorPrimary)


                        //{optional} - Footer Customization
                        //.footerNameColor(R.color.nliveo_blue_colorPrimary)
                        //.footerIconColor(R.color.nliveo_blue_colorPrimary)
                        //.footerBackground(R.color.nliveo_white)

                .setOnPrepareOptionsMenu(onPrepare)
                .build();



    }


    private OnPrepareOptionsMenuLiveo onPrepare = new OnPrepareOptionsMenuLiveo() {
        @Override
        public void onPrepareOptionsMenu(Menu menu, int position, boolean visible) {

        }
    };



    @Override
    public void onItemClick(int position) {


        FragmentManager fragmentManager = getSupportFragmentManager();

          if (position == 0) {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, Chest.newInstance())
                    .commit();
        } else if (position == 1) {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, Shoulder.newInstance())
                    .commit();
        } else if (position == 2) {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, Back.newInstance())
                    .commit();
        } else if (position == 3) {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, Leg.newInstance())
                    .commit();



        }
    }







//实现任意位置侧滑：

    /**
     * 回调接口
     */
    public interface MyTouchListener {
        void onTouchEvent(MotionEvent event);
    }

    /*
     * 保存MyTouchListener接口的列表
     */
    private ArrayList<MyTouchListener> myTouchListeners = new ArrayList<>();

    /**
     * 提供给Fragment通过getActivity()方法来注册自己的触摸事件的方法
     *
     * @param listener
     */
    public void registerMyTouchListener(MyTouchListener listener) {
        myTouchListeners.add(listener);
    }

    /**
     * 提供给Fragment通过getActivity()方法来取消注册自己的触摸事件的方法
     *
     * @param listener
     */
    public void unRegisterMyTouchListener(MyTouchListener listener) {
        myTouchListeners.remove(listener);
    }

    /**
     * 分发触摸事件给所有注册了MyTouchListener的接口
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        // TODO Auto-generated method stub
        for (MyTouchListener listener : myTouchListeners) {
            listener.onTouchEvent(ev);
        }
        return super.dispatchTouchEvent(ev);
    }

//通过实现needOpenOrNot接口来接收滑动方向，判断侧边栏的开关
    @Override
    public void needOpenOrNot(boolean drawerOpen) {
        if (drawerOpen) {
            openDrawer();

        } else {
            closeDrawer();
        }
    }



}