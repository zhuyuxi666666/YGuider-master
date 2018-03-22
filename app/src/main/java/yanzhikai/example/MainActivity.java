package yanzhikai.example;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.yanzhikai.guiderview.YGuider;
import com.yanzhikai.guiderview.interfaces.OnGuiderListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final String TAG = "MainActivity";
    private Button btn1, btn2, btn3;
    private YGuider mYGuider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        initGuider();
    }

    private void initGuider() {
        mYGuider = new YGuider(this);
        mYGuider.addNextTarget(new RectF(70, 70, 170, 170), "点击这里可以立刻出现所有提示文字，大家好，我是YGuider！",10,70);
        mYGuider.addNextTarget(btn1, "第一个按钮的位置！", 150, 10);
//        mYGuider.addNextTarget(new RectF(50, 500, 150, 650), "这里是根据传入矩形区域坐标来确定的！", 100, 10);
        mYGuider.addNextTarget(
                btn2, "第二个按钮的位置！"
                , -350, -350
                , 430, ViewGroup.LayoutParams.WRAP_CONTENT);
        mYGuider.addNextTarget(
                btn3, "第三个按钮的位置！", 200, 200
                , 430, ViewGroup.LayoutParams.WRAP_CONTENT);
        mYGuider.addNextTarget(
                new RectF(500, 200, 600, 270), "可以动态改变两个按钮的文字",
                -350, 50
                , 300, ViewGroup.LayoutParams.WRAP_CONTENT
                , "", "完成！");
//之后打开的
//        mYGuider.prepare();
////        mYGuider.setMaskMoveDuration(500);
////        mYGuider.setExpandDuration(500);
        mYGuider.setMaskRefreshTime(30);
////        mYGuider.setWindowContent(R.layout.tips_window_layout_test);//设置按键的位置例如：下一步and跳过
        mYGuider.setWindowTyperTextSize(12);//设置提示字体的大小
        mYGuider.setWindowJumpAndNextTextSize(15);//设置提示按键的大小
        mYGuider.setNextText("下一步");
        mYGuider.setJumpText("跳过");
//        mYGuider.setMaskColor(Color.argb(99, 200, 100, 99));
//        mYGuider.setMaskPaint(getPaint());//设置交叉线的样式
//
//
//        mYGuider.setOnGuiderListener(new MyGuiderListener());
        mYGuider.startGuide();
    }

    //用于测试setMaskPaint()设置交叉线的样式
    private Paint getPaint() {
        Paint p = new Paint();
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(10);
        p.setShader(new LinearGradient(0, 0, 0, 0, Color.YELLOW, Color.RED, Shader.TileMode.MIRROR));
        p.setColor(Color.BLUE);
        return p;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                mYGuider.startGuide();
                break;
            case R.id.btn2:
                Toast.makeText(MainActivity.this, "点击了第二个啦啦啦!", Toast.LENGTH_SHORT).show();
                break;
        }
    }

//    class MyGuiderListener extends OnGuiderListener {
//        @Override
//        public void onMaskClick() {
//            Log.d(TAG, "onMaskClick: ");
//        }
//
//        @Override
//        public void onNextClick(int nextIndex) {
//            Log.d(TAG, "onNextClick: " + nextIndex);
////            if (nextIndex > 2 ){
////                if (nextIndex % 2 == 0){
////                    mYGuider.addNextTarget(btn1,"这是新增的",0,0);
////                }else {
////                    mYGuider.addNextTarget(btn2,"这是新增的",0,0);
////                }
////            }
//        }
//
//        @Override
//        public void onJumpClick() {
//            Log.d(TAG, "onJumpClick: ");
//        }
//
//        @Override
//        public void onGuiderStart() {
//            Log.d(TAG, "onGuiderStart: ");
//        }
//
//        @Override
//        public void onGuiderNext(int nextIndex) {
//            Log.d(TAG, "onGuiderNext: " + nextIndex);
//        }
//
//        @Override
//        public void onGuiderFinished() {
//            Log.d(TAG, "onGuiderFinished: ");
//        }
//
//        @Override
//        public void onTargetClick(int index) {
////            mYGuider.startNextGuide();
//            Log.d(TAG, "onTargetClick: " + index);
//        }
//    }
}
