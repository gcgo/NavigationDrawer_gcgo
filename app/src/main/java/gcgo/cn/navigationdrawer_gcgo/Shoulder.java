package gcgo.cn.navigationdrawer_gcgo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2015/7/18 0018.
 */
public class Shoulder extends Fragment {


    public static Shoulder newInstance() {

        return new Shoulder();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.shoulder_main, container, false);


        return rootView;
    }
}