package br.edu.ifrs.projetoexemplomd.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import br.edu.ifrs.projetoexemplomd.R;

public class DicaFragment extends Fragment {

    private MutableLiveData<String> mText;

    public DicaFragment() {
        mText = new MutableLiveData<>();
        mText.setValue("Dicas Fragment");
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dica, container, false);
        return root;
    }
    public LiveData<String> getText() {
        return mText;
    }
}