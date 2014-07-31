package poolup.penguins.chocolate.com.poolup;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Picture;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;


public class Launcher extends Activity {
    private static final int SPLASH_TIME_OUT = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(Launcher.this, MainActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);

        AnimatorSet animatorSet = new AnimatorSet();
        ImageView image = (ImageView) findViewById(R.id.launcher_image_car);
        PropertyValuesHolder xScale = PropertyValuesHolder.ofFloat(View.SCALE_X, 1, 12);
        PropertyValuesHolder yScale = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1, 12);
        PropertyValuesHolder yMove = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, 10, 280);
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(image, xScale, yScale, yMove);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setDuration(2800);

        PropertyValuesHolder xxScale = PropertyValuesHolder.ofFloat(View.SCALE_X, 12, 15);
        PropertyValuesHolder yyScale = PropertyValuesHolder.ofFloat(View.SCALE_Y, 12, 15);
        PropertyValuesHolder yyMove = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, 280, 300);
        ObjectAnimator overshootAnimator = ObjectAnimator.ofPropertyValuesHolder(image, xxScale, yyScale, yyMove);
        overshootAnimator.setInterpolator(new OvershootInterpolator());
        overshootAnimator.setDuration(500);

        animatorSet.playSequentially(animator, overshootAnimator);
        animatorSet.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.launcher, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}


