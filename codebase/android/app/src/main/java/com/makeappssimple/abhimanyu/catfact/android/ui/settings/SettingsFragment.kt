package com.makeappssimple.abhimanyu.catfact.android.ui.settings

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity
import com.makeappssimple.abhimanyu.catfact.android.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fragmentSettingsTextviewAbout.setOnClickListener {
            val action = SettingsFragmentDirections.actionSettingsFragmentToAboutFragment()
            findNavController().navigate(action)
        }

        binding.fragmentSettingsTextviewCredits.setOnClickListener {
            val action = SettingsFragmentDirections.actionSettingsFragmentToCreditsFragment()
            findNavController().navigate(action)
        }

        binding.fragmentSettingsTextviewLicences.setOnClickListener {
            val intent = Intent(activity, OssLicensesMenuActivity::class.java)
            activity?.startActivity(intent)
        }
    }
}
