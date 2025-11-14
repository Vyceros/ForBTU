package ge.academics.university.projectbtu.fragments

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import ge.academics.university.projectbtu.adapters.CartAdapter
import ge.academics.university.projectbtu.base.BaseFragment
import ge.academics.university.projectbtu.databinding.FragmentCheckoutBinding

class CheckoutFragment : BaseFragment<FragmentCheckoutBinding>(FragmentCheckoutBinding::inflate) {
    private lateinit var cartAdapter: CartAdapter
    private var productPrice: Int = 0
    private var currentQuantity: Int = 1

    private val args: CheckoutFragmentArgs by navArgs()

    override fun setup() {
        productPrice = args.productPrice

        setupRecyclerView()

        updateTotalPrice()

        updateQuantity()
    }

    override fun listeners() {
        binding.ibBackArrow.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.btnPlaceOrder.setOnClickListener {
            placeOrder()
        }
    }

    private fun setupRecyclerView() {
        cartAdapter = CartAdapter()

        cartAdapter.onQuantityChanged = { quantity, itemTotal ->
            currentQuantity = quantity
            updateTotalPrice()
            updateQuantity()
        }

        cartAdapter.onDeleteItem = {
            findNavController().navigateUp()
        }

        binding.rvCartItems.apply {
            adapter = cartAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun updateTotalPrice() {
        val total = productPrice * currentQuantity
        binding.tvTotalAmount.text = "$total $"
    }

    private fun updateQuantity() {
        binding.tvSubtotal.text = "Subtotal ($currentQuantity items)"
    }

    private fun placeOrder() {
        findNavController().navigate(CheckoutFragmentDirections.actionCheckoutFragmentToSuccessFragment())
    }
}