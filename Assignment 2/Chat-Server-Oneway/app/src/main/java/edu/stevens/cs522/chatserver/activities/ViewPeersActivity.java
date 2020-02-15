package edu.stevens.cs522.chatserver.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.util.Log;


import java.util.ArrayList;

import edu.stevens.cs522.chatserver.R;
import edu.stevens.cs522.chatserver.entities.Peer;


public class ViewPeersActivity extends Activity implements AdapterView.OnItemClickListener {
//test
    final static public String TAG = ChatServer.class.getCanonicalName();
//test
    public static final String PEERS_KEY = "peers";

    private ArrayList<Peer> peers;

    ListView peerList;
    private ArrayAdapter<Peer> peerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_peers);

        peers = getIntent().getParcelableArrayListExtra(PEERS_KEY);
       //test
        Log.d(TAG, "peers are:" + peers.toString());
//test
        // TODO display the list of peers, set this activity as onClick listener
         peerList = (ListView) findViewById(R.id.peer_list);
        // peers.toString();


        peerAdapter = new ArrayAdapter<Peer>(this,R.layout.view_peers,peers);

        peerList.setAdapter(peerAdapter);
        registerForContextMenu(peerList);
        peerList.setOnItemClickListener(this);


    }


        @Override
        public void onItemClick (AdapterView < ? > parent, View view,int position, long id){
        /*
         * Clicking on a peer brings up details
         */
        Peer peer = peers.get(position);
        Intent intent = new Intent(this, ViewPeerActivity.class);
        intent.putExtra(ViewPeerActivity.PEER_KEY, peer);
        startActivity(intent);
    }

}
