package com.babenkovladimir.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.babenkovladimir.R;

public class FragmentTwo extends Fragment {

  public static FragmentTwo getInstance() {
    FragmentTwo fragment = new FragmentTwo();
    return fragment;
  }

  private FragmentTwo() {
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_two, container, false);
  }
}
