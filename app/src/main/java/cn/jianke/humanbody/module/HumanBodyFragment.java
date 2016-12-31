package cn.jianke.humanbody.module;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import cn.jianke.humanbody.R;

/**
 * @className: HumanBodyFragment
 * @classDescription: 人体图用于症状自诊模块（重构）
 * @author: leibing
 * @createTime: 2016/10/07
 */
public class HumanBodyFragment extends Fragment implements OnClickListener,OnTouchListener{
	// 性别面向
	public final static String CURRNT_SEX_FACE = "curSexFace";
	// 当前性别以及面向
	private int curSexFace;
	// 男正面
	// 男正面右手臂
	private ImageView manFrontArmRightIv;
	// 男正面头部
	private ImageView manFrontHeadIv;
	// 男正面颈部
	private ImageView manFrontNeckIv;
	// 男正面胸部
	private ImageView manFrontChestIv;
	// 男正面腹部
	private ImageView manFrontStomachIv;
	// 男正面左手臂
	private ImageView manFrontArmLeftIv;
	// 男正面右手
	private ImageView manFrontHandRightIv;
	// 男正面男性股沟
	private ImageView manFrontThighIv;
	// 男正面左手
	private ImageView manFrontHandLeftIv;
	// 男正面双腿
	private ImageView manFrontLegs;
	// 男正面双脚
	private ImageView manFrontFoots;

	// 男反面
	// 男反面左手臂
	private ImageView manBackArmLeftIv;
	// 男反面头部
	private ImageView manBackHeadIv;
	// 男反面颈部
	private ImageView manBackNeckIv;
	// 男反面背部
	private ImageView manBackBacksideIv;
	// 男反面腰部
	private ImageView manBackWaistIv;
	// 男反面右手臂
	private ImageView manBackArmRightIv;
	// 男反面左手
	private ImageView manBackHandLeftIv;
	// 男反面臀部
	private ImageView manBackHipIv;
	// 男反面右手
	private ImageView manBackHandRightIv;
	// 男反面双腿
	private ImageView manBackLegsIv;
	// 男反面双脚
	private ImageView manBackFootsIv;

	// 女正面
	// 女正面头部
	private ImageView womenFrontHeadIv;
	// 女正面颈部
	private ImageView womenFrontNeckIv;
	// 女正面右上手臂
	private ImageView womenFrontArmRightUpIv;
	// 女正面胸部
	private ImageView womenFrontChestIv;
	// 女正面腹部（上）
	private ImageView womenFrontStomachUpIv;
	// 女正面左上手臂
	private ImageView womenFrontArmLeftUpIv;
	// 女正面右中手臂
	private ImageView womenFrontArmRightMiddleIv;
	// 女正面腹部（中）
	private ImageView womenFrontStomachMiddleIv;
	// 女正面左中手臂
	private ImageView womenFrontArmLeftMiddleIv;
	// 女正面右下手臂
	private ImageView womenFrontArmRightDownIv;
	// 女正面腹部（下）
	private ImageView womenFrontStomachDownIv;
	// 女正面左下手臂
	private ImageView womenFrontArmLeftDownIv;
	// 女正面右手
	private ImageView womenFrontHandRightIv;
	// 女正面女性盆骨
	private ImageView womenFrontPelvisIv;
	// 女正面双腿
	private ImageView womenFrontLegsIv;
	// 女正面双脚
	private ImageView womenFrontFootsIv;
	// 女正面左手
	private ImageView womenFrontHandLeftIv;

	// 女反面
	// 女反面头部
	private ImageView womenBackHeadIv;
	// 女反面颈部
	private ImageView womenBackNeckIv;
	// 女反面左上手臂
	private ImageView womenBackArmLeftUpIv;
	// 女反面背部（上）
	private ImageView womenBackBacksideUpIv;
	// 女反面背部（下）
	private ImageView womenBackBacksideDownIv;
	// 女反面右上手臂
	private ImageView womenBackArmRightUpIv;
	// 女反面左中手臂
	private ImageView womenBackArmLeftMiddleIv;
	// 女反面腰部（上）
	private ImageView womenBackWaistUpIv;
	// 女反面右中手臂
	private ImageView womenBackArmRightMiddleIv;
	// 女反面左下手臂
	private ImageView womenBackArmLeftDownIv;
	// 女反面腰部（下）
	private ImageView womenBackWaistDownIv;
	// 女反面右下手臂
	private ImageView womenBackArmRightDownIv;
	// 女反面左手
	private ImageView womenBackHandLeftIv;
	// 女反面臀部
	private ImageView womenBackHipIv;
	// 女反面双腿
	private ImageView womenBackLegsIv;
	// 女反面双脚
	private ImageView womenBackFootsIv;
	// 女反面右手
	private ImageView womenBackHandRightIv;
	// 控件被点击的坐标
	float[] touchIVPos = new float[2];
	// 部位id
	// 1：头部；2：颈部；3：胸部；4：腹部；5：男性勾股；6：女性盆骨；7：上肢；8：下肢；
	// 9：下肢（本应足部，但数据没分出来）；10：背部；11：腰部；12：臀部；
	// 13：上肢（本应手指，但数据没分出来）
	private int partId = 1;

	/**
	 * 可以在创建时传参数的fragment
	 * @author leibing
	 * @createTime 2016/10/07
	 * @lastModify 2016/10/07
	 * @param curSexFace 当前性别和面向
	 * @return
	 */
	public static HumanBodyFragment newInstance(int curSexFace) {
		HumanBodyFragment f = new HumanBodyFragment();
		Bundle args = new Bundle();
		args.putInt(CURRNT_SEX_FACE, curSexFace);
		f.setArguments(args);
		return f;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
			View view = null;
			// 获取当前性别和面向，默认为男性正面
			curSexFace = getArguments().getInt(CURRNT_SEX_FACE, HumanBodyActivity.MAN_FRONT);
			switch (curSexFace) {
			case HumanBodyActivity.WOMEN_FRONT:
				// 女性正面
				view = inflater.inflate(R.layout.women_front_new, null);
				break;
			case HumanBodyActivity.WOMEN_BACK:
				// 女性反面
				view = inflater.inflate(R.layout.women_back_new, null);
				break;
			case HumanBodyActivity.MAN_FRONT:
				// 男性正面
				view = inflater.inflate(R.layout.man_front_new, null);
				break;
			case HumanBodyActivity.MAN_BACK:
				// 男性反面
				view = inflater.inflate(R.layout.man_back_new, null);
				break;
			default:
				break;
			}
			// 初始化View
			initView(view);

			return view;
	}

	/**
	 * 初始化view
	 * @author leibing
	 * @createTime 2016/10/07
	 * @lastModify 2016/10/07
	 * @param view
	 * @return
	 */
	private void initView(View view) {
		switch (curSexFace) {
		case 1:
			// 初始化女性正面view
			initWomenFront(view);
			// 设置女性正面点击监听
			setWomenFrontOnClickListener();
			// 设置女性正面触摸监听
			setWomenFrontOnTouchListener();
			break;
		case 2:
			// 初始化女性反面view
			initWomenBack(view);
			// 设置女性反面点击监听
			setWomenBackOnClickListener();
			// 设置女性反面触摸监听
			setWomenBackOnTouchListener();
			break;
		case 3:
			// 初始化男性正面view
			initManFront(view);
			// 设置男性正面点击监听
			setManFrontOnClickListener();
			// 设置男性正面触摸监听
			setManFrontOnTouchListener();
			break;
		case 4:
			// 初始化男性反面view
			initManBack(view);
			// 设置男性反面点击监听
			setManBackOnClickListener();
			// 设置男性反面触摸监听
			setManBackOnTouchListener();
			break;
		default:
			break;
		}
	}

	/**
	 * 初始化女性正面view
	 * @author leibing
	 * @createTime 2016/10/07
	 * @lastModify 2016/10/07
	 * @param view
	 * @return
	 */
	private void initWomenFront(View view){
		// 女正面头部
		womenFrontHeadIv = (ImageView) view.findViewById(R.id.iv_women_front_head);
		// 女正面颈部
		womenFrontNeckIv = (ImageView) view.findViewById(R.id.iv_women_front_neck);
		// 女正面右上手臂
		womenFrontArmRightUpIv = (ImageView) view.findViewById(R.id.iv_women_front_arm_right_up);
		// 女正面胸部
		womenFrontChestIv = (ImageView) view.findViewById(R.id.iv_women_front_chest);
		// 女正面腹部（上）
		womenFrontStomachUpIv = (ImageView) view.findViewById(R.id.iv_women_front_stomach_up);
		// 女正面左上手臂
		womenFrontArmLeftUpIv = (ImageView) view.findViewById(R.id.iv_women_front_arm_left_up);
		// 女正面右中手臂
		womenFrontArmRightMiddleIv = (ImageView) view.findViewById(R.id.iv_women_front_arm_right_middle);
		// 女正面腹部（中）
		womenFrontStomachMiddleIv = (ImageView) view.findViewById(R.id.iv_women_front_stomach_middle);
		// 女正面左中手臂
		womenFrontArmLeftMiddleIv = (ImageView) view.findViewById(R.id.iv_women_front_arm_left_middle);
		// 女正面右下手臂
		womenFrontArmRightDownIv = (ImageView) view.findViewById(R.id.iv_women_front_arm_right_down);
		// 女正面腹部（下）
		womenFrontStomachDownIv = (ImageView) view.findViewById(R.id.iv_women_front_stomach_down);
		// 女正面左下手臂
		womenFrontArmLeftDownIv = (ImageView) view.findViewById(R.id.iv_women_front_arm_left_down);
		// 女正面右手
		womenFrontHandRightIv = (ImageView) view.findViewById(R.id.iv_women_front_hand_right);
		// 女正面女性盆骨
		womenFrontPelvisIv = (ImageView) view.findViewById(R.id.iv_women_front_pelvis);
		// 女正面双腿
		womenFrontLegsIv = (ImageView) view.findViewById(R.id.iv_women_front_legs);
		// 女正面双脚
		womenFrontFootsIv = (ImageView) view.findViewById(R.id.iv_women_front_foots);
		// 女正面左手
		womenFrontHandLeftIv = (ImageView) view.findViewById(R.id.iv_women_front_hand_left);
	}

	/**
	 * 初始化女性反面view
	 * @author leibing
	 * @createTime 2016/10/07
	 * @lastModify 2016/10/07
	 * @param view
	 * @return
	 */
	private void initWomenBack(View view){
		// 女反面头部
		womenBackHeadIv = (ImageView) view.findViewById(R.id.iv_women_back_head);
		// 女反面颈部
		womenBackNeckIv = (ImageView) view.findViewById(R.id.iv_women_back_neck);
		// 女反面左上手臂
		womenBackArmLeftUpIv = (ImageView) view.findViewById(R.id.iv_women_back_arm_left_up);
		// 女反面背部（上）
		womenBackBacksideUpIv = (ImageView) view.findViewById(R.id.iv_women_back_backside_up);
		// 女反面背部（下）
		womenBackBacksideDownIv = (ImageView) view.findViewById(R.id.iv_women_back_backside_down);
		// 女反面右上手臂
		womenBackArmRightUpIv = (ImageView) view.findViewById(R.id.iv_women_back_arm_right_up);
		// 女反面左中手臂
		womenBackArmLeftMiddleIv = (ImageView) view.findViewById(R.id.iv_women_back_arm_left_middle);
		// 女反面腰部（上）
		womenBackWaistUpIv = (ImageView) view.findViewById(R.id.iv_women_back_waist_up);
		// 女反面右中手臂
		womenBackArmRightMiddleIv = (ImageView) view.findViewById(R.id.iv_women_back_arm_right_middle);
		// 女反面左下手臂
		womenBackArmLeftDownIv = (ImageView) view.findViewById(R.id.iv_women_back_arm_left_down);
		// 女反面腰部（下）
		womenBackWaistDownIv = (ImageView) view.findViewById(R.id.iv_women_back_waist_down);
		// 女反面右下手臂
		womenBackArmRightDownIv = (ImageView) view.findViewById(R.id.iv_women_back_arm_right_down);
		// 女反面左手
		womenBackHandLeftIv = (ImageView) view.findViewById(R.id.iv_women_back_hand_left);
		// 女反面臀部
		womenBackHipIv = (ImageView) view.findViewById(R.id.iv_women_back_hip);
		// 女反面双腿
		womenBackLegsIv = (ImageView) view.findViewById(R.id.iv_women_back_legs);
		// 女反面双脚
		womenBackFootsIv = (ImageView) view.findViewById(R.id.iv_women_back_foots);
		// 女反面右手
		womenBackHandRightIv = (ImageView) view.findViewById(R.id.iv_women_back_hand_right);
	}

	/**
	 * 初始化男性正面view
	 * @author leibing
	 * @createTime 2016/10/07
	 * @lastModify 2016/10/07
	 * @param view
	 * @return
	 */
	private void initManFront(View view){
		// 男正面右手臂
		manFrontArmRightIv = (ImageView) view.findViewById(R.id.iv_man_front_arm_right);
		// 男正面头部
		manFrontHeadIv = (ImageView) view.findViewById(R.id.iv_man_front_head);
		// 男正面颈部
		manFrontNeckIv = (ImageView) view.findViewById(R.id.iv_man_front_neck);
		// 男正面胸部
		manFrontChestIv = (ImageView) view.findViewById(R.id.iv_man_front_chest);
		// 男正面腹部
		manFrontStomachIv = (ImageView) view.findViewById(R.id.iv_man_front_stomach);
		// 男正面左手臂
		manFrontArmLeftIv = (ImageView) view.findViewById(R.id.iv_man_front_arm_left);
		// 男正面右手
		manFrontHandRightIv = (ImageView) view.findViewById(R.id.iv_man_front_hand_right);
		// 男正面男性股沟
		manFrontThighIv = (ImageView) view.findViewById(R.id.iv_man_front_thigh);
		// 男正面左手
		manFrontHandLeftIv = (ImageView) view.findViewById(R.id.iv_man_front_hand_left);
		// 男正面双腿
		manFrontLegs = (ImageView) view.findViewById(R.id.iv_man_front_legs);
		// 男正面双脚
		manFrontFoots = (ImageView) view.findViewById(R.id.iv_man_front_foots);
	}

	/**
	 * 初始化男性反面view
	 * @author leibing
	 * @createTime 2016/10/07
	 * @lastModify 2016/10/07
	 * @param view
	 * @return
	 */
	private void initManBack(View view){
		// 男反面左手臂
		manBackArmLeftIv = (ImageView) view.findViewById(R.id.iv_man_back_arm_left);
		// 男反面头部
		manBackHeadIv = (ImageView) view.findViewById(R.id.iv_man_back_head);
		// 男反面颈部
		manBackNeckIv = (ImageView) view.findViewById(R.id.iv_man_back_neck);
		// 男反面背部
		manBackBacksideIv = (ImageView) view.findViewById(R.id.iv_man_back_backside);
		// 男反面腰部
		manBackWaistIv = (ImageView) view.findViewById(R.id.iv_man_back_waist);
		// 男反面右手臂
		manBackArmRightIv = (ImageView) view.findViewById(R.id.iv_man_back_arm_right);
		// 男反面左手
		manBackHandLeftIv = (ImageView) view.findViewById(R.id.iv_man_back_hand_left);
		// 男反面臀部
		manBackHipIv = (ImageView) view.findViewById(R.id.iv_man_back_hip);
		// 男反面右手
		manBackHandRightIv = (ImageView) view.findViewById(R.id.iv_man_back_hand_right);
		// 男反面双腿
		manBackLegsIv = (ImageView) view.findViewById(R.id.iv_man_back_legs);
		// 男反面双脚
		manBackFootsIv = (ImageView) view.findViewById(R.id.iv_man_back_foots);
	}

	/**
	 * 设置男性正面点击监听
	 * @author leibing
	 * @createTime 2016/10/07
	 * @lastModify 2016/10/07
	 * @param
	 * @return
	 */
	private void setManFrontOnClickListener(){
		// 男正面右手臂
		manFrontArmRightIv.setOnClickListener(this);
		// 男正面头部
		manFrontHeadIv.setOnClickListener(this);
		// 男正面颈部
		manFrontNeckIv.setOnClickListener(this);
		// 男正面胸部
		manFrontChestIv.setOnClickListener(this);
		// 男正面腹部
		manFrontStomachIv.setOnClickListener(this);
		// 男正面左手臂
		manFrontArmLeftIv.setOnClickListener(this);
		// 男正面右手
		manFrontHandRightIv.setOnClickListener(this);
		// 男正面男性股沟
		manFrontThighIv.setOnClickListener(this);
		// 男正面左手
		manFrontHandLeftIv.setOnClickListener(this);
		// 男正面双腿
		manFrontLegs.setOnClickListener(this);
		// 男正面双脚
		manFrontFoots.setOnClickListener(this);
	}

	/**
	 * 设置男性反面点击监听
	 * @author leibing
	 * @createTime 2016/10/07
	 * @lastModify 2016/10/07
	 * @param
	 * @return
	 */
	private void setManBackOnClickListener(){
		// 男反面左手臂
		manBackArmLeftIv.setOnClickListener(this);
		// 男反面头部
		manBackHeadIv.setOnClickListener(this);
		// 男反面颈部
		manBackNeckIv.setOnClickListener(this);
		// 男反面背部
		manBackBacksideIv.setOnClickListener(this);
		// 男反面腰部
		manBackWaistIv.setOnClickListener(this);
		// 男反面右手臂
		manBackArmRightIv.setOnClickListener(this);
		// 男反面左手
		manBackHandLeftIv.setOnClickListener(this);
		// 男反面臀部
		manBackHipIv.setOnClickListener(this);
		// 男反面右手
		manBackHandRightIv.setOnClickListener(this);
		// 男反面双腿
		manBackLegsIv.setOnClickListener(this);
		// 男反面双脚
		manBackFootsIv.setOnClickListener(this);
	}

	/**
	 * 设置男性正面触摸监听
	 * @author leibing
	 * @createTime 2016/10/07
	 * @lastModify 2016/10/07
	 * @param
	 * @return
	 */
	private void setManFrontOnTouchListener(){
		// 男正面右手臂
		manFrontArmRightIv.setOnTouchListener(this);
		// 男正面头部
		manFrontHeadIv.setOnTouchListener(this);
		// 男正面颈部
		manFrontNeckIv.setOnTouchListener(this);
		// 男正面胸部
		manFrontChestIv.setOnTouchListener(this);
		// 男正面腹部
		manFrontStomachIv.setOnTouchListener(this);
		// 男正面左手臂
		manFrontArmLeftIv.setOnTouchListener(this);
		// 男正面右手
		manFrontHandRightIv.setOnTouchListener(this);
		// 男正面男性股沟
		manFrontThighIv.setOnTouchListener(this);
		// 男正面左手
		manFrontHandLeftIv.setOnTouchListener(this);
		// 男正面双腿
		manFrontLegs.setOnTouchListener(this);
		// 男正面双脚
		manFrontFoots.setOnTouchListener(this);
	}

	/**
	 * 设置男性反面触摸监听
	 * @author leibing
	 * @createTime 2016/10/07
	 * @lastModify 2016/10/07
	 * @param
	 * @return
	 */
	private void setManBackOnTouchListener(){
		// 男反面左手臂
		manBackArmLeftIv.setOnTouchListener(this);
		// 男反面头部
		manBackHeadIv.setOnTouchListener(this);
		// 男反面颈部
		manBackNeckIv.setOnTouchListener(this);
		// 男反面背部
		manBackBacksideIv.setOnTouchListener(this);
		// 男反面腰部
		manBackWaistIv.setOnTouchListener(this);
		// 男反面右手臂
		manBackArmRightIv.setOnTouchListener(this);
		// 男反面左手
		manBackHandLeftIv.setOnTouchListener(this);
		// 男反面臀部
		manBackHipIv.setOnTouchListener(this);
		// 男反面右手
		manBackHandRightIv.setOnTouchListener(this);
		// 男反面双腿
		manBackLegsIv.setOnTouchListener(this);
		// 男反面双脚
		manBackFootsIv.setOnTouchListener(this);
	}

	/**
	 * 设置女性正面点击监听
	 * @author leibing
	 * @createTime 2016/10/07
	 * @lastModify 2016/10/07
	 * @param
	 * @return
	 */
	private void setWomenFrontOnClickListener(){
		// 女正面头部
		womenFrontHeadIv.setOnClickListener(this);
		// 女正面颈部
		womenFrontNeckIv.setOnClickListener(this);
		// 女正面右上手臂
		womenFrontArmRightUpIv.setOnClickListener(this);
		// 女正面胸部
		womenFrontChestIv.setOnClickListener(this);
		// 女正面腹部（上）
		womenFrontStomachUpIv.setOnClickListener(this);
		// 女正面左上手臂
		womenFrontArmLeftUpIv.setOnClickListener(this);
		// 女正面右中手臂
		womenFrontArmRightMiddleIv.setOnClickListener(this);
		// 女正面腹部（中）
		womenFrontStomachMiddleIv.setOnClickListener(this);
		// 女正面左中手臂
		womenFrontArmLeftMiddleIv.setOnClickListener(this);
		// 女正面右下手臂
		womenFrontArmRightDownIv.setOnClickListener(this);
		// 女正面腹部（下）
		womenFrontStomachDownIv.setOnClickListener(this);
		// 女正面左下手臂
		womenFrontArmLeftDownIv.setOnClickListener(this);
		// 女正面右手
		womenFrontHandRightIv.setOnClickListener(this);
		// 女正面女性盆骨
		womenFrontPelvisIv.setOnClickListener(this);
		// 女正面双腿
		womenFrontLegsIv.setOnClickListener(this);
		// 女正面双脚
		womenFrontFootsIv.setOnClickListener(this);
		// 女正面左手
		womenFrontHandLeftIv.setOnClickListener(this);
	}

	/**
	 * 设置女性反面点击监听
	 * @author leibing
	 * @createTime 2016/10/07
	 * @lastModify 2016/10/07
	 * @param
	 * @return
	 */
	private void setWomenBackOnClickListener(){
		// 女反面头部
		womenBackHeadIv.setOnClickListener(this);
		// 女反面颈部
		womenBackNeckIv.setOnClickListener(this);
		// 女反面左上手臂
		womenBackArmLeftUpIv.setOnClickListener(this);
		// 女反面背部（上）
		womenBackBacksideUpIv.setOnClickListener(this);
		// 女反面背部（下）
		womenBackBacksideDownIv.setOnClickListener(this);
		// 女反面右上手臂
		womenBackArmRightUpIv.setOnClickListener(this);
		// 女反面左中手臂
		womenBackArmLeftMiddleIv.setOnClickListener(this);
		// 女反面腰部（上）
		womenBackWaistUpIv.setOnClickListener(this);
		// 女反面右中手臂
		womenBackArmRightMiddleIv.setOnClickListener(this);
		// 女反面左下手臂
		womenBackArmLeftDownIv.setOnClickListener(this);
		// 女反面腰部（下）
		womenBackWaistDownIv.setOnClickListener(this);
		// 女反面右下手臂
		womenBackArmRightDownIv.setOnClickListener(this);
		// 女反面左手
		womenBackHandLeftIv.setOnClickListener(this);
		// 女反面臀部
		womenBackHipIv.setOnClickListener(this);
		// 女反面双腿
		womenBackLegsIv.setOnClickListener(this);
		// 女反面双脚
		womenBackFootsIv.setOnClickListener(this);
		// 女反面右手
		womenBackHandRightIv.setOnClickListener(this);
	}

	/**
	 * 设置女性正面触摸监听
	 * @author leibing
	 * @createTime 2016/10/07
	 * @lastModify 2016/10/07
	 * @param
	 * @return
	 */
	private void setWomenFrontOnTouchListener() {
		// 女正面头部
		womenFrontHeadIv.setOnTouchListener(this);
		// 女正面颈部
		womenFrontNeckIv.setOnTouchListener(this);
		// 女正面右上手臂
		womenFrontArmRightUpIv.setOnTouchListener(this);
		// 女正面胸部
		womenFrontChestIv.setOnTouchListener(this);
		// 女正面腹部（上）
		womenFrontStomachUpIv.setOnTouchListener(this);
		// 女正面左上手臂
		womenFrontArmLeftUpIv.setOnTouchListener(this);
		// 女正面右中手臂
		womenFrontArmRightMiddleIv.setOnTouchListener(this);
		// 女正面腹部（中）
		womenFrontStomachMiddleIv.setOnTouchListener(this);
		// 女正面左中手臂
		womenFrontArmLeftMiddleIv.setOnTouchListener(this);
		// 女正面右下手臂
		womenFrontArmRightDownIv.setOnTouchListener(this);
		// 女正面腹部（下）
		womenFrontStomachDownIv.setOnTouchListener(this);
		// 女正面左下手臂
		womenFrontArmLeftDownIv.setOnTouchListener(this);
		// 女正面右手
		womenFrontHandRightIv.setOnTouchListener(this);
		// 女正面女性盆骨
		womenFrontPelvisIv.setOnTouchListener(this);
		// 女正面双腿
		womenFrontLegsIv.setOnTouchListener(this);
		// 女正面双脚
		womenFrontFootsIv.setOnTouchListener(this);
		// 女正面左手
		womenFrontHandLeftIv.setOnTouchListener(this);
	}

	/**
	 * 设置女性反面触摸监听
	 * @author leibing
	 * @createTime 2016/10/07
	 * @lastModify 2016/10/07
	 * @param
	 * @return
	 */
	private void setWomenBackOnTouchListener() {
		// 女反面头部
		womenBackHeadIv.setOnTouchListener(this);
		// 女反面颈部
		womenBackNeckIv.setOnTouchListener(this);
		// 女反面左上手臂
		womenBackArmLeftUpIv.setOnTouchListener(this);
		// 女反面背部（上）
		womenBackBacksideUpIv.setOnTouchListener(this);
		// 女反面背部（下）
		womenBackBacksideDownIv.setOnTouchListener(this);
		// 女反面右上手臂
		womenBackArmRightUpIv.setOnTouchListener(this);
		// 女反面左中手臂
		womenBackArmLeftMiddleIv.setOnTouchListener(this);
		// 女反面腰部（上）
		womenBackWaistUpIv.setOnTouchListener(this);
		// 女反面右中手臂
		womenBackArmRightMiddleIv.setOnTouchListener(this);
		// 女反面左下手臂
		womenBackArmLeftDownIv.setOnTouchListener(this);
		// 女反面腰部（下）
		womenBackWaistDownIv.setOnTouchListener(this);
		// 女反面右下手臂
		womenBackArmRightDownIv.setOnTouchListener(this);
		// 女反面左手
		womenBackHandLeftIv.setOnTouchListener(this);
		// 女反面臀部
		womenBackHipIv.setOnTouchListener(this);
		// 女反面双腿
		womenBackLegsIv.setOnTouchListener(this);
		// 女反面双脚
		womenBackFootsIv.setOnTouchListener(this);
		// 女反面右手
		womenBackHandRightIv.setOnTouchListener(this);
	}
	
	@Override
	public void onClick(View v) {
		// 在播放动画时，禁止点击响应
		if (!((HumanBodyActivity) getActivity()).isCanTouch())
			return;
		// 女性正面点击监听
		onClick2WomenFront(v);
		// 女性反面点击监听
		onClick2WomenBack(v);
		// 男性正面点击监听
		onClick2ManFront(v);
		// 男性反面点击监听
		onClick2ManBack(v);
		// 跳转到对应id身体区域
		gotoWhichBodyPart(v, partId);
	}

	/**
	 * 女性正面点击监听
	 * @author leibing
	 * @createTime 2016/10/07
	 * @lastModify 2016/10/07
	 * @param v
	 * @return
	 */
	private void onClick2WomenFront(View v){
		switch (v.getId()) {
		case R.id.iv_women_front_head:
			// 头部
			partId = 1;
			break;
		case R.id.iv_women_front_neck:
			// 颈部
			partId = 2;
			break;
		case R.id.iv_women_front_arm_right_up:
		case R.id.iv_women_front_arm_left_up:
		case R.id.iv_women_front_arm_right_middle:
		case R.id.iv_women_front_arm_left_middle:
		case R.id.iv_women_front_arm_right_down:
		case R.id.iv_women_front_arm_left_down:
		case R.id.iv_women_front_hand_right:
		case R.id.iv_women_front_hand_left:
			// 上肢
			partId = 7;
			break;
		case R.id.iv_women_front_chest:
			// 胸部
			partId = 3;
			break;
		case R.id.iv_women_front_stomach_up:
		case R.id.iv_women_front_stomach_middle:
			case R.id.iv_women_front_stomach_down:
			// 腹部
			partId = 4;
			break;
		case R.id.iv_women_front_pelvis:
			// 女性盆骨
			partId = 6;
			break;
		case R.id.iv_women_front_legs:
		case R.id.iv_women_front_foots:
			// 下肢
			partId = 8;
			break;
		}
	}

	/**
	 * 女性反面点击监听
	 * @author leibing
	 * @createTime 2016/10/07
	 * @lastModify 2016/10/07
	 * @param v
	 * @return
	 */
	private void onClick2WomenBack(View v){
		switch (v.getId()) {
		case R.id.iv_women_back_arm_left_up:
		case R.id.iv_women_back_arm_right_up:
		case R.id.iv_women_back_arm_left_middle:
		case R.id.iv_women_back_arm_right_middle:
		case R.id.iv_women_back_arm_left_down:
		case R.id.iv_women_back_arm_right_down:
			case R.id.iv_women_back_hand_left:
			case R.id.iv_women_back_hand_right:
			// 上肢
			partId = 7;
			break;
		case R.id.iv_women_back_head:
			// 头部
			partId = 1;
			break;
		case R.id.iv_women_back_neck:
			// 颈部
			partId = 2;
			break;
		case R.id.iv_women_back_backside_up:
			case R.id.iv_women_back_backside_down:
			// 背部
			partId = 10;
			break;
		case R.id.iv_women_back_waist_up:
			case R.id.iv_women_back_waist_down:
			// 腰部
			partId = 11;
			break;
		case R.id.iv_women_back_hip:
			// 臀部
			partId = 12;
			break;
		case R.id.iv_women_back_legs:
		case R.id.iv_women_back_foots:
			// 下肢
			partId = 8;
			break;
		}
	}

	/**
	 * 男性正面点击监听
	 * @author leibing
	 * @createTime 2016/10/07
	 * @lastModify 2016/10/07
	 * @param v
	 * @return
	 */
	private void onClick2ManFront(View v){
		switch (v.getId()) {
		case R.id.iv_man_front_arm_right:
		case R.id.iv_man_front_arm_left:
		case R.id.iv_man_front_hand_right:
		case R.id.iv_man_front_hand_left:
			// 上肢
			partId = 7;
			break;
		case R.id.iv_man_front_head:
			// 头部
			partId = 1;
			break;
		case R.id.iv_man_front_neck:
			// 颈部
			partId = 2;
			break;
		case R.id.iv_man_front_chest:
			// 胸部
			partId = 3;
			break;
		case R.id.iv_man_front_stomach:
			// 腹部
			partId = 4;
			break;
		case R.id.iv_man_front_thigh:
			// 男性股沟
			partId = 5;
			break;
		case R.id.iv_man_front_legs:
		case R.id.iv_man_front_foots:
			// 下肢
			partId = 8;
			break;
		}
	}

	/**
	 * 男性反面点击监听
	 * @author leibing
	 * @createTime 2016/10/07
	 * @lastModify 2016/10/07
	 * @param v
	 * @return
	 */
	private void onClick2ManBack(View v){
		switch (v.getId()) {
		case R.id.iv_man_back_arm_left:
		case R.id.iv_man_back_arm_right:
		case R.id.iv_man_back_hand_left:
		case R.id.iv_man_back_hand_right:
			// 上肢
			partId = 7;
			break;
		case R.id.iv_man_back_head:
			// 头部
			partId = 1;
			break;
		case R.id.iv_man_back_neck:
			// 颈部
			partId = 2;
			break;
		case R.id.iv_man_back_backside:
			// 背部
			partId = 10;
			break;
		case R.id.iv_man_back_waist:
			// 腰部
			partId = 11;
			break;
		case R.id.iv_man_back_hip:
			// 臀部
			partId = 12;
			break;
		case R.id.iv_man_back_legs:
		case R.id.iv_man_back_foots:
			// 下肢
			partId = 8;
			break;
		}
	}

	/**
	 * 跳转到对应id身体区域
	 * @author leibing
	 * @createTime 2016/10/07
	 * @lastModify 2016/10/07
	 * @param v
	 * @param bodyPartId 身体部位id
	 * @return
	 */
	private void gotoWhichBodyPart(View v, int bodyPartId){
		Bitmap bitmap = ((BitmapDrawable) (((ImageView) v).getDrawable()))
				.getBitmap();
		// 如果是点击的是透明像素，直接返回！否则向下执行！
		try {
			if (bitmap.getPixel((int) (touchIVPos[0]),
					((int) touchIVPos[1])) == 0) {
				return;
			}
		} catch (Exception e) {
		}

		((HumanBodyActivity) getActivity()).addIVandPlay(bodyPartId);
	}
	
	@Override
	public boolean onTouch(View v, MotionEvent ev) {
		touchIVPos[0] = ev.getX();
		touchIVPos[1] = ev.getY();
		return false;
	}

	/**
	 * 清理ImageView对象,防止内存泄漏
	 * @author leibing
	 * @createTime 2016/10/07
	 * @lastModify 2016/10/07
	 * @param
	 * @return
	 */
	private void clearImg(){
		// 男正面
		// 男正面右手臂
		manFrontArmRightIv = null;
		// 男正面头部
		manFrontHeadIv = null;
		// 男正面颈部
		manFrontNeckIv = null;
		// 男正面胸部
		manFrontChestIv = null;
		// 男正面腹部
		manFrontStomachIv = null;
		// 男正面左手臂
		manFrontArmLeftIv = null;
		// 男正面右手
		manFrontHandRightIv = null;
		// 男正面男性股沟
		manFrontThighIv = null;
		// 男正面左手
		manFrontHandLeftIv = null;
		// 男正面双腿
		manFrontLegs = null;
		// 男正面双脚
		manFrontFoots = null;

		// 男反面
		// 男反面左手臂
		manBackArmLeftIv = null;
		// 男反面头部
		manBackHeadIv = null;
		// 男反面颈部
		manBackNeckIv = null;
		// 男反面背部
		manBackBacksideIv = null;
		// 男反面腰部
		manBackWaistIv = null;
		// 男反面右手臂
		manBackArmRightIv = null;
		// 男反面左手
		manBackHandLeftIv = null;
		// 男反面臀部
		manBackHipIv = null;
		// 男反面右手
		manBackHandRightIv = null;
		// 男反面双腿
		manBackLegsIv = null;
		// 男反面双脚
		manBackFootsIv = null;

		// 女正面
		// 女正面头部
		womenFrontHeadIv = null;
		// 女正面颈部
		womenFrontNeckIv = null;
		// 女正面右上手臂
		womenFrontArmRightUpIv = null;
		// 女正面胸部
		womenFrontChestIv = null;
		// 女正面腹部（上）
		womenFrontStomachUpIv = null;
		// 女正面左上手臂
		womenFrontArmLeftUpIv = null;
		// 女正面右中手臂
		womenFrontArmRightMiddleIv = null;
		// 女正面腹部（中）
		womenFrontStomachMiddleIv = null;
		// 女正面左中手臂
		womenFrontArmLeftMiddleIv = null;
		// 女正面右下手臂
		womenFrontArmRightDownIv = null;
		// 女正面腹部（下）
		womenFrontStomachDownIv = null;
		// 女正面左下手臂
		womenFrontArmLeftDownIv = null;
		// 女正面右手
		womenFrontHandRightIv = null;
		// 女正面女性盆骨
		womenFrontPelvisIv = null;
		// 女正面双腿
		womenFrontLegsIv = null;
		// 女正面双脚
		womenFrontFootsIv = null;
		// 女正面左手
		womenFrontHandLeftIv = null;

		// 女反面
		// 女反面头部
		womenBackHeadIv = null;
		// 女反面颈部
		womenBackNeckIv = null;
		// 女反面左上手臂
		womenBackArmLeftUpIv = null;
		// 女反面背部（上）
		womenBackBacksideUpIv = null;
		// 女反面背部（下）
		womenBackBacksideDownIv = null;
		// 女反面右上手臂
		womenBackArmRightUpIv = null;
		// 女反面左中手臂
		womenBackArmLeftMiddleIv = null;
		// 女反面腰部（上）
		womenBackWaistUpIv = null;
		// 女反面右中手臂
		womenBackArmRightMiddleIv = null;
		// 女反面左下手臂
		womenBackArmLeftDownIv = null;
		// 女反面腰部（下）
		womenBackWaistDownIv = null;
		// 女反面右下手臂
		womenBackArmRightDownIv = null;
		// 女反面左手
		womenBackHandLeftIv = null;
		// 女反面臀部
		womenBackHipIv = null;
		// 女反面双腿
		womenBackLegsIv = null;
		// 女反面双脚
		womenBackFootsIv = null;
		// 女反面右手
		womenBackHandRightIv = null;
	}
	
	@Override
	public void onDestroyView() {
		// 清理ImageView对象,防止内存泄漏
		clearImg();
		super.onDestroyView();
	}
}
