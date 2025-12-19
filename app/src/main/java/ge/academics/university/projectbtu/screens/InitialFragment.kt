package ge.academics.university.projectbtu.screens

import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import ge.academics.university.projectbtu.R
import ge.academics.university.projectbtu.databinding.FragmentInitialBinding
import ge.academics.university.projectbtu.fragments.BaseFragment

class InitialFragment : BaseFragment<FragmentInitialBinding>(FragmentInitialBinding::inflate) {
    private lateinit var navController: NavController
    override fun setup() {
        navController = findNavController()
    }

    override fun listeners() {
        binding.btnGetStarted.setOnClickListener {
            navController.navigate(R.id.action_initialFragment_to_secondScreen)
        }
    }

}


