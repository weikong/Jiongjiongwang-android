package com.pet.travel.view.dialog.fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pet.travel.R;
import com.pet.travel.bean.PetDatingBean;
import com.pet.travel.util.DisplayUtil;
import com.pet.travel.view.viewpager.RoundHeaderPagerView;


/**
 * Created by xinzhendi-031 on 2017/1/25.
 */
public class DialogPetDatingFragment extends DialogFragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";

    private LinearLayout layout_root_content;
    private RoundHeaderPagerView roundHeaderPagerView;
//    private ImageView dialog_pet_header;
    private TextView dialog_pet_type, dialog_pet_name, dialog_pet_age, dialog_pet_sex, dialog_pet_like,dialog_pet_desc;

    private OnEventListener mOnEventListener;
    private String title, content;
    private PetDatingBean petDatingBean;

    public static DialogPetDatingFragment newInstance(PetDatingBean bean) {
        DialogPetDatingFragment fragment = new DialogPetDatingFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM3, bean);
        fragment.setArguments(args);
        return fragment;
    }

    public static DialogPetDatingFragment newInstance(String title, String content) {
        DialogPetDatingFragment fragment = new DialogPetDatingFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, title);
        args.putSerializable(ARG_PARAM2, content);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        //设置动画
        params.windowAnimations = R.style.NearbyDialogFragment;
        window.setAttributes(params);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_PARAM1);
            content = getArguments().getString(ARG_PARAM2);
            petDatingBean = (PetDatingBean) getArguments().getSerializable(ARG_PARAM3);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.dialog_pet_dating, container, false);
        layout_root_content = (LinearLayout)view.findViewById(R.id.layout_root_content);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) layout_root_content.getLayoutParams();
        params.width = DisplayUtil.screenWidth - DisplayUtil.dp2px(40);
        roundHeaderPagerView = (RoundHeaderPagerView)view.findViewById(R.id.dialog_pet_header);
//        dialog_pet_header = (ImageView)view.findViewById(R.id.dialog_pet_header);
        dialog_pet_type = (TextView) view.findViewById(R.id.dialog_pet_type);
        dialog_pet_name = (TextView) view.findViewById(R.id.dialog_pet_name);
        dialog_pet_age = (TextView) view.findViewById(R.id.dialog_pet_age);
        dialog_pet_sex = (TextView) view.findViewById(R.id.dialog_pet_sex);
        dialog_pet_like = (TextView) view.findViewById(R.id.dialog_pet_like);
        dialog_pet_desc = (TextView) view.findViewById(R.id.dialog_pet_desc);
        if (petDatingBean != null){
            roundHeaderPagerView.loadData(petDatingBean);
            dialog_pet_type.setText(petDatingBean.getType());
            dialog_pet_name.setText(petDatingBean.getName());
            dialog_pet_age.setText(petDatingBean.getAge()+"岁");
            if (!TextUtils.isEmpty(petDatingBean.getSex()) && "2".equals(petDatingBean.getSex()))
                dialog_pet_sex.setText("公主");
            else
                dialog_pet_sex.setText("太子");
            dialog_pet_desc.setText(petDatingBean.getDescription());
        }
        return view;
    }

    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    public interface OnEventListener {

        /**
         * @param sure Are you sure
         */
        void result(boolean sure);
    }
}
