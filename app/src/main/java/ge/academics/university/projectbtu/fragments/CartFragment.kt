package ge.academics.university.projectbtu.fragments

import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import ge.academics.university.projectbtu.base.BaseFragment
import ge.academics.university.projectbtu.databinding.FragmentCartBinding

class CartFragment : BaseFragment<FragmentCartBinding>(FragmentCartBinding::inflate) {
    private lateinit var navController: NavController
    override fun setup() {
        navController = findNavController()
    }

    override fun listeners() {
        binding.btnStartShopping.setOnClickListener {
            navController.navigate(CartFragmentDirections.actionCartFragmentToShopFragment())
        }
    }
}