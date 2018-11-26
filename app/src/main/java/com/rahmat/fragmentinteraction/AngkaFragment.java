package com.rahmat.fragmentinteraction;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AngkaFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AngkaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AngkaFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    int angka1, angka2;
    Button _BtHitung;
    TextView _txt1, _txt2;

    private OnInteraction mListener;

    public AngkaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AngkaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AngkaFragment newInstance(String param1, String param2) {
        AngkaFragment fragment = new AngkaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ViewFrag = inflater.inflate(R.layout.fragment_angka, container, false);
        _BtHitung = ViewFrag.findViewById(R.id.kirim);
        _BtHitung.setOnClickListener(this);

        _txt1 = ViewFrag.findViewById(R.id.angkaSatu);
        _txt2= ViewFrag.findViewById(R.id.angkaDua);

        Random a = new Random();
        angka1 = a.nextInt(9);
         angka2 = a.nextInt(9);
        _txt1.setText(String.valueOf(angka1));
        _txt2.setText(String.valueOf(angka2));

        return ViewFrag;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnInteraction) {
            mListener = (OnInteraction) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {

        int result = Math.max(angka1,angka2);
        onCallActivity(String.valueOf(result));
        Random a = new Random();
        angka1 = a.nextInt(9);
        angka2 = a.nextInt(9);
        _txt1.setText(String.valueOf(angka1));
        _txt2.setText(String.valueOf(angka2));

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    public void onCallActivity(String data) {
        if (mListener != null) {
            mListener.onFragmentIntercation(data);
        }
    }
}
