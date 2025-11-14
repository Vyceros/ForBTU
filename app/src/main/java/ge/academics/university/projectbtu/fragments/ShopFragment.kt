package ge.academics.university.projectbtu.fragments

import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ge.academics.university.projectbtu.adapters.RecyclerAdapter
import ge.academics.university.projectbtu.base.BaseFragment
import ge.academics.university.projectbtu.databinding.FragmentShopBinding

class ShopFragment : BaseFragment<FragmentShopBinding>(FragmentShopBinding::inflate) {

    private lateinit var rvAdapter: RecyclerAdapter
    private lateinit var navController: NavController
    override fun setup() {
        setUpRecycler()
        navController = findNavController()
    }

    override fun listeners() {
        binding.btnAddToCart.setOnClickListener {
            onAddCartClick()
        }
    }


    private fun setUpRecycler() {
        val options = listOf(
            "Various Installment Options",
            "Monthly Installment",
            "Jumia Birthday"
        )

        binding.rvItems.apply {
            rvAdapter = RecyclerAdapter(options)
            adapter = rvAdapter

            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun onAddCartClick() {
        val price = 120

        val action =
            ShopFragmentDirections.actionShopFragmentToCheckoutFragment(productPrice = price)
        navController.navigate(action)
    }
}