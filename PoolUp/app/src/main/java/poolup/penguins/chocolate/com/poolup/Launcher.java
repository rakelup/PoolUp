package poolup.penguins.chocolate.com.poolup;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.graphics.Picture;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


public class Launcher extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        ImageView image = (ImageView) findViewById(R.id.launcher_image_car);
        PropertyValuesHolder xScale = PropertyValuesHolder.ofFloat(View.SCALE_X, 1, 5);
        PropertyValuesHolder yScale = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1, 5);
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(image, xScale, yScale);
        //ObjectAnimator animator = new ObjectAnimator(image, );
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
