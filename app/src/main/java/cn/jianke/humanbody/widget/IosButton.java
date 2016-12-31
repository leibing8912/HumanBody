package cn.jianke.humanbody.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * @className: IosButton
 * @classDescription: 用一张图片实现按钮被点击效果（通过改变图片的透明度）
 * @author: leibing
 * @createTime: 2016/12/30
 */
public class IosButton extends Button {

		/**
		 * Constructor
		 * @author leibing
		 * @createTime 2016/12/30
		 * @lastModify 2016/12/30
		 * @param context
		 * @return
		 */
	    public IosButton(Context context) {  
	        super(context);  
	        initMyButton();  
	    }  

		/**
		 * Constructor
		 * @author leibing
		 * @createTime 2016/12/30
		 * @lastModify 2016/12/30
		 * @param context
		 * @param attrs
		 * @return
		 */
	    public IosButton(Context context, AttributeSet attrs) {  
	        super(context, attrs);  
	        initMyButton();  
	    }

		/**
		 * Constructor
		 * @author leibing
		 * @createTime 2016/12/30
		 * @lastModify 2016/12/30
		 * @param context
		 * @param attrs
		 * @param defStyle
		 * @return
		 */
	    public IosButton(Context context, AttributeSet attrs, int defStyle) {  
	        super(context, attrs, defStyle);  
	        initMyButton();  
	    }  
	      
	    @SuppressWarnings("deprecation")
		private void initMyButton(){
			// 设置背景
	        setBackgroundDrawable(newSelector());  
	    }  

		/**
		 * 传入改变亮度前的bitmap，返回改变亮度后的bitmap
		 * @author leibing
		 * @createTime 2016/12/30
		 * @lastModify 2016/12/30
		 * @param srcBitmap
		 * @return
		 */
	    @SuppressWarnings("deprecation")
		public Drawable changeBrightnessBitmap(Bitmap srcBitmap){  
	         Bitmap bmp = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(),    
	                Config.ARGB_8888);    
	        int brightness = 60 - 127;    
	        ColorMatrix cMatrix = new ColorMatrix();
			// 改变亮度
	        cMatrix.set(new float[] { 1, 0, 0, 0, brightness, 0, 1,    
	                0, 0, brightness,
	                0, 0, 1, 0, brightness, 0, 0, 0, 1, 0 });    
	        Paint paint = new Paint();    
	        paint.setColorFilter(new ColorMatrixColorFilter(cMatrix));    
	        Canvas canvas = new Canvas(bmp);    
	        // 在Canvas上绘制一个Bitmap  
	        canvas.drawBitmap(srcBitmap, 0, 0, paint);    
	       return new BitmapDrawable(bmp);  
	    }

		/**
		 * 设置Selector
		 * @author leibing
		 * @createTime 2016/12/30
		 * @lastModify 2016/12/30
		 * @param
		 * @return
		 */
	    public StateListDrawable newSelector() {    
	        StateListDrawable bg = new StateListDrawable();    
	        Drawable normal =getBackground();    
	        Drawable pressed =changeBrightnessBitmap(((BitmapDrawable) getBackground()).getBitmap());;     
	        // View.PRESSED_ENABLED_STATE_SET     
	        bg.addState(new int[] { android.R.attr.state_pressed, android.R.attr.state_enabled }, pressed);    
	        // View.ENABLED_STATE_SET     
	        bg.addState(new int[] { android.R.attr.state_enabled }, normal);    
	        // View.EMPTY_STATE_SET     
	        bg.addState(new int[] {}, normal);    
	        return bg;    
	    }   

		/**
		 * 保持控件的大小
		 * IosButton这个控件调用setBackgroundResource()有时会改变view的大小
		 * 通过此方法可以保持view的大小
		 * @author leibing
		 * @createTime 2016/12/30
		 * @lastModify 2016/12/30
		 * @param
		 * @return
		 */
		public void keepViewSize() {
			RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
					this.getWidth(), this.getHeight());
			layoutParams.bottomMargin = ((RelativeLayout.LayoutParams)this.getLayoutParams()).bottomMargin;
			layoutParams.rightMargin = ((RelativeLayout.LayoutParams)this.getLayoutParams()).rightMargin;
			layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
			layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
			this.setLayoutParams(layoutParams);
		}
}
