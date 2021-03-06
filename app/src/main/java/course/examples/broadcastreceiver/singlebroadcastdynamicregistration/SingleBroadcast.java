package course.examples.broadcastreceiver.singlebroadcastdynamicregistration;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SingleBroadcast extends Activity {

	private static final String CUSTOM_INTENT = "course.examples.BroadcastReceiver.show_toast";
	private final IntentFilter intentFilter = new IntentFilter(CUSTOM_INTENT);
	private final Receiver receiver = new Receiver();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		registerReceiver(receiver, intentFilter);

		setContentView(R.layout.main);

		Button button = (Button) findViewById(R.id.button);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				sendBroadcast(new Intent(CUSTOM_INTENT));
			}
		});
	}

	@Override
	protected void onDestroy() {
		unregisterReceiver(receiver);
		super.onDestroy();
	}
}