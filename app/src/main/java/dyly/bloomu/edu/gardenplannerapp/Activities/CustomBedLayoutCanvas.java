package dyly.bloomu.edu.gardenplannerapp.Activities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.Stack;

/**
 * Created by EVANDESKTOP on 12/2/2015.
 */
public class CustomBedLayoutCanvas extends View {
    public int width;
    public int height;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Path path;
    Context c;
    private Paint mPaint;
    private float mX, mY;
    private static final float TOLERANCE = 5;
    private Stack<Path> currentDrawingPaths = null;

    public CustomBedLayoutCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
        c = context;

        path = new Path();
        currentDrawingPaths = new Stack<>();
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeWidth(4f);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mBitmap, 0, 0, mPaint);
        canvas.drawPath(path, mPaint);
    }


    public void clearCanvas()
    {
        mBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
        currentDrawingPaths.clear();
    }

    public void undo()
    {
        if(currentDrawingPaths.size() > 0)
        {
            currentDrawingPaths.pop();
            invalidate();
        }
    }

    private void upTouch()
    {
        path.lineTo(mX, mY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                mCanvas.drawPath(path, mPaint);
                path.reset();
                currentDrawingPaths.push(path);
                invalidate();
                break;
        }
        System.out.println(currentDrawingPaths.size());
        return true;
    }

}




















