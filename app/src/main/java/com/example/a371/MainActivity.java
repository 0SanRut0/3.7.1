package com.example.a371;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new DrawView(this));
    }

    class DrawView extends View {

        Paint paint;
        Rect rect;
        Path path;

        public DrawView(Context context) {
            super(context);
            paint = new Paint();
            rect = new Rect();
            path = new Path();
        }

        @SuppressLint("ResourceAsColor")
        @Override
        protected void onDraw(Canvas canvas) {
            //трава
            paint.setColor(Color.rgb(0,128,0));
            canvas.drawRect(0, getHeight()/45*35, getWidth(), getHeight(), paint);

            //ствол
            paint.setColor(Color.rgb(128,64,0));
            canvas.drawRect(getWidth()/58*31, getHeight()/45*39, getWidth()/58*32, getHeight()/45*42, paint);

            //листва
            paint.setColor(Color.rgb(2,255,0));
            canvas.drawOval(new RectF(getWidth()/58*25, getHeight()/45*15, getWidth()/58*38, getHeight()/45*39), paint);

            //дом
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.rgb(128, 64, 0));
            canvas.drawRect(getWidth()/58*7,getHeight()/45*28,getWidth()/58*22,getHeight()/45*41,paint);

            //крыша
            path.reset();
            path.moveTo(getWidth()/58*7,getHeight()/45*28);
            path.lineTo(getWidth()/58*15,getHeight()/45*18);
            path.lineTo(getWidth()/58*22,getHeight()/45*28);
            canvas.drawPath(path,paint);

            //солнце
            paint.setColor(Color.rgb(255,255,0));
            canvas.drawCircle(getWidth()/58*2,getHeight()/45*3,getWidth()/58*3, paint);



            //лавочка
            paint.setColor(Color.rgb(128,128, 128));
            canvas.drawRect(getWidth()/58*43,getHeight()/45*36,getWidth()/58*54,getHeight()/45*37,paint);
            canvas.drawRect(getWidth()/58*45,getHeight()/45*37,getWidth()/58*47,getHeight()/45*40,paint);
            canvas.drawRect(getWidth()/58*50,getHeight()/45*37,getWidth()/58*52,getHeight()/45*40,paint);

            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(5);
            //лучи
            paint.setColor(Color.rgb(255,255, 0));
            int a = 150, b = 300;
            for (int i=1;i<=12;i++) {
                canvas.drawLine(getWidth()/58*2,getHeight()/45*3,getWidth()/58*2+a,getHeight()/45*3+b,paint);
                a=a+getWidth()/120;
                b=b-getHeight()/45;
            }

            //окно сверху
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.rgb(0,0, 255));
            int c;

            //окно снизу
            a = getWidth()/58*8;
            while (a<getWidth()/58*12) {
                canvas.drawLine(a,getHeight()/45*31,a,getHeight()/45*37,paint);
                a+=getWidth()/58;
            }
            b = getHeight()/45*31;
            while (b<getHeight()/45*37) {
                canvas.drawLine(getWidth()/58*8,b,getWidth()/58*12,b,paint);
                b+=getHeight()/45;
            }

            //дверь
            paint.setColor(Color.rgb(255,255, 255));
            a = getWidth()/58*20;
            b = getHeight()/45*31;
            while (a>getWidth()/58*15) {
                canvas.drawLine(a,getHeight()/45*31,getWidth()/58*20,b,paint);
                a-=getWidth()/58;
                b+=getHeight()/45;
            }
            a = getWidth()/58*15;
            b = getHeight()/45*41;
            c=getHeight()/45*41;
            while (a<getWidth()/58*20) {
                canvas.drawLine(getWidth()/58*15,b,a,getHeight()/45*41,paint);
                a+=getWidth()/58;
                b-=getHeight()/45;
                c = b;
            }
            a = getHeight()/45*41;
            while (c>=getHeight()/45*31) {
                canvas.drawLine(getWidth()/58*15, c, getWidth()/58*20, a, paint);
                a -= getHeight()/45;
                c -= getHeight()/45;
            }

            //обводка
            paint.setStrokeWidth(3);
            paint.setColor(Color.BLACK);
            canvas.drawOval(new RectF(getWidth()/58*25, getHeight()/45*15, getWidth()/58*38, getHeight()/45*39), paint);
            canvas.drawRect(getWidth()/58*7,getHeight()/45*28,getWidth()/58*22,getHeight()/45*41,paint);
            path.reset();
            path.moveTo(getWidth()/58*7,getHeight()/45*28);
            path.lineTo(getWidth()/58*15,getHeight()/45*18);
            path.lineTo(getWidth()/58*22,getHeight()/45*28);
            canvas.drawPath(path,paint);

            canvas.drawRect(getWidth()/58*15,getHeight()/45*31,getWidth()/58*20,getHeight()/45*41,paint);
            canvas.drawCircle(getWidth()/58*15,getHeight()/45*24,getWidth()/58*2, paint);
            canvas.drawRect(getWidth()/58*8,getHeight()/45*31,getWidth()/58*12,getHeight()/45*37,paint);
            canvas.drawRect(getWidth()/58*43,getHeight()/45*36,getWidth()/58*54,getHeight()/45*37,paint);
            canvas.drawRect(getWidth()/58*45,getHeight()/45*37,getWidth()/58*47,getHeight()/45*40,paint);
            canvas.drawRect(getWidth()/58*50,getHeight()/45*37,getWidth()/58*52,getHeight()/45*40,paint);

        }
    }
}
