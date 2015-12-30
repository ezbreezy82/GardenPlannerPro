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
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

/**
 * Custom implementation of the drawing functionality in the BedLayoutModifyActivity.
 * This code was assisted by the following URL:
 * http://code.tutsplus.com/tutorials/android-sdk-create-a-drawing-app-touch-interaction--mobile-19202
 * Created by EVANDESKTOP on 11/15/2015.
 */
public class CustomBedLayoutCanvas extends View
{
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Path mPath;
    private Context context;
    private Paint mPaint;
    private List<Path> currentDrawingPaths = null;

    /**
     * Will initialize any private attributes that need to be instantiated and set the
     * stroke color and width. For future implementation, colors will be decided by the user
     * with a default color of Black.
     * @param c Context
     * @param attrs any Attributes passed.
     */
    public CustomBedLayoutCanvas(Context c, AttributeSet attrs) {
        super(c, attrs);
        currentDrawingPaths = new ArrayList<>();
        context = c;
        mPath = new Path();
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeWidth(4f);
    }

    /**
     * Overrode method to take care of the size changes for the bitmap.
     * @param w width
     * @param h height
     * @param oldw old width
     * @param oldh old height
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
    }

    /**
     * This method will be called quite often. Specifically when you see a invalidate() call,
     * this will pretty much refresh the current drawing area with the saved paths.
     * @param canvas current canvas the drawing is taken place in.
     */
    @Override
    protected void onDraw(Canvas canvas) {
        //canvas.drawBitmap(mBitmap, 0, 0, mPaint);
        for (Path path : currentDrawingPaths)
        {
            canvas.drawPath(path, mPaint);
        }
        canvas.drawPath(mPath, mPaint);
    }


    /**
     * Will be invoked when the user wants to clear the canvas.  Will simply create a fresh
     * bitmap image and re-initialize the private attribute, mCanvas, with this bitmap.
     * It will then clear the currentDrawingPaths which holds all current paths that were
     * drawn on the canvas and then invoke invalidate() to refresh the canvas.
     */
    public void clearCanvas()
    {
        mBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
        currentDrawingPaths.clear();
        invalidate();
    }

    /**
     * Will remove the most recent path added to currentDrawingPaths and then invoke invalidate()
     * to refresh the canvas.  If there are no paths remaining it will send a toast to the screen
     * to notify the user that all drawing paths are already removed.
     */
    public void undo() {
        if (currentDrawingPaths.size() > 0) {
            currentDrawingPaths.remove(currentDrawingPaths.size() - 1);
            invalidate();
        }else
        {
            Toast.makeText(context, "No undo's left.", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Will handle the ACTION_DOWN, ACTION_MOVE, and ACTION_UP functions in the touch event.
     * If the action is down it will move the mPath to that x and y position.
     * If the action is moving it will connect a line between that x and y position and its
     * starting path which was determined in ACTION_DOWN.
     * If the action is up this will complete the path and finalize the line at the x and y
     * position.  It will then add that path to currentDrawingPaths and invoke invalidate()
     * to refresh the canvas.
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                mPath.lineTo(x, y);
                mCanvas.drawPath(mPath, mPaint);
                currentDrawingPaths.add(mPath);
                mPath = new Path();
                invalidate();
                break;
        }
        return true;
    }

    public Bitmap getmBitmap() {
        return mBitmap;
    }

    public void setmBitmap(Bitmap mBitmap) {
        this.mBitmap = mBitmap;
    }
}




















