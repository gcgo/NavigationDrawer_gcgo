package gcgo.cn.navigationdrawer_gcgo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2015/7/18
 */
public class Back extends Fragment {


    public static Back newInstance() {

        return new Back();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.back_main, container, false);


        return rootView;
    }
}