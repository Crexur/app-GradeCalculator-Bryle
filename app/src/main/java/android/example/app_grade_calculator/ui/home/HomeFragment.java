package android.example.app_grade_calculator.ui.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.example.app_grade_calculator.databinding.FragmentHomeBinding;
import android.widget.Toast;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        //SeekBar Prelim
        binding.seekBarPrelim.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                binding.prelimTxtbox.setText(String.valueOf(progress));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //SeekBar Midterm
        binding.seekBarMidterm.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                binding.midtermsTxtbox.setText(String.valueOf(progress));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //SeekBar PreFinals
        binding.seekBarPrefinals.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                binding.prefinalsTxtbox.setText(String.valueOf(progress));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //SeekBar Finals
        binding.seekBarFinals.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                binding.finalsTxtbox.setText(String.valueOf(progress));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Button Quick Compute
        binding.quickBtn.setOnClickListener((View v) -> {
            String prelim_inputs = binding.prelimTxtbox.getText().toString();
            String midterm_inputs = binding.midtermsTxtbox.getText().toString();
            String prefinals_inputs = binding.prefinalsTxtbox.getText().toString();
            String finals_inputs = binding.finalsTxtbox.getText().toString();

            try {
                float prelim = Float.parseFloat(prelim_inputs);
                float midterm = Float.parseFloat(midterm_inputs);
                float prefinals = Float.parseFloat(prefinals_inputs);
                float finals = Float.parseFloat(finals_inputs);

                float total = (prelim * 0.2f) + (midterm * 0.2f) + (prefinals * 0.2f) + (finals * 0.4f);
                Toast.makeText(this.getContext(), "Your score is, " + total, Toast.LENGTH_SHORT).show();


                new AlertDialog.Builder(requireContext())
                        .setIcon(android.R.drawable.ic_menu_myplaces)
                        .setTitle("This is your GWA")
                        .setMessage("If there are error please let me know @Bryle!\n\n")
                        .setMessage("Your grade is: " + total)
                        .setPositiveButton("Clear Boxes?", (dialog, which) -> {

                            binding.seekBarPrelim.setProgress(20);
                            binding.seekBarMidterm.setProgress(20);
                            binding.seekBarPrefinals.setProgress(20);
                            binding.seekBarFinals.setProgress(20);
                            binding.prelimTxtbox.setText("");
                            binding.midtermsTxtbox.setText("");
                            binding.prefinalsTxtbox.setText("");
                            binding.finalsTxtbox.setText("");
                        }).setNegativeButton("Don't Clear", null).show();

            } catch (NumberFormatException e) {
                Toast.makeText(this.getContext(), "Invalid Input Please Check Again!", Toast.LENGTH_SHORT).show();
            }


        });

        //Button Save Compute
        binding.calcBtn.setOnClickListener((View v) -> Toast.makeText(this.getContext(), "Show me full calculator", Toast.LENGTH_SHORT).show());


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}