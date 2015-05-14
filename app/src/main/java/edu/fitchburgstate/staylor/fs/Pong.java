package edu.fitchburgstate.staylor.fs;



        import android.content.Context;
        import android.graphics.Canvas;
        import android.graphics.Color;
        import android.graphics.Paint;
        import android.util.AttributeSet;
        import android.view.View;

public class Pong extends View {

    public Pong(Context context) {
        super(context);
        white.setColor(Color.WHITE);
    }
    public Pong(Context context, AttributeSet attrs) {
        super(context, attrs);
        white.setColor(Color.WHITE);
    }
    public Pong(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        white.setColor(Color.WHITE);
    }
    double angle = 1; // measured in radians
    int radius = 10; // measured in pixels
    double x = 2*radius;
    double y = 2*radius;

    double speed = 15; // measured in pixels per refresh

    Paint white = new Paint();
    Paint black = new Paint(); // defaults to black

    public void onDraw(Canvas canvas){
        double h = getHeight();
        double w = getWidth();
        double dx = speed * Math.cos(angle);
        double dy = speed * Math.sin(angle);

        while (true) {
            // erase old position
            canvas.drawCircle((float)x, (float)y, radius, white);
            // compute new position
            x += dx;
            y += dy;

            // check for collision
            if (x + radius > w || x - radius < 0){  angle = Math.PI - angle;}
            if (y + radius > h || y - radius < 0){  angle = 2*Math.PI - angle;}

            canvas.drawCircle((float)x, (float) y, radius, black);
            dx = speed * Math.cos(angle);           // calculate dx, dy  here to delay
            dy = speed * Math.sin(angle);           // while circle black
        }
    }
}

