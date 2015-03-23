package com.deitel.twittersearches;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewFragment;

import com.deitel.twittersearches.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WebContentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WebContentFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_URI = "uri";

    // TODO: Rename and change types of parameters
    private String uri;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment WebContentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WebContentFragment newInstance(String param1) {
        WebContentFragment fragment = new WebContentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_URI, param1);
        fragment.setArguments(args);
        return fragment;
    }

    public WebContentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            uri = getArguments().getString(ARG_URI);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_web_content,container,false);
        WebView wv = (WebView)myView.findViewById(R.id.webView);
        wv.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        wv.loadUrl(uri);
        return myView;
    }


}
