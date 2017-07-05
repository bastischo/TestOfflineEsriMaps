package de.bastischo.testapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.esri.android.map.MapView;
import com.esri.android.map.ags.ArcGISLocalTiledLayer;
import com.esri.android.map.event.OnStatusChangedListener;
import com.esri.core.geometry.Envelope;

import java.io.File;

public class MainActivity extends AppCompatActivity {


    private MapView mMapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        mMapView = (MapView) findViewById(R.id.map);
        mMapView.setOnStatusChangedListener(new OnStatusChangedListener() {

            private static final long serialVersionUID = 1L;


            @Override

            public void onStatusChanged(Object source, STATUS status) {

                if (source == mMapView && status == OnStatusChangedListener.STATUS.INITIALIZED) {

                    // set initial extent on startup
                    Envelope env = new Envelope(-2.0037507067161843E7, -1.9971868880408604E7, 2.0037507067161843E7, 1.99718688804085E7);
                    mMapView.setExtent(env);
                }

            }

        });

        String offlinePath = "/storage/emulated/0/waldecho/offlinemaps/rheinland-pfalz-01.tpk";
        File f = new File(offlinePath);
        if (f.exists()) {
            ArcGISLocalTiledLayer offlineMapLayer = new ArcGISLocalTiledLayer(offlinePath);

            mMapView.addLayer(offlineMapLayer);
        }
    }

}
