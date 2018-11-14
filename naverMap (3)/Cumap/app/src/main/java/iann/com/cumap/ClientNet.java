package iann.com.cumap;

import android.util.Log;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class ClientNet {
    static String dust=null;
    static String temperature=null;
    static String humidity=null;
    static int windowState = 3;

    private String ip = "192.168.123.110";
    private int port = 3000;
    public static com.github.nkzawa.socketio.client.Socket mSocket = null;

    public ClientNet(){
        try{
            setSoeckt(ip,port);
        }catch (Exception e){e.printStackTrace();}
        connect();
    }

    public void connect(){
        mSocket.connect();
        Log.d("test1","mSocket Connect");
    }

    public void setSoeckt(String ip, int port) throws IOException, URISyntaxException {
        try {
            mSocket = IO.socket("http://" + ip + ":" + port+"/");
            Log.d("test1", "mSocket Create" + " http://" + ip + ":" + port);
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public void receiveInfo() {
        mSocket.emit("receiveInfo");
        Emitter.Listener receiveInfo = new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                JSONObject data = (JSONObject) args[0];
                Log.d("tests", "Receive info");

                try {
                    if(data!=null) {
                        MainActivity.currentX = parseFloat(data.getString("currnetX"));
                        MainActivity.currentY = parseFloat(data.getString("currnetY"));
                        MainActivity.destX = parseFloat(data.getString("destX"));
                        MainActivity.destY = parseFloat(data.getString("destY"));
                    }
                    else{
                        Log.d("tests","data가 없음");
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public void sendInfo(JSONObject data){
        Log.i("test1", String.valueOf(data));
        mSocket.emit("sendScheduleInfo",data);
    }
}

